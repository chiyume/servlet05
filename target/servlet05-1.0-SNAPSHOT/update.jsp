<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2022/9/24
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>UserData</title>
    <style>
        /*表格样式*/
        * {
            margin: 0;
            padding: 0;
        }

        table {

            width: 50%;
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
        .abt{
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
        .abt:hover{
            background-color: deepskyblue;
            color: white;
        }
        hr{
            margin-bottom: 20px;
        }
        input{
            width: 100%;
            height: 150%;
        }

    </style>
</head>
<body>
<div class="bg">
    <div class="container">
        <h1 style="text-align: center">用户数据修改</h1>

        <form method="post" action="/servlet05_war_exploded/update">
            <table>
                <tr>
                    <td></td>
                    <td>初始数据</td>
                    <td>更改后数据</td>
                </tr>
                <tr>
                    <td>用户id</td>
                    <td>${userById.getId()}</td>
                    <td><input type="number" name="id" value="${userById.getId()}" readonly></td>
                </tr>
                <tr>
                    <td>角色id</td>
                    <td>${userById.getRoleId()}</td>
                    <td><input type="number" name="roleId"></td>
                </tr>
                <tr>
                    <td>用户名</td>
                    <td>${userById.getUserName()}</td>
                    <td><input type="text" name="userName"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>${userById.getPassword()}</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td>真实名字</td>
                    <td>${userById.getTrueName()}</td>
                    <td><input type="text" name="trueName"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>${userById.getGender()}</td>
                    <td><input type="text" name="gender"></td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td>${userById.getPhone()}</td>
                    <td><input type="text" name="phone"> </td>
                </tr>
                <tr>
                    <td>地址</td>
                    <td>${userById.getAddress()}</td>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td>身份</td>
                    <td>${userById.getIdentity()}</td>
                    <td><input type="text" name="identity"></td>
                </tr>
                <tr>
                    <td>状态</td>
                    <td>${userById.getStatus()}</td>
                    <td><input type="number" name="status"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="提交" style="background-color: #50e5ff;color: white;"></td>
                    <td><input type="reset" value="重置数据"></td>
                </tr>
            </table>
        </form>
        <p style="text-align: center;color: coral;font-size: 30px">${updateMessage}</p>
        <hr>
        <a href="index.jsp" class="abt">首页</a>
        <a href="userList" class="abt">用户列表</a>
        <a href="deleteUser.jsp" class="abt">删除用户</a>

    </div>

</div>
</body>
</html>
