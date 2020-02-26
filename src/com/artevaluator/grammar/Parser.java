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

    NodePack factor(){
        NodePack result = new NodePack();
        NodePack a = new NodePack();
        NodePack b = new NodePack();
        NodePack c = new NodePack();
        result.result = true;
        if ( curTok.tokCheckVal("(") ){
            curTok = nextToken();
            a = expr();
            if(a.result == false){
                result.result = false;
            }
            else if (curTok.tokCheckVal(")")){
                System.out.println("Syntsx Error[expr()] -- missing ')' ");
                result.result = false;
            }
            else{
                curTok = nextToken();
            }
        }
        else if (curTok.tokCheckType("operand")){
            result.aNode = new Node(curTok);
            curTok = nextToken();
        }
        else{
            System.out.println("Syntax Error.. !");
            result.result = false;
        }
    return result;
    }
    public Parser(ArrayList<Token> a) {
        tokenStream = a;
        tokPointer = -1;
        curTok = new Token("LOL", "LOL");
    }
}

