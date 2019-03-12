package com.wzc.utils;

import javax.servlet.http.HttpServletRequest;

public class ParamT {

    public static String getString(HttpServletRequest request,String paramName,String defaultVal){
        String res=request.getParameter(paramName);
        if(res!=null){
            return res;
        }else{
            return defaultVal;
        }
    }
    public static String getString(HttpServletRequest request,String paramName){
        String res=request.getParameter(paramName);
        if(res!=null){
            return res;
        }else{
            return "";
        }
    }
    public static int getInt(HttpServletRequest request,String paramName,Integer defaultVal){
        String res=request.getParameter(paramName);
        if(res!=null){
            return Integer.parseInt(res);
        }else{
            return defaultVal;
        }
    }
    public static int getInt(HttpServletRequest request,String paramName){
        String res=request.getParameter(paramName);
        if(res!=null){
            return Integer.parseInt(res);
        }else{
            return 0;
        }
    }
}
