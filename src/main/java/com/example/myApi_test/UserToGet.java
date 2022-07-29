package com.example.myApi_test;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@RestController
public class UserToGet {

    public Insert insert;

    private ArrayList<UserTest> userTestArrayList = new ArrayList<>(Arrays.asList(
            new UserTest(),
            new UserTest(),
            new UserTest()
    ));

    @GetMapping("/onlyoneobject")
    public UserTest userTest() throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "Nmr123456@@!");
        Statement statement = connection.createStatement();
        String sqlQuery = "select * from users";
        ResultSet st = statement.executeQuery(sqlQuery);

        Random r = new Random();
        ArrayList<UserTest> mArrayStringUsers = new ArrayList<>();

        while (st.next()) {

            st.getRow();
            String email = st.getString("email");
            String password = st.getString("passWord");
            String fname = st.getString("firstName");
            String lname = st.getString("lastName");
            String uname = st.getString("userName");

            UserTest object = new UserTest();

            object.setEmail(email);
            object.setPassword(password);
            object.setFirstName(fname);
            object.setLastName(lname);
            object.setUserName(uname);

            mArrayStringUsers.add(object);


        }

        int o = r.nextInt(mArrayStringUsers.size());
        String fn = mArrayStringUsers.get(o).getFirstName();
        String ln = mArrayStringUsers.get(o).getLastName();
        String em = mArrayStringUsers.get(o).getEmail();
        String us = mArrayStringUsers.get(o).getUserName();
        String pa = mArrayStringUsers.get(o).getPassWord();
        int id = mArrayStringUsers.get(o).getId();


        return new UserTest(fn, ln, em, us, pa, id);


    }

    //getting
    @GetMapping("/allobject")
    public UserFor userFor() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "Nmr123456@@!");
        Statement statement = connection.createStatement();
        String sqlQuery = "select * from users";
        ResultSet st = statement.executeQuery(sqlQuery);

        Random r = new Random();
        ArrayList<UserTest> mArrayStringUsers = new ArrayList<>();

        while (st.next()) {

            st.getRow();
            String email = st.getString("email");
            String password = st.getString("passWord");
            String fname = st.getString("firstName");
            String lname = st.getString("lastName");
            String uname = st.getString("userName");

            UserTest object = new UserTest();

            object.setEmail(email);
            object.setPassword(password);
            object.setFirstName(fname);
            object.setLastName(lname);
            object.setUserName(uname);

            mArrayStringUsers.add(object);


        }

        return new UserFor(mArrayStringUsers);
    }

    @PostMapping("/newusers")
    public String inserUser(@RequestBody UserTest userTest) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Nmr123456@@!");
            String sqlQuery = "INSERT INTO users (ID, firstName, lastName, email, userName, passWord)" + "values (?, ?, ?, ?, ?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, userTest.getId());
            preparedStatement.setString(2, userTest.getFirstName());
            preparedStatement.setString(3, userTest.getLastName());
            preparedStatement.setString(4, userTest.getEmail());
            preparedStatement.setString(5, userTest.getUserName());
            preparedStatement.setString(6, userTest.getPassWord());

            preparedStatement.execute();


        } catch (SQLException s) {
            System.out.println(s.getMessage());
            s.printStackTrace();

        }
        return testToAdd(userTest);
    }

    @PutMapping("/udatedata")
    public String updateUser(@RequestBody UserTest userTest){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Nmr123456@@!");
            String sqlQuery = "UPDATE users SET passWord = ? WHERE email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userTest.getPassWord());
            preparedStatement.setString(2, userTest.getEmail());

            preparedStatement.execute();


        } catch (SQLException s) {
            System.out.println(s.getMessage());
            s.printStackTrace();

        }

        return "DONE";
    }


    public String testToAdd(UserTest userTest){
        userTestArrayList.add(userTest);
        return "Post Succefully Done";
    }

    public String testToUpdate(UserTest userTest){
        userTestArrayList.add(userTest);
        return "PUT Succefully Done";
    }

}


