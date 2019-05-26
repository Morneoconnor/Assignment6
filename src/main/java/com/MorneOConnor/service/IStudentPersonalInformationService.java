package com.MorneOConnor.service;

import com.MorneOConnor.domain.StudentPersonalInformation;

import java.util.Set;

public interface IStudentPersonalInformationService extends IService<StudentPersonalInformation, String> {
    Set<StudentPersonalInformation> getAll();
}
