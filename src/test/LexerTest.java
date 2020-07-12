package test;

import com.artevaluator.grammar.Exception.DecimalSyntaxError;
import com.artevaluator.grammar.Exception.WrongLiteralException;
import com.artevaluator.grammar.Lexer;
import com.artevaluator.grammar.Token;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {

    @Test
    public void should_throw_exception_onWrongLiteral () {

        //given
        String input = "1+2+5$67";

        //when
        Lexer sampleLexer = new Lexer(input);
        Executable executable = () -> sampleLexer.tokenize();

        //then
        assertThrows(WrongLiteralException.class, executable);
    }

    @Test
    public void should_throw_exception_DecimalSyntaxError () {

        //given
        String input = "1+2+3.45.5+67";

        //when
        Lexer sampleLexer = new Lexer(input);
        Executable executable = () -> sampleLexer.tokenize();

        //then
        assertThrows(DecimalSyntaxError.class, executable);
    }

    @Test
    public void should_return_tokenStream () throws DecimalSyntaxError {

        //given
        String input = "1+2*log(3)##";

        //when
        Lexer sampleLexer = new Lexer(input);
        try {
            sampleLexer.tokenize();
        } catch (WrongLiteralException e) {
            e.printStackTrace();
        }

        String[] expectedTokStream = new String[]{"operand","1", "operator","+", "operand","2", "operator","*", "logarithmic","log", "leftParenthesis","(", "operand","3", "rightParenthesis",")"};
        ArrayList<Token> sampleTokenStream = sampleLexer.getTokenized();
        ArrayList<String> sampleTokStream = new ArrayList<>();
        for (Token tk: sampleTokenStream) {
            sampleTokStream.add(tk.getType());
            sampleTokStream.add(tk.getVal());
        }

        //then
        assertLinesMatch (Arrays.asList(expectedTokStream), sampleTokStream);
    }

}