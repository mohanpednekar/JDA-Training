package com.jda.datastructureprograms;

import com.jda.datastructures.Queue;
import com.jda.utility.Util;
import java.util.ArrayList;

public
class PrimesUsingQueue {

  public static
  void main(String[] args) {
    ArrayList<Integer> primes = Util.primesUpto(1000);
    Queue<Integer> primesQueue = new Queue<>();
    for (Integer prime : primes) {
      if (Util.isPrimeAnagram(primes, prime)) { primesQueue.enqueue(prime); }
    }

    while (!primesQueue.isEmpty()) { System.out.println(primesQueue.dequeue()); }
  }
}
