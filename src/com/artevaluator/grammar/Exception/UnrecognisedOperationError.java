package com.artevaluator.grammar.Exception;

public class UnrecognisedOperationError extends Throwable {
    @Override
    public String toString() {
        return "this evaluator only supports: sin, cos, tan, log operations !";
    }
}
