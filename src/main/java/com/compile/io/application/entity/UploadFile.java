package com.compile.io.application.entity;


public class UploadFile {
    private String username;
    private String assignment;

    private String fileName;
    private String fileContent;

    public UploadFile(String username, String assignment, String fileName, String fileContent) {
        this.username = username;
        this.assignment = assignment;
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public String getUsername() {
        return username;
    }

    public String getAssignment() {
        return assignment;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileContent() {
        return fileContent;
    }
}