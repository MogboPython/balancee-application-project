package com.example.balancee_rewards.util;
import java.util.Random;

public class IdGenerator {
    
  public static String generateId() {
    
    String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < 4; i++) {
      int index = random.nextInt(characters.length());
      sb.append(characters.charAt(index));
    }
    
    return sb.toString();
  }
}