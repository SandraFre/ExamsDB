package lt.codeacademy.repository;

import lt.codeacademy.entity.StudentAnswer;

public class StudentAnswerRepository extends AbstractRepository {

    public void createNewStudentAnswer(StudentAnswer studentAnswer){
        changeEntity(session -> session.save(studentAnswer));
    }
}
