package com.MorneOConnor.service;

import com.MorneOConnor.domain.StudentPersonalInformation;
import com.MorneOConnor.repository.IStudentPersonalInformationRepository;
import com.MorneOConnor.repository.StudentPersonalInformationRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

    @Service
    public class StudentPersonalInformationService implements IStudentPersonalInformationService{

        private static StudentPersonalInformationService service = null;
        private IStudentPersonalInformationRepository repository;

        private StudentPersonalInformationService() {
            this.repository =  StudentPersonalInformationRepository.getRepository();
        }

        public static StudentPersonalInformationService getService(){
            if (service == null) service = new StudentPersonalInformationService();
            return service;
        }

        @Override
        public StudentPersonalInformation create(StudentPersonalInformation questions) {
            return this.repository.create(questions);
        }

        @Override
        public StudentPersonalInformation update(StudentPersonalInformation questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public StudentPersonalInformation read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<StudentPersonalInformation> getAll() {
            return this.repository.getAll();
        }
    }
