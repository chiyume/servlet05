<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2022/9/24
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User By ID</title>
    <style>
        /*表格样式*/
        * {
            margin: 0;
            padding: 0;
        }

        table {
            width: 90%;
            background: rgba(255, 255, 255, .3);
            border-radius: 10px;
            margin: 30px auto;
            border-collapse: collapse;
            margin-bottom: 50px;
            /*border-collapse:collapse合并内外边距
            (去除表格单元格默认的2个像素内外边距*/
        }

        th, td {

            height: 25px;

            line-height: 25px;

            text-align: center;

            border: 1px solid #ccc;

        }

        th {

            background: #eee;

            font-weight: normal;

        }

        tr {

            background: #fff;

        }

        tr:hover {

            background: #50e5ff;

        }

        td a {

            color: #06f;

            text-decoration: none;

        }

        td a:hover {

            color: #06f;

            text-decoration: underline;

        }

        .bg {
            background: url("https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20181130%2F197c51569c834a64af6f6252f22c0da7.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1666686937&t=d8606e47f767933918d72de86ccc46fa");
            background-repeat: no-repeat;
            background-size: cover;
            width: 100vw;
            height: 100vh;
            overflow: hidden;

        }

        .container {
            background-color: rgba(255, 255, 255, .4);
            width: 90%;
            border-radius: 10px;
            margin: auto;
            margin-top: 50px;
            padding-bottom: 50px;


        }

        .abt {
            padding: 10px 26px;
            font-family: "不凡星爵 (非商业使用)";
            font-size: 20px;
            border-radius: 5px;
            border: #50e5ff 1px solid;
            margin-left: 100px;
            text-decoration: none;
            font-weight: bold;
            margin-top: 30px;
            color: white;
        }

        .abt:hover {
            background-color: deepskyblue;
            color: white;
        }

        hr {
            margin-bottom: 20px;
        }

    </style>
</head>
<body>
<div class="bg">
    <div class="container">
        <h1 style="text-align: center">删除用户</h1>
        <table>
            <tr>
                <th>用户id</th>
                <th>角色id</th>
                <th>用户名</th>
                <th>用户密码</th>
                <th>真实名字</th>
                <th>性别</th>
                <th>电话</th>
                <th>地址</th>
                <th>身份</th>
                <th>状态</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${allUser}" var="user">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getRoleId()}</td>
                    <td>${user.getUserName()}</td>
                    <td>${user.getPassword()}</td>
                    <td>${user.getTrueName()}</td>
                    <td>${user.getGender()}</td>
                    <td>${user.getPhone()}</td>
                    <td>${user.getAddress()}</td>
                    <td>${user.getIdentity()}</td>
                    <td>${user.getStatus()}</td>
                    <td><a>删除</a></td>
                    <td><a>修改</a></td>
                </tr>
            </c:forEach>
        </table>
        <p style="margin: 50px;text-align: center;font-weight: bold;font-family: 春日甜茶手记;font-size: 30px">
            输入id删除指定用户
        </p>
        <hr>
        <div style="padding: 30px;margin-top: 30px;display: flex;justify-content: center">
            <form method="post" action="/servlet05_war_exploded/deleteUser" style="margin: auto">
                ID：<input type="number" placeholder="删除用户id" name="id"
                          style="width: 260px;height: 36px;line-height: 200px;font-size: 26px;border: #50e5ff 1px solid">
                <input type="submit" name="id" value="删除" style="width: 200px;height: 40px;background-color: rgba(255,255,255,0);border: #50e5ff 1px solid">
                <h2 style="text-align: center;font-family: 宋体;color: coral;">${deleteMessage}</h2>
            </form>
        </div>
        <hr>
        <a href="index.jsp" class="abt">返回首页</a>
        <a href="userList" class="abt">用户列表</a>
        <a href="deleteUser.jsp" class="abt">删除用户</a>
        <a href="userList.jsp" class="abt">更改用户</a>

    </div>
</div>
</body>
</html>
