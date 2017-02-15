package com.humbledude.crypto;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by keunhui.park on 2017. 2. 15..
 */
public class Base64Utils {

  public static String toBase64String(byte[] bytes) {
    byte[] byteArray = Base64.encodeBase64(bytes);
    return new String(byteArray);
  }
}
