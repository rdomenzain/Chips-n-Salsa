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
 
package org.cicirello.search.problems.binpack;

/**
 * This class is used by the {@link BinPackingSolution} class to represent the
 * contents of a bin in a solution to a {@link BinPacking} problem instance.
 * Although you cannot construct instances of it directly (it doesn't have a public
 * constructor), you can use the methods of this class
 * to inspect the contents (i.e., which items) of the Bin.
 *
 * @author <a href=https://www.cicirello.org/ target=_top>Vincent A. Cicirello</a>, 
 * <a href=https://www.cicirello.org/ target=_top>https://www.cicirello.org/</a>
 */
public final class Bin {
	
	private int space;
	private int[] items;
	private int size;
	
	/*
	 * package-private to keep initialization within the package 
	 */
	Bin(int space, int initialLength) {
		this.space = space;
		items = new int[initialLength];
	}
	
	/*
	 * package-private: so only classes in same package can add to a bin
	 */
	final void addItem(int itemId, int itemSize) {
		if (itemSize <= space) {
			space -= itemSize;
			if (size >= items.length) {
				int[] temp = new int[items.length << 1];
				System.arraycopy(items, 0, temp, 0, size);
			}
			items[size] = itemId;
			size++;
		} else {
			throw new IllegalArgumentException("insufficient space remaining in bin");
		}
	}
	
	/**
	 * Gets the amount of space remaining in the bin.
	 * @return the amount of remaining space
	 */
	public final int space() {
		return space;
	}
	
	/**
	 * Gets the number of items in the Bin.
	 * @return the number of items in the Bin
	 */
	public final int size() {
		return size;
	}
	
	/**
	 * Gets the id of an item in this bin.
	 * @param i an index into the bin
	 * @return the id of the item at index i.
	 */
	public final int getItem(int i) {
		return items[i];
	}
}
