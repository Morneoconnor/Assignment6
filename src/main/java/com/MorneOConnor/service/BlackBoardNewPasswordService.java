package com.MorneOConnor.service;

import com.MorneOConnor.domain.BlackBoardNewPassword;
import com.MorneOConnor.repository.BlackBoardNewPasswordRepository;
import com.MorneOConnor.repository.IBlackBoardNewPasswordRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

    @Service
    public class BlackBoardNewPasswordService implements IBlackBoardNewPasswordService
    {

        private static BlackBoardNewPasswordService service = null;
        private IBlackBoardNewPasswordRepository repository;

        private BlackBoardNewPasswordService() {
            this.repository =  BlackBoardNewPasswordRepository.getRepository();
        }

        public static BlackBoardNewPasswordService getService(){
            if (service == null) service = new BlackBoardNewPasswordService();
            return service;
        }

        @Override
        public BlackBoardNewPassword create(BlackBoardNewPassword questions) {
            return this.repository.create(questions);
        }

        @Override
        public  BlackBoardNewPassword update(BlackBoardNewPassword questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public BlackBoardNewPassword read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<BlackBoardNewPassword> getAll() {
            return this.repository.getAll();
        }
    }


