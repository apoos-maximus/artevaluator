package com.artevaluator.grammar.Exception;

public class WrongLiteralException extends Exception {
    char wrong_literal;

    public WrongLiteralException(char a) {
        wrong_literal = a;
    }

    @Override
    public String toString() {
        return "WrongLiteralException{" +
                "wrong_literal=" + wrong_literal +
                '}';
    }


}
