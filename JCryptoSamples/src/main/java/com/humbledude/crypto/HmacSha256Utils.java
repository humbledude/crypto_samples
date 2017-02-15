package com.humbledude.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by keunhui.park on 2017. 2. 15..
 */
public class HmacSha256Utils implements CryptoBase{

  private static final String ALGORITHM = "HmacSHA256";

  public byte[] encrypt(String key, byte[] message) {
    try {
      SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
      Mac mac = Mac.getInstance(ALGORITHM);
      mac.init(secretKey);

      return mac.doFinal(message);

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    }

    return null;
  }

  public byte[] decrypt(String key, byte[] message) {
    return null;
  }

  public String getAlgorithm() {
    return ALGORITHM;
  }

}
