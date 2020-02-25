package operator;


public class Cos extends operator {
    public Cos(){
        this.precedence=0;
        this.leftAssociative=true;
    }


    @Override
    public Double Solve(double a, double b) {
        return 0.0;
    }

    @Override
    public Double solve(double a) {
        return Math.cos(a);
    }
}
