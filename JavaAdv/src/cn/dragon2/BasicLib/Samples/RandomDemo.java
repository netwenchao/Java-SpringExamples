package cn.dragon2.BasicLib.Samples;

import java.util.Random;

public class RandomDemo {
  public static void main(String[] args) throws Exception {
    int[] arr = RandomFactory.Create(5);
    for (int i : arr) {
      System.out.println(i);
    }

  }
}

class RandomFactory {
  public static int[] Create(int len) throws Exception {
    if (len <= 0)
      throw new Exception("Length should be great than 0.");
    int[] arr = new int[len];
    int cur = 0;
    Random r = new Random(System.currentTimeMillis());
    while (cur < len) {
      arr[cur++] = r.nextInt(30) + 1;
    }
    return arr;
  }
}
