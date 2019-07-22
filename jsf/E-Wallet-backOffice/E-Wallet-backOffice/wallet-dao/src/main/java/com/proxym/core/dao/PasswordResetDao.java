package com.proxym.core.dao;

public interface PasswordResetDao {

    public void createPasswordResetTokenForUser(PasswordReset passwordReset);
    PasswordReset getPasswordResetToken(String token);
    void deletePasswordToken(PasswordReset passwordReset);
}
