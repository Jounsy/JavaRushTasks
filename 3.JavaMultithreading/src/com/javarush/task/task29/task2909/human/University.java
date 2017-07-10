package com.javarush.task.task29.task2909.human;


import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;

    private int age;

    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        //students.add(new Student(name, age, 0));
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public Student getStudentWithAverageGrade(double grade) {
        //TODO:

        for(Student averageStudents: students){
            if(averageStudents.getAverageGrade() == grade){return averageStudents;}

        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student maxAverageStudent = students.get(0);

        for(Student averageStudents: students){
            if(averageStudents.getAverageGrade() > maxAverageStudent.getAverageGrade()){
                maxAverageStudent = averageStudents;
            }
        }

        return maxAverageStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minGrade = 100;
        int index = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < minGrade) {
                minGrade = students.get(i).getAverageGrade();
                index = i;
            }
        }

        return students.get(index);
    }

    public void expel(Student student) {
        students.remove(student);
    }


}