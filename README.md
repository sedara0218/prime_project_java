# Prime Project Java Version
## Steps to Run the program
#### 1. Download all files listed in this repo to a local directory.<br />
  * __effPrimeCalc.java__ is a traditional method for calculating primes.  It loops through all numbers from 1 to n and checks if each number is divisble by any of the numbers from 2 to the sqrt of the number.<br />
  * __primeCalcDemo.java__ is my method for calculating primes.<br />
  * __programEffeciency.java__ is the main program which will output the time taken for each algorithm to generate primes up to a certain number.<br />
#### 2. Open the terminal or command prompt to the location of the directory where the files are saved. <br />
#### 3. Type `java programEfficiency` into the terminal
  * to end the program before completion press ctrl-C
  * view the note at the bottom of this page to run the program with MORE memory

## Expected Output: 
### *VIEW THE BOTTOM OF THIS PAGE FOR RUNTIME COMPARISIONS TO FAMOUS PRIME GENERATORS

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
```
This will run the program with 8gb of memory.

## Runtime Comparisions to famous prime generators:
If you are well adversed with common prime generation algorithms, then you should be aware of these three effecient prime generation algorithms:
  * Sieve of Eratosthenes (https://www.geeksforgeeks.org/sieve-of-eratosthenes/)
  * Sieve of Sundaram (https://www.geeksforgeeks.org/sieve-sundaram-print-primes-smaller-n/)
  * Sieve of Atkin (https://www.geeksforgeeks.org/sieve-of-atkin/)
  
I downloaded the code posted on the geeksforgeeks.org website, and changed the int primitive type to BigInteger so that it would match the type I used in my own algorithm.  Posted below are the runtime comparisions when running each of the algorithms:
```
N = 19
RunTime Output:  Time for PrimeFactor Algo: 0.337128 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 0.773121 ms
RunTime Output:  Time for Sundaram Algo: 0.984756 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.833837 ms

N = 61
RunTime Output:  Time for PrimeFactor Algo: 0.572111 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 1.012238 ms
RunTime Output:  Time for Sundaram Algo: 1.361967 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.836227 ms

N = 181
RunTime Output:  Time for PrimeFactor Algo: 1.292388 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 1.6006 ms
RunTime Output:  Time for Sundaram Algo: 2.200034 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.903148 ms

N = 547
RunTime Output:  Time for PrimeFactor Algo: 2.948037 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 3.66841 ms
RunTime Output:  Time for Sundaram Algo: 4.774039 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.885588 ms

N = 1637
RunTime Output:  Time for PrimeFactor Algo: 5.933537 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 7.155151 ms
RunTime Output:  Time for Sundaram Algo: 9.036404 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.858282 ms

N = 4909
RunTime Output:  Time for PrimeFactor Algo: 12.649911 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 11.531344 ms
RunTime Output:  Time for Sundaram Algo: 17.689583 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.844921 ms

N = 14731
RunTime Output:  Time for PrimeFactor Algo: 23.163009 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 18.72076 ms
RunTime Output:  Time for Sundaram Algo: 36.375983 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.848306 ms

N = 44189
RunTime Output:  Time for PrimeFactor Algo: 41.237302 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 44.402246 ms
RunTime Output:  Time for Sundaram Algo: 87.493372 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.878022 ms

N = 132547
RunTime Output:  Time for PrimeFactor Algo: 86.579419 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 101.688847 ms
RunTime Output:  Time for Sundaram Algo: 185.899978 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.847487 ms

N = 397643
RunTime Output:  Time for PrimeFactor Algo: 159.524152 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 195.536117 ms
RunTime Output:  Time for Sundaram Algo: 389.430587 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.83482 ms

N = 1192937
RunTime Output:  Time for PrimeFactor Algo: 425.488908 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 1381.50103 ms
RunTime Output:  Time for Sundaram Algo: 1239.723367 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.832785 ms

N = 3578807
RunTime Output:  Time for PrimeFactor Algo: 1533.816482 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 3446.888499 ms
RunTime Output:  Time for Sundaram Algo: 4029.911306 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.833458 ms

N = 10736413
RunTime Output:  Time for PrimeFactor Algo: 4888.353792 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 13512.832954 ms
RunTime Output:  Time for Sundaram Algo: 14457.398485 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.847659 ms
Done!
```
As can be seen above, my algorithm, while not the fastest, is much faster than the two slower Sieves!!!  If you are skeptical of my results you can view the geeksforgeeks.org site I linked above for the respective Sieve, download the Java code, modify the code so that you are using BigIntegers OR use my primeCalcDemo_INTEGER.java file instead of the primeCalcDemo.java file.  The reason for this is that BigInteger adds to the runtime of the algorithm as it is basically a list of integers which obviously takes up more bytes than a simple primitive integer type.
