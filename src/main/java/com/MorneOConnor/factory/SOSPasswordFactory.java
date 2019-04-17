package com.MorneOConnor.factory;

import com.MorneOConnor.domain.SOSPassword;

public class SOSPasswordFactory {
    public static SOSPassword createSOSPassword(
            String oldSOSPassword)
    {
        return new SOSPassword.Builder()
                .oldSOSPassword(oldSOSPassword)
                .build();
    }
}
