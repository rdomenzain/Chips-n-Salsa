/*
 * Chips-n-Salsa: A library of parallel self-adaptive local search algorithms.
 * Copyright (C) 2002-2022 Vincent A. Cicirello
 *
 * This file is part of Chips-n-Salsa (https://chips-n-salsa.cicirello.org/).
 * 
 * Chips-n-Salsa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Chips-n-Salsa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * <h2>Chips-n-Salsa - A Java library of customizable, hybridizable, iterative, parallel, 
 * stochastic, and self-adaptive local search algorithms</h2>
 *
 * <p>Copyright &copy; 2002-2022 <a href="https://www.cicirello.org/" target=_top>Vincent A. Cicirello</a>.</p>
 *
 * <p><a href="https://doi.org/10.21105/joss.02448"><img 
 * src="https://joss.theoj.org/papers/10.21105/joss.02448/status.svg" 
 * alt="DOI:10.21105/joss.02448" height="20" width="168"></a>
 * <a href="https://search.maven.org/artifact/org.cicirello/chips-n-salsa"><img 
 * src="https://img.shields.io/maven-central/v/org.cicirello/chips-n-salsa.svg?logo=apachemaven" 
 * alt="Maven Central" height="20" width="153"></a>
 * <a href="https://github.com/cicirello/Chips-n-Salsa/releases"><img 
 * src="https://img.shields.io/github/v/release/cicirello/Chips-n-Salsa?logo=GitHub" 
 * alt="GitHub release (latest by date)" height="20" width="111"></a>
 * <a href="https://github.com/cicirello/Chips-n-Salsa"><img 
 * src="https://chips-n-salsa.cicirello.org/images/GitHub.svg" 
 * alt="GitHub Repository" width="68" height="20"></a>
 * <a href="https://github.com/cicirello/Chips-n-Salsa/blob/master/LICENSE"><img 
 * src="https://img.shields.io/github/license/cicirello/Chips-n-Salsa" 
 * alt="GNU General Public License Version 3 (GPLv3)" height="20" width="102"></a>
 * </p>
 *
 * <h3>About the Chips-n-Salsa Library</h3>
 *
 * <p>Chips-n-Salsa is a Java library of Customizable, Hybridizable, 
 * Iterative, Parallel, Stochastic, and Self-Adaptive Local Search Algorithms.
 * The Chips-n-Salsa library includes implementations of several stochastic
 * local search algorithms, including simulated annealing, hill climbers,
 * as well as constructive search algorithms such as stochastic sampling.
 * Chips-n-Salsa now also includes genetic algorithms as well as evolutionary
 * algorithms more generally. The library very extensively supports simulated annealing.
 * The library includes several built-in representations for representing
 * solutions to a variety of optimization problems.  For example, the library
 * includes a BitVector class that implements vectors of bits, as well as classes
 * for representing solutions to problems where we are searching for an optimal
 * vector of integers or reals.  For each of the built-in representations, the
 * library provides the most common mutation operators for generating random
 * neighbors of candidate solutions, as well as crossover operators for use with
 * evolutionary algorithms. Additionally, the library provides
 * extensive support for permutation optimization problems, including implementations
 * of a very large variety of mutation operators for permutations, and utilizing the efficiently
 * implemented Permutation class of 
 * the <a href="https://jpt.cicirello.org/">JavaPermutationTools (JPT)</a> library.</p>
 * 
 * <p>Chips-n-Salsa is customizable in that it makes extensive use of generic types,
 * enabling using the library to optimize other types of representations beyond what
 * is provided in the library.  It is hybridizable, providing support for integrating
 * multiple forms of local search (e.g., using a hill climber on a solution generated by
 * simulated annealing), creating hybrid mutation operators (e.g., local search using 
 * multiple mutation operators), and classes that support running more than one type
 * of search for the same problem concurrently using multiple threads as a form of
 * algorithm portfolio. Chips-n-Salsa is iterative, with support for multistart 
 * metaheuristics, including implementations of several restart schedules for
 * varying the run lengths across the restarts.  It also supports parallel execution
 * of multiple instances of the same, or different, stochastic local search algorithms
 * for an instance of a problem to accelerate the search process.  The library supports
 * self-adaptive search in a variety of ways, such as including implementations of
 * adaptive annealing schedules for simulated annealing, such as the Modified Lam schedule,
 * implementations of the simpler annealing schedules but which self-tune the initial temperature
 * and other parameters, and restart schedules that adapt run length.</p>
 * 
 * <p>The <a href="https://github.com/cicirello/Chips-n-Salsa" target=_top>source code repository</a> 
 * is hosted on GitHub, and includes the source code and example programs that use the library.
 * The source code is licensed under the 
 * <a href="https://www.gnu.org/licenses/gpl-3.0.html" target=_top>GNU General Public License Version 3 (GPLv3)</a>.  For more information see the <a href="https://chips-n-salsa.cicirello.org/" target=_top>Chips-n-Salsa 
 * website</a>.</p>
 *
 * <h3>How to Cite</h3>
 *
 * <p>If you use the Chips-n-Salsa library in your research, please cite the following 
 * article which describes the library:</p>
 * <ul>
 * <li>Vincent A. Cicirello. 
 * <a href="https://www.cicirello.org/publications/cicirello2020joss.html">Chips-n-Salsa: A Java Library of Customizable, Hybridizable, Iterative, Parallel, Stochastic, and Self-Adaptive Local Search Algorithms</a>.
 * <i>Journal of Open Source Software</i>, 5(52), 2448, August 2020.
 * <a href="https://www.cicirello.org/publications/cicirello2020joss.pdf">[PDF]</a> <a href="https://www.cicirello.org/publications/cicirello2020joss.bib">[BIB]</a> <a href="https://doi.org/10.21105/joss.02448">[DOI]</a></li>
 * </ul>
 *
 * <h3>Support Chips-n-Salsa</h3>
 *
 * <p><a href="https://github.com/sponsors/cicirello"><img src="https://chips-n-salsa.cicirello.org/images/github-sponsors.svg" alt="GitHub Sponsors" width="107" height="28"></a>
 * <a href="https://liberapay.com/cicirello"><img src="https://chips-n-salsa.cicirello.org/images/Liberapay.svg" alt="Liberapay" width="119" height="28"></a>
 * <a href="https://ko-fi.com/cicirello"><img src="https://chips-n-salsa.cicirello.org/images/ko-fi.svg" alt="Ko-Fi" width="82" height="28"></a></p>
 *
 * @author <a href=https://www.cicirello.org/ target=_top>Vincent A. Cicirello</a>, 
 * <a href=https://www.cicirello.org/ target=_top>https://www.cicirello.org/</a>
 */
module org.cicirello.chips_n_salsa {
	exports org.cicirello.search;
	exports org.cicirello.search.concurrent;
	exports org.cicirello.search.evo;
	exports org.cicirello.search.hc;
	exports org.cicirello.search.operators;
	exports org.cicirello.search.operators.bits;
	exports org.cicirello.search.operators.integers;
	exports org.cicirello.search.operators.permutations;
	exports org.cicirello.search.operators.reals;
	exports org.cicirello.search.problems;
	exports org.cicirello.search.problems.binpack;
	exports org.cicirello.search.problems.scheduling;
	exports org.cicirello.search.problems.tsp;
	exports org.cicirello.search.representations;
	exports org.cicirello.search.restarts;
	exports org.cicirello.search.sa;
	exports org.cicirello.search.ss;
	
	// This needs to be transitive since 
	// searches over space of Permutations may
	// return Permutation objects, defined in this
	// module.
	requires transitive org.cicirello.jpt;
	requires org.cicirello.rho_mu;
	requires org.cicirello.core;
}
