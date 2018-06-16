# Prime Project Java Version
## Steps to Run the program
#### 1. Download all files listed in this repo to a local directory.<br />
  * __effPrimeCalc.java__ is a traditional method for calculating primes.  It loops through all numbers from 1 to n and checks if each number is divisble by any of the numbers from 2 to the sqrt of the number.<br />
  * __Sieve_EDARA.java__ is my method for calculating primes.<br />
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
RunTime Output:  Time for My EDARA Algo: 0.408166 ms
RunTime Output:  Time for Effecient Looping: 0.601978 ms

N = 61
RunTime Output:  Time for My EDARA Algo: 0.570128 ms
RunTime Output:  Time for Effecient Looping: 1.518575 ms

N = 181
RunTime Output:  Time for My EDARA Algo: 1.310789 ms
RunTime Output:  Time for Effecient Looping: 4.185063 ms

N = 547
RunTime Output:  Time for My EDARA Algo: 3.06782 ms
RunTime Output:  Time for Effecient Looping: 10.114269 ms

N = 1637
RunTime Output:  Time for My EDARA Algo: 6.570717 ms
RunTime Output:  Time for Effecient Looping: 20.435806 ms

N = 4909
RunTime Output:  Time for My EDARA Algo: 12.391258 ms
RunTime Output:  Time for Effecient Looping: 44.512238 ms

N = 14731
RunTime Output:  Time for My EDARA Algo: 21.425074 ms
RunTime Output:  Time for Effecient Looping: 102.398841 ms

N = 44189
RunTime Output:  Time for My EDARA Algo: 45.046743 ms
RunTime Output:  Time for Effecient Looping: 245.889901 ms

N = 132547
RunTime Output:  Time for My EDARA Algo: 79.327216 ms
RunTime Output:  Time for Effecient Looping: 866.786937 ms

N = 397643
RunTime Output:  Time for My EDARA Algo: 157.016553 ms
RunTime Output:  Time for Effecient Looping: 3239.445974 ms

N = 1192937
RunTime Output:  Time for My EDARA Algo: 433.971553 ms
RunTime Output:  Time for Effecient Looping: 13672.302931 ms

N = 3578807
RunTime Output:  Time for My EDARA Algo: 1730.705861 ms
RunTime Output:  Time for Effecient Looping: 61384.83956 ms

N = 10736413
RunTime Output:  Time for My EDARA Algo: 5026.810681 ms
RunTime Output:  Time for Effecient Looping: 326987.867979 ms

Done!
```

## Extensions to the project:
If you played around with the program you would have noticed that by running Sieve_EDARA.java for 14 iterations (this can be done by typing `java Sieve_EDARA 14` in the terminal) you get an error: 
```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.math.BigInteger.<init>(BigInteger.java:463)
	at java.math.BigInteger.<init>(BigInteger.java:606)
	at Sieve_EDARA.getPossArray(Sieve_EDARA.java:59)
	at Sieve_EDARA.main(Sieve_EDARA.java:114)
```
I believe this is due to the fact that the algorithm I wrote uses way to much memory as I am storing millions of numbers.  In order to get around this I am currenlty rewritting this in C++ and will instead use local harddrive to store the numbers in my lists.  This way only a small portion of the memory will store the current iteration of numbers needed and I can quickly access and change the current list in memory using parallel processing so it shouldn't terribly affect the time taken for the algorithm. 

### *NOTE: YOU CAN RUN THE PROGRAM FOR A COUPLE MORE ITERATIONS BY INCREASING JVM MEMORY.  TO DO THIS USE THE FOLLOWING COMMAND WHEN RUNNING IN THE TERMINAL:
```
java -Xmx8g Sieve_EDARA 15
```
This will run the program with 8gb of memory.

## Runtime Comparisions to famous prime generators:
If you are well adversed with common prime generation algorithms, then you should be aware of these three effecient prime generation algorithms:
  * Sieve of Eratosthenes (https://www.geeksforgeeks.org/sieve-of-eratosthenes/)
  * Sieve of Sundaram (https://www.geeksforgeeks.org/sieve-sundaram-print-primes-smaller-n/)
  * Sieve of Atkin (https://www.geeksforgeeks.org/sieve-of-atkin/)
  
I downloaded the code posted on the geeksforgeeks.org website, and modified the code so that instead of using the int primitive type they would use BigInteger so that it would match the type I used in my own algorithm.  Posted below are the runtime comparisions when running each of the algorithms:
```
N = 19
RunTime Output:  Time for My EDARA Algo: 0.515184 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 0.857288 ms
RunTime Output:  Time for Sundaram Algo: 1.348159 ms
RunTime Output:  Time for Sieve of Atkin Algo: 1.741106 ms

N = 61
RunTime Output:  Time for My EDARA Algo: 0.577519 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 0.997515 ms
RunTime Output:  Time for Sundaram Algo: 1.308766 ms
RunTime Output:  Time for Sieve of Atkin Algo: 3.151065 ms

N = 181
RunTime Output:  Time for My EDARA Algo: 1.196069 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 1.597736 ms
RunTime Output:  Time for Sundaram Algo: 2.353183 ms
RunTime Output:  Time for Sieve of Atkin Algo: 5.796125 ms

N = 547
RunTime Output:  Time for My EDARA Algo: 3.183867 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 3.268081 ms
RunTime Output:  Time for Sundaram Algo: 5.212332 ms
RunTime Output:  Time for Sieve of Atkin Algo: 10.135988 ms

N = 1637
RunTime Output:  Time for My EDARA Algo: 9.611169 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 7.759105 ms
RunTime Output:  Time for Sundaram Algo: 12.920162 ms
RunTime Output:  Time for Sieve of Atkin Algo: 17.036979 ms

N = 4909
RunTime Output:  Time for My EDARA Algo: 13.141681 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 11.001805 ms
RunTime Output:  Time for Sundaram Algo: 16.087704 ms
RunTime Output:  Time for Sieve of Atkin Algo: 47.221882 ms

N = 14731
RunTime Output:  Time for My EDARA Algo: 22.992999 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 22.813391 ms
RunTime Output:  Time for Sundaram Algo: 39.544612 ms
RunTime Output:  Time for Sieve of Atkin Algo: 63.810715 ms

N = 44189
RunTime Output:  Time for My EDARA Algo: 46.796873 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 45.773029 ms
RunTime Output:  Time for Sundaram Algo: 84.541303 ms
RunTime Output:  Time for Sieve of Atkin Algo: 124.223001 ms

N = 132547
RunTime Output:  Time for My EDARA Algo: 131.795781 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 114.86514 ms
RunTime Output:  Time for Sundaram Algo: 194.179972 ms
RunTime Output:  Time for Sieve of Atkin Algo: 237.746747 ms

N = 397643
RunTime Output:  Time for My EDARA Algo: 169.504458 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 205.429847 ms
RunTime Output:  Time for Sundaram Algo: 381.067349 ms
RunTime Output:  Time for Sieve of Atkin Algo: 579.519665 ms

N = 1192937
RunTime Output:  Time for My EDARA Algo: 413.033449 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 1377.550607 ms
RunTime Output:  Time for Sundaram Algo: 1207.085806 ms
RunTime Output:  Time for Sieve of Atkin Algo: 2197.992309 ms

N = 3578807
RunTime Output:  Time for My EDARA Algo: 1613.045521 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 4036.730272 ms
RunTime Output:  Time for Sundaram Algo: 4511.915289 ms
RunTime Output:  Time for Sieve of Atkin Algo: 6032.365983 ms

N = 10736413
RunTime Output:  Time for My EDARA Algo: 5324.038924 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 15306.861956 ms
RunTime Output:  Time for Sundaram Algo: 15263.137452 ms
RunTime Output:  Time for Sieve of Atkin Algo: 20202.084604 ms

Done!
```
While it seems my algorithm is more efficient than the other sieves, I still believe the Sieve of Atkin is faster than my algorithm. I created a version of my Java program using the int primitive type and tested this with the Sieve of Atkin posted as is on the geeksforgeeks site.  I found that Atkin was predominately much faster than my own algorithm, and this can be further backed up by the Big O analysis of the Sieve of Atkin.  With that being said the data structures used in the Integer version of Sieve of Atkin was an array whereas I used Maps and Lists which aren't as quick as using an array; thus adding overhead time to my algorithm.  I beleive I can further optimize the integer version of my Edara algorithm so that I don't need to use extensive data structures; which will help reduce my runtime.

In addition, I beleive when it comes to prime generators, programmers should be using the BigInteger class since we are hopefully trying to deal with numbers beyond the scope of the primitive types.  Therefore from a strictly programming perspective I can strongly conclude my algorithm is the more effecient.
