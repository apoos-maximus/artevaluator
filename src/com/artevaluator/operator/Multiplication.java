package operator;

public class Multiplication extends operator {
    public Multiplication(){
        this.precedence=1;
        this.leftAssociative=true;
    }


    @Override
    public Double Solve(double a, double b) {
        return a*b;
    }

    @Override
    public Double solve(double a) {
        return 0.0;
    }
}
