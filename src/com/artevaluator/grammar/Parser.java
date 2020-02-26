package com.artevaluator.grammar;
import java.util.ArrayList;

public class Parser {
    ArrayList<Token> tokenStream;
    int tokPointer;
    Token curTok;

    Boolean parseSucces;
    Node root;

    Token nextToken() {
        tokPointer++;
        return tokenStream.get(tokPointer);
    }

    NodePack factor(){
        NodePack result = new NodePack();
        if(curTok.tokCheckType('(')){
            curTok = nextToken();
        }
    }




    public Parser(ArrayList<Token> a) {
        tokenStream = a;
        tokPointer = -1;
        curTok = new Token("LOL", "LOL");
        parseSucces = false;
        root = new Node(new Token("root","answer goes here"));
    }
}

