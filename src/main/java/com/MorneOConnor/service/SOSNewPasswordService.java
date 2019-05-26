package com.MorneOConnor.service;

import com.MorneOConnor.domain.SOSNewPassword;
import com.MorneOConnor.repository.ISOSNewPasswordRepository;
import com.MorneOConnor.repository.SOSNewPasswordRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

    @Service
    public class SOSNewPasswordService implements ISOSNewPasswordService{

        private static SOSNewPasswordService service = null;
        private ISOSNewPasswordRepository repository;

        private SOSNewPasswordService() {
            this.repository =  SOSNewPasswordRepository.getRepository();
        }

        public static SOSNewPasswordService getService(){
            if (service == null) service = new SOSNewPasswordService();
            return service;
        }

        @Override
        public SOSNewPassword create(SOSNewPassword questions) {
            return this.repository.create(questions);
        }

        @Override
        public  SOSNewPassword update(SOSNewPassword questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public SOSNewPassword read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<SOSNewPassword> getAll() {
            return this.repository.getAll();
        }
    }
