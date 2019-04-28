package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseRegistration;

import java.util.Set;

public interface ICourseRegistrationRepository extends IRepository<CourseRegistration, String> {
    Set<CourseRegistration> getAll();
}
