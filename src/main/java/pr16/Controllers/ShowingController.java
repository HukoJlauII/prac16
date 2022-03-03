package pr16.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pr16.Services.ImplementsService.DepartureService;
import pr16.Services.ImplementsService.PostOfficeService;

@RestController
@RequestMapping("/show")
public class ShowingController {

    @Autowired
    private PostOfficeService postOfficeService;
    @Autowired
    private DepartureService departureService;

    @GetMapping("/postoffice/{cityname}")
    public String showPostOffice(@PathVariable String cityname) {
        return postOfficeService.showPostOffice(cityname);
    }

    @GetMapping("/postoffice/all")
    public String showAllPostOffice() {
        return postOfficeService.showAllPostOffice();
    }

    @GetMapping("/departure/{cityname}/{type}/")
    public String showDeparture(@PathVariable String cityname, @PathVariable String type) {
        return departureService.showDeparture(cityname, type);
    }
}
