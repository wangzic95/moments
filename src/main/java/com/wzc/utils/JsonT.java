package com.wzc.utils;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonT {


    static class RespResult{
        private String message;
        private boolean success;
        private Object data;

        public RespResult() { }
        public RespResult( boolean success,String message) {
            this.message = message;
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
    static class LayResult{
        private String code ="0";
        private String msg;
        private Long count;
        private Object data;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
    public static void respJSON(HttpServletResponse response, boolean success, String msg, Object data){
        try {
            RespResult result = new RespResult();
            result.setSuccess(success);
            result.setMessage(msg);
            if(data!=null){
                result.setData(data);
            }
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            response.getWriter().print(JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void respJSON(HttpServletResponse response, boolean success,String msg) {
        try {
            RespResult result = new RespResult();
            result.setSuccess(success);
            result.setMessage(msg);
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            response.getWriter().print(JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String toJSON(boolean success, String msg, Object data){
        RespResult result = new RespResult();
        result.setSuccess(success);
        result.setMessage(msg);
        if(data!=null){
            result.setData(data);
        }
        return  JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss");
    }
    public static <T> void layJSON(HttpServletResponse response, String code, String msg, PageInfo<T> info){
        try {
            LayResult result = new LayResult();
            result.setCode(code);
            result.setMsg(msg);
            result.setCount(info.getTotal());
            result.setData(info.getList());
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            response.getWriter().print(JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static <T> void layJSON(HttpServletResponse response, String code, String msg,Object data) throws IOException {
        LayResult result = new LayResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        response.setHeader("Content-Type", "text/json;charset=utf-8");
        response.getWriter().print(JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss"));
    }
}
