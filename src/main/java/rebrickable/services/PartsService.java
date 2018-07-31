package rebrickable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value = "parts")
    public ArrayList<Parts> getAllParts(){
        System.out.println("Getting all parts");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return partsMapper.getAllParts();
    }

    // get parts by id
    @Cacheable(value = "parts", key = "#part_num")
    public Parts getPartNum(String part_num){
        System.out.println("Getting parts by id " + part_num);

        // have the thread sleep for two seconds if it's not hitting the cache
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return partsMapper.getPartNum(part_num);
    }

    // add new part
    //@CachePut(value = "parts")
    @CacheEvict(value = "parts", allEntries = true)
    public Parts addNew(Parts parts){
        System.out.println("Creating part");
        partsMapper.insertPart(parts);
        return partsMapper.getPartNum(parts.getPart_num());
    }

    // update by part num
    @CacheEvict(value = "parts", allEntries = true)
    public Parts updatebyPart_num(Parts parts) {
        partsMapper.updatePartNum(parts);
        return partsMapper.getPartNum(parts.getPart_num());
    }

    // delete by part num
    @CacheEvict(value = "parts", key = "#part_num")
    public Parts deletebyPartnum(String part_num) {
        partsMapper.deletePart(part_num);
        return partsMapper.getPartNum(part_num);
    }
}
