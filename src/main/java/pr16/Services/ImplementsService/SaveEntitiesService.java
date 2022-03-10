package pr16.Services.ImplementsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pr16.Repositories.DepartureRepos;
import pr16.Repositories.PostOfficeRepos;

@EnableScheduling
@Service
@Slf4j
public class SaveEntitiesService implements pr16.Services.SaveEntitiesService {
    @Autowired
    private PostOfficeRepos postOfficeRepos;
    @Autowired
    private DepartureRepos departureRepos;

    @Scheduled(cron = "* 30 * * * *")
    @Transactional
    @Override
    public void saveEntities() {
        postOfficeRepos.savePostoffice();
        departureRepos.saveDeparture();
        log.info("All entities saved successfully");
    }
}
