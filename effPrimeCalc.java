import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class effPrimeCalc
{
	private static BigInteger N; //= new BigInteger("397643"); 

    public static BigInteger sqrt(BigInteger x) 
    {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
	public static List<BigInteger> primeLoop ()
	{
		List<BigInteger> primes = new ArrayList<BigInteger>();

        for (BigInteger b = new BigInteger("2"); b.compareTo(N) < 0; b=b.add(new BigInteger("1"))) {
            boolean iPrime = true;
            
            if (b.compareTo(new BigInteger("2")) > 0 && (b.mod(new BigInteger("2"))).equals(new BigInteger("0")))
                iPrime = false;

            else {
                for (BigInteger j = new BigInteger("3"); j.compareTo(sqrt(b)) <= 0; j=j.add(new BigInteger("2"))) {
                    if ((b.mod(j)).equals(new BigInteger("0"))) {
                        iPrime = false;
                        break;
                    }
                }
            }
            if (iPrime) 
                primes.add(b);
        }		
        return primes;
	}
	public static void main(String[] args)
	{
        N = new BigInteger(args[0]);
		long startTime = System.nanoTime();
		List<BigInteger> pLoopArray = primeLoop();
		long endTime = System.nanoTime();
		double loopTime = (endTime - startTime)/1000000.0; 

		System.out.println("Time for Effecient Looping: " + loopTime + " ms");
	}
}