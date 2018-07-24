package com.jda.datastructureprograms;

import com.jda.datastructures.Queue;
import com.jda.utility.Maths;
import com.jda.utility.StringUtils;
import java.util.ArrayList;

public
class PrimesUsingQueue {

  public static
  void main(String[] args) {
    ArrayList<Integer> primes = Maths.primesUpto(1000);
    Queue<Integer> primesQueue = new Queue<>();
    for (Integer prime : primes) {
      if (StringUtils.isPrimeAnagram(primes, prime)) { primesQueue.enqueue(prime); }
    }

    while (!primesQueue.isEmpty()) { System.out.println(primesQueue.dequeue()); }
  }
}
