package operator;


public class Log extends operator {
    public Log(){
        this.precedence=0;
        this.leftAssociative=true;
    }


    @Override
    public Double Solve(double a, double b) {
        return 0.0;
    }

    @Override
    public Double solve(double a) {
        return Math.log(a);
    }
}
