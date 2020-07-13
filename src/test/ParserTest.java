package test;

import com.artevaluator.grammar.Exception.*;
import com.artevaluator.grammar.Lexer;
import com.artevaluator.grammar.Parser;
import com.artevaluator.grammar.Token;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;


class ParserTest {

    @ParameterizedTest
    @CsvSource({"1+4+5*log(3/(23-67)##", "1+4+5*(3/(23-67)##"})
    public void should_throw_OpenParenthesisException(String input) throws UnrecognisedOperationError, WrongLiteralException, EmptyParenthesisError, OperatorRequiredError, DecimalSyntaxError {

        //given
        Lexer sampleLexer = new Lexer(input);
        sampleLexer.tokenize();;
        ArrayList<Token> tokenStream = sampleLexer.getTokenized();
        tokenStream.add(new Token("EOF","EOF"));
        Parser sampleParser = new Parser(tokenStream);

        //when
        Executable executable = () -> sampleParser.isValid();

        //then
        assertThrows (OpenParenthesisError.class, executable);
    }

    @ParameterizedTest
    @CsvSource({"1+2+4**7##" , "1+2*/5##", "1+2//56##" , "1+2++45##" , "1+2---43*7##" , "log(log(1*/67))##" , "(##"})
    public void should_throw_ExpressionSyntaxError (String input) throws UnrecognisedOperationError, WrongLiteralException, EmptyParenthesisError, OperatorRequiredError, DecimalSyntaxError {
        //given
        Lexer sampleLexer = new Lexer(input);
        sampleLexer.tokenize();;
        ArrayList<Token> tokenStream = sampleLexer.getTokenized();
        tokenStream.add(new Token("EOF","EOF"));
        Parser sampleParser = new Parser(tokenStream);

        //when
        Executable executable = () -> sampleParser.isValid();

        //then
        assertThrows (ExpressionSyntaxError.class, executable);

    }
}