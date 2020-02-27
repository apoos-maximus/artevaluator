package com.artevaluator.operator;

public class Division extends Operator{
    @Override
    public double Solve(double a, double b) {
        if(b == 0.0){
            System.out.println("Divide by zero error !");
            if(a >=0)
                return Double.POSITIVE_INFINITY;
            else
                return Double.NEGATIVE_INFINITY;
        }
        else {
            return a/b;
        }
    }

    @Override
    public double Solve(double a) {
        return 0;
    }
}
