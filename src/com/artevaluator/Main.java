package com.artevaluator;
import com.artevaluator.grammar.Lexer;
import  com.artevaluator.grammar.Token;
import  com.artevaluator.grammar.Parser;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Lexer lexr = new Lexer(args[0]+"##");
        lexr.tokenize();
        ArrayList<Token> a = lexr.getTokenized();
        a.add(new Token("EOF","EOF"));
        for (Token token : a) {
            System.out.println(token.tokToString() + " ");
        }

        Parser parsr = new Parser(a);
        System.out.println(parsr.isValid());
    }
}
