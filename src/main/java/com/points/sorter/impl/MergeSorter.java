package com.points.sorter.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.points.sorter.Sorter;

public class MergeSorter<T extends Comparable<T>> implements Sorter {

    private List<T> list;
    private List<T> tempList;

    private static final Logger LOG = LoggerFactory.getLogger(MergeSorter.class);

    public MergeSorter(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public void sort() {
        if (list == null || list.isEmpty()) {
            LOG.error("Cannot sort null or empty list");
            return;
        }

        initTempList();
        mergeSort(0, list.size() - 1);
    }

    private void initTempList() {
        tempList = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
            tempList.add(null);
        }
    }

    private void mergeSort(int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int middle = lowIndex + (highIndex - lowIndex) / 2;

        mergeSort(lowIndex, middle);
        mergeSort(middle + 1, highIndex);

        combineLists(lowIndex, middle, highIndex);
    }

    private void combineLists(int lowIndex, int middleIndex, int highIndex) {
        for (int i = lowIndex; i <= highIndex; i++) {
            tempList.set(i, list.get(i));
        }

        int lowPointer = lowIndex;
        int midPointer = middleIndex + 1;
        int listPointer = lowIndex;

        while (lowPointer <= middleIndex && midPointer <= highIndex) {
            if (tempList.get(lowPointer).compareTo(tempList.get(midPointer)) <= 0) {
                list.set(listPointer, tempList.get(lowPointer));
                lowPointer++;
            } else {
                list.set(listPointer, tempList.get(midPointer));
                midPointer++;
            }
            listPointer++;
        }

        while (lowPointer <= middleIndex) {
            list.set(listPointer, tempList.get(lowPointer));
            lowPointer++;
            listPointer++;
        }
    }

}
