package com.artevaluator.grammar;

import java.util.ArrayList;
import java.util.Stack;

public class Evaluator {
    ArrayList<Token> tokenStream;
    String answer;

    public void evaluate(){
        Stack<Token> operand = new Stack<>();
        Stack<Token> operator = new Stack<>();

        for(Token token : tokenStream){
            if(token.tokCheckType("operand")) operand.push(token);
            else if(token.tokCheckType("operator") || token.tokCheckType("leftParenthesis") || token.tokCheckType("rightParenthesis")) operator.push(token);
        }
    }
    public Evaluator(ArrayList<Token> tt){
        tokenStream = tt;
        answer = "";
    }
}
