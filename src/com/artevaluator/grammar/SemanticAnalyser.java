package com.artevaluator.grammar;

public class SemanticAnalyser {

    Terminals tr;
    String expression;
    int index;
    Character lookahead;

    void match(Character t){
        if (lookahead == t) {
            index++;
            lookahead=expression.charAt(index);
        }
        else {
            System.out.println("Error");
            System.out.println("Expected : " + t);
        }
    }
    void A(){
        System.out.print(lookahead);
        if (tr.getType(lookahead) == "digit") {
            match(lookahead);
            B();
        }
        else if(tr.getType(lookahead) == "basicOperator") {
            match(lookahead);
            C();
        }
        else {
            return;
        }
    }

    void B(){
        System.out.print(lookahead);
        if(tr.getType(lookahead) == "basicOperator"){
            match(lookahead);
            C();
        }
        else if(lookahead == '.') {
            match('.');
            D();
        }
        else if(tr.getType(lookahead) == "digit"){
            match(lookahead);
            B();
        }
        else{
           return;
        }
    }
    void C(){
        System.out.print(lookahead);
        if(tr.getType(lookahead) == "digit") {
            match(lookahead);
            B();
        }
        else if(lookahead == '+') {
            match('+');
            C();
        }
        else if(lookahead == '-') {
            match('-');
            C();
        }
        else if(lookahead == '*') {
            match('*');
            C();
        }
        else{
            return;
        }
    }

    void D(){
        System.out.print(lookahead);
        if (tr.getType(lookahead) == "basicOperator") {
            match(lookahead);
            C();
        }
        else if(tr.getType(lookahead) == "digit") {
            match(lookahead);
            D();
        }
        else{
            return;
        }
    }

    public void parse(){
        A();
        if (lookahead == '\0') {
            System.out.println("parse Success!!");
        } else {
            System.out.println("Syntax Error !!");
        }
    }
    public SemanticAnalyser(String a) {
        expression = a;
        index = 0;
        lookahead = expression.charAt(index);
        tr = new Terminals();
    }

}
