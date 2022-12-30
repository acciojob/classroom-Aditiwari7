package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    private Map<String, Student> studentMap;
    private Map<String, Teacher> teacherMap;
    private Map<String, List<String>> teacherStudentMap;

    public StudentRepository(){
        this.studentMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
        this.teacherStudentMap = new HashMap<>();
    }

    public void addStudentInDB(Student student){
        studentMap.put(student.getName(), student);
    }

    public void addTeacherInDB(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }

    public void addSTPairInDB(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            List<String> currStudentsList = new ArrayList<>();

            if(teacherStudentMap.containsKey(teacher))
                currStudentsList = teacherStudentMap.get(teacher);
            currStudentsList.add(student);
            teacherStudentMap.put(teacher, currStudentsList);
        }
    }

    public Student findStudentInDB(String student){
        return studentMap.get(student);
    }

    public Teacher findTeacherInDB(String teacher){
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsByTeacherInDB(String teacher){
        if(teacherStudentMap.containsKey(teacher))
            return teacherStudentMap.get(teacher);

        return new ArrayList<>();
    }

    public List<String> findAllStudentsInDB(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacherFromDB(String teacher){
        List<String> studentOfTeacher = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)){
            studentOfTeacher = teacherStudentMap.get(teacher);
            for (String student : studentOfTeacher){
                if (studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }
            teacherStudentMap.remove(teacher);
        }
        if(teacherMap.containsKey(teacher))
            teacherMap.remove(teacher);
    }

    public void deleteAllTeachersFromDB(){
        Set<String> studentSet = new HashSet<>();
        teacherMap = new HashMap<>();

        for(String teacher : teacherStudentMap.keySet())
            for (String student : teacherStudentMap.get(teacher))
                studentSet.add(student);

        for (String student : studentSet)
            if (studentMap.containsKey(student))
                studentMap.remove(student);

        teacherStudentMap = new HashMap<>();
    }
}
