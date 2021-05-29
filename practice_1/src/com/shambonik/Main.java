package com.shambonik;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Predicate predicate = (ArrayList<Student> students) -> {
            for (Student student: students) {
                if(student.getScore() == 100) return true;
            }
            return false;
        };
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(45, "Andrey"));
        students.add(new Student(99, "Danil"));
        System.out.println(predicate.maxScore(students));
    }
}
