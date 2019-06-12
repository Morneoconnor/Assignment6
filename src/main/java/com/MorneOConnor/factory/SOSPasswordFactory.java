package com.MorneOConnor.factory;

import com.MorneOConnor.domain.SOSPassword;

public class SOSPasswordFactory {
    public static SOSPassword createSOSPassword(
            String oldSOSPassword, int id)
    {
        return new SOSPassword.Builder()
                .oldSOSPassword(oldSOSPassword)
                .id(id)
                .build();
    }
}
