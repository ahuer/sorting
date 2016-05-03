package com.points.sorter.impl

import static org.junit.Assert.*
import org.junit.Test;

class MergeSorterTest {
    
    @Test
    public void testMergeSortOneElement() {
        def list = [1]
        def sorter = new MergeSorter(list)
        sorter.sort()
        assertEquals([1], sorter.getList())
    }

    @Test
    public void testMergeSortSmall() {
        def list = [2, 1]
        def sorter = new MergeSorter(list)
        sorter.sort()
        assertEquals([1, 2], sorter.getList())
    }
    
    @Test
    public void testMergeSortMed() {
        def list = [3, 2, 1, 5, 4]
        def sorter = new MergeSorter(list)
        sorter.sort()
        assertEquals([1, 2, 3, 4, 5], sorter.getList())
    }
    
    @Test
    public void testMergeSortLarge() {
        def list = [2, 7, 5, 8, 6, 9, 3, 1, 4]
        def sorter = new MergeSorter(list)
        sorter.sort()
        assertEquals([1, 2, 3, 4, 5, 6, 7, 8, 9], sorter.getList())
    }
    
    @Test
    public void testMergeSortEmptyList() {
        def list = []
        def sorter = new MergeSorter(list)
        sorter.sort()
        assertEquals([], sorter.getList())
    }
    
    @Test
    public void testMergeSortNullList() {
        def list = null
        def sorter = new MergeSorter(list)
        sorter.sort()
        assertEquals(null, sorter.getList())
    }

}
