package com.artevaluator.grammar.Exception;

public class OperatorRequiredError extends Exception {

    @Override
    public String toString() {
        return "operator expected after closing parenthesis ! ";
    }
}
