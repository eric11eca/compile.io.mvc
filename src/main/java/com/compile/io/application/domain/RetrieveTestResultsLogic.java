package com.compile.io.application.domain;

import com.compile.io.application.data.TestData;
import com.compile.io.application.entity.TestRecords;

public class RetrieveTestResultsLogic {
    private TestData testData;

    public TestRecords retrieveTestRecords(String username) {
        return testData.getTestDataByUsername(username);
    }
}
