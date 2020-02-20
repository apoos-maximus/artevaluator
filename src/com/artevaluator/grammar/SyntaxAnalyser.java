package com.artevaluator.grammar;

import java.util.ArrayList;

public class SyntaxAnalyser {
    ArrayList<Token> tokenStream;
    String rawExpression;


    public void parse(){

    }
    public SyntaxAnalyser(ArrayList<Token> a, String b){
        tokenStream = a;
        rawExpression = b;
    }
}
