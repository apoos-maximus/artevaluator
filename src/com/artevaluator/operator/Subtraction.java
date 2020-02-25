package operator;


    public class Subtraction extends operator {
        public Subtraction(){
            this.precedence=2;
            this.leftAssociative=true;
        }


        @Override
        public Double Solve(double a, double b) {
            return a-b;
        }

        @Override
        public Double solve(double a) {
            return a-1;
        }
    }

