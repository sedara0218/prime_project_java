import PrimeClasses.Prime;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Sieve_EDARA
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

	/*  This function, given starting and ending possible primes, will return a linkedhashmap
	containing a list of possible primes between the two poss primes.
	This function assumes => s = starting possible prime, e = ending possible prime
	The BigInteger value in p is the possible prime, and the Boolean value is initially set to true
	*/
	public static LinkedHashMap<BigInteger, Boolean> getPossArray(BigInteger s, BigInteger e)
	{
		LinkedHashMap<BigInteger, Boolean> p = new LinkedHashMap<BigInteger, Boolean>();
		for (BigInteger b = s; b.compareTo(e) <= 0; b = b.add(new BigInteger("2"))) {
			//System.out.println(p.size() + " " + b.toString().length()); ERROR IN BIGINTEGER
			p.put(b, true);
			if (b.mod(new BigInteger("10")).equals(new BigInteger("3")))
				b = b.add(new BigInteger("2"));
		}

		return p;
	}

	public static void main(String[] args) throws Exception
	{
		/*Initial Value Set*/
		List<BigInteger> comb = new ArrayList<BigInteger>(Arrays.asList(new BigInteger("3")));
		List<Prime> primes = new ArrayList<Prime>(Arrays.asList(new Prime(new BigInteger("3"), 0)));

		BigInteger start = getNextPoss(new BigInteger("3"));
		BigInteger end = minNextPoss(start);
		LinkedHashMap<BigInteger, Boolean> poss = getPossArray(start, end);

		iter = Integer.parseInt(args[0]);

		long startTime = System.nanoTime();

		/*Iteration*/
		for (int z=0; z<iter; z++) {
			int maxInd = comb.size();
			for (Prime p: primes) {
				int index = p.getIndex();
				BigInteger curB = p.getBigInt();

				for (int i=index; i<maxInd; i++) {
					BigInteger mTmp = curB.multiply(comb.get(i));
					if (mTmp.compareTo(end) > 0)
						break;
					poss.put(mTmp, false);
					p.setIndex(p.getIndex()+1);
				}
				maxInd = p.getIndex();
			}

			for (Map.Entry<BigInteger, Boolean> entry : poss.entrySet()) {
				//System.out.println(comb.size() + " " + primes.size() + " " + poss.size());
	    		BigInteger key = entry.getKey();
			    Boolean value = entry.getValue();
			    comb.add(key);
			    if (value == true)
			    	primes.add(new Prime(key, comb.size()-1));
			}

			// System.out.println("Iteration " + z + " -> " + (primes.get(primes.size()-1)).getBigInt());

			if (z+1 != iter) {
				start = getNextPoss((primes.get(primes.size()-1)).getBigInt());
				end = minNextPoss(start);
				poss = getPossArray(start, end);

			}
		}

		long endTime = System.nanoTime();
		double exeTime = (endTime - startTime)/1000000.0;

		// for (Prime p: primes)
		// 	System.out.println((p.getBigInt()).toString());

		// System.out.println(((primes.get(primes.size()-1)).getBigInt()).toString());
		System.out.println("Time for My EDARA Algo: " + exeTime + " ms");
	}
}
