package edu.psu.l06tripoli;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    private static Gson gson;

    private static final int MAX_STUDENTS = 3;

    public static void main(String[] args) {

        // We want it pretty, right?
        gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            objToJSON();

            displayJSON();
        } catch (IOException e) {
            System.err.println("Something went wrong! " + e.getMessage());
        }
    }

    private static void objToJSON() throws IOException {
        StudentList studentList = new StudentList();

        // Create 3 students
        for (int i = 0; i < MAX_STUDENTS; i++) {
            studentList.addStudent(getStudent());
        }
        writeStudents(studentList);
    }

    private static void displayJSON() throws IOException {
        File file = new File("students.json");
        file.createNewFile(); // will do nothing if already exists
        InputStream is = new FileInputStream("students.json");
        var fileBody = jsonToString(is, "UTF-8");
        var studentList = gson.fromJson(fileBody, StudentList.class);

        for (Student student : studentList.getStudents()) {
            System.out.println(student);
            System.out.println(gson.toJson(student));
        }
    }

    private static void writeStudents(StudentList studentList) throws IOException {
        File file = new File("students.json");
        file.createNewFile(); // does nothing if already exists
        FileOutputStream fout = new FileOutputStream("students.json");
        fout.write(gson.toJson(studentList).getBytes());
        fout.close();
    }

    private static Student getStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student's First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Student's Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Student's GPA: ");
        double gpa = scanner.nextDouble();
        System.out.print("Enter Student's Current Credits: ");
        int currentCredits = scanner.nextInt();
        System.out.print("Enter Student's Total Credits: ");
        int totalCredits = scanner.nextInt();

        return new Student(lastName, gpa, currentCredits, totalCredits, firstName);
    }

    /**
     * Converts a input stream to string with a given encoding type
     *
     * @param inputStream input stream
     * @param encoding    The encoding type of the input
     * @return the input stream and a string
     * @throws UnsupportedEncodingException
     */
    private static String jsonToString(InputStream inputStream, String encoding) throws UnsupportedEncodingException {
        return new BufferedReader(
                new InputStreamReader(inputStream, encoding))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
