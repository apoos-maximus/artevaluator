package com.artevaluator.grammar;

import com.artevaluator.operator.*;
import java.util.HashMap;
import java.util.Map;

public class Node {
    Token data;
    Boolean isLeaf;
    int childCount;
    Map<String,Node> ch;
    Map<String,Operator> ops;

    public Boolean checkType(String a){
        return  data.tokCheckType(a);
    }
    public Boolean addChild(String a,Node b){

        if(childCount > 0) {
            if( (a.equals("left") || a.equals("right")) && childCount == 2 ){
                ch.put(a,b);
                return true;
            }
            else if( (a.equals("only")) && childCount == 1 ){
                ch.put(a,b);
                return true;
            }
            else
                System.out.println("unsupported tree property");
        }
        else {
            System.out.println("can't add children to leaf node !!");
            return false;
        }
        return false;
    }

    public Node getChild(String a){
        if(childCount > 0){
            if( (a.equals("left") || a.equals("right")) && childCount == 2 ){
                return ch.get(a);
            }
            else if((a.equals("only")) && childCount == 1){
                return ch.get(a);
            }
        }
        else {
            System.out.println("Leaf node can't have children");
            System.exit(0);
        }
        return new Node(new Token("lol","lol"));
    }
    public Token getData(){
        return data;
    }
    public void printTree(){
        if (childCount == 2){
         if(ch.containsKey("left")) ch.get("left").printTree();
         System.out.println(data.tokToString());
         if(ch.containsKey("right")) ch.get("right").printTree();
        }
        if (childCount == 1){
            if(ch.containsKey("only")) ch.get("only").printTree();
            System.out.println(data.tokToString());
        }
        if (childCount == 0){
            System.out.println(data.tokToString());
        }
    }

    public Double eval(){
        if (childCount == 2) {
            Double left = 0.0, right = 0.0;
            if (ch.containsKey("left")) left = ch.get("left").eval();
            if (ch.containsKey("right")) right = ch.get("right").eval();
            return ops.get(data.getVal()).Solve(left, right);
        }
        if (childCount == 1) {
            Double only = 0.0;
            if (ch.containsKey("only")) only = ch.get("only").eval();
            return only;
        }
        if (childCount == 0) {
            return Double.parseDouble(data.getVal());
        }
        return  0.0;
    }


    public Node(Token a){
        data = a;
        if(a.tokCheckType("operand")){
            isLeaf = true;
            childCount = 0;
        }
        else if(a.tokCheckType("operator")){
            isLeaf = false;
            childCount = 2;
        }
        else if(a.tokCheckType("trigonometric")){
            isLeaf = false;
            childCount = 1;
        }
        else if(a.tokCheckType("logarithmic")){
            isLeaf = false;
            childCount = 1;
        }
        else if (a.tokCheckType("root")){
            isLeaf = false;
            childCount = 1;
        }
        else if(a.tokCheckType("lol")){
            isLeaf = false;
            childCount = -1;
        }
        else{
            System.out.println("Tree Error  !!");
        }

        ch = new HashMap<>();
        ops = new HashMap<>();
        ops.put("+",new Addition());
        ops.put("-",new Subtraction());
        ops.put("*",new Multiplication());
        ops.put("/",new Division());
        ops.put("sin",new Sine());
        ops.put("cos",new Cosine());
        ops.put("tan",new Tangent());
        ops.put("log",new Logarithm());
    }

}
