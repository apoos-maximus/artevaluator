package com.artevaluator.grammar;
import java.util.*;


public class Terminals {
    Set<Character> digits;
    Set<Character> basicOperators;

    Terminals(){
        digits = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
        basicOperators = new HashSet<>(Arrays.asList('+','-','/','*'));
    }
     String getType(Character a){
        if (digits.contains(a)) return "digit";
        else if (basicOperators.contains(a)) return "basicOperator";
        else return "invalid";
    }
}
