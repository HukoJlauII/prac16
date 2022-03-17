package pr16.Services.ImplementsService;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class PostOfficeServiceTest {
    @Autowired
    private PostOfficeService postOfficeService;
    @Test
    void addPostOffice() {
        boolean isPostOfficeCreated=postOfficeService.addPostOffice("Testname","Testcity")!=null;
        Assertions.assertTrue(isPostOfficeCreated);
    }

    @Test
    void removePostOffice() {
        Assertions.assertTrue(postOfficeService.removePostOffice("Testcity"));
    }

    @Test
    void removeAllPostOffice() {
        Assertions.assertTrue(postOfficeService.removeAllPostOffice());
    }

    @Test
    void showPostOffice() {

        Assertions.assertEquals("",postOfficeService.showPostOffice("Testcity"));
    }

    @Test
    void showAllPostOffice() {
        String testpostoffice=postOfficeService.showAllPostOffice();
        Assertions.assertEquals(testpostoffice,postOfficeService.showAllPostOffice());
    }
}