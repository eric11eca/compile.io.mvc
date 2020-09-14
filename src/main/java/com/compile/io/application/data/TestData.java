package com.compile.io.application.data;

import com.compile.io.application.entity.TestRecords;

import java.util.Map;

public class TestData {
    private Map<String, TestRecords> testDataTable;

    public TestRecords getTestDataByUsername(String username) {
        if(testDataTable.containsKey(username)) {
            return testDataTable.get(username);
        }
        return new TestRecords(username);
    }
}
