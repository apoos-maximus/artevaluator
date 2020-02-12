package com.artevaluator;
import com.artevaluator.grammar.Lexer;
import  com.artevaluator.grammar.Token;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Token> a = new ArrayList<Token>();
        Lexer lexr = new Lexer(args[0]+'\0');
        lexr.tokenize();
        a = lexr.getTokenized();

        for (int i = 0; i < a.size(); i ++){
            System.out.println(a.get(i).tokToString());
        }
    }
}
