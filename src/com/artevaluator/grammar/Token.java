package com.artevaluator.grammar;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Token {

     String type;
     String value;

    public Token(String a, String b) {
        type = a;
        value = b;
    }
    public void buildToken(char a){
        value += a;
    }

    public String tokToString() {
        return "<" + type + "," + value + ">" ;
    }

    public Boolean tokCheckVal(String a){
        if(value.equals(a))return true;
        else return false;
    }
    public Boolean tokCheckType(String a){
        if(type.equals(a)) return true;
        else return false;
    }
};

