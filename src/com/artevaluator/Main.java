package com.artevaluator;
import com.artevaluator.grammar.Exception.*;
import com.artevaluator.grammar.Lexer;
import  com.artevaluator.grammar.Token;
import  com.artevaluator.grammar.Parser;
import  com.artevaluator.operator.*;

import com.artevaluator.grammar.Node;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws WrongLiteralException, DecimalSyntaxError, EmptyParenthesisError, OperatorRequiredError, UnrecognisedOperationError {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        Lexer lexr = new Lexer(exp+"##");
        lexr.tokenize();
        ArrayList<Token> a = lexr.getTokenized();
        a.add(new Token("EOF","EOF"));

        Parser parsr = new Parser(a);
        System.out.println(parsr.isValid());

        Addition add = new Addition();
        Sine sin = new Sine();
        System.out.println(parsr.getVal());


    }
}
