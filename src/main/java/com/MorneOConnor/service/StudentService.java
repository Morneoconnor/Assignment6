package com.MorneOConnor.service;

import com.MorneOConnor.domain.Student;
import com.MorneOConnor.repository.IStudentRepository;
import com.MorneOConnor.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

    @Service
    public class StudentService implements IStudentService{

        private static StudentService service = null;
        private IStudentRepository repository;

        private StudentService() {
            this.repository =  StudentRepository.getRepository();
        }

        public static StudentService getService(){
            if (service == null) service = new StudentService();
            return service;
        }

        @Override
        public Student create(Student questions) {
            return this.repository.create(questions);
        }

        @Override
        public Student update(Student questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public Student read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<Student> getAll() {
            return this.repository.getAll();
        }
    }


