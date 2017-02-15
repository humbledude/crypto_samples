package com.humbledude.crypto;

/**
 * Created by keunhui.park on 2017. 2. 15..
 */
public interface CryptoBase {

  String getAlgorithm();
  byte[] encrypt (String key, byte[] message);

}
