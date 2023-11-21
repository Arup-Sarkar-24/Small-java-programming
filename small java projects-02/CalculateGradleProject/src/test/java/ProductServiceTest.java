import org.junit.jupiter.api.*;
@Order(2)
public class ProductServiceTest {
    @BeforeAll
    static void setUp() {System.out.println("Test methods related to User products");}
    @Test
    void testCreateProduct_whenProductTitleIsMissing_throwsProductServiceException() {

    }
}
