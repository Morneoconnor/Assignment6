package com.MorneOConnor.service;

import com.MorneOConnor.domain.SOSPassword;
import com.MorneOConnor.repository.ISOSPasswordRepository;
import com.MorneOConnor.repository.SOSPasswordRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SOSPasswordService implements ISOSPasswordService{

    private static SOSPasswordService service = null;
    private ISOSPasswordRepository repository;

    private SOSPasswordService() {
        this.repository =  SOSPasswordRepository.getRepository();
    }

    public static SOSPasswordService getService(){
        if (service == null) service = new SOSPasswordService();
        return service;
    }

    @Override
    public SOSPassword create(SOSPassword questions) {
        return this.repository.create(questions);
    }

    @Override
    public  SOSPassword update(SOSPassword questions) {
        return this.repository.update(questions);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public SOSPassword read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<SOSPassword> getAll() {
        return this.repository.getAll();
    }
}

