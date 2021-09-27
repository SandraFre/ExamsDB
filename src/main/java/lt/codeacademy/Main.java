package lt.codeacademy;

import lt.codeacademy.service.ExamService;
import lt.codeacademy.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        ExamService examService = new ExamService();

//        studentService.createStudent(scanner);
//        studentService.updateStudentInfoById(scanner);
//        studentService.getStudents();

//        examService.createExam(scanner);
//        examService.getExamsWithQuestions();
//        examService.getExamWithQuestionsById(scanner);

        examService.startExam(scanner);


    }
}
