package com.compile.io.application.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestRecords {
    private String userName;
    private Map<String, ArrayList<TestCase>> records;

    public TestRecords(String userName) {
        this.userName = userName;
        this.records = new HashMap<>();
    }

    public String getUserName() {
        return userName;
    }

    public Map<String, ArrayList<TestCase>> getRecords() {
        return records;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRecords(Map<String, ArrayList<TestCase>> records) {
        this.records = records;
    }

    public void insertTestRecord(String date, ArrayList<TestCase> test) {
        this.records.put(date, test);
    }
}
