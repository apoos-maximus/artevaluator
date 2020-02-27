package com.artevaluator.operator;

public class Tangent extends Operator {
    @Override
    public double Solve(double a, double b) {
        return 0;
    }

    @Override
    public double Solve(double a) {
        return Math.tan(a);
    }
}
