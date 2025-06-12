package com.ksivlay.crudstudentapp.activity;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ksivlay.crudstudentapp.models.Province;
import com.ksivlay.crudstudentapp.models.Student;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    protected static List<Student> studentList = new ArrayList<>();
    protected static List<Province> provinceList = new ArrayList<>();
    protected Student getStudentById(int id){
        Student student = new Student();
        for(Student data : studentList){
            if(data.getId() == id){
                student = data;
            }
        }
        return student;
    }

    protected List<Student> getAllStudents(){
        if(studentList.isEmpty()){
            Student student = new Student();
            student.setId(studentList.size()+1);
            student.setFirstName("Kheang");
            student.setLastName("Sivlay");
            student.setGender("Male");
            student.setProvince(new Province(1,"Phnom Penh"));
            student.setAddress("Phnom Penh");
            student.setPhoneNumber("012 666 888");
            studentList.add(student);

            Student student1 = new Student();
            student1.setId(studentList.size()+1);
            student1.setFirstName("Mr.");
            student1.setLastName("Jimmy");
            student1.setGender("Male");
            student1.setProvince(new Province(1,"Phnom Penh"));
            student1.setAddress("Phnom Penh");
            student1.setPhoneNumber("089 555 454");
            studentList.add(student1);
        }
        return studentList;
    }

    public List<Province> getAllProvince(){
        provinceList = new ArrayList<>();
        provinceList.add(new Province(1,"Phnom Penh"));
        provinceList.add(new Province(2,"Battambang"));
        provinceList.add(new Province(3,"Takeo"));
        provinceList.add(new Province(4,"Prey Veng"));
        return provinceList;
    }

    protected void addStudent(Student student){
        studentList.add(student);
    }
    protected Province getProvinceById(int id){
        for(Province data: provinceList){
            if(data.getId() == id){
                return data;
            }
        }
        return null;
    }

    protected void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
