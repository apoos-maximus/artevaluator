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

    NodePack expr() {
        NodePack result = new NodePack();
        NodePack a = new NodePack();
        NodePack b = new NodePack();
        NodePack c = new NodePack();
        result.result = true;

        if((a = term()).result == false) result.result = false;

        else if((b = eprime()).result == false) result.result = false;

        return result;
    }

    NodePack eprime(){
        NodePack result = new NodePack();
        NodePack a = new NodePack();
        NodePack b = new NodePack();
        NodePack c = new NodePack();
        result.result = true;
        if (curTok.tokCheckVal("+")) {
            result.aNode = new Node(curTok);
            curTok = nextToken();
            a = term();
            b = eprime();
            if ( ( a.result != false ) && (b.result != false) ){
                b.aNode.addChild("left",a.aNode);
                result.aNode.addChild("right",b.aNode);
            }
            else if ( (a.result != false) && (b.result == false)) {
                result.aNode.addChild("right",a.aNode);
            }
            else {
                result.result = false;
            }

        }
        else if (curTok.tokCheckVal("-")) {
            result.aNode = new Node(curTok);
            curTok = nextToken();
            a = term();
            b = eprime();
            if ((a.result != false) && (b.result != false)) {
                b.aNode.addChild("left", a.aNode);
                result.aNode.addChild("right", b.aNode);
            } else if ((a.result != false) && (b.result == false)) {
                result.aNode.addChild("right", a.aNode);
            } else {
                result.result = false;
            }

        }
        else {
            result.result = true;
        }
        return result;
    }

    NodePack term(){
        NodePack result = new NodePack();
        NodePack a = new NodePack();
        NodePack b = new NodePack();
        NodePack c = new NodePack();
        result.result = true;
        a = factor();
        b = tprime();

        if ( (a.result != false) && (b.result != false) ){
            b.aNode.addChild("left",a.aNode);
            result.aNode = b.aNode;
        } else {
            result.result = false;
        }
        return result;
    }

    NodePack tprime(){
        NodePack result = new NodePack();
        NodePack a = new NodePack();
        NodePack b = new NodePack();
        NodePack c = new NodePack();
        result.result = true;
        if (curTok.tokCheckVal("*")){
            result.aNode = new Node(curTok);
            curTok = nextToken();
            a = factor();
            b = tprime();
            if ( (a.result != false) && (b.result != false) ){
                b.aNode.addChild("left",a.aNode);
                result.aNode.addChild("right",b.aNode);
            }
            else if ((a.result != false) && (b.result == false)){
                result.aNode.addChild("right",a.aNode);
            }
            else{
                result.result = false;
            }
        }
        else if(curTok.tokCheckVal("/")){
            result.aNode = new Node(curTok);
            curTok = nextToken();
            a = factor();
            b = tprime();
            if ( (a.result != false) && (b.result != false) ){
                b.aNode.addChild("left",a.aNode);
                result.aNode.addChild("right",b.aNode);
            }
            else if ((a.result != false) && (b.result == false)){
                result.aNode.addChild("right",a.aNode);
            }
            else {
                result.result = false;
            }
        }
        else result.result = true;

        return result;
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

    public Boolean isValid(){
        curTok = nextToken();
        NodePack am = expr();
        if(am.result == false){
            System.out.println("parse failed");
            return  false;
        }
        else {
            System.out.println("parse success");
            return true;
        }
    }

    public Parser(ArrayList<Token> a) {
        tokenStream = a;
        tokPointer = -1;
        curTok = new Token("LOL", "LOL");
    }
}

