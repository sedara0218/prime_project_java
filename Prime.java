package PrimeClasses;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

/*This Class is for classifying the Primes Array*/
public class Prime
{
	int i;
	BigInteger b;
	public Prime(BigInteger bigInt, int index)
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

	public BigInteger getBigInt()
	{
		return b;
	}

	public void setIndex(int newI)
	{
		i = newI;
	}

	public void setBigInt(BigInteger newB)
	{
		b = newB;
	}
}