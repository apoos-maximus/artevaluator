package com.artevaluator.grammar;
import java.util.*;


public class Terminals {
    Set<Character> digits;
    Set<Character> alpha;
    Set<Character> basicOperators;
    Set<Character> punctuators;

    Terminals(){
        digits = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
        alpha = new HashSet<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        basicOperators = new HashSet<>(Arrays.asList('+','-','/','*'));
        punctuators = new HashSet<>(Arrays.asList('.','(',')'));
    }
     String getType(Character a){
        if (digits.contains(a)) return "digit";
        else if (basicOperators.contains(a)) return "basicOperator";
        else if (punctuators.contains(a)) return "punctuator";
        else return "invalid";
    }
}
