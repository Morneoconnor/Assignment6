package com.MorneOConnor.service;

import com.MorneOConnor.domain.CourseRegistration;
import com.MorneOConnor.repository.CourseRegistrationRepository;
import com.MorneOConnor.repository.ICourseRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

    @Service
    public class CourseRegistrationService implements ICourseRegistrationService{

        private static CourseRegistrationService service = null;
        private ICourseRegistrationRepository repository;

        private CourseRegistrationService() {
            this.repository =  CourseRegistrationRepository.getRepository();
        }

        public static CourseRegistrationService getService(){
            if (service == null) service = new CourseRegistrationService();
            return service;
        }

        @Override
        public CourseRegistration create(CourseRegistration questions) {
            return this.repository.create(questions);
        }

        @Override
        public  CourseRegistration update(CourseRegistration questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public CourseRegistration read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<CourseRegistration> getAll() {
            return this.repository.getAll();
        }
    }

