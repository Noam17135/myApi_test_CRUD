//package com.example.myApi_test;
//
//import java.sql.*;
//import java.util.ArrayList;2
//import java.util.Random;
//
//
//public class methods {
//
//
//
//    public methods() {
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "Nmr123456@@!");
//            Statement statement = connection.createStatement();
//            String sqlQuery = "select * from users";
//            ResultSet st = statement.executeQuery(sqlQuery);
//
//            Random r = new Random();
//            ArrayList<User> mArrayStringUsers = new ArrayList<>();
//
//            System.out.println(st);
//            while (st.next()) {
//
//                st.getRow();
//                String email = st.getString("email");
//                String password = st.getString("passWord");
//                User object = new User();
//
//                object.setEmail(email);
//                object.setPassword(password);
//                mArrayStringUsers.add(object);
//
//
//
//            }
//
//            System.out.println(mArrayStringUsers);
//        } catch (SQLException throwable) {
//            throwable.printStackTrace();
//        }
//
//
//
//    }
//
//
//}
//
//
//
//
