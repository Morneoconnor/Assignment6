package com.MorneOConnor.factory;

import com.MorneOConnor.domain.PasswordRequirements;

public class PasswordRequirementsFactory {
    public static PasswordRequirements createPasswordRequirements (
            String passwordCharacther, int passwordCharactherLenght, int id)
    {
        return new PasswordRequirements.Builder()
                .passwordCharacther(passwordCharacther)
                .passwordCharactherLenght(passwordCharactherLenght)
                .id(id)
                .build();
    }
}
