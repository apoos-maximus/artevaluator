package com.artevaluator.grammar;

import java.util.ArrayList;

public class Parser {
    ArrayList<Token> tokenStream;
    int tokPointer;
    Token curTok;

    Token nextToken() {
        tokPointer++;
        return tokenStream.get(tokPointer);
    }




    public Parser(ArrayList<Token> a) {
        tokenStream = a;
        tokPointer = -1;
        curTok = new Token("LOL", "LOL");
    }
}

