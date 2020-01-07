package com.fangjian.zhenbao.base.exportview;

import com.fangjian.zhenbao.base.utils.StringHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;


/**
 * 导出Excel工具类
 */
public class ExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
        HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置文件名称
        String fileName = (String) model.get("fileName");
        if (StringHelper.isNullOrEmpty(fileName)) {
            throw new Exception("文件名称不得为空！model中必须含有key为“fileName”的字符串。");
        }
        fileName = StringHelper.encodeFilename(fileName, request);
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        // 设置Excel的sheet名称
        String sheetName = (String) model.get("sheetName");
        if (StringHelper.isNullOrEmpty(sheetName)) {
            throw new Exception("sheet名称不得为空！model中必须含有key为“sheetName”的字符串。");
        }

        response.reset();
        OutputStream ouputStream = response.getOutputStream();
        HSSFWorkbook resultWorkbook = new HSSFWorkbook();

        HSSFSheet sheet = resultWorkbook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(18);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(1, true);

        // 设置自动换行
        HSSFCellStyle style = resultWorkbook.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 设置Excel的头
        String headers = (String) model.get("headers");
        if (headers != null) {
            String[] head = headers.split(",");
            for (int i = 0, length = head.length; i < length; i++) {
                HSSFCell headCell = getCell(sheet, 0, i);
                headCell.setCellStyle(style);
                setText(headCell, head[i]);
                HSSFCellStyle cellStyle = headCell.getCellStyle();
                cellStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
            }
        }

        // 向Excel中填写数据
        @SuppressWarnings("unchecked")
        List<List<?>> dataLists = (List<List<?>>) model.get("data");
        if (dataLists == null || dataLists.size() == 0) {
            HSSFCell headCell = getCell(sheet, 1, 0);
            setText(headCell, "无内容！");
            return;
        }

        for (int i = 1, length = dataLists.size(); i <= length; i++) {
            for (int j = 0; j < dataLists.get(i - 1).size(); j++) {
                HSSFCell headCell = getCell(sheet, i, j);
                headCell.setCellStyle(style);
                Object obj = dataLists.get(i - 1).get(j);
                setText(headCell, obj == null ? StringUtils.EMPTY : obj.toString());
            }
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        resultWorkbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}
