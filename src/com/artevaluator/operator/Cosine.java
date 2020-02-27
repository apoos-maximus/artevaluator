package com.artevaluator.operator;

public class Cosine extends Operator {
    @Override
    public double Solve(double a, double b) {
        return 0;
    }

    @Override
    public double Solve(double a) {
        return Math.cos(a);
    }
}
