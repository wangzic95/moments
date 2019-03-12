package com.wzc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StrT {


    public static String genFileName(String originalFilename){
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return df.format(new Date())+genRandomNub(6)+fileType;
    }


    public static String genRandomNub(Integer digit){
        Random random = new Random();
        StringBuilder minstr = new StringBuilder("1");
        StringBuilder maxstr = new StringBuilder("9");
        for(int i=1;i<digit;i++){
            minstr.append("0");
            maxstr.append("9");
        }
        int max =Integer.parseInt(maxstr.toString());
        int min =Integer.parseInt(minstr.toString());
        int s = random.nextInt(max)%(max-min+1) + min;
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        for(int i=1;i<20;i++) {
//            System.out.println(buildFileName("21wqrq.jpg"));
        }
    }

}
