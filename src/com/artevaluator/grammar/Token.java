package com.artevaluator.grammar;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Objects;

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

    public String getVal(){
        return value;
    }
    public String getType() {return type;  }
    public Boolean tokCheckVal(String a){
        if(value.equals(a))return true;
        else return false;
    }
    public Boolean tokCheckType(String a){
        if(type.equals(a)) return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        Token tk = (Token)o;
        return this.type.equals(tk.type) && this.value.equals(tk.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
};

