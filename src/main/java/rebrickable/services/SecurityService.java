package rebrickable.services;

import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class SecurityService {

    // this method generates an API-Key
    public static String createApiKey() throws NoSuchAlgorithmException {
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

}
