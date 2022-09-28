<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
            background-color: rgba(255, 255, 255, .7);
            width: 90%;
            border-radius: 10px;
            margin: auto;
            margin-top: 50px;
            padding-bottom: 50px;
            padding: 30px;
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
            color: black;
        }
        .abt:hover{
            background-color: deepskyblue;
            color: white;
        }
        hr{
            margin-bottom: 20px;
        }

    </style>
</head>
<body>
<div class="bg">
    <div class="container" style="display: flex;justify-content: space-between;flex-wrap: wrap;">
        <h1 style="text-align: center;margin: 30px;width: 100vw;">
            Hello ${activeUser.getUserName()},这是菜单功能列表
        </h1>
        <br/>
        <a href="index.jsp" class="abt">首页</a>
        <a href="userList" class="abt">用户列表</a>
        <a href="deleteUser.jsp" class="abt">删除用户</a>
        <a href="userList.jsp" class="abt">更改用户</a>
        <a href="index.jsp" class="abt">添加角色</a>
        <a href="userList" class="abt">查看角色</a>
        <a href="deleteUser.jsp" class="abt">删除角色</a>
        <a href="upload.jsp" class="abt">文件上传</a>
    </div>
</div>
</body>
</html>