package com.artevaluator.grammar;

import java.util.ArrayList;

public class Parser {
    ArrayList<Token> tokenStream;
    int tokPointer;
    Token curTok;

    Token nextToken(){
        tokPointer++;
        return tokenStream.get(tokPointer);
    }

    Boolean factor(){
        Boolean result = true;
        if(curTok.tokCheckVal("(")){
            curTok = nextToken();
            if(expr() == false)
                result = false;
            else if(curTok.tokCheckVal(")") == false){
                System.out.println(") expected -- syntax error");
                result = false;
            }
            else
                curTok = nextToken();
        }
        else if(curTok.tokCheckVal("sin")){
            curTok = nextToken();
            if(curTok.tokCheckVal("(")){
                curTok = nextToken();
                if(expr() == false)
                    result = false;
                else if(curTok.tokCheckVal(")") == false){
                    System.out.println(") expected -- syntax error");
                    result = false;
                }
                else
                    curTok = nextToken();
            }
            else
                result = false;

        }
        else if(curTok.tokCheckVal("cos")){
            curTok = nextToken();
            if(curTok.tokCheckVal("(")){
                curTok = nextToken();
                if(expr() == false)
                    result = false;
                else if(curTok.tokCheckVal(")") == false){
                    System.out.println(") expected -- syntax error");
                    result = false;
                }
                else
                    curTok = nextToken();
            }
            else
                result = false;

        }
        else if(curTok.tokCheckVal("tan")){
            curTok = nextToken();
            if(curTok.tokCheckVal("(")){
                curTok = nextToken();
                if(expr() == false)
                    result = false;
                else if(curTok.tokCheckVal(")") == false){
                    System.out.println(") expected -- syntax error");
                    result = false;
                }
                else
                    curTok = nextToken();
            }
            else
                result = false;
        }
        else if(curTok.tokCheckVal("log")){
            curTok = nextToken();
            if(curTok.tokCheckVal("(")){
                curTok = nextToken();
                if(expr() == false)
                    result = false;
                else if(curTok.tokCheckVal(")") == false){
                    System.out.println(") expected -- syntax error");
                    result = false;
                }
                else
                    curTok = nextToken();
            }
            else
                result = false;

        }

        else if (curTok.tokCheckType("operand"))
            curTok = nextToken();
        else {
            System.out.println("Syntax Error !");
            result = false;
        }
        return result;
    }

    Boolean tprime(){
        Boolean result = true;
        if(curTok.tokCheckVal("*")){
            curTok = nextToken();
            if (factor() == false)
                result = false;
            else if (tprime() == false)
                result = false;
        }
        else if(curTok.tokCheckVal("/")){
            curTok = nextToken();
            if (factor() == false)
                result = false;
            else if (tprime() == false)
                result = false;
        }
        else
            result = true;
        return result;
    }

    Boolean term(){
        Boolean result = true;
        if(factor() == false)
            result = false;
        else if (tprime() == false)
            result = false;
        return result;
    }

    Boolean eprime(){
        Boolean result = true;
        if(curTok.tokCheckVal("+")){
            curTok = nextToken();
            if(term() == false)
                result = false;
            else if(eprime() == false)
                result = false;
        }
        else if(curTok.tokCheckVal("-")){
            curTok = nextToken();
            if(term() == false)
                result = false;
            else if(eprime() == false)
                result = false;
        }
        else
            result = true;

        return  result;
    }

    Boolean expr(){
        Boolean result = true;
        if (term() == false)
            result = false;
        else if (eprime() == false)
            result = false;
        return  result;
    }

    public Boolean isValid(){
        curTok = nextToken();
        if(expr() != false)
                return true;
        else
                return false;
    }

    public Parser(ArrayList<Token> a){
        tokenStream = a;
        tokPointer = -1;
        curTok = new Token("LOL","LOL");
    }
    
}
