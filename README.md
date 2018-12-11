# **Online Bin Packing**

This program is use to test five online bin packing algorithms in three benchmarks.

Five algorithms includes First Fit algorithm, Best Fit algorithm, Next Fit algorithm, Harmonic algorithm, and Move to Front  algorithm. 

## Getting Started

### Prerequisites

The software I use to develop this program is Dr.Java.  The version is : drjava-20160913-225446

The download link can be found in this link: http://www.drjava.org/download.shtml

### Installing

Depends on what system you use.  If you are using Windows, choose "Download Windows App via HTTP" to install Dr.Java.  If you are using Mac OS, choose "Download Mac OS X App via HTTP" to install Dr.Java.

The version that I use is in the "Current Stable Release" Section.

## Running the tests

Download all files in this repository, includes (box_volumn.txt and words.txt).

Then, open all Java files in Dr.Java.  The main method of this program is named "mainFunctions.java".   Compile files, then select mainFunction.java in Dr.Java, then run the program.



There will a dialog box jumps out.

```
which benchmark option would you want to run?（enter the character to choose）
a.normal
b.amazon box
c.words
```

There are three benchmarks in this program.  Enter a, it will run the normal benchmark.  Enter b, it will run the amazon box benchmark.  Enter c, it will run the words benchmark.



If you entered the option, then another dialog box will show up.

```
how many tests do you want to do in a round?(enter numbers from 1 to 1500)
```

Enter numbers between 1 to 1500, then the system will run the selected benchmarks n times. 



The third dialog box ask about do you want to print each steps.

```

Do you want to print all algorithms results in detail?
type y for yes
type n for no

```

If you choose print results, and and numbers of test you entered is high.  The output will looks mess.

Normally, I type n to choose not print results in detail.  Because this feature is used to help me debug the program during the development, it's not design for showing results to users.



If you choose to run the normal benchmark.  The system will ask you about how many optimal numbers of bins you want the program to generate.

```
enter the how bins for optimal solution
```

If you entered 10, the system will assume the optimal number of bins is 10.  Then, it will divided 10 bins to random size pieces as inputs for testing.  The number you entered should not be too high.  Because when I run the program on my program, if number I entered is too high (like 3000), my computer run out of memory.



If you choose to run the amazon box benchmark.  The system will ask you to enter how many boxes you wish to be loaded in bins.

```
how many items in total
```



If you choose to run the words benchmark.  The system will ask you to enter how many words as your testing inputs.

```
how many words in total
```



The output should looks like this.

```
Optimal result:5  binSize:100
best fit bins:
[6, 6, 6, 6, 6]
best fit times:
[2128146, 72135, 74380, 143308, 92974]
best fit waste total:
[9, 0]
-----------------------------
first fit bins:
[6, 6, 6, 6, 6]
first fit times:
[2127184, 33342, 33663, 58029, 43923]
first fit waste total:
[10, 0]
-----------------------------
next fit bins:
[6, 8, 7, 6, 6]
next fit times:
[1937710, 28854, 23404, 41999, 32381]
next fit waste total:
[11, 1]
-----------------------------
harmonic fit bins:
[8, 8, 8, 7, 7]
harmonic fit times:
[1730922, 69570, 77586, 144911, 97463]
harmonic fit waste total:
[6, 0]
-----------------------------
move to front bins:
[6, 6, 6, 6, 6]
move to front times:
[1230465, 30457, 34946, 55464, 41037]
move to front waste total:
[14, 0]

```

Take Move to Front's output as an example.  I run the normal benchmark 5 times.  

[6, 6, 6, 6, 6] means the algorithm uses 6 bins in every test.

[1230465, 30457, 34946, 55464, 41037] is processing time for each test in nanoseconds.

[14, 0] means for all tests, there are 14 bins that has usable space less than 10% of original bin size, I call it "small waste bin".  And no bins that has useable space more than 90% of original bin size, I call it "big waste bin".  For example, if the bin size is 100, a bin with usable space that less than 10 is a small waste bin.  If the bin size is 50, a bin with usable space that more than 45, it's a big waste bin.



## Authors

- Zhuoqun Li 



## Acknowledgments

- Thanks for Dr. Shahin Kamali's advice and encouragement.
- Thanks Billie Thompson for providing the readme template.
