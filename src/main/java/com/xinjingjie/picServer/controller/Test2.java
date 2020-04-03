package com.xinjingjie.picServer.controller;

import com.xinjingjie.picServer.bean.Tag;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(new Date());
//        TimeZone time = TimeZone.getTimeZone("ETC/GMT-8");
//        TimeZone.setDefault(time);
//        System.out.println(new Date());
            String s = "#神秘的海洋#出现了一只#话题#话题#话题#海怪阿拉斯加#热门话题#和一艘很诡异的破船\n";
            System.out.println("例子："+s);
        String[] split = s.split("#");
        Set<String> tagsSet = new LinkedHashSet<>();

        for (String s1 : split) {
            System.out.println(s1);
            tagsSet.add(s1);
        }

        for (String tag:tagsSet){
            String t=tag;
            System.out.println(t);
            System.out.println(t);

        }
        System.out.println(tagsSet);
//            Pattern pattern = Pattern.compile("#(.*?)#");
//            Matcher matcher = pattern.matcher(s);
//            while (matcher.find()){
//                System.out.println(matcher.group());
//            }
            //System.out.println(s.replaceAll("#(.*?)#",""));
//        System.out.println(formatDate(new Date()));
    }
    public static String formatDate(Date data){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(data);
        return dateString;
    }
}
