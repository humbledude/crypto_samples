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

    // encrypt it
    byte[] encrypted = cryptoBase.encrypt(key, message.getBytes());
    String base64Str = null;
    if (encrypted != null) {
      base64Str = Base64Utils.toBase64Str(encrypted);
      System.out.println(base64Str);
    } else {
      System.out.println("encryption not support");
    }

    // decrypt it
    if (base64Str != null) {
      encrypted = Base64Utils.fromBase64Str(base64Str);
      byte[] decrypted = cryptoBase.decrypt(key, encrypted);
      if (decrypted != null) {
        System.out.println(new String(decrypted));
      } else {
        System.out.println("decryption not support");
      }
    }
  }
}
