/**
 * 
 */
package com.rentit.test_class;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * @author kotic
 *
 */
public class EncryptPassword {
  

  private static final String UNICODE_FORMAT = "UTF8";
     public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
     private KeySpec ks;
     private SecretKeyFactory skf;
     private Cipher cipher;
     byte[] arrayBytes;
     private String myEncryptionKey;
     private String myEncryptionScheme;
     SecretKey key;

     public EncryptPassword() throws Exception {
         myEncryptionKey = "ThisIsSpartaThisIsSparta";
         myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
         arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
         ks = new DESedeKeySpec(arrayBytes);
         skf = SecretKeyFactory.getInstance(myEncryptionScheme);
         cipher = Cipher.getInstance(myEncryptionScheme);
         key = skf.generateSecret(ks);
     }


     public String encrypt(String unencryptedString) {
         String encryptedString = null;
         try {
             cipher.init(Cipher.ENCRYPT_MODE, key);
             byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
             byte[] encryptedText = cipher.doFinal(plainText);
             Base64.Encoder encoder = Base64.getEncoder();
             encryptedString = encoder.encodeToString(encryptedText);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return encryptedString;
     }


     public String decrypt(String encryptedString) {
         String decryptedText=null;
         try {
             Base64.Decoder decoder = Base64.getDecoder();
             cipher.init(Cipher.DECRYPT_MODE, key);
             byte[] encryptedText = decoder.decode(encryptedString);
             byte[] plainText = cipher.doFinal(encryptedText);
             decryptedText= new String(plainText);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return decryptedText;
     }
}
