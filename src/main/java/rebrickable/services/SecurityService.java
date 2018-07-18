package rebrickable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rebrickable.mappers.UserMapper;
import rebrickable.model.db.User;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class SecurityService {

    @Autowired
    UserMapper userMapper;

    // this method generates an API-Key
    public String createApiKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 256;

        keyGenerator.init(keyBitSize, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();

        System.out.println(secretKey.toString().toString());
        byte[] encoded = secretKey.getEncoded();
        String key =  DatatypeConverter.printHexBinary(encoded).toLowerCase();
        return key.substring(0,20);
    }

    // method to check if the api key is there or not
    public boolean authenticate(String apiKey) {

        // if there is no API key return false
        if (userMapper.getUserByApiKey(apiKey) == null){
            return false;
        }
        return true;
    }
}
