package com.artevaluator.grammar;

import java.util.ArrayList;

public class SyntaxAnalyser {
    ArrayList<Token> expression;
    String rawExpression;

    void A(){}
    void exp(){
        value();
        A();
    }
    public void parse(){
        exp();
    }
    public SyntaxAnalyser(ArrayList<Token> a, String b){
        expression = a;
        rawExpression = b;
    }
}
