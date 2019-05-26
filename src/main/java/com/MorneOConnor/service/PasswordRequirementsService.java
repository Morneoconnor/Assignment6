package com.MorneOConnor.service;

import com.MorneOConnor.domain.PasswordRequirements;
import com.MorneOConnor.repository.IPasswordRequirementsRepository;
import com.MorneOConnor.repository.PasswordRequirementsRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

    @Service
    public class PasswordRequirementsService implements IPasswordRequirementsService{

        private static PasswordRequirementsService service = null;
        private IPasswordRequirementsRepository repository;

        private PasswordRequirementsService() {
            this.repository =  PasswordRequirementsRepository.getRepository();
        }

        public static PasswordRequirementsService getService(){
            if (service == null) service = new PasswordRequirementsService();
            return service;
        }

        @Override
        public PasswordRequirements create(PasswordRequirements questions) {
            return this.repository.create(questions);
        }

        @Override
        public  PasswordRequirements update(PasswordRequirements questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public PasswordRequirements read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<PasswordRequirements> getAll() {
            return this.repository.getAll();
        }
    }

