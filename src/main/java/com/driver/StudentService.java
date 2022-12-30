package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository stuRepo;

    public void addStudent(Student student){
        stuRepo.addStudentInDB(student);
    }

    public void addTeacher(Teacher teacher){
        stuRepo.addTeacherInDB(teacher);
    }

    public void addSTPair(String student, String teacher){
        stuRepo.addSTPairInDB(student, teacher);
    }

    public Student findStudent(String student){
        return stuRepo.findStudentInDB(student);
    }

    public Teacher findTeacher(String teacher){
        return stuRepo.findTeacherInDB(teacher);
    }

    public List<String> findStudentsByTeacher(String teacher){
        return stuRepo.findStudentsByTeacherInDB(teacher);
    }

    public List<String> findAllStudent(){
        return stuRepo.findAllStudentsInDB();
    }

    public void deleteTeacher(String teacher){
        stuRepo.deleteTeacherFromDB(teacher);
    }

    public void deleteAllTeachers(){
        stuRepo.deleteAllTeachersFromDB();
    }
}
