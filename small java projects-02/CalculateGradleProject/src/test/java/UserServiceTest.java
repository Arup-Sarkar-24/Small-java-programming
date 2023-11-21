import org.junit.jupiter.api.*;
@Order(3)
public class UserServiceTest {
    @BeforeAll
    static void setUp() {System.out.println("Test methods related to User");}
    @Test
    void testCreateUser_whenFirstNameIsMissing_throwsUserServiceException() {

    }
}
