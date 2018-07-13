package rebrickable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rebrickable.model.LEGO.LEGORoot;
import rebrickable.model.LEGO.ThemesResults;
import rebrickable.services.LEGOService;

@RestController
@RequestMapping("/lego")
public class LEGOController {

    //autowire service interface
    @Autowired
    LEGOService service;

    @RequestMapping("/themes")
    // takes request param, query command (?)
    public LEGORoot legoThemes(
            @RequestParam("persist") String persist){

        // returns whatever lego response returns
        LEGORoot response = service.getLegoThemes(persist);

        return response;
    }
}
