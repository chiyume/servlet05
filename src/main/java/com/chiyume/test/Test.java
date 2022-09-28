package com.chiyume.test;

import com.chiyume.utils.C3p0Utils;
import com.chiyume.utils.SensitiveWorldFilter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        worldFilterTest();

    }
    public static void worldFilterTest(){
        Set<String> sensitiveWordSet = new HashSet<>();
        sensitiveWordSet.add("太多");
        sensitiveWordSet.add("爱恋");
        sensitiveWordSet.add("静静");
        sensitiveWordSet.add("哈哈");
        sensitiveWordSet.add("啦啦");
        sensitiveWordSet.add("感动");
        sensitiveWordSet.add("发呆");
        //初始化敏感词库
        SensitiveWorldFilter.init(sensitiveWordSet);

        /**
         * 需要进行处理的目标字符串
         */
        System.out.println("敏感词的数量：" + SensitiveWorldFilter.sensitiveWordMap.size());
        String string = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节。"
                + "然后 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
                + "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个贱人一杯红酒一部电影在夜 深人静的晚上，关上电话静静的发呆着。";
        System.out.println("待检测语句字数：" + string.length());

        /**
         * 是否含有关键字
         */
        try {
            boolean result = SensitiveWorldFilter.contains(string);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 获取语句中的敏感词
         */
        Set<String> set = null;
        try {
            set = SensitiveWorldFilter.getSensitiveWord(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);

        /**
         * 替换语句中的敏感词
         */
        String filterStr = null;
        try {
            filterStr = SensitiveWorldFilter.replaceSensitiveWord(string, '*');
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filterStr);

        String filterStr2 = null;
        try {
            filterStr2 = SensitiveWorldFilter.replaceSensitiveWord(string, "[*敏感词*]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filterStr2);

    }

    public static void c3p0Test2(){

    }
    public static void c3p0Test(){
        Connection connection = C3p0Utils.getConnection();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from sysuser");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int userid = resultSet.getInt("userid");
                String username = resultSet.getString("username");
                System.out.println(userid+"----"+username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.release(connection, preparedStatement, resultSet);
        }
    }
}
