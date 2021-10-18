package DChatUtilities;

import java.util.Base64;

import java.nio.charset.StandardCharsets;

import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypter {

    private String secretKey = "";
    private String salt = "";

    private static final String keySample = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*();'+-*/";
    private static final String saltSample = "!@#$%^&*()_+-*/";


    public Encrypter(String key, String salt) {
        secretKey = key;
        this.salt = salt;
    }

    public String encryptString(String strToEncrypt)
    {
        try {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 };

            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            return Base64.getEncoder().encodeToString(
                    cipher.doFinal(strToEncrypt.getBytes(
                            StandardCharsets.UTF_8)));
        }
        catch (Exception e) {
            System.out.println("Error while encrypting: "
                    + e);
        }
        return null;
    }

    public static String generateKey() {
        var key = "";

        var rand = new Random();

        for(int i = 0; i < 13; i++) {
            key += keySample.split("")[rand.nextInt(keySample.length())];
        }

        return key;
    }

    public static String generateSalt() {
        var salt = "";

        var rand = new Random();

        for(int i = 0; i < 7; i++) {
            salt += saltSample.split("")[rand.nextInt(saltSample.length())];
        }

        return salt;
    }
}
