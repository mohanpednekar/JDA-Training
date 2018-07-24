package com.jda.datastructureprograms;

import com.jda.datastructures.Stack;
import com.jda.utility.Maths;
import com.jda.utility.StringUtils;
import java.util.ArrayList;

public
class PrimesUsingStack {

  public static
  void main(String[] args) {
    ArrayList<Integer> primes = Maths.primesUpto(1000);
    Stack<Integer> primesStack = new Stack<>();
    for (Integer prime : primes) {
      if (StringUtils.isPrimeAnagram(primes, prime)) { primesStack.push(prime); }
    }

    while (!primesStack.isEmpty()) { System.out.println(primesStack.pop()); }
  }
}
