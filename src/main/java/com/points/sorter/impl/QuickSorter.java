package com.points.sorter.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.points.sorter.Sorter;

public class QuickSorter<T extends Comparable<T>> implements Sorter {

    private List<T> list;

    private static final Logger LOG = LoggerFactory.getLogger(QuickSorter.class);

    public QuickSorter(List<T> list) {
        this.list = list;
    }
    
    public List<T> getList() {
        return list;
    }

    @Override
    public void sort() {
        if (list == null) {
            LOG.error("Cannot sort null list");
            return;
        }

        if (list.size() == 0) {
            LOG.error("Cannot sort empty list");
            return;
        }

        quickSort(0, list.size() - 1);
    }

    private void quickSort(int lowIndex, int highIndex) {
        if (lowIndex < 0 || highIndex < 0 || lowIndex > list.size() -1 || highIndex > list.size() - 1) {
            return;
        }
        
        if (!(lowIndex < highIndex) ) {
            return;
        }
        
        int pivot = partitionList(lowIndex, highIndex);

        quickSort(lowIndex, pivot - 1);
        quickSort(pivot + 1, highIndex);
    }

    private int partitionList(int lowIndex, int highIndex) {
        T pivot = list.get(highIndex);
        int lowestIndex = lowIndex;

        for (int elementIndex = lowIndex; elementIndex < highIndex; elementIndex++) {
            if (list.get(elementIndex).compareTo(pivot) < 0) {
                swap(lowestIndex, elementIndex);
                lowestIndex++;
            }
        }

        swap(lowestIndex, highIndex);
        return lowestIndex;
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

}
