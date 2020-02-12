package com.artevaluator.grammar;
import java.util.*;

public class Lexer {
    String input;
    ArrayList<Token> tokenized;
    Terminals tr;
    enum State {
        A,B,C,D
    };

    public void tokenize(){
        char inputDumy[] = input.toCharArray();
        char ch = '\0';
        State st = State.A;
        String tok = new String();

        for (int i=0; i < inputDumy.length; i++ ) {
            ch = inputDumy[i];
            switch(st){
                case A: if (st != State.A) break;
                        if(tr.getType(ch) == "digit"){
                        tok += ch;
                        st = State.B;
                        }
                        else if(tr.getType(ch) == "basicOperator"){
                        tok += ch;
                        st = State.C;
                        }
                        else {
                            //throw error
                            System.out.println("invalid literal !");
                        }
                        break;
                case B: if(tr.getType(ch) == "digit"){
                        tok += ch;
                        st = State.B;
                        }
                        else if (tr.getType(ch) == "basicOperator"){
                            tokenized.add(new Token("operand",tok));
                            tok = "";
                            tok += ch;
                            st = State.C;
                        }
                        else if (ch == '.'){
                            tok += ch;
                            st = State.D;
                        }
                        else if(ch == '\0') {
                            tokenized.add(new Token("operand",tok));
                            st = State.A;
                        }
                        else {
                            //throw error
                            System.out.println("invalid literal");
                        }
                        break;
                case C: if( (ch == '+') || (ch == '-') || (ch == '*') ){
                        tok += ch;
                        st = State.C;
                        }
                        else if (tr.getType(ch) == "digit"){
                            tokenized.add(new Token("operator",tok));
                            tok = "";
                            tok += ch;
                            st = State.B;
                        }
                        else if ( ch == '\0' ){
                            tokenized.add(new Token("operator",tok));
                            tok = "";
                            st = State.A;
                        }
                        else{
                            //throw error
                            System.out.println("invalid literal");
                        }
                        break;
                case D: if (ch == '.') {
                            //throw error
                            System.out.println("invalid expression");
                            break;
                        }
                        else if (tr.getType(ch) == "digit") {
                            tok += ch;
                            st = State.D;
                        }
                        else if(tr.getType(ch) == "basicOperator") {
                            tokenized.add(new Token("operand",tok));
                            tok = "";
                            tok += ch;
                            st = State.C;
                        }
                        else {
                            //throw error
                            System.out.println("Invalid");
                        }
                        break;
               default:
                        System.out.println("Wrong State");
                        //throw error
                        break;
            }
        }
    }
    public  Lexer(String a) {
        input = a;
        tokenized = new ArrayList<Token>();
        tr = new Terminals();
    }
    public ArrayList<Token> getTokenized(){
        return tokenized;
    }
}