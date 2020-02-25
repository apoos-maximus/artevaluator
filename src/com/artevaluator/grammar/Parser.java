package com.artevaluator.grammar;

import java.util.ArrayList;

public class Parser {
    ArrayList<Token> tokenStream;
    int tokPointer;

    Token nextToken(){
        tokPointer++;
        return tokenStream.get(tokPointer);
    }

}
