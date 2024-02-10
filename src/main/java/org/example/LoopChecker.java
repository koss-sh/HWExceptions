package org.example;

public class LoopChecker implements Checker {
//    private static final String SYMBOLS = "1234567890_qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
//
//    @Override
//    public boolean isValid(String s) {
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            if (!SYMBOLS.contains(Character.toString(c))) {
//                return false;
//            }
//        }
//        return true;
//    }

    @Override
    public boolean isValid(String s){
        return s.matches("^\\w+$");
    }
}
