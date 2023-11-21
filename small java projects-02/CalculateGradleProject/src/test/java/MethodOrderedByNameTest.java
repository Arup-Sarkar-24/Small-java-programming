import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodOrderedByNameTest {
    @Test
    void testB(){
        System.out.println("Running test B");
    }
    @Test
    void testD(){
        System.out.println("Running test D");
    }
    @Test
    void testA(){
        System.out.println("Running test A");
    }
    @Test
    void testC(){
        System.out.println("Running test c");
    }

    @Test
    void testE(){
        System.out.println("Running test E");
    }
    @Test
    void testG(){
        System.out.println("Running test G");
    }
    @Test
    void testF(){
        System.out.println("Running test F");
    }
    @Test
    void testH(){
        System.out.println("Running test H");
    }
}
