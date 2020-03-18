import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Sieve_EDARA_SpaceEff
{
	private static int iter;// = 10;

	/* This function returns the next possible prime
	A Possible Prime is determined as a number which ends in either 1,3,7,9*/
	public static BigInteger getNextPoss(BigInteger b)
	{
		if (b.mod(new BigInteger("2")).equals(new BigInteger("0"))) {	// Check if b is even
			b = b.add(new BigInteger("1")); 							// If even make b odd by adding one
			BigInteger mod = b.mod(new BigInteger("10"));
			if (!mod.equals(new BigInteger("5")))						// If b doesn't end in 5 return
				return b;
		}

		// If b is not even then it must be an odd number
		BigInteger mod = b.mod(new BigInteger("10"));
		if (mod.equals(new BigInteger("3")))							// If b is currently ending in 3 then add 4 to get next prime
			return b.add(new BigInteger("4"));
		return b.add(new BigInteger("2"));								// Else adding 2 to the number will produce the next possible prime
	}

	/* This functions returns the maximum possible prime which can be determined in the current iteration
	*/
	public static BigInteger minNextPoss(BigInteger b)
	{
		BigInteger maxNxt = b.multiply(new BigInteger("3"));

		if (maxNxt.mod(new BigInteger("2")).equals(new BigInteger("0"))) {
			maxNxt = maxNxt.subtract(new BigInteger("1"));					// If the maxVal is even subtract 1 to make odd
			BigInteger mod = maxNxt.mod(new BigInteger("10"));
			if (!mod.equals(new BigInteger("5")))							// If this val is not ending in 5 return it
				return maxNxt;
		}

		BigInteger mod = maxNxt.mod(new BigInteger("10"));
		if (mod.equals(new BigInteger("7")))								// If this val is odd and ending in 7 return the previous poss prime ending in 3.
			return maxNxt.subtract(new BigInteger("4"));
		return maxNxt.subtract(new BigInteger("2"));						// If val is odd and not ending in 7 then return val-2
	}

	public static void main(String[] args) throws Exception
	{
      System.out.println("Total Memory Available: " + Runtime.getRuntime().totalMemory() / 1024.0 + " KB");
      
		/* Initial Value Set */
		// List<BigInteger> comb = new ArrayList<BigInteger>(Arrays.asList(new BigInteger("3")));
		LinkedHashMap<BigInteger, Primality> primes = new LinkedHashMap<BigInteger, Primality>();
      primes.put(new BigInteger("3"), new Primality(new BigInteger("3"), true));
      
		BigInteger start = getNextPoss(new BigInteger("3"));
		BigInteger end = minNextPoss(start);
		// LinkedHashMap<BigInteger, Boolean> poss = getPossArray(start, end);

		iter = Integer.parseInt(args[0]);

		long startTime = System.nanoTime();

		/* Iteration Variables*/
	   BigInteger maxComb = new BigInteger("3");
      /* Iteration */
   	for (int z=0; z<iter; z++) {
         // System.out.println("Free Memory Available at Start: " + Runtime.getRuntime().freeMemory() / 1024.0 + " KB");

			for (BigInteger i=start; i.compareTo(end)<=0; i=i.add(new BigInteger("2"))) {
				primes.put(i, new Primality(i, true));
            
            if (i.mod(new BigInteger("10")).equals(new BigInteger("3")))
				   i = i.add(new BigInteger("2"));
			}
         
			for (Map.Entry<BigInteger, Primality> p: primes.entrySet()) {
            if (p.getKey().compareTo(start) >= 0)
               break;
            
            if (p.getValue().getPrimality() == false)
               continue;
               
				BigInteger startComb = p.getValue().getComb();

				for (BigInteger i=startComb; i.compareTo(maxComb)<=0; i=i.add(new BigInteger("2"))) {
					BigInteger mTmp = p.getKey().multiply(i);
               
					if (mTmp.compareTo(end) > 0)
						break;
                  
					primes.put(mTmp, new Primality(null, false));
					p.getValue().setComb(getNextPoss(p.getValue().getComb()));
               
               if (i.mod(new BigInteger("10")).equals(new BigInteger("3")))
				      i = i.add(new BigInteger("2"));
				}
			}
         
         BigInteger largestPrime = new BigInteger("3");
			for (BigInteger i=end; i.compareTo(start)>=0; i=i.subtract(new BigInteger("2"))) {
				if (primes.get(i).getPrimality() == true && i.compareTo(largestPrime) > 0) {
               largestPrime = i;
               break;
            }
               
            if (i.mod(new BigInteger("10")).equals(new BigInteger("7")))
				   i = i.subtract(new BigInteger("2"));
			}

			System.out.println("Iteration " + z + " -> " + largestPrime);
         System.out.println("Free Memory Available at End: " + Runtime.getRuntime().freeMemory() / 1024.0 + " KB");
         
			if (z+1 != iter) {
            maxComb = end;
				start = getNextPoss(largestPrime);
				end = minNextPoss(start);
			}
		}

		long endTime = System.nanoTime();
		double exeTime = (endTime - startTime)/1000000.0;

		// for (Prime p: primes)
		    // System.out.println((p.getBigInt()).toString());

		// System.out.println("Last Prime in Current Iteration: " + ((primes.get(primes.size()-1)).getBigInt()).toString());
		System.out.println("Time for My EDARA Algo: " + exeTime + " ms");
	}
}

/*This Class is for classifying values of the Primes Map*/
class Primality
{
	private BigInteger c;
	private boolean isPrime;
   
	public Primality(BigInteger startComb, boolean primality)
	{
		isPrime = primality;
		c = startComb;
	}

	public BigInteger getComb()
	{
		return c;
	}

	public void setComb(BigInteger newC)
	{
		c = newC;
	}

	public boolean getPrimality()
	{
		return isPrime;
	}
}