package org.example;

import org.example.exceptions.WrongLoginException;
import org.example.exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        boolean result = Validator.validate("yhhfn33989_4",
                "rtyfhjfjj_64yh1dghhfgsgsgsjshgsdh",
                "rtyfhjfjj_64yh1dghhfgsgsgsjshgsdh");
        if (result) {
            System.out.println("Логин и пароль корректные");
        }
    }
}