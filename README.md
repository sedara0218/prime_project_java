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
  
I downloaded the code posted on the geeksforgeeks.org website, and changed the int primitive type to BigInteger so that it would match the type I used in my own algorithm.  Posted below are the runtime comparisions when running each of the algorithms:
```
N = 19
RunTime Output:  Time for My EDARA Algo: 0.360946 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 0.762038 ms
RunTime Output:  Time for Sundaram Algo: 0.98747 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.856554 ms

N = 61
RunTime Output:  Time for My EDARA Algo: 0.63967 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 0.991794 ms
RunTime Output:  Time for Sundaram Algo: 1.353262 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.836473 ms

N = 181
RunTime Output:  Time for My EDARA Algo: 1.242635 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 1.608379 ms
RunTime Output:  Time for Sundaram Algo: 2.488601 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.836096 ms

N = 547
RunTime Output:  Time for My EDARA Algo: 2.994189 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 3.572769 ms
RunTime Output:  Time for Sundaram Algo: 5.239958 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.915496 ms

N = 1637
RunTime Output:  Time for My EDARA Algo: 6.040511 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 6.466071 ms
RunTime Output:  Time for Sundaram Algo: 9.24433 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.850505 ms

N = 4909
RunTime Output:  Time for My EDARA Algo: 13.10111 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 10.040123 ms
RunTime Output:  Time for Sundaram Algo: 17.429241 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.853673 ms

N = 14731
RunTime Output:  Time for My EDARA Algo: 23.733195 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 24.936006 ms
RunTime Output:  Time for Sundaram Algo: 36.943461 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.866346 ms

N = 44189
RunTime Output:  Time for My EDARA Algo: 46.46009 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 45.496277 ms
RunTime Output:  Time for Sundaram Algo: 80.785687 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.855372 ms

N = 132547
RunTime Output:  Time for My EDARA Algo: 87.269402 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 90.206854 ms
RunTime Output:  Time for Sundaram Algo: 178.388403 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.827621 ms

N = 397643
RunTime Output:  Time for My EDARA Algo: 155.635449 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 198.379035 ms
RunTime Output:  Time for Sundaram Algo: 382.481201 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.843782 ms

N = 1192937
RunTime Output:  Time for My EDARA Algo: 424.498919 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 1377.984797 ms
RunTime Output:  Time for Sundaram Algo: 1225.67866 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.83986 ms

N = 3578807
RunTime Output:  Time for My EDARA Algo: 1527.620358 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 3435.861479 ms
RunTime Output:  Time for Sundaram Algo: 4010.106851 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.834432 ms

N = 10736413
RunTime Output:  Time for My EDARA Algo: 4828.215248 ms
RunTime Output:  Time for Sieve of Eratosthenes Algo: 13433.728233 ms
RunTime Output:  Time for Sundaram Algo: 14250.571638 ms
RunTime Output:  Time for Sieve of Atkin Algo: 0.848753 ms

Done!
```
As can be seen above, my algorithm, while not the fastest, is much faster than the two slower Sieves!!!  If you are skeptical of my results you can view the geeksforgeeks.org site I linked above for the respective Sieve, download the Java code, modify the code so that you are using BigIntegers OR use my Sieve_EDARA_INTEGER.java file for testing instead of the Sieve_EDARA.java file.  The reason for this is that BigInteger adds to the runtime of the algorithm as it is basically a list of integers which obviously takes up more bytes than a simple primitive integer type.

Posted below are the runtimes for my EDARA algo using the integer primitive type:

*Note: this can be run by typing `java programEfficiency_EDARA_INT` in the terminal.
```
N = 19
RunTime Output:  Time for My EDARA Algo: 0.307315 ms

N = 61
RunTime Output:  Time for My EDARA Algo: 0.351426 ms

N = 181
RunTime Output:  Time for My EDARA Algo: 0.524727 ms

N = 547
RunTime Output:  Time for My EDARA Algo: 1.000302 ms

N = 1637
RunTime Output:  Time for My EDARA Algo: 2.472271 ms

N = 4909
RunTime Output:  Time for My EDARA Algo: 3.941444 ms

N = 14731
RunTime Output:  Time for My EDARA Algo: 7.726192 ms

N = 44189
RunTime Output:  Time for My EDARA Algo: 13.092983 ms

N = 132547
RunTime Output:  Time for My EDARA Algo: 30.873247 ms

N = 397643
RunTime Output:  Time for My EDARA Algo: 57.614836 ms

N = 1192937
RunTime Output:  Time for My EDARA Algo: 140.853198 ms

N = 3578807
RunTime Output:  Time for My EDARA Algo: 423.0058 ms

N = 10736413
RunTime Output:  Time for My EDARA Algo: 2574.043819 ms

Done!
```
