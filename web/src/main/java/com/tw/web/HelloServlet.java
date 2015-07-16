package com.tw.web;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.core.Connector;
import com.tw.core.Service;

public class HelloServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try{
            Class.forName("Constant.Driver");
            Connection conn = DriverManager(url, root, pswd);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from person");
            while(rs.next()){
              System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
            }
            rs.close();
            stmt.close();
          }catch(Exception e){
            e.printStackTrace();
  }

        PrintWriter out ;
        out.println("<h1>sfsdfsdM</h1>");

        jsp

    }
}