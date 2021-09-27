package lt.codeacademy.repository;

import lt.codeacademy.entity.Exam;
import lt.codeacademy.entity.Student;

import java.util.List;

public class ExamRepository extends AbstractRepository{

    public void createNewExam(Exam exam){
        changeEntity(session -> session.save(exam));
    }

    public Exam getExam (Long id){
        return getEntityInformation(session -> session.get(Exam.class, id));
    }

    public List<Exam> getExams(){
        return getEntityInformation(session -> session.createQuery("FROM Exam", Exam.class).list());
    }
}
