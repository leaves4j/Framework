package com.leaves.framework.common;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * User: jiangq
 * Date: 2015/2/12
 * Time: 16:50
 * Description:
 */
public class CommonFunction {
    public static String ObjectToJSON(Object object) {
        String json = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(object);
        } catch (IOException io) {
            /* todo */
        }
        return json;
    }
}
