package org.example;

public class Main {
    public static void main(String[] args) {
        boolean result = validateUser("kjygylkblbljbljbtyhhfn33989_4", "rtyfhjfjj_64yh", "rtyfhjfjj_64yh");
        System.out.println(result);
    }

    private static boolean validateUser(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
        } catch (WrongLoginException e) {
            return false;
        }
        try {
            validatePassword(password, confirmPassword);
        } catch (WrongPasswordException e) {
            return false;
        }
        return true;
    }

    private static void validateLogin(String login) {
        String symbols = "1234567890_qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        for (int i = 0; i < login.length(); i++) {
            int j;
            for (j = 0; j < symbols.length(); j++) {
                if (login.charAt(i) == symbols.charAt(j)) {
                    break;
                }
            }
            if (login.charAt(i) != symbols.charAt(j)) {
                throw new WrongLoginException("Некорректный логин");
            }
        }

    }

    private static void validatePassword(String password, String confirmPassword) {
        String symbols = "1234567890_qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        if (password.length() >= 20) {
            throw new WrongPasswordException("Слишком длинный пароль");
        }
        for (int i = 0; i < password.length(); i++) {
            int j;
            for (j = 0; j < symbols.length(); j++) {
                if (password.charAt(i) == symbols.charAt(j)) {
                    break;
                }
            }
            if (password.charAt(i) != symbols.charAt(j)) {
                throw new WrongPasswordException("Некорректный пароль");
            }
            if (!confirmPassword.equals(password)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        }
    }
}