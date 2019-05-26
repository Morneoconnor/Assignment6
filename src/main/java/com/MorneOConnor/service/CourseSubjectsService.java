package com.MorneOConnor.service;

import com.MorneOConnor.domain.CourseSubjects;
import com.MorneOConnor.repository.CourseSubjectRepository;
import com.MorneOConnor.repository.ICourseSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

    @Service
    public class CourseSubjectsService implements ICourseSubjectsService{

        private static CourseSubjectsService service = null;
        private ICourseSubjectRepository repository;

        private CourseSubjectsService() {
            this.repository =  CourseSubjectRepository.getRepository();
        }

        public static CourseSubjectsService getService(){
            if (service == null) service = new CourseSubjectsService();
            return service;
        }

        @Override
        public CourseSubjects create(CourseSubjects questions) {
            return this.repository.create(questions);
        }

        @Override
        public  CourseSubjects update(CourseSubjects questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public CourseSubjects read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<CourseSubjects> getAll() {
            return this.repository.getAll();
        }
    }
