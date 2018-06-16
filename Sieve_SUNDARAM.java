// Java program to print primes smaller
// than n using Sieve of Sundaram.
import java.util.*;
import java.math.BigInteger;
public class Sieve_SUNDARAM {
 
// Prints all prime numbers smaller
public static int SieveOfSundaram(BigInteger n) {
 
    // In general Sieve of Sundaram, produces 
    // primes smaller than (2*x + 2) for a number
    // given number x. Since we want primes 
    // smaller than n, we reduce n to half
    BigInteger nNew = (n.subtract(new BigInteger("2"))).divide(new BigInteger("2"));
 
    // This array is used to separate numbers of the 
    // form i+j+2ij from others where 1 <= i <= j
    Map<BigInteger, Boolean> marked = new LinkedHashMap<BigInteger, Boolean>();
    
    // Initalize all elements as not marked
    // Arrays.fill(marked, false);
 
    // Main logic of Sundaram. Mark all numbers of the
    // form i + j + 2ij as true where 1 <= i <= j
    for (BigInteger i = new BigInteger("1"); i.compareTo(nNew) <= 0; i=i.add(new BigInteger("1"))) {
        for (BigInteger j = i; (i.add(j).add((new BigInteger("2")).multiply(i).multiply(j))).compareTo(nNew) <= 0; j=j.add(new BigInteger("1")))
            marked.put((i.add(j).add((new BigInteger("2")).multiply(i).multiply(j))), true);
    }
 
    return -1;
}
 
// Driver code
public static void main(String[] args) {

    long startTime = System.nanoTime();

    BigInteger n = new BigInteger(args[0]);
    SieveOfSundaram(n);

    long endTime = System.nanoTime();
    double exeTime = (endTime - startTime)/1000000.0;
    System.out.println("Time for Sundaram Algo: " + exeTime + " ms");
}
}
// This code is contributed by Anant Agarwal.