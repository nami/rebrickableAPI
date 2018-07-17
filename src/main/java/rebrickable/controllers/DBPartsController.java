package rebrickable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rebrickable.model.db.Parts;
import rebrickable.services.PartsService;
import java.util.ArrayList;

@RestController
// maps url to methods
@RequestMapping("/legoDB")
public class DBPartsController {

    //Spring doing dependency injection
    @Autowired
    PartsService partsService;

    // Get
    @GetMapping
    public ArrayList<Parts> getParts(){
        return partsService.getAllParts();
    }

    // get parts by part id
    @GetMapping("/{part_num}")
    public Parts getPartId(@PathVariable(value="part_num")String part_num){
        return partsService.getPartNum(part_num);
    }

    // Create parts
    @PostMapping
    public Parts addNew(@RequestBody Parts parts){
        return partsService.addNew(parts);
    }

    // Update parts
    @PutMapping
    public Parts updatebyPart_num(@RequestBody Parts parts){
        return partsService.updatebyPart_num(parts);
    }

    // Delete parts
    @DeleteMapping
    public Parts deletebyPartNum(@RequestParam(value="part_num")String part_num){
        return partsService.deletebyPartnum(part_num);
    }
}
