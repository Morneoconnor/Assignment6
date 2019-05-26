package com.MorneOConnor.service;

import com.MorneOConnor.domain.BlackBoardPassword;
import com.MorneOConnor.repository.BlackBoardPasswordRepository;
import com.MorneOConnor.repository.IBlackBoardPasswordRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BlackBoardPasswordService implements IBlackBoardPasswordService{

        private static BlackBoardPasswordService service = null;
        private IBlackBoardPasswordRepository repository;

        private BlackBoardPasswordService() {
            this.repository =  BlackBoardPasswordRepository.getRepository();
        }

        public static BlackBoardPasswordService getService(){
            if (service == null) service = new BlackBoardPasswordService();
            return service;
        }

        @Override
        public BlackBoardPassword create(BlackBoardPassword questions) {
            return this.repository.create(questions);
        }

        @Override
        public  BlackBoardPassword update(BlackBoardPassword questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public BlackBoardPassword read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<BlackBoardPassword> getAll() {
            return this.repository.getAll();
        }
    }

