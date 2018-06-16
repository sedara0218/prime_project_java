// Java program to print all primes smaller than or equal to
// n using Sieve of Eratosthenes
import java.util.*;
import java.math.BigInteger;

public class Sieve_ERATOSTHENES
{
    public static void sieveOfEratosthenes(BigInteger n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        Map<BigInteger, Boolean> prime = new LinkedHashMap<BigInteger, Boolean>();
        for(BigInteger i=new BigInteger("0");i.compareTo(n)<0;i=i.add(new BigInteger("1")))
            prime.put(i, true);
         
        for(BigInteger p = new BigInteger("2"); (p.multiply(p)).compareTo(n) <=0; p=p.add(new BigInteger("1")))
        {
            // If prime[p] is not changed, then it is a prime
            if(prime.get(p) == true)
            {
                // Update all multiples of p
                for(BigInteger i = p.multiply(new BigInteger("2")); i.compareTo(n) <= 0; i = i.add(p))
                    prime.put(i, false);
            }
        }
         
        // // Print all prime numbers
        // for(BigInteger i = new BigInteger("2"); i.compareTo(n) <= 0; i.add(new BigInteger("1")))
        // {
        //     if(prime.get(i) == true)
        //         System.out.print(i + " ");
        // }
    }
     
    // Driver Program to test above function
    public static void main(String args[])
    {
        long startTime = System.nanoTime();

        BigInteger n = new BigInteger(args[0]);
        sieveOfEratosthenes(n);

        long endTime = System.nanoTime();
        double exeTime = (endTime - startTime)/1000000.0;
        System.out.println("Time for Sieve of Eratosthenes Algo: " + exeTime + " ms");
    }
}
 
// This code has been contributed by Amit Khandelwal.