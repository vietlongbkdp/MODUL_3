package service;

import model.EGender;
import model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final List<Student> students;
    private static int idCurrent;
    static {
        students = new ArrayList<>();
        students.add(new Student(++idCurrent, "Long", LocalDate.of(1997,5,31), EGender.MALE));
        students.add(new Student(++idCurrent, "Đạt", LocalDate.of(1997,3,22), EGender.MALE));
        students.add(new Student(++idCurrent, "Tường", LocalDate.of(1998,1,30), EGender.MALE));
        students.add(new Student(++idCurrent, "Bình", LocalDate.of(1999,8,7), EGender.FEMALE));
    }
    public List<Student> getAll(){
        return students;
    }

    public void addStudent(String name, LocalDate dob, EGender gender) {
        students.add(new Student(++idCurrent, name, dob, gender));
    }

    public Student getElementById(int index) {
        return students.stream().filter(student -> student.getId() == index).findFirst().orElse(null);
    }

    public void updateStudent(int index, String name, LocalDate dob, EGender gender) {
        for (Student s: students) {
            if (s.getId() == index){
                s.setName(name);
                s.setDob(dob);
                s.setGender(gender);
            }
        }
    }
}
