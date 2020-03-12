package com.zl.utils.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zl.utils.DBConfig;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.*;

/**
 * @author 周林
 * @Description 数据库连接池工具
 * @email 15198299634@163.com
 * @date 2020/3/12 16:33
 */
public class C3P0Utils {
    private static ComboPooledDataSource cpds;
    private static Connection con;
    private static Statement sta;
    private static ResultSet rs;
    private static PreparedStatement ps;

    /**
     * 获取Connection
     *
     * @return
     * @throws SQLException
     * @throws PropertyVetoException
     */
    public static Connection getConnection() throws SQLException, PropertyVetoException {
        return getConnection(DBConfig.SQL_DATABASE);
    }

    /**
     * 获取指定数据库Connection
     *
     * @param dataBase
     * @return
     * @throws SQLException
     * @throws PropertyVetoException
     */
    public static Connection getConnection(String dataBase) throws SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://" + DBConfig.SQL_IP + ":" + DBConfig.SQL_PORT + "/" + dataBase
                + "?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
        cpds.setUser(DBConfig.SQL_USER);
        cpds.setPassword(DBConfig.SQL_PASSWORD);
        // 得到一个Connection
        con = cpds.getConnection();
        return con;
    }

    /**
     * 获取指定Sql语句结果集
     *
     * @param sql
     * @return
     * @throws SQLException
     * @throws PropertyVetoException
     */
    public static ResultSet getResultSet(String sql) throws SQLException, PropertyVetoException {
        return getResultSet(sql, DBConfig.SQL_DATABASE);
    }

    /**
     * 获取指定数据库Sql语句结果集
     *
     * @param sql
     * @return
     * @throws SQLException
     * @throws PropertyVetoException
     */
    public static ResultSet getResultSet(String sql, String dataBase) throws SQLException, PropertyVetoException {
        con = getConnection(dataBase);
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        return rs;
    }

    public static void close() throws SQLException {
        if (rs != null) rs.close();
        if (sta != null) sta.close();
        if (con != null) con.close();
        if (cpds != null) cpds.close();
    }

    public static void closePs(ResultSet rs) throws SQLException {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (con != null) con.close();
        if (cpds != null) cpds.close();
    }

    @Test
    public void testConnection() throws PropertyVetoException, SQLException {
        String sql = "SELECT * FROM `t_test`;";
        ResultSet rs = getResultSet(sql);
        while (rs.next()) {
            System.out.print(rs.getString("id"));
            System.out.println(rs.getString("name"));
        }
    }

}
