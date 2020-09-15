package com.compile.io.application.domain;

import com.compile.io.application.data.TestData;
import com.compile.io.application.entity.TestCase;
import com.compile.io.application.entity.TestRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component("testLogic")
public class TestLogic {
    @Autowired
    private TestData testData;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public TestLogic() {}

    public Set<String> getAllAssignments() {
        return testData.getAssignmentList();
    }

    public TestRecords getTestsByUserNameAssignment(String username, String assignment) {
        Map<String, TestRecords> testTable = getTestsByAssignment(assignment);
        if (testTable.containsKey(username)) {
            return testTable.get(username);
        }
        return new TestRecords(username);
    }

    public Map<String, TestRecords> getTestsByAssignment(String assignment) {
        return testData.getTestDataByAssignment(assignment);
    }

    public void runTestCases(String code, String assignment, String username) {
        ArrayList<TestCase> record = new ArrayList<>();

        if (assignment.equals("HW1_AVL")) {
            if (username.equals("blakes")) {
                record = new ArrayList<>();
                record.add(new TestCase(1, "HW1_BST", "Basic Insertion", "Yes", "None"));
                record.add(new TestCase(1, "HW1_BST", "Complex Insertion", "Yes", "None"));
                record.add(new TestCase(1, "HW1_BST", "Basic Deletion", "Yes", "None"));
                record.add(new TestCase(1, "HW1_BST", "Complex Deletion", "Yes", "None"));
            } else if (username.equals("gaoq")) {
                record = new ArrayList<>();
                record.add(new TestCase(1, "HW1_BST", "Basic Insertion", "Yes", "None"));
                record.add(new TestCase(1, "HW1_BST", "Complex Insertion", "Yes", "None"));
                record.add(new TestCase(1, "HW1_BST", "Basic Deletion", "Yes", "None"));
                record.add(new TestCase(1, "HW1_BST", "Complex Deletion", "Yes", "None"));
            }
        } else if (assignment.equals("HW2_Search,BFS")) {
            if (username.equals("blakes")) {
                record = new ArrayList<>();
                record.add(new TestCase(1, "HW2_Search,BFS", "Simple Path Search", "Yes", "None"));
                record.add(new TestCase(1, "HW2_Search,BFS", "Long Path Search", "Yes", "None"));
                record.add(new TestCase(1, "HW2_Search,BFS", "Obstacle Path Search", "No", "Unimplemented"));
                record.add(new TestCase(1, "HW2_Search,BFS", "Multi-goal Path Search", "No", "Unimplemented"));
            } else if (username.equals(("gaoq"))) {
                record = new ArrayList<>();
                record.add(new TestCase(1, "HW2_Search,BFS", "Simple Path Search", "Yes", "None"));
                record.add(new TestCase(1, "HW2_Search,BFS", "Long Path Search", "Yes", "None"));
                record.add(new TestCase(1, "HW2_Search,BFS", "Obstacle Path Search", "Yes", "None"));
                record.add(new TestCase(1, "HW2_Search,BFS", "Multi-goal Path Search", "Yes", "None"));
            }
        } else if (assignment.equals("HW2_Search,Astar")) {
            if (username.equals("blakes")) {
                record = new ArrayList<>();
                record.add(new TestCase(1, "HW2_Search,Astar", "Simple Path Search", "Yes", "None"));
                record.add(new TestCase(1, "HW2_Search,Astar", "Obstacle Path Search", "No", "Unimplemented"));
                record.add(new TestCase(1, "HW2_Search,Astar", "Advanced Heuristic", "No", "Unimplemented"));
                record.add(new TestCase(1, "HW2_Search,Astar", "Bidirectional Search", "No", "Unimplemented"));
            } else if (username.equals(("gaoq"))) {
                record = new ArrayList<>();
                record.add(new TestCase(1, "HW2_Search,Astar", "Simple Path Search", "Yes", "None"));
                record.add(new TestCase(1, "HW2_Search,Astar", "Obstacle Path Search", "Yes", "None"));
                record.add(new TestCase(1, "HW2_Search,Astar", "Advanced Heuristic", "No", "Fail at Manhattan Distance"));
                record.add(new TestCase(1, "HW2_Search,Astar", "Bidirectional Search", "No", "Unimplemented"));
            }
        }

        insertTestRecord(record, username, assignment);
    }

    private void insertTestRecord(ArrayList<TestCase> record, String username, String assignment) {
        Map<String, TestRecords> testTable = testData.getTestDataByAssignment(assignment);
        TestRecords records = testTable.get(username);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(records);
        System.out.println(record);
        records.insertTestRecord(dtf.format(now), record);
    }


}
