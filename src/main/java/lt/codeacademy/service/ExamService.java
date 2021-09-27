package lt.codeacademy.service;

import lt.codeacademy.entity.Exam;
import lt.codeacademy.repository.ExamRepository;

import java.util.List;

public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(){
        examRepository = new ExamRepository();
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
