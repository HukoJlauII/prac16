package pr16.Services.ImplementsService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pr16.Repositories.DepartureRepos;
import pr16.Repositories.PostOfficeRepos;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartureServiceTest {
    @Autowired
    private DepartureService departureService;
    
    @Test
    void addDeparture() {
        boolean isDepartureCreated=departureService.addDeparture("Testcity","flight","18.03.2022")!=null;
        Assertions.assertTrue(isDepartureCreated);
    }

    @Test
    void removeDeparture() {
        Assertions.assertTrue(departureService.removeDeparture("Testcity","flight"));
    }

    @Test
    void showDeparture() {
        Assertions.assertEquals("",departureService.showDeparture("Testcity","flight"));
    }
}