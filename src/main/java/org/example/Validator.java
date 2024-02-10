package org.example;

import org.example.exceptions.WrongLoginException;
import org.example.exceptions.WrongPasswordException;

import java.util.Objects;

public class Validator {
    private Validator() {
    }

//    public static boolean validateUser(String login, String password, String confirmPassword) {
//        try {
//            validateLogin(login);
//        } catch (WrongLoginException e) {
//            return false;
//        }
//        try {
//            validatePassword(password, confirmPassword);
//        } catch (WrongPasswordException e) {
//            return false;
//        }
//        return true;
//    }
//
//    private static void validateLogin(String login) {
//        String symbols = "1234567890_qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
//        if (login.length() > 20) {
//            throw new WrongLoginException("Слишком длинный логин");
//        }
//        for (int i = 0; i < login.length(); i++) {
//            int j;
//            for (j = 0; j < symbols.length(); j++) {
//                if (login.charAt(i) == symbols.charAt(j)) {
//                    break;
//                }
//            }
//            if (login.charAt(i) != symbols.charAt(j)) {
//                throw new WrongLoginException("Некорректный логин");
//            }
//        }
//
//    }
//
//    private static void validatePassword(String password, String confirmPassword) {
//        String symbols = "1234567890_qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
//        if (password.length() >= 20) {
//            throw new WrongPasswordException("Слишком длинный пароль");
//        }
//        for (int i = 0; i < password.length(); i++) {
//            int j;
//            for (j = 0; j < symbols.length(); j++) {
//                if (password.charAt(i) == symbols.charAt(j)) {
//                    break;
//                }
//            }
//            if (password.charAt(i) != symbols.charAt(j)) {
//                throw new WrongPasswordException("Некорректный пароль");
//            }
//            if (!confirmPassword.equals(password)) {
//                throw new WrongPasswordException("Пароли не совпадают");
//            }
//        }
//    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        if (Objects.isNull(password) || password.length() >= 20) {
            throw new WrongPasswordException("Слишком длинный пароль");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        Checker checker = new LoopChecker();
        if (!checker.isValid(login)) {
            throw new WrongLoginException("Некорректный логин");
        }
        if (!checker.isValid(password)) {
            throw new WrongLoginException("Некорректный пароль");
        }
    }
}
