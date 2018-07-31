package rebrickable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rebrickable.model.db.InvalidAPIKeyException;
import rebrickable.model.db.Parts;
import rebrickable.services.PartsService;
import rebrickable.services.SecurityService;

import java.security.Security;
import java.util.ArrayList;

@RestController
// maps url to methods
@RequestMapping("/legoDB")
public class DBPartsController {

    //Spring doing dependency injection
    @Autowired
    PartsService partsService;

    @Autowired
    SecurityService securityService;

    // Get
    @GetMapping
    public ArrayList<Parts> getParts()
//            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {
//        if (securityService.authenticate(apikey))
        {
            return partsService.getAllParts();
//        } else {
//            throw new InvalidAPIKeyException("Your API key is not valid");
//        }
    }

    // get parts by part id
    @GetMapping("/{part_num}")
    public Parts getPartId(
            @PathVariable(value = "part_num") String part_num) {
//            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {
//        if (securityService.authenticate(apikey)) {
            return partsService.getPartNum(part_num);
//        } else {
//            throw new InvalidAPIKeyException("Your API key is not valid");
//        }
    }

    // Create parts
    @PostMapping
    public Parts addNew(
            @RequestBody Parts parts) {
//            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {
//        if (securityService.authenticate(apikey)) {
            return partsService.addNew(parts);
//        } else {
//            throw new InvalidAPIKeyException("Your API key is not valid");
//        }
    }

    // Update parts
    @PutMapping
    public Parts updatebyPart_num(
            @RequestBody Parts parts){
//            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {
//        if (securityService.authenticate(apikey)) {
            return partsService.updatebyPart_num(parts);
//        } else {
//            throw new InvalidAPIKeyException("Your API key is not valid");
//        }
    }

    // Delete parts
    @DeleteMapping
    public Parts deletebyPartNum(
            @RequestParam(value = "part_num") String part_num){
//            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {
//        if (securityService.authenticate(apikey)) {
            return partsService.deletebyPartnum(part_num);
//        } else {
//            throw new InvalidAPIKeyException("Your API key is not valid");
//        }
    }

    // class level exception handler
    @ExceptionHandler(Exception.class)
    public void handleError(){
        System.out.println("Part not found.");
    }
}
