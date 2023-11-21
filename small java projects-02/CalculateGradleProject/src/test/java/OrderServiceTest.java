import org.junit.jupiter.api.*;
@Order(1)
public class OrderServiceTest {
    @BeforeAll
    static void setUp() {System.out.println("Test methods related to User orders");}
    @Test
    void testCreateOrder_whenProductIdIsMissing_throwsOrdersServiceException() {

    }
}
