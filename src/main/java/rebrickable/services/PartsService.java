package rebrickable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rebrickable.mappers.PartsMapper;
import rebrickable.model.db.Parts;

import java.util.ArrayList;

@Service
public class PartsService {

    // calling the spring framework
    @Autowired
    PartsMapper partsMapper;

    // get all parts in DB
    public ArrayList<Parts> getAllParts(){
        return partsMapper.getAllParts();
    }

    // get parts by id
    public Parts getPartNum(String part_num){
        return partsMapper.getPartNum(part_num);
    }

    // add new part
    public Parts addNew(Parts parts){
        partsMapper.insertPart(parts);
        return partsMapper.getPartNum(parts.getPart_num());
    }

    // update by part num
    public Parts updatebyPart_num(Parts parts) {
        partsMapper.updatePartNum(parts);
        return partsMapper.getPartNum(parts.getPart_num());
    }

    // delete by part num
    public Parts deletebyPartnum(String part_num) {
        partsMapper.deletePart(part_num);
        return partsMapper.getPartNum(part_num);
    }
}
