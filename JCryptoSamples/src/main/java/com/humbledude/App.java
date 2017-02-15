package com.humbledude;

import com.humbledude.crypto.AES128Utils;
import com.humbledude.crypto.Base64Utils;
import com.humbledude.crypto.CryptoBase;
import com.humbledude.crypto.HmacSha256Utils;

/**
 * Created by keunhui.park on 2017. 2. 15..
 */
public class App {

  public static void main(String args[]) {
    System.out.println("hello world");

    test(new HmacSha256Utils(), "myKey", "hello world");

    test(new AES128Utils(), "0123456789012345", "test event:"+System.currentTimeMillis());


  }

  private static void test(CryptoBase cryptoBase, String key, String message) {
    System.out.println("ALGORITHM : " + cryptoBase.getAlgorithm());
    byte[] encrypted = cryptoBase.encrypt(key, message.getBytes());
    if (encrypted != null) {
      System.out.println(Base64Utils.toBase64String(encrypted));
    } else {
      System.out.println("encryption not support");
    }

    byte[] decrypted = cryptoBase.decrypt(key, encrypted);
    if (decrypted != null) {
      System.out.println(new String(decrypted));
    } else {
      System.out.println("decryption not support");
    }
  }
}
