package com.chiyume.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class C3p0Utils {
    private static DataSource datasource;
    /**
     * 1、C3P0连接池的配置文件名称必须为c3p0-config.xml
     * 2、读取配置文件、加载驱动类、创建连接等操作均由连接池自动完成
     */
    static {
        try {
            datasource = new ComboPooledDataSource();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库链接
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 执行更新操作:增加、修改、删除
     * @param sql SQL语句
     * @param parameters SQL参数
     * @return 0失败、1成功
     */
    public static Integer executeUpdate(String sql,Object ...parameters){
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        Integer result = 0;
        try {
            if(parameters == null){
                result = queryRunner.update(connection, sql);
            }else{
                result = queryRunner.update(connection, sql, parameters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 执行更新操作:增加、修改、删除
     */
    public static Integer executeUpdate(String sql){
        Object [] parameters=null;
        return executeUpdate(sql, parameters);
    }

    /**
     * 执行查询操作
     * @param <T> 实体泛型
     * @param sql SQL语句
     * @param clazz 实体的Class
     * @param parameters SQL参数
     * @return 存放Bean的list
     */
    public static <T> List<T> executeQuery(String sql, Class<T> clazz, Object ...parameters){
        Connection connection = getConnection();
        List<T> list = null;
        try{
            QueryRunner queryRunner = new QueryRunner();
            BeanListHandler<T> beanListHandler = new BeanListHandler<T>(clazz);
            if(parameters == null){
                list = queryRunner.query(connection, sql,beanListHandler);
            }else{
                list = queryRunner.query(connection, sql,beanListHandler,parameters);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 执行查询操作
     */
    public static <T> List<T> executeQuery(String sql,Class<T> clazz){
        Object [] parameters=null;
        return executeQuery(sql,clazz,parameters);
    }

    //释放连接
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            statement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
}
