package com.example.passwordManager;

public class PasswordChecker {
    /**
     * Checks if the given password meets the following criteria:
     * <ul>
     * <li>Is at least 8 characters long and at most 20 characters long</li>
     * <li>Contains at least one uppercase letter</li>
     * <li>Contains at least one lowercase letter</li>
     * <li>Contains at least one digit</li>
     * </ul>
     *
     * @param password the password to check
     * @return {@code true} if the password meets all the criteria, {@code false}
     *         otherwise
     */
    public boolean checkPassword(String password) {
        // Check if the password is at least 8 characters long and at most 20 characters
        // long
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        // Check if the password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if the password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if the password contains at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }

    /**
     * Checks the validity of the given password and throws an exception with a
     * specific reason if the password is invalid.
     *
     * @param password the password to be checked
     * @throws Exception if the password does not meet the required criteria:
     *                   - Password must be between 8 and 20 characters long.
     *                   - Password must contain at least one uppercase letter.
     *                   - Password must contain at least one lowercase letter.
     *                   - Password must contain at least one digit.
     */
    public void checkPasswordAndThrowReason(String password) throws Exception {
        if (password.length() < 8 || password.length() > 20) {
            throw new Exception("Password must be between 8 and 20 characters long.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new Exception("Password must contain at least one uppercase letter.");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new Exception("Password must contain at least one lowercase letter.");
        }

        if (!password.matches(".*\\d.*")) {
            throw new Exception("Password must contain at least one digit.");
        }
    }
}
