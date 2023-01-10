/*
 * Chips-n-Salsa: A library of parallel self-adaptive local search algorithms.
 * Copyright (C) 2002-2023 Vincent A. Cicirello
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

package org.cicirello.search.evo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/** JUnit test cases for ExponentialCoolingBiasFunction. */
public class ExponentialCoolingBiasFunctionTests {

  @Test
  public void testExponentialCoolingSchedule() {
    ExponentialCoolingBiasFunction bias = new ExponentialCoolingBiasFunction(1.0, 0.5, 0.1);
    double mult = 1.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    ExponentialCoolingBiasFunction biasSplit = bias.split();
    bias.update();
    mult = 10;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }

    // Use split copy
    mult = 1.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), biasSplit.bias(f));
    }
    biasSplit.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), biasSplit.bias(f));
    }
    biasSplit.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), biasSplit.bias(f));
    }
    biasSplit.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), biasSplit.bias(f));
    }
    biasSplit.update();
    mult = 10;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), biasSplit.bias(f));
    }
    biasSplit.update();
    mult = 10;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), biasSplit.bias(f));
    }

    // reinitialize and use original
    bias.init();
    mult = 1.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    mult *= 2.0;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    mult = 10;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
    bias.update();
    mult = 10;
    for (double f = 0.0; f <= 5.1; f += 1.0) {
      assertEquals(Math.exp(mult * f), bias.bias(f));
    }
  }
}
