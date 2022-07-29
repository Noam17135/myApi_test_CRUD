package com.example.myApi_test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Insert {

    private ArrayList<UserTest> userTestArrayList = new ArrayList<>(Arrays.asList(
            new UserTest(),
            new UserTest()
    ));



//    public void addUser(UserTest userTest){
//        arrayList.add(userTest);
//    }

    public void addUser(UserTest userTest){
        userTestArrayList.add(userTest);
//        return userTest;
    }

    public String testToAdd(UserTest userTest){
        userTestArrayList.add(userTest);
        return "Post Succefully Done";
    }

}
