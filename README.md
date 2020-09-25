An Extensible Arithmetic Evaluator written in java

### Character Set ###
[0-9], [a-z], {+, -, /, *}, {., (, )}

operations supported :\
        Addition\
        Subtraction\
        Multiplication\
        Division\
        Sine\
        Cosine\
        Tangent\
        Logarithm\
        Identity

### Usage ###
        sample expression : 
        
        
        Case 1 : input syntax is correct
        log(log(log(tan(105/100)*12.4+1)))
        Output :
        parse success
        true
        -0.8802202256366045
        
        Case 2 : wrong input syntax
        log(log(log(tan(105/100)*12.4+1))
        Output :
        Exception in thread "main" closing parenthesis required !
        	at com.artevaluator.grammar.Parser.factor(Parser.java:180)
        	at com.artevaluator.grammar.Parser.term(Parser.java:92)
        	at com.artevaluator.grammar.Parser.expr(Parser.java:27)
        	at com.artevaluator.grammar.Parser.isValid(Parser.java:203)
        	at com.artevaluator.Main.main(Main.java:30)
        	
### How can It be extended ###
* Determine the new operator
* If operator uses any new character add that character to the character-set in Literals.java
* Design a DFA which could recognize the new operator with distinct Accept State.
* Add the code for the dfa to Lexer.java
* Add another implementation for the operator interface in operators package and override the solved method
based on unary or binary operator
* add the new operator object to the ops HashMap in Node.java at the end of file.
 