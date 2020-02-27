package com.artevaluator.operator;

public class Addition extends Operator {
    @Override
    public double Solve(double a, double b) {
        return a+b;
    }

    @Override
    public double Solve(double a) {
        return 0;
    }
}
