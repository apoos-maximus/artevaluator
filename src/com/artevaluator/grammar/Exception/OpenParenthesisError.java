package com.artevaluator.grammar.Exception;

public class OpenParenthesisError extends Exception {
    @Override
    public String toString() {
        return "closing parenthesis required !";
    }
}
