package lt.codeacademy.service;

import lt.codeacademy.repository.StudentRepository;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(){
        studentRepository = new StudentRepository();
    }

    public void createStudent(){

    }

    public void getStudents(){
        studentRepository.getStudents().forEach(System.out::println);
    }

    public void updateStudentInfoById(){
//        studentRepository.updateStudentInfoById();
    }

    public void delete(){
//        studentRepository.deleteStudentById();
    }
}
