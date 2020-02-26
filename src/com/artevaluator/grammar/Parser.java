package com.artevaluator.grammar;

import java.util.ArrayList;

public class Parser {
    ArrayList<Token> tokenStream;
    int tokPointer;
    Node AST;
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

        if(result.result){
            if(b.aNode.checkType("lol")){
                result.aNode = a.aNode;
            } else {
                result.aNode = b.aNode;
                result.aNode.addChild("left",a.aNode);
            }
        }
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

            if ((a = term()).result == false) result.result = false;
            else if ((b = eprime()).result == false) result.result = false;

            if(result.result){
                if(b.aNode.checkType("lol")){
                    result.aNode.addChild("right",a.aNode);
                } else {
                    b.aNode.addChild("left",a.aNode);
                    result.aNode.addChild("right",b.aNode);
                }
            }
        }
        else if (curTok.tokCheckVal("-")) {
            result.aNode = new Node(curTok);
            curTok = nextToken();

            if ((a = term()).result == false) result.result = false;
            else if ((b = eprime()).result == false) result.result = false;

            if(result.result){
                if(b.aNode.checkType("lol")){
                    result.aNode.addChild("right",a.aNode);
                } else {
                    b.aNode.addChild("left",a.aNode);
                    result.aNode.addChild("right",b.aNode);
                }
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

        if((a = factor()).result == false) result.result = false;
        else if((b = tprime()).result == false) result.result = false;

        if(result.result){
            if(b.aNode.checkType("lol")){
                result.aNode = a.aNode;
            } else {
                result.aNode = b.aNode;
                result.aNode.addChild("left",a.aNode);
            }
        }
        return  result;
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


            if((a = factor()).result == false ) result.result = false;
            else if((b = tprime()).result == false ) result.result = false;

            if(result.result) {
                if(b.aNode.checkType("lol")){
                    result.aNode.addChild("right",a.aNode);
                } else {
                    b.aNode.addChild("left",a.aNode);
                    result.aNode.addChild("right",b.aNode);
                }
            }
        }
        else if(curTok.tokCheckVal("/")){
            result.aNode = new Node(curTok);
            curTok = nextToken();
            if((a = factor()).result == false ) result.result = false;
            else if((b = tprime()).result == false ) result.result = false;

            if(result.result) {
                if(b.aNode.checkType("lol")){
                    result.aNode.addChild("right",a.aNode);
                } else {
                    b.aNode.addChild("left",a.aNode);
                    result.aNode.addChild("right",b.aNode);
                }
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

        if(curTok.tokCheckVal("(")){
            curTok = nextToken();

            if((a = expr()).result == false){
                result.result = false;
            }
            else if(curTok.tokCheckVal(")") == false){
                result.result = false;
                System.out.println("Syntax error (expr): ')' expected ");
            }

            else curTok = nextToken();
            if(result.result){
                result.aNode = a.aNode;
            }
        }
        else if(curTok.tokCheckType("trigonometric") || curTok.tokCheckType("logarithmic")){
            result.aNode = new Node(curTok);
            curTok = nextToken();
            if(curTok.tokCheckVal("(")){
                curTok = nextToken();
                if((a = expr()).result == false) result.result = false;
                else if(curTok.tokCheckVal(")") == false) {
                    result.result = false;
                    System.out.println("Syntax error f(x): ')' expected ");
                }
                else curTok = nextToken();
                if(result.result){
                    result.aNode.addChild("only",a.aNode);
                }
            } else {
                System.out.println("syntax error");
                result.result = false;
            }

        }
        else if(curTok.tokCheckType("operand")){
            result.aNode = new Node(curTok);
            curTok = nextToken();
        }
        else {
            System.out.println("Syntax Error !");
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
            AST.addChild("only",am.aNode);
            System.out.println("parse success");
            return true;
        }
    }

    public Parser(ArrayList<Token> a) {
        tokenStream = a;
        tokPointer = -1;
        AST = new Node(new Token("root","root"));
        curTok = new Token("LOL", "LOL");
    }

    public Node getAST() {
        return AST;
    }
    public void printAST(){
        AST.printTree();
    }
}

