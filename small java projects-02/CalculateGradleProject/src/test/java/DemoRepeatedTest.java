import com.cisco.gradle.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class DemoRepeatedTest {
    Calculator calculator;
    @BeforeEach
    void beforeEachTestMethod(){
        calculator=new Calculator();
        System.out.println("Executing @BeforeAll method...");
    }
    @AfterEach
    void afterEachTestMethod(){
        System.out.println("Executing @AfterAll method...");
    }
    @DisplayName("Division by zero")
    //@RepeatedTest(value = 3, name = "{DisplayName}.Repetition {CurrentRepetition} of "+"{TotalRepetitions}")
    @RepeatedTest(3)
     void testIntegerDivision_WhenDividentIsDividedByZero_ShouldThrowArithmeticException( RepetitionInfo repetitionInfo, TestInfo testInfo ){
        System.out.println("Running "+testInfo.getTestMethod().get().getName());
        System.out.println("Repetition # " + repetitionInfo.getCurrentRepetition()+" of "+repetitionInfo.getTotalRepetitions());
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
    @ParameterizedTest
    @ValueSource(strings = {"Arup","Ananada","Ambani","Adani"})
    void valueSourceDemonstration(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }
}
