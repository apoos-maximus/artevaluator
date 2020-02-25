package operator;


public class Tan extends operator {
    public Tan(){
        this.precedence=0;
        this.leftAssociative=true;
    }


    @Override
    public Double Solve(double a, double b) {
        return 0.0;
    }

    @Override
    public Double solve(double a) {
        return Math.tan(a);
    }
}
