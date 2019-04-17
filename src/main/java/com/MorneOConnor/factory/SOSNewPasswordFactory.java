package com.MorneOConnor.factory;

import com.MorneOConnor.domain.SOSNewPassword;

public class SOSNewPasswordFactory {
    public static SOSNewPassword createSOSNewPassword(
            String newSOSPassword)
    {
        return new SOSNewPassword.Builder()
                .newSOSPassword(newSOSPassword)
                .build();
    }
}
