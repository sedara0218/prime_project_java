// Java program for implementation of Sieve
// of Atkin
import java.math.BigInteger;
import java.util.*;

class Sieve_ATKIN {
 
    static int SieveOfAtkin(BigInteger limit)
    {
        // 2 and 3 are known to be prime
        if (limit.compareTo(new BigInteger("2")) > 0) {
            // System.out.print(2 + " ");
            return 0;
        }
        if (limit.compareTo(new BigInteger("3")) > 0) {
            // System.out.print(3 + " ");
            return 0;
        }   
        // Initialise the sieve array with
        // false values
        Map<BigInteger, Boolean> sieve = new LinkedHashMap<BigInteger, Boolean>();

        for (BigInteger i = new BigInteger("0"); i.compareTo(limit) < 0; i=i.add(new BigInteger("1")))
            sieve.put(i, false);
 
        /* Mark siev[n] is true if one of the
        following is true:
        a) n = (4*x*x)+(y*y) has odd number 
           of solutions, i.e., there exist 
           odd number of distinct pairs 
           (x, y) that satisfy the equation 
           and    n % 12 = 1 or n % 12 = 5.
        b) n = (3*x*x)+(y*y) has odd number 
           of solutions and n % 12 = 7
        c) n = (3*x*x)-(y*y) has odd number 
           of solutions, x > y and n % 12 = 11 */
        for (BigInteger x = new BigInteger("1"); (x.multiply(x)).compareTo(limit) < 0; x=x.add(new BigInteger("1"))) {
            for (BigInteger y = new BigInteger("1"); (y.multiply(y)).compareTo(limit) < 0; y=y.add(new BigInteger("1"))) {
 
                // Main part of Sieve of Atkin
                BigInteger n = ((new BigInteger("4")).multiply(x.multiply(x))).add(y.multiply(y));
                if (n.compareTo(limit) <= 0 && (n.mod(new BigInteger("12")).equals(new BigInteger("1")) || n.mod(new BigInteger("12")).equals(new BigInteger("5"))))
                    sieve.put(n, sieve.get(n)^true);
 
                n = ((new BigInteger("3")).multiply(x.multiply(x))).add(y.multiply(y));
                if (n.compareTo(limit) <= 0 && (n.mod(new BigInteger("12")).equals(new BigInteger("7"))))
                    sieve.put(n, sieve.get(n)^true);
 
                n = ((new BigInteger("3")).multiply(x.multiply(x))).subtract(y.multiply(y));
                if (x.compareTo(y) > 0 && n.compareTo(limit) <= 0 && n.mod(new BigInteger("12")).equals(new BigInteger("11")))
                    sieve.put(n, sieve.get(n)^true);
            }
        }
 
        // Mark all multiples of squares as
        // non-prime
        for (BigInteger r = new BigInteger("5"); (r.multiply(r)).compareTo(limit) < 0; r=r.add(new BigInteger("1"))) {
            if (sieve.get(r)) {
                for (BigInteger i = r.multiply(r); i.compareTo(limit) < 0; i = i.add(r.multiply(r)))
                    sieve.put(i, false);
            }
        }
 
        // Print primes using sieve[]
        // for (int a = 5; a < limit; a++)
        //     if (sieve[a])
        //         System.out.print(a + " ");
        return 0;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        long startTime = System.nanoTime();

        BigInteger limit = new BigInteger(args[0]);
        SieveOfAtkin(limit);

        long endTime = System.nanoTime();
        double exeTime = (endTime - startTime)/1000000.0;
        System.out.println("Time for Sieve of Atkin Algo: " + exeTime + " ms");
    }
}