package com.artevaluator.grammar.Exception;

public class EmptyParenthesisError extends Exception {
    @Override
    public String toString() {
        return "parenthesis can't be empty";
    }
}
