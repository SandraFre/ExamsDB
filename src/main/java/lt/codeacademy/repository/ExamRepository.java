package lt.codeacademy.repository;

import lt.codeacademy.entity.Exam;

import java.util.List;

public class ExamRepository extends AbstractRepository{

    public List<Exam> getExams(){
        return getEntityInformation(session -> session.createQuery("FROM Exam", Exam.class).list());
    }
}
