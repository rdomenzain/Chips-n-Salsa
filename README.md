# Chips-n-Salsa - A Java library of customizable, hybridizable, iterative, parallel, stochastic, and self-adaptive local search algorithms

Copyright (C) 2002-2020 Vincent A. Cicirello.

https://www.cicirello.org/

Webpage: https://chips-n-salsa.cicirello.org/

![Java CI](https://github.com/cicirello/Chips-n-Salsa/workflows/Java%20CI/badge.svg)

## Overview

Chips-n-Salsa is a Java library of customizable, hybridizable, iterative, parallel, stochastic, and self-adaptive local search algorithms. The library includes implementations of several stochastic local search algorithms, including simulated annealing, hill climbers, as well as constructive search algorithms such as stochastic sampling. The library most extensively supports simulated annealing. It includes several classes for representing solutions to a variety of optimization problems. For example, the library includes a BitVector class that implements vectors of bits, as well as classes for representing solutions to problems where we are searching for an optimal vector of integers or reals. For each of the built-in representations, the library provides the most common mutation operators for generating random neighbors of candidate solutions. Additionally, the library provides extensive support for permutation optimization problems, including implementations of many different mutation operators for permutations, and utilizing the efficiently implemented Permutation class of the [JavaPermutationTools (JPT)](https://jpt.cicirello.org/) library.

Chips-n-Salsa is customizable, making extensive use of Java's generic types, enabling using the library to optimize other types of representations beyond what is provided in the library. It is hybridizable, providing support for integrating multiple forms of local search (e.g., using a hill climber on a solution generated by simulated annealing), creating hybrid mutation operators (e.g., local search using multiple mutation operators), as well as support for running more than one type of search for the same problem concurrently using multiple threads as a form of algorithm portfolio. Chips-n-Salsa is iterative, with support for multistart metaheuristics, including implementations of several restart schedules for varying the run lengths across the restarts. It also supports parallel execution of multiple instances of the same, or different, stochastic local search algorithms for an instance of a problem to accelerate the search process. The library supports self-adaptive search in a variety of ways, such as including implementations of adaptive annealing schedules for simulated annealing, such as the Modified Lam schedule, implementations of the simpler annealing schedules but which self-tune the initial temperature and other parameters, and restart schedules that adapt to run length.

## Repository Organization

The GitHub repository is organized as follows:
* The /build directory contains an ant build file, and other resources related to building the library.
* The /dist directory contains the compiled jar files of the library, one consisting of just the Chips-n-Salsa library, and a second jar file that contains Chips-n-Salsa as well as all dependencies.  The file name makes it clear which is which.
* The /docs directory contains the javadoc documentation in a sub-directory /docs/api. The /docs directory is also the location of the website for the project hosted via GitHub pages at https://chips-n-salsa.cicirello.org/.
* The /examples directory contains several example programs that use the library, and which demonstrate usage of various features.
* The /lib directory contains jar files of all dependencies.  At the present time, the only dependency is a library [JavaPermutationTools (JPT)](https://jpt.cicirello.org/) which is used for its representation of a Permutation, as well as for some of its random number generation capabilities.
* The /src directory contains all of the source code for Chips-n-Salsa.
* The /tests directory contains JUnit test cases for all functionality of the library.

## Java 8

The library supports Java 8 or higher, including both Oracle JDK 8 and OpenJDK 8.

## Building the Library and Running Examples (Quickstart)

The root of the repository contains a makefile that can be used to: (a) execute the build process, and (b) run 
all of the example programs back-to-back. The build process uses an ant build file, so the build will fail if 
you don't have ant installed on your system.  Assuming that you have ant, you can build the library and examples 
by executing either `make` or `make build` from the root of the repository.  Once the build is complete, you 
can run all of the examples back-to-back with: `make examples`.  To run a specific example program, see the contents 
of the makefile, or see the README in the /examples folder.  The following sections contain more detail on
building the library and running the examples.

## Building the Library (with ant)

The /build directory contains an ant build file.  The build file also executes the JUnit tests, and the build 
directory contains the relevant jar files for the JUnit libraries. If you prefer, you can replace these 
with the latest versions available from https://junit.org/junit4/ (just be sure to edit the property 
fields in the build.xml to point to the locations of the JUnit jar files).

To execute the build process do one of the following. If your working directory is the build directory, 
then simply execute `ant` from the command line. If your working directory is the parent of build, 
then execute: `ant -f build/build.xml`

The default of the provided ant build file, compiles all source files and all JUnit tests, executes all 
test cases, generates two jar files of the library (one that includes all dependencies, and one that 
does not), and compiles all example programs. The build process will terminate on any test case failures.  

The build generates the following directories: bin (for the compiled Java classes), testbin (for the 
compiled JUnit tests), and exbin (for the compiled example programs).

## Running the Example Programs

The examples directory contains example usage of several of the classes of the library. The examples directory 
contains a README file that provides more details on the examples. Each of the examples contains detailed 
comments within the source code explaining the example. Running the examples without reading the 
source comments is not advised.  Assuming the build was successful, the compiled example programs 
will be in the exbin directory.  See /examples/README.md for details on running the examples individually.

## License

The Chips-n-Salsa library is licensed under the [GNU General Public License 3.0](https://www.gnu.org/licenses/gpl-3.0.en.html).

## Contribute

Report bugs, suggestions, feature requests, etc via the [issues tracker](https://github.com/cicirello/Chips-n-Salsa/issues). If you would like to directly contribute new code, you may also fork the repository, and create pull requests.  All code contributions must include JUnit tests, and all existing JUnit tests must pass for your code contribution to be accepted.  If your code contribution is a bug-fix, then you must include JUnit tests that recreate the bug prior to your fix, and which pass afterwards.
