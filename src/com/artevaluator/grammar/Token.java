package com.artevaluator.grammar;

public class Token {

     String type;
     String value;

    public Token(String a, String b) {
        type = a;
        value = b;
    }

    public String tokToString() {
        return "<" + type + "," + value + ">" ;
    }
};

