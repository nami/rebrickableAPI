package rebrickable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rebrickable.model.LEGO.*;
import rebrickable.services.LEGOService;

@RestController
@RequestMapping("/lego")
public class LEGOController {

    //autowire service interface
    @Autowired
    LEGOService service;

    @RequestMapping("/themes")
    // takes request param, query command (?)
    public ThemesRoot legoThemes(
            @RequestParam("persist") String persist){

        // returns whatever LEGO API response returns
        ThemesRoot response = service.getLegoThemes(persist);

        return response;
    }

    @RequestMapping("/sets")
    // takes request param, query command (?)
    public SetsRoot legoSets(
            @RequestParam("persist") String persist){

        // returns whatever response returns
        SetsRoot response = service.getLegoSets(persist);

        return response;
    }

    @RequestMapping("/parts")
    // takes request param, query command (?)
    public PartsRoot searchParts(
            @RequestParam("keyword") String keyword,
            @RequestParam("persist") String persist) {

        // returns whatever LEGO API response returns
        PartsRoot response = service.searchParts(keyword, persist);

        return response;
    }

    @RequestMapping("/getToken")
    public ResponseEntity<UserToken> getToken(
            @RequestParam("token") String key)
    {
        // get user token
        ResponseEntity<UserToken> response = service.getToken(key);

        return response;
    }

    @RequestMapping("/addset")
    public MySetsRoot addSet(){
        // returns whatever response returns
        MySetsRoot response = service.addSet();

        return response;
    }

    @RequestMapping("/mysets")
    public MySetsRoot getMySets(){

        // returns whatever response returns
        MySetsRoot response = service.getMySets();

        return response;
    }

    @RequestMapping("/updateset")
    public MySetsRoot updateSet(){

        // returns whatever response returns
        MySetsRoot response = service.updateSet();

        return response;
    }

}
