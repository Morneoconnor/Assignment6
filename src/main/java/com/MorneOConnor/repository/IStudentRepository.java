package com.MorneOConnor.repository;

import com.MorneOConnor.domain.Student;

import java.util.Set;

public interface IStudentRepository extends IRepository<Student, String> {
    Set<Student> getAll();
}
