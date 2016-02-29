package com.points.sorter.impl

import static org.junit.Assert.*
import org.junit.Test

class QuickSorterTest {
    
    @Test
    public void testQuickSortOneElement() {
        def list = [1]
        def sorter = new QuickSorter(list)
        sorter.sort()
        assertEquals([1], sorter.getList())
    }

    @Test
    public void testQuickSortSmall() {
        def list = [2, 1]
        def sorter = new QuickSorter(list)
        sorter.sort()
        assertEquals([1, 2], sorter.getList())
    }
    
    @Test
    public void testQuickSortMed() {
        def list = [3, 2, 1, 5, 4]
        def sorter = new QuickSorter(list)
        sorter.sort()
        assertEquals([1, 2, 3, 4, 5], sorter.getList())
    }
    
    @Test
    public void testQuickSortLarge() {
        def list = [2, 7, 5, 8, 6, 9, 3, 1, 4]
        def sorter = new QuickSorter(list)
        sorter.sort()
        assertEquals([1, 2, 3, 4, 5, 6, 7, 8, 9], sorter.getList())
    }
    
    @Test
    public void testQuickSortEmptyList() {
        def list = []
        def sorter = new QuickSorter(list)
        sorter.sort()
        assertEquals([], sorter.getList())
    }
    
    @Test
    public void testQuickSortNullList() {
        def list = null
        def sorter = new QuickSorter(list)
        sorter.sort()
        assertEquals(null, sorter.getList())
    }
}
