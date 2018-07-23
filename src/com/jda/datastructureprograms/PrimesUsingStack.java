package com.jda.datastructureprograms;

import com.jda.datastructures.Stack;
import com.jda.utility.Util;
import java.util.ArrayList;

public
class PrimesUsingStack {

  public static
  void main(String[] args) {
    ArrayList<Integer> primes = Util.primesUpto(1000);
    Stack<Integer> primesStack = new Stack<>();
    for (Integer prime : primes) {
      if (Util.isPrimeAnagram(primes, prime)) { primesStack.push(prime); }
    }

    while (!primesStack.isEmpty()) { System.out.println(primesStack.pop()); }
  }
}
