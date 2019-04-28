package com.MorneOConnor.repository;

import com.MorneOConnor.domain.StudentPersonalInformation;

import java.util.Set;

public interface IStudentPersonalInformationRepository extends IRepository<StudentPersonalInformation, String> {
    Set<StudentPersonalInformation> getAll();
}
