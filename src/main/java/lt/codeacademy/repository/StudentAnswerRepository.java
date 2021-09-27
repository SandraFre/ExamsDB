package lt.codeacademy.repository;

import lt.codeacademy.entity.StudentAnswer;

import java.util.List;

public class StudentAnswerRepository extends AbstractRepository {

    public List<StudentAnswer> getStudentAnswers(){
        return getEntityInformation(session -> session.createQuery("FROM StudentAnswer", StudentAnswer.class).list());
    }

    public void createNewStudentAnswer(StudentAnswer studentAnswer){
        changeEntity(session -> session.save(studentAnswer));
    }
}
