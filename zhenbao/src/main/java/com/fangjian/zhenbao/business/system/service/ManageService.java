package com.fangjian.zhenbao.business.system.service;

import com.fangjian.zhenbao.business.huabo.controller.HuaboUserController;
import com.fangjian.zhenbao.business.huabo.dao.DistrictDao;
import com.fangjian.zhenbao.business.huabo.entity.District;
import com.fangjian.zhenbao.business.huabo.entity.Question;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import com.fangjian.zhenbao.business.system.entity.Role;
import com.fangjian.zhenbao.business.system.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ChenYan on 2020/1/3.
 */

@Service
public class ManageService {
    private static final Logger logger = LogManager.getLogger(HuaboUserController.class);

    @Autowired
    private SystemBaseDao systemBaseDao;



    /**
     * ********************************* 账 号 管 理 ******************************************************
     */


    /**
     * 查询省份总记录数
     *
     * @param params
     * @return count
     */
    public  long getDistrictCount(Map<String, Object> params) {
        return systemBaseDao.get("AuthorityMapper.getDistrictCount", params);
    }


    /**
     * 通过主键名查找用户
     *
     * @param id
     * @return
     */
    public District findDistrictById(Integer id) {
        return systemBaseDao.get("AuthorityMapper.findDistrictById",id);
    }

    /**
     * 查询 省份重复验证
     */
    public List<District> findDisName(Map<String, Object> params) {
        return systemBaseDao.getList("AuthorityMapper.findDisName",params);
    }

    /**
     * 添加省份
     */
    public int insertDistrict(District dis) {
        return  systemBaseDao.save("AuthorityMapper.insertDistrict",dis);
    }

    /**
     *修改省份
     */
    public int updateDistrict(District dis) {
        return  systemBaseDao.update("AuthorityMapper.updateDistrict",dis);
    }

    /**
     *删除省份
     */
    public int deleteDistrict(Integer id) {
        return  systemBaseDao.delete("AuthorityMapper.deleteDistrict",id);
    }



    //构建省份table列表
    public void  districtBuilder(District district,List<Object> disList) {

        disList.add(district.getDisName());
        disList.add(district.getDisSimpleName());
        String result = "";
        //编辑按钮
        result += "<i class='icon-pencil bigger-130 blue dis_edit_icon' id='" + district.getDisId() + "'></i>&nbsp&nbsp";
        //删除按钮
        result += "<i class='icon-trash bigger-130 red dis_del_icon' id='" + district.getDisId() + "'></i>";

        disList.add(result);
    }

    /**
     * 省份查询
     * @param page
     * @param district
     * @return
     */
    public Map<String, Object> findDistrictPage(com.fangjian.zhenbao.base.PageBean page,District district) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();

        params.put("start", page.getStart());
        params.put("pageSize", page.getPageSize());
        params.put("sort", page.getSortCol());
        params.put("order", ("DESC".equals(page.getSortWay()) ? Sort.Direction.DESC : Sort.Direction.ASC));

        String disName = district.getDisName();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(disName)) {
            params.put("disName", disName);
        }
        String disSimpleName = district.getDisSimpleName();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(disSimpleName)) {
            params.put("disSimpleName", disSimpleName);
        }
        List<List<Object>> aaData = new ArrayList<>();
        List<District> District = systemBaseDao.getList("AuthorityMapper.districtPage",params);
        long count = getDistrictCount(params);

        for (District d : District) {
            List<Object> disList = new ArrayList<>();
            districtBuilder(d,disList);
            aaData.add(disList);
        }

        resultMap.put("aaData", aaData);
        resultMap.put("iTotalRecords", count);
        resultMap.put("iTotalDisplayRecords", count);

        return resultMap;
    }


    /********************************反 馈 管 理***********************************/

    /**
     * 查询反馈总记录数
     *
     * @param params
     * @return count
     */
    public  long getQuestionCount(Map<String, Object> params) {
        return systemBaseDao.get("AuthorityMapper.getQuestionCount", params);
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param formatStr
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }


    /**
     * 日期格式字符串转换成时间戳
     * @param date 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(date_str)) {
            try {
                return String.valueOf(sdf.parse(date_str).getTime() / 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }



    //构建反馈table列表
    public void  questionBuilder(Question question, List<Object> questionList) {

        String quePosttime = timeStamp2Date(question.getQuePosttime(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("date========>>>>>>>>>>"+quePosttime);//运行输出:date=2016-08-04 10:34:42

        questionList.add(question.getQueInfo());
        questionList.add(quePosttime);
        questionList.add(question.getLinkStyle());

        String result = "";
        //编辑按钮
        result += "<i class='icon-pencil bigger-130 blue dis_edit_icon' id='" + question.getQueId() + "'></i>&nbsp&nbsp";
        //删除按钮
        result += "<i class='icon-trash bigger-130 red dis_del_icon' id='" + question.getQueId() + "'></i>";

        questionList.add(result);
    }



    public Map<String, Object> findQuestionPage(com.fangjian.zhenbao.base.PageBean page, Question question,User user) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();

        params.put("customer", user.getOrganizationId());
        params.put("start", page.getStart());
        params.put("pageSize", page.getPageSize());
        params.put("sort", page.getSortCol());
        params.put("order", ("DESC".equals(page.getSortWay()) ? Sort.Direction.DESC : Sort.Direction.ASC));

        String quePosttime = date2TimeStamp(question.getQuePosttime(),"yyyy-MM-dd HH:mm:ss");
        System.out.println("quePosttime====>>>>"+quePosttime);

        if (org.apache.commons.lang3.StringUtils.isNotEmpty(quePosttime)) {
             params.put("quePosttime", quePosttime);
        }
        String queInfo = question.getQueInfo();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(queInfo)) {
            params.put("queInfo", queInfo);
        }

        List<List<Object>> aaData = new ArrayList<>();
        List<Question> Questions = systemBaseDao.getList("AuthorityMapper.questionPage",params);
        long count = getQuestionCount(params);

        for (Question q : Questions) {
            List<Object> questionsList = new ArrayList<>();
            questionBuilder(q,questionsList);
            aaData.add(questionsList);
        }

        resultMap.put("aaData", aaData);
        resultMap.put("iTotalRecords", count);
        resultMap.put("iTotalDisplayRecords", count);

        return resultMap;
    }

}

