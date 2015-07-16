package com.tw.core.Service;

import java.sql.*;

/**
 * Created by xiaohang on 7/8/15.
 */
public class Connector {
    Connection con = null;
    public Connection connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc.mysql://127.0.0.1:3306/information", "root", "");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args){

}

}

