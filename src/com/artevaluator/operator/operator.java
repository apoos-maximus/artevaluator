package operator;

public abstract class operator {
   int precedence;
   Boolean leftAssociative=false;
   public abstract Double Solve(double a,double b);
   public abstract Double solve(double a);

}
