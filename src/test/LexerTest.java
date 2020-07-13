package test;

import com.artevaluator.grammar.Exception.*;
import com.artevaluator.grammar.Lexer;
import com.artevaluator.grammar.Token;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {

    @Test
    public void should_throw_exception_onWrongLiteral () {

        //given
        String input = "1+2+5$67##";

        //when
        Lexer sampleLexer = new Lexer(input);
        Executable executable = () -> sampleLexer.tokenize();

        //then
        assertThrows(WrongLiteralException.class, executable);
    }

    @Test
    public void should_throw_exception_DecimalSyntaxError () {

        //given
        String input = "1+2+3.45.5+67##";

        //when
        Lexer sampleLexer = new Lexer(input);
        Executable executable = () -> sampleLexer.tokenize();

        //then
        assertThrows(DecimalSyntaxError.class, executable);
    }

    @Test
    public void should_throw_exception_EmptyParenthesisError () {

        //given
        String input = "1+2+3/45+(34)##";

        //when
        Lexer sampleLexer = new Lexer(input);
        Executable executable = () -> sampleLexer.tokenize();

        //then
        assertThrows(EmptyParenthesisError.class, executable);
    }

    @Test
    public void should_throw_operatorExpectedError () {
        //given
        String input = "1+2+*3/4/(56+78)89##";

        //when
        Lexer sampleLexer = new Lexer(input);
        Executable executable = () -> sampleLexer.tokenize();

        //then
        assertThrows(OperatorRequiredError.class, executable);
    }

    @ParameterizedTest
    @CsvSource({"1+2+4-loj(45)##" , "1+2+4-sir(45)##", "1+2+4-coo(45)##", "1+2+4-tin(45)##"})
    public void should_throw_UnrecognisedOperationError (String input) {
        //given


        //when
        Lexer sampleLexer = new Lexer(input);
        Executable executable = () -> sampleLexer.tokenize();

        //then
        assertThrows(UnrecognisedOperationError.class, executable);
    }


    @Test
    public void should_return_tokenStream () throws DecimalSyntaxError, EmptyParenthesisError, OperatorRequiredError, UnrecognisedOperationError {

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