package com.compile.io.application.entity;

public class TestCase {
    private int id;
    private String assignment;
    private String caseName;
    private String isPassed;
    private String errorMessage;

    public TestCase(int id, String assignment, String caseName, String isPassed, String errorMessage) {
        this.id = id;
        this.assignment = assignment;
        this.caseName = caseName;
        this.isPassed = isPassed;
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public String getCaseName() {
        return caseName;
    }

    public String getIsPassed() {
        return isPassed;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
