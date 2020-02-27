package com.artevaluator.operator;

public class Logarithm extends Operator {
    @Override
    public double Solve(double a, double b) {
        return 0;
    }

    @Override
    public double Solve(double a) {
        return Math.log10(a);
    }
}
