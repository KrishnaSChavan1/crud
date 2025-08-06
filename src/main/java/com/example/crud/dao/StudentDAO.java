package com.example.crud.dao;

import com.example.crud.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
}
