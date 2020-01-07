package com.fangjian.zhenbao.base.freemarker;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class MyFreeMarkerView extends FreeMarkerView {
    @Override
    protected void exposeHelpers(Map<String, Object> model,
                                 HttpServletRequest request) throws Exception {
        model.put("base", request.getContextPath());
        super.exposeHelpers(model, request);
    }
}
