package operator;


public class Power extends operator {
    public Power(){
        this.precedence=0;
        this.leftAssociative=true;
    }


    @Override
    public Double Solve(double a, double b) {
        return Math.pow(a,b);
    }

    @Override
    public Double solve(double a) {
        return 0.0;
    }
}
