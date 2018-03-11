package com.edu.ldu.core.common.auth;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 给请求的参数去空格
 *
 * @author 唐全成
 */
public class ParameterRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String[]> params = new HashMap<>();

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public ParameterRequestWrapper(HttpServletRequest request) {
        super(request);
        this.params.putAll(request.getParameterMap());
        this.modifyParameterValues();
    }

    public ParameterRequestWrapper(HttpServletRequest request, Map<String, Object> extendParams) {
        this(request);
        //这里将扩展参数写入参数表
        addAllParameters(extendParams);
    }

    /**
     * 将parameter的值去除空格后重写回去
     */
    public void modifyParameterValues() {
        Set<String> set = params.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String[] values = params.get(key);
            if (StringUtils.isNotBlank(values[0])) {
                values[0] = StringUtils.trim(values[0]);
            }
            params.put(key, values);
        }
    }

    /**
     * 重写getParameter，代表参数从当前类中的map获取
     *
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name) {//同上
        return params.get(name);
    }

    /**
     * 增加多个参数
     *
     * @param otherParams
     */
    public void addAllParameters(Map<String, Object> otherParams) {
        for (Map.Entry<String, Object> entry : otherParams.entrySet()) {
            addParameter(entry.getKey(), entry.getValue());
        }
    }

    /**
     * 增加参数
     *
     * @param name
     * @param value
     */
    public void addParameter(String name, Object value) {
        if (value != null) {
            if (value instanceof String[]) {
                params.put(name, (String[]) value);
            } else if (value instanceof String) {
                params.put(name, new String[]{(String) value});
            } else {
                params.put(name, new String[]{String.valueOf(value)});
            }
        }
    }
}
