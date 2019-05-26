package com.MorneOConnor.service;

import com.MorneOConnor.domain.Student;

import java.util.Set;

public interface IStudentService extends IService<Student, String> {
    Set<Student> getAll();
}
