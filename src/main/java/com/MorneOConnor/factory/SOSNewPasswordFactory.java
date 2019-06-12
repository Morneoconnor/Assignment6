package com.MorneOConnor.factory;

import com.MorneOConnor.domain.SOSNewPassword;

public class SOSNewPasswordFactory {
    public static SOSNewPassword createSOSNewPassword(
            String newSOSPassword, int id)
    {
        return new SOSNewPassword.Builder()
                .newSOSPassword(newSOSPassword)
                .id(id)
                .build();
    }
}
