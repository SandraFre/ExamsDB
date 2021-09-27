package lt.codeacademy.service;

import lt.codeacademy.entity.Exam;
import lt.codeacademy.entity.Student;
import lt.codeacademy.repository.ExamRepository;

import java.util.List;
import java.util.Scanner;

public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(){
        examRepository = new ExamRepository();
    }

    public void createExam(Scanner sc){
        System.out.println("----Exam info----");
        System.out.println("Enter exam title:");
        String title = sc.nextLine();

        Exam exam = new Exam(title);

        examRepository.createNewExam(exam);

        if (exam.getId()!=null) {
            System.out.println("Exam " + exam.getTitle() + " created successfully");
            System.out.println("Exam id: " + exam.getId());
        } else {
            System.out.println("Exam was not created");
        }
    }


    public void getExamsWithResults(){
        List<Exam> exams = examRepository.getExams();
        for (Exam e: exams){
            System.out.println(e.getId() + " " + e.getTitle() + " " + e.getResults());
        }
    }

    public void getExamsWithQuestions(){
        List<Exam> exams = examRepository.getExams();
        for (Exam e: exams){
            System.out.println(e.getId() + " " + e.getTitle() + " " + e.getQuestions());
        }
    }
}
