import com.cisco.gradle.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("My Calculator Test: ")

public class CalculatorTest {
    Calculator calculator;
    @BeforeAll
    static void setup(){
        System.out.println("Executing @BeforeAll method...");
    }
    @AfterAll
    static void cleanup(){
        System.out.println("Executing @AfterAll method...");
    }
    @BeforeEach
    void beforeEachTestMethod(){
        calculator=new Calculator();
        System.out.println("Executing @BeforeAll method...");
    }
    @AfterEach
    void afterEachTestMethod(){
        System.out.println("Executing @AfterAll method...");
    }
    @Test
    void integerAddition(){
        int result = calculator.integerAddition(4,2);
        assertEquals(6, result,"message");
    }
    @Test
    void integerSubtraction(){
        int minuend=36;
        int subtrahend=4;
        int expectedResult=32;
        int actualResult=calculator.integerSubtraction(minuend,subtrahend);
        assertEquals(expectedResult,actualResult,()->minuend+"-"+subtrahend+" did not produce "+expectedResult);

    }
    @DisplayName("Multiple Subtraction Test")
    @ParameterizedTest
    @MethodSource("InterSubtractionInputParameters")
    void multipleIntegerSubtraction( int minuend,int subtrahend,int expectedResult){
        System.out.println("Running Test of Subtraction :"+minuend+" - "+subtrahend+" = "+expectedResult);
        int actualResult=calculator.integerSubtraction(minuend,subtrahend);
        assertEquals(expectedResult,actualResult,()->minuend+"-"+subtrahend+" did not produce "+expectedResult);

    }
    private static Stream<Arguments> InterSubtractionInputParameters(){
        return Stream.of(
                Arguments.of(45,5,40),
                Arguments.of(40,5,35),
                Arguments.of(35,5,30),
                Arguments.of(30,5,25),
                Arguments.of(25,5,20)
        );
    }
    @DisplayName("Multiple Subtraction Test Using CSV Source")
    @ParameterizedTest
    @CsvSource({"20,5,15","15,5,10","10,5,5"})
    void multipleIntegerSubtractionInputByCsv( int minuend,int subtrahend,int expectedResult){
        System.out.println("Running Test of Subtraction :"+minuend+" - "+subtrahend+" = "+expectedResult);
        int actualResult=calculator.integerSubtraction(minuend,subtrahend);
        assertEquals(expectedResult,actualResult,()->minuend+"-"+subtrahend+" did not produce "+expectedResult);

    }

    @DisplayName("Multiple Subtraction Test Using CSV File Source")
    @ParameterizedTest
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void multipleIntegerSubtractionInputByCsvFile( int minuend,int subtrahend,int expectedResult){
        System.out.println("Running Test of Subtraction :"+minuend+" - "+subtrahend+" = "+expectedResult);
        int actualResult=calculator.integerSubtraction(minuend,subtrahend);
        assertEquals(expectedResult,actualResult,()->minuend+"-"+subtrahend+" did not produce "+expectedResult);

    }

    @Test
    void integerMultiplication(){
        int result=calculator.integerMultiplication(5,3);
        assertEquals(15,result,"message");
    }
    @Test
    void integerDivision(){
        int result=calculator.integerDivision(4,2);
        assertEquals(2,result,"message");
    }
    // Test<System Under Test>_<Condition or State Change>_<Expected Result>
    @DisplayName("4/2=2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        //Arrange  //Given
        System.out.println("Running test 4/2=2");
       // Calculator calculator=new Calculator();
        int dividend=4;
        int divisor=2;
        int expectedResult=2;
        //Act //when
        int actualResult=calculator.integerDivision(dividend, divisor);
        //Assert //Then
        assertEquals(expectedResult,actualResult,"4/2 did not produce 2.");
    }
    @DisplayName("Division by zero")
    //@Disabled("TODO: Still need to work on it.")
    @Test
     void testIntegerDivision_WhenDividentIsDividedByZero_ShouldThrowArithmeticException(){
        System.out.println("Running Division by zero.");
        //Arrange
        int divident = 4;
        int divisor = 0;
        String expectedExceptionMessage="/ by zero";
        //Act & Assert
        ArithmeticException actualException = assertThrows(ArithmeticException.class,()->{
        calculator.integerDivision(divident, divisor);
        },"Division by zero should have thrown an ArithmeticException.");
        //Assert
        assertEquals(expectedExceptionMessage,actualException.getMessage(),"Unexpected exception message");
        //fail("Division by zero should not implemented yet");
    }
}
