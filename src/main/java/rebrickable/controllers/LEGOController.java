package rebrickable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rebrickable.model.LEGO.*;
import rebrickable.model.db.InvalidAPIKeyException;
import rebrickable.services.LEGOService;
import rebrickable.services.SecurityService;

@RestController
@RequestMapping("/lego")
public class LEGOController {

    //autowire service interface
    @Autowired
    LEGOService service;

    @Autowired
    SecurityService securityService;

    // get lego themes
    @RequestMapping("/themes")
    // takes request param, query command (?)
    public ThemesRoot legoThemes(
            @RequestParam("api-key") String apikey,
            @RequestParam("persist") String persist) throws InvalidAPIKeyException {

        // returns whatever LEGO API response returns
        if (securityService.authenticate(apikey)) {
            ThemesRoot response = service.getLegoThemes(persist);

            return response;
        } else {
            throw new InvalidAPIKeyException("You API key is invalid");
        }
    }

    // get lego sets
    @RequestMapping("/sets")
    // takes request param, query command (?)
    public SetsRoot legoSets(
            @RequestParam("api-key") String apikey,
            @RequestParam("persist") String persist) throws InvalidAPIKeyException {

        if (securityService.authenticate(apikey)) {
            // returns whatever response returns
            SetsRoot response = service.getLegoSets(persist);

            return response;
        } else {
            throw new InvalidAPIKeyException("Your API key is invalid");
        }
    }

    // get & search lego parts
    @RequestMapping("/parts")
    // takes request param, query command (?)
    public PartsRoot searchParts(
            @RequestParam("api-key") String apikey,
            @RequestParam("keyword") String keyword,
            @RequestParam("persist") String persist) throws InvalidAPIKeyException {

        if (securityService.authenticate(apikey)) {
            // returns whatever LEGO API response returns
            PartsRoot response = service.searchParts(keyword, persist);

            return response;
        } else {
            throw new InvalidAPIKeyException("Your API key is invalid");
        }
    }

    // get user token
    @RequestMapping("/getToken")
    public ResponseEntity<UserToken> getToken(
            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {
        if (securityService.authenticate(apikey)) {
            // get user token
            ResponseEntity<UserToken> response = service.getToken();

            return response;
        } else {
            throw new InvalidAPIKeyException("Your API key is invalid");
        }
    }

    // add a set to my set list
    @RequestMapping("/addset")
    public MySetsRoot addSet(
            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {
        // returns whatever response returns
        if (securityService.authenticate(apikey)) {
            MySetsRoot response = service.addSet();

            return response;
        } else {
            throw new InvalidAPIKeyException("Your API key is invalid");
        }
    }

    // get a list of mysets
    @RequestMapping("/mysets")
    public MySetsRoot getMySets(
            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {

        if (securityService.authenticate(apikey)) {
            // returns whatever response returns
            MySetsRoot response = service.getMySets();

            return response;
        } else {
            throw new InvalidAPIKeyException("Your API key is invalid");
        }
    }

    // update a set in my list
    @RequestMapping("/updateset")
    public MySetsRoot updateSet(
            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {

        if (securityService.authenticate(apikey)) {
            // returns whatever response returns
            MySetsRoot response = service.updateSet();

            return response;
        } else {
            throw new InvalidAPIKeyException("Your API key is invalid");
        }
    }
}
