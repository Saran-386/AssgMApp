package com.example.assg;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReportActivity extends AppCompatActivity {
    private TextView reportTextView; // TextView to display the report

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        reportTextView = findViewById(R.id.reportTextView); // Link to TextView in layout

        generateReport();
    }

    private void generateReport() {
        // Sample data - replace with actual data fetching logic
        ArrayList<Student> students = fetchStudentData();

        // Calculate total marks and rank the students
        for (Student student : students) {
            student.calculateTotal();
        }

        // Sort students based on total marks in descending order
        Collections.sort(students, Comparator.comparingInt(Student::getTotal).reversed());

        // Generate report text
        StringBuilder report = new StringBuilder();
        report.append("Rank\tName\tTotal\tStatus\n");
        report.append("---------------------------------\n");

        int rank = 1;
        int passCount = 0;
        int failCount = 0;

        for (Student student : students) {
            String status = student.hasPassed() ? "Pass" : "Fail";
            report.append(rank).append("\t")
                    .append(student.getName()).append("\t")
                    .append(student.getTotal()).append("\t")
                    .append(status).append("\n");

            if (status.equals("Pass")) {
                passCount++;
            } else {
                failCount++;
            }

            rank++;
        }

        report.append("\nTotal Passed: ").append(passCount)
                .append("\nTotal Failed: ").append(failCount);

        // Display the report
        reportTextView.setText(report.toString());
    }

    private ArrayList<Student> fetchStudentData() {
        // Placeholder for actual data fetching logic
        ArrayList<Student> students = new ArrayList<>();

        // Example student data
        students.add(new Student("Alice", new int[]{70, 80, 90})); // Add actual marks
        students.add(new Student("Bob", new int[]{50, 60, 70}));
        students.add(new Student("Charlie", new int[]{30, 40, 20}));

        return students;
    }
}
