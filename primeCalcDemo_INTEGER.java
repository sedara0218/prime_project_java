import java.io.*;
import java.util.*;

/*This Class is for classifying the Primes Array*/
class Prime
{
	int i;
	int b;
	public Prime(int bigInt, int index)
	{
		b = bigInt;
		i = index;
	}
	/*Function checks to make sure that the combinations 
	done on current prime is greater than or equal to 
	previous prime, if not then return false*/
	public boolean cont(Prime prev)
	{
		if (prev.i > i)
			return false;
		return true;
	}

	public int getIndex()
	{
		return i;
	}

	public int getBigInt()
	{
		return b;
	}

	public void setIndex(int newI)
	{
		i = newI;
	}

	public void setBigInt(int newB)
	{
		b = newB;
	}
}

public class primeCalcDemo_INTEGER
{
	private static int iter;// = 10;

	/* This function returns the next possible prime
	A Possible Prime is determined as a number which ends in either 1,3,7,9*/
	public static int getNextPoss(int b)
	{
		if (b % 2 == 0) {	// Check if b is even
			b += 1;							// If even make b odd by adding one
			int mod = b % 10;
			if (mod != 5)						// If b doesn't end in 5 return
				return b;
		}

		// If b is not even then it must be an odd number
		int mod = b % 10;
		if (mod == 3)							// If b is currently ending in 3 then add 4 to get next prime
			return b + 4;
		return b + 2;								// Else adding 2 to the number will produce the next possible prime
	}

	/* This functions returns the maximum possible prime which can be determined in the current iteration
	*/
	public static int minNextPoss(int b)
	{
		int maxNxt = b * 3;

		if (maxNxt % 2 == 0) {
			maxNxt -= 1;					// If the maxVal is even subtract 1 to make odd
			int mod = maxNxt % 10;
			if (mod != 5)							// If this val is not ending in 5 return it
				return maxNxt;
		}

		int mod = maxNxt % 10;
		if (mod == 7)								// If this val is odd and ending in 7 return the previous poss prime ending in 3.
			return maxNxt - 4;
		return maxNxt - 2;						// If val is odd and not ending in 7 then return val-2
	}

	/*  This function, given starting and ending possible primes, will return a linkedhashmap
	containing a list of possible primes between the two poss primes.
	This function assumes => s = starting possible prime, e = ending possible prime
	The BigInteger value in p is the possible prime, and the Boolean value is initially set to true
	*/
	public static LinkedHashMap<Integer, Boolean> getPossArray(int s, long e)
	{
		LinkedHashMap<Integer, Boolean> p = new LinkedHashMap<Integer, Boolean>();
		for (int b = s; b <= e; b+=2) {
			//System.out.println(p.size() + " " + b.toString().length()); ERROR IN BIGINTEGER
			p.put(b, true);
			if (b % 10 == 3)
				b += 2;
		}

		return p;
	}

	public static void main(String[] args) throws Exception
	{
		/*Initial Value Set*/
		List<Integer> comb = new ArrayList<Integer>();
		comb.add(3);
		List<Prime> primes = new ArrayList<Prime>(Arrays.asList(new Prime(3, 0)));

		int start = getNextPoss(3);
		int end = minNextPoss(start);
		LinkedHashMap<Integer, Boolean> poss = getPossArray(start, end);

		iter = Integer.parseInt(args[0]);

		long startTime = System.nanoTime();

		/*Iteration*/
		for (int z=0; z<iter; z++) {
			int maxInd = comb.size();
			for (Prime p: primes) {
				int index = p.getIndex();
				int curB = p.getBigInt();

				for (int i=index; i<maxInd; i++) {
					int mTmp = curB * comb.get(i);
					if (mTmp > end)
						break;
					poss.put(mTmp, false);
					p.setIndex(p.getIndex()+1);
				}
				maxInd = p.getIndex();
			}

			for (Map.Entry<Integer, Boolean> entry : poss.entrySet()) {
				//System.out.println(comb.size() + " " + primes.size() + " " + poss.size());
	    		int key = entry.getKey();
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
		// 	System.out.println(p.getBigInt());

		// System.out.println(((primes.get(primes.size()-1)).getBigInt()));
		System.out.println("Time for PrimeFactor Algo: " + exeTime + " ms");
	}
}
