package com.jda.datastructureprograms;

import com.jda.utility.Util;
import java.util.ArrayList;
import java.util.HashSet;

public
class PrimesAnagrams2D {

  public static
  void main(String[] args) {
    ArrayList<Integer> primes = Util.primesUpto(1000);
    HashSet<Integer> anagramPrimes = new HashSet<>();
    HashSet<Integer> nonAnagramPrimes = new HashSet<>();

    for (Integer prime : primes) {
      boolean foundPrimeAnagram = Util.isPrimeAnagram(primes, prime);
      if (foundPrimeAnagram) { anagramPrimes.add(prime); }
      else { nonAnagramPrimes.add(prime); }
    }
    System.out.println("Prime anagrams");
    PrimeNumbers2DArray.printIntArrayExceptZeros(anagramPrimes);

    System.out.println("Non anagram primes");
    PrimeNumbers2DArray.printIntArrayExceptZeros(nonAnagramPrimes);
  }
}
