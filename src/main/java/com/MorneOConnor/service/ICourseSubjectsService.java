package com.MorneOConnor.service;

import com.MorneOConnor.domain.CourseSubjects;

import java.util.Set;

public interface ICourseSubjectsService extends IService<CourseSubjects, String> {
    Set<CourseSubjects> getAll();
}
