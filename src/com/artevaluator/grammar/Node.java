package com.artevaluator.grammar;

import java.util.HashMap;
import java.util.Map;

public class Node {
    Token data;
    Boolean isLeaf;
    int childCount;
    Map<String,Node> ch;


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
    public Node(Token a){
        data = a;
        if(a.type.equals("operand")){
            isLeaf = true;
            childCount = 0;
        }
        else if(a.type.equals("operator")){
            isLeaf = false;
            childCount = 2;
        }
        else if(a.type.equals("trigonometric")){
            isLeaf = false;
            childCount = 1;
        }
        else if(a.type.equals("logarithmic")){
            isLeaf = false;
            childCount = 1;
        }
        else
            System.out.println("Tree Error  !!");
        ch = new HashMap<>();
    }

}
