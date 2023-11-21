import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndexTest {
    @Order(1)
    @Test
    void testB(){
        System.out.println("Running test B, orderNo= 1");
    }
    @Order(3)
    @Test
    void testD(){
        System.out.println("Running test D, orderNo= 3");
    }
    @Order(5)
    @Test
    void testA(){
        System.out.println("Running test A,, orderNo= 5");
    }
    @Order(8)
    @Test
    void testC(){
        System.out.println("Running test c, orderNo= 8");
    }

    @Order(6)
    @Test
    void testE(){
        System.out.println("Running test E, orderNo= 6");
    }
    @Order(2)
    @Test
    void testG(){
        System.out.println("Running test G, orderNo= 2");
    }
    @Order(7)
    @Test
    void testF(){
        System.out.println("Running test F, orderNo= 7");
    }
    @Order(4)
    @Test
    void testH(){
        System.out.println("Running test H, orderNo= 4");
    }
}
