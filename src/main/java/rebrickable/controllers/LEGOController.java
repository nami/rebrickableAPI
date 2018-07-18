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

    // get lego themes
    @RequestMapping("/themes")
    // takes request param, query command (?)
    public ThemesRoot legoThemes(
            @RequestParam("persist") String persist){

        // returns whatever LEGO API response returns
        ThemesRoot response = service.getLegoThemes(persist);

        return response;
    }

    // get lego sets
    @RequestMapping("/sets")
    // takes request param, query command (?)
    public SetsRoot legoSets(
            @RequestParam("persist") String persist){

        // returns whatever response returns
        SetsRoot response = service.getLegoSets(persist);

        return response;
    }

    // get & search lego parts
    @RequestMapping("/parts")
    // takes request param, query command (?)
    public PartsRoot searchParts(
            @RequestParam("keyword") String keyword,
            @RequestParam("persist") String persist) {

        // returns whatever LEGO API response returns
        PartsRoot response = service.searchParts(keyword, persist);

        return response;
    }

    // get user token
    @RequestMapping("/getToken")
    public ResponseEntity<UserToken> getToken(
            @RequestParam("token") String key)
    {
        // get user token
        ResponseEntity<UserToken> response = service.getToken(key);

        return response;
    }

    // add a set to my set list
    @RequestMapping("/addset")
    public MySetsRoot addSet(){
        // returns whatever response returns
        MySetsRoot response = service.addSet();

        return response;
    }

    // get a list of mysets
    @RequestMapping("/mysets")
    public MySetsRoot getMySets(){

        // returns whatever response returns
        MySetsRoot response = service.getMySets();

        return response;
    }

    // update a set in my list
    @RequestMapping("/updateset")
    public MySetsRoot updateSet(){

        // returns whatever response returns
        MySetsRoot response = service.updateSet();

        return response;
    }

}
