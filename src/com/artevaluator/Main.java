package com.artevaluator;
import com.artevaluator.grammar.Lexer;
import com.artevaluator.grammar.SyntaxAnalyser;
import  com.artevaluator.grammar.Token;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Lexer lexr = new Lexer(args[0]+'\0');
        lexr.tokenize();
        ArrayList<Token> a = lexr.getTokenized();

        for (int i = 0; i < a.size(); i ++){
            System.out.println(a.get(i).tokToString());
        }

        SyntaxAnalyser ss = new SyntaxAnalyser(a);


    }
}
