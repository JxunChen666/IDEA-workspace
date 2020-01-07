package com.fangjian.zhenbao.base.freemarker.directive;

import com.fangjian.zhenbao.base.freemarker.directive.OverrideDirective.TemplateDirectiveBodyOverrideWraper;
import freemarker.core.Environment;
import freemarker.template.TemplateModelException;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class DirectiveUtils {

    public static final String BLOCK = "__ftl_override__";
    public static final String OVERRIDE_CURRENT_NODE = "__ftl_override_current_node";

    public static String getRequiredParam(Map<?, ?> params, String key)
        throws TemplateModelException {
        Object value = params.get(key);
        if (value == null || StringUtils.isEmpty(value.toString())) {
            throw new TemplateModelException(
                "not found required parameter:" + key + " for directive");
        }
        return value.toString();
    }

    public static TemplateDirectiveBodyOverrideWraper getOverrideBody(Environment env, String name)
        throws TemplateModelException {
        TemplateDirectiveBodyOverrideWraper value = (TemplateDirectiveBodyOverrideWraper) env
            .getVariable(DirectiveUtils.getOverrideVariableName(name));
        return value;
    }

    static String getOverrideVariableName(String name) {
        return BLOCK + name;
    }

    public static void setTopBodyForParentBody(
        Environment env,
        TemplateDirectiveBodyOverrideWraper topBody,
        TemplateDirectiveBodyOverrideWraper overrideBody) {

        TemplateDirectiveBodyOverrideWraper parent = overrideBody;
        while (parent.parentBody != null) {
            parent = parent.parentBody;
        }
        parent.parentBody = topBody;

    }

    public static String getParam(Map<?, ?> params, String key, String defaultValue) {
        Object value = params.get(key);
        return value == null ? defaultValue : value.toString();
    }

}
