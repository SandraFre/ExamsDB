package lt.codeacademy.service;

import lt.codeacademy.entity.Exam;
import lt.codeacademy.entity.Question;
import lt.codeacademy.entity.Student;
import lt.codeacademy.repository.ExamRepository;
import lt.codeacademy.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExamService {

    private final ExamRepository examRepository;
    private StudentService studentService;

    private StudentAnswerService studentAnswerService;

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
            System.out.println(e.getId() + " " + e.getTitle());
            for (Question question : e.getQuestions().stream().collect(Collectors.toList())) {
                System.out.println(question);
            }
        }
    }

    public void getExamWithQuestionsById(Scanner sc){
        System.out.println("Enter exam id:");
        Long id = sc.nextLong();
        Exam exam = examRepository.getExam(id);
        if (exam==null){
            System.out.println("Exam does not exist");
            return;
        }
        System.out.println("--------");
        System.out.println(exam.getId() + " " + exam.getTitle());
        for (Question question : exam.getQuestions().stream().collect(Collectors.toList())) {
            System.out.println(question);
        }
    }

    public void startExam(Scanner sc){
        System.out.println("Enter exam id:");
        Long id = sc.nextLong();
        Exam exam = examRepository.getExam(id);
        if (exam==null){
            System.out.println("Exam does not exist");
            return;
        }
//        studentService.getStudentById(sc);

        System.out.println("---- Exam: " + exam.getTitle() + " ----");
        for (Question question:exam.getQuestions().stream().collect(Collectors.toList())){
            System.out.println(question.getQuestionTitle());
            System.out.println("a) " + question.getAAnswer());
            System.out.println("b) " + question.getBAnswer());
            System.out.println("c) " + question.getCAnswer());
            studentAnswerService.enterAnswer(sc);
        }

    }


}
