package com.humbledude.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by keunhui.park on 2017. 2. 15..
 */
public class AES128Utils implements CryptoBase{

  private static final String ALGORITHM = "AES";

  @Override
  public byte[] encrypt(String key, byte[] message) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);
      Cipher cipher = Cipher.getInstance(ALGORITHM);

      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

      return cipher.doFinal(message);

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getAlgorithm() {
    return ALGORITHM;
  }
}
