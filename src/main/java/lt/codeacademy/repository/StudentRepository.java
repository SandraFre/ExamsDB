package lt.codeacademy.repository;

import lt.codeacademy.entity.Student;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository extends AbstractRepository{

    public void createNewStudent(Student student){
        changeEntity(session -> session.save(student));
    }

    public List<Student> getStudents(){
        return getEntityInformation(session -> session.createQuery("FROM Student", Student.class).list());
    }

    public Student getStudent (Long id){
        return getEntityInformation(session -> session.get(Student.class, id));
    }

    public void updateStudent (Student student){
        changeEntity(session -> session.update(student));
    }

    public void updateStudentInfoById (Long id, String name, String surname){
        changeEntity(session -> {
            Query query = session.createQuery("UPDATE Student SET name=:name, surname=:surname WHERE id=:id");
            query.setParameter("name", name);
            query.setParameter("surname", surname);
            query.setParameter("id", id);

            query.executeUpdate();
        });
    }

    public void deleteStudentById(Long id){
        Student student = new Student();
        student.setId(id);
        changeEntity(session -> session.delete(student));
    }

}
