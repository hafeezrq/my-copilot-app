package com.example.passwordManager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {

    private PasswordChecker passwordChecker;

    @BeforeEach
    public void setUp() {
        passwordChecker = new PasswordChecker();
    }

    @Test
    public void testCheckPassword_ValidPassword() {
        assertTrue(passwordChecker.checkPassword("Valid123"));
    }

    @Test
    public void testCheckPassword_ShortPassword() {
        assertFalse(passwordChecker.checkPassword("Short1"));
    }

    @Test
    public void testCheckPassword_LongPassword() {
        assertFalse(passwordChecker.checkPassword("ThisPasswordIsWayTooLong123"));
    }

    @Test
    public void testCheckPassword_NoUppercase() {
        assertFalse(passwordChecker.checkPassword("nouppercase123"));
    }

    @Test
    public void testCheckPassword_NoLowercase() {
        assertFalse(passwordChecker.checkPassword("NOLOWERCASE123"));
    }

    @Test
    public void testCheckPassword_NoDigit() {
        assertFalse(passwordChecker.checkPassword("NoDigitHere"));
    }

    @Test
    public void testCheckPasswordAndThrowReason_ValidPassword() {
        assertDoesNotThrow(() -> passwordChecker.checkPasswordAndThrowReason("Valid123"));
    }

    @Test
    public void testCheckPasswordAndThrowReason_ShortPassword() {
        Exception exception = assertThrows(Exception.class,
                () -> passwordChecker.checkPasswordAndThrowReason("Short1"));
        assertEquals("Password must be between 8 and 20 characters long.", exception.getMessage());
    }

    @Test
    public void testCheckPasswordAndThrowReason_LongPassword() {
        Exception exception = assertThrows(Exception.class,
                () -> passwordChecker.checkPasswordAndThrowReason("ThisPasswordIsWayTooLong123"));
        assertEquals("Password must be between 8 and 20 characters long.", exception.getMessage());
    }

    @Test
    public void testCheckPasswordAndThrowReason_NoUppercase() {
        Exception exception = assertThrows(Exception.class,
                () -> passwordChecker.checkPasswordAndThrowReason("nouppercase123"));
        assertEquals("Password must contain at least one uppercase letter.", exception.getMessage());
    }

    @Test
    public void testCheckPasswordAndThrowReason_NoLowercase() {
        Exception exception = assertThrows(Exception.class,
                () -> passwordChecker.checkPasswordAndThrowReason("NOLOWERCASE123"));
        assertEquals("Password must contain at least one lowercase letter.", exception.getMessage());
    }

    @Test
    public void testCheckPasswordAndThrowReason_NoDigit() {
        Exception exception = assertThrows(Exception.class,
                () -> passwordChecker.checkPasswordAndThrowReason("NoDigitHere"));
        assertEquals("Password must contain at least one digit.", exception.getMessage());
    }
}