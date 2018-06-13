# Prime Project Java Version
## Steps to Run the program
#### 1. Download all files listed in this repo to a local directory.<br />
  * __effPrimeCalc.java__ is a traditional method for calculating primes.  It loops through all numbers from 1 to n and checks if each number is divisble by any of the numbers from 2 to the sqrt of the number.<br />
  * __primeCalcDemo.java__ is my method for calculating primes.<br />
  * __programEffeciency.java__ is the main program which will output the time taken for each algorithm to generate primes up to a certain number.<br />
#### 2. Open the terminal or command prompt to the location of the directory where the files are saved. <br />
#### 3. Type `java programEfficiency` into the terminal
  * to end the program before completion press ctrl-C

## Expected Output: 
*Note times will vary per machine

```
N = 19
RunTime Output:  Time for PrimeFactor Algo: 0.54571 ms
RunTime Output:  Time for Effecient Looping: 0.605646 ms

N = 61
RunTime Output:  Time for PrimeFactor Algo: 1.211673 ms
RunTime Output:  Time for Effecient Looping: 1.523463 ms

N = 181
RunTime Output:  Time for PrimeFactor Algo: 2.661169 ms
RunTime Output:  Time for Effecient Looping: 4.361052 ms

N = 547
RunTime Output:  Time for PrimeFactor Algo: 5.019299 ms
RunTime Output:  Time for Effecient Looping: 10.14739 ms

N = 1637
RunTime Output:  Time for PrimeFactor Algo: 9.824538 ms
RunTime Output:  Time for Effecient Looping: 20.429362 ms

N = 4909
RunTime Output:  Time for PrimeFactor Algo: 17.615257 ms
RunTime Output:  Time for Effecient Looping: 42.902115 ms

N = 14731
RunTime Output:  Time for PrimeFactor Algo: 38.160276 ms
RunTime Output:  Time for Effecient Looping: 109.60512 ms

N = 44189
RunTime Output:  Time for PrimeFactor Algo: 72.231368 ms
RunTime Output:  Time for Effecient Looping: 248.566089 ms

N = 132547
RunTime Output:  Time for PrimeFactor Algo: 142.149152 ms
RunTime Output:  Time for Effecient Looping: 867.989478 ms

N = 397643
RunTime Output:  Time for PrimeFactor Algo: 261.764434 ms
RunTime Output:  Time for Effecient Looping: 3262.276276 ms

N = 1192937
RunTime Output:  Time for PrimeFactor Algo: 1196.879222 ms
RunTime Output:  Time for Effecient Looping: 13588.610043 ms

N = 3578807
RunTime Output:  Time for PrimeFactor Algo: 3636.644343 ms
RunTime Output:  Time for Effecient Looping: 61029.312398 ms

N = 10736413
RunTime Output:  Time for PrimeFactor Algo: 12370.215671 ms
RunTime Output:  Time for Effecient Looping: 320985.276613 ms

Done!
```

## Extensions to the project:
If you played around with the program you would have noticed that by running primeCalcDemo.java for 14 iterations (this can be done by typing `java primeCalcDemo 14` in the terminal) you get an error: 
```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.math.BigInteger.<init>(BigInteger.java:463)
	at java.math.BigInteger.<init>(BigInteger.java:606)
	at primeCalcDemo.getPossArray(primeCalcDemo.java:59)
	at primeCalcDemo.main(primeCalcDemo.java:114)
```
I believe this is due to the fact that the algorithm I wrote uses way to much memory as I am storing millions of numbers.  In order to get around this I am currenlty rewritting this in C++ and will instead use local harddrive to store the numbers in my lists.  This way only a small portion of the memory will store the current iteration of numbers needed and I can quickly access and change the current list in memory using parallel processing so it shouldn't terribly affect the time taken for the algorithm. 
### *NOTE: YOU CAN RUN THE PROGRAM FOR A COUPLE MORE ITERATIONS BY INCREASING JVM MEMORY.  TO DO THIS USE THE FOLLOWING COMMAND WHEN RUNNING IN THE TERMINAL:
```
java -Xmx8g primeCalcDemo 15
This will run the program with 8gb of memory.
```



