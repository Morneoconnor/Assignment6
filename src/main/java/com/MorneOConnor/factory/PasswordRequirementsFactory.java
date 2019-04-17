package com.MorneOConnor.factory;

import com.MorneOConnor.domain.PasswordRequirements;

public class PasswordRequirementsFactory {
    public static PasswordRequirements createPasswordRequirements (
            String passwordCharacther, int passwordCharactherLenght)
    {
        return new PasswordRequirements.Builder()
                .passwordCharacther(passwordCharacther)
                .passwordCharactherLenght(passwordCharactherLenght)
                .build();
    }
}
