package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseSubjects;

import java.util.Set;

public interface ICourseSubjectRepository extends IRepository<CourseSubjects, String> {
    Set<CourseSubjects> getAll();
}
