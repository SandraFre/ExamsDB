package lt.codeacademy.service;

import lt.codeacademy.entity.StudentAnswer;
import lt.codeacademy.repository.ExamRepository;
import lt.codeacademy.repository.StudentAnswerRepository;

import java.util.Scanner;

public class StudentAnswerService {
    private final StudentAnswerRepository studentAnswerRepository;

    public StudentAnswerService(){
        studentAnswerRepository = new StudentAnswerRepository();
    }

    public void enterAnswer(Scanner sc){
        System.out.println("Enter your answer:");
        String answer = sc.nextLine();

        StudentAnswer studentAnswer = new StudentAnswer(answer);
        studentAnswerRepository.createNewStudentAnswer(studentAnswer);
    }
}
