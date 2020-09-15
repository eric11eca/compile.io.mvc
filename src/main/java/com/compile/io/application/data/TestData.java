package com.compile.io.application.data;

import com.compile.io.application.entity.TestCase;
import com.compile.io.application.entity.TestRecords;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Component("testData")
public class TestData {
    private Map<String, Map<String, TestRecords>> assignmentTable;

    public TestData () {
        assignmentTable = new HashMap<>();
        generateData();
    }

    public void generateData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        ArrayList<TestCase> blakesTest1 = new ArrayList<>();
        blakesTest1.add(new TestCase(1, "HW1_AVL", "Basic Insertion", "Yes", "None"));
        blakesTest1.add(new TestCase(1, "HW1_AVL", "Complex Insertion", "Yes", "None"));
        blakesTest1.add(new TestCase(1, "HW1_AVL", "Basic Deletion", "No", "Fail on fifth deletion"));
        blakesTest1.add(new TestCase(1, "HW1_AVL", "Complex Deletion", "No", "Fail on 34th deletion"));

        TestRecords blakesTestRecordsAVL = new TestRecords("blakes");
        blakesTestRecordsAVL.insertTestRecord("2020/09/02:10:30:25", blakesTest1);

        ArrayList<TestCase> gaoqTest1 = new ArrayList<>();
        gaoqTest1.add(new TestCase(1, "HW1_AVL", "Basic Insertion", "Yes", "None"));
        gaoqTest1.add(new TestCase(1, "HW1_AVL", "Complex Insertion", "Yes", "None"));
        gaoqTest1.add(new TestCase(1, "HW1_AVL", "Basic Deletion", "Yes", "None"));
        gaoqTest1.add(new TestCase(1, "HW1_AVL", "Complex Deletion", "No", "Fail on 100th deletion"));

        TestRecords gaoqTestRecordsAVL = new TestRecords("gaoq");
        gaoqTestRecordsAVL.insertTestRecord("2020/09/01:15:42:19", gaoqTest1);

        Map<String, TestRecords> avlTestTable = new HashMap<>();
        avlTestTable.put(blakesTestRecordsAVL.getUserName(), blakesTestRecordsAVL);
        avlTestTable.put(gaoqTestRecordsAVL.getUserName(), blakesTestRecordsAVL);
        assignmentTable.put("HW1_AVL", avlTestTable);

        /* Assignment 2 */
        TestRecords blakesTestRecordsSearchBFS = new TestRecords("blakes");
        TestRecords gaoqTestRecordsSearchBFS = new TestRecords("gaoq");

        Map<String, TestRecords> searchBFSTestTable = new HashMap<>();
        searchBFSTestTable.put(blakesTestRecordsSearchBFS.getUserName(), blakesTestRecordsSearchBFS);
        searchBFSTestTable.put(gaoqTestRecordsSearchBFS.getUserName(), gaoqTestRecordsSearchBFS);
        assignmentTable.put("HW2_Search,BFS", searchBFSTestTable);

        /* Assignment 3 */
        TestRecords blakesTestRecordsSearchAstar = new TestRecords("blakes");
        TestRecords gaoqTestRecordsSearchAstar = new TestRecords("gaoq");

        Map<String, TestRecords> searchAstarTestTable = new HashMap<>();
        searchAstarTestTable.put(blakesTestRecordsSearchAstar.getUserName(), blakesTestRecordsSearchAstar);
        searchAstarTestTable.put(gaoqTestRecordsSearchAstar.getUserName(), gaoqTestRecordsSearchAstar);
        assignmentTable.put("HW2_Search,Astar", searchAstarTestTable);
    }

    public Map<String, TestRecords> getTestDataByAssignment(String assignment) {
        if(assignmentTable.containsKey(assignment)) {
            return assignmentTable.get(assignment);
        }
        return new HashMap<>();
    }

    public Set<String> getAssignmentList() {
        return assignmentTable.keySet();
    }
}
