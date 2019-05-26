package com.MorneOConnor.service;

import com.MorneOConnor.domain.CourseRegistration;

import java.util.Set;

public interface ICourseRegistrationService extends IService<CourseRegistration, String> {
    Set<CourseRegistration> getAll();
}
