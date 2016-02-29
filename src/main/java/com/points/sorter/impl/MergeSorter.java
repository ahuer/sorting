package com.points.sorter.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.points.sorter.Sorter;

public class MergeSorter<T extends Comparable<T>> implements Sorter {
    
    private List<T> list;
    
    private static final Logger LOG = LoggerFactory.getLogger(MergeSorter.class);
    
    public MergeSorter(List<T> list) {
        this.list = list;
    }
    
    public List<T> getList() {
        return list;
    }

    @Override
    public void sort() {
        // TODO Auto-generated method stub
        
    }
    
    private ArrayList<String> tempList;
    private int length;
    
    public void sort(ArrayList<String> unsortedList) {
        if (unsortedList == null || unsortedList.isEmpty()) {
            return;
        }
        
        list = unsortedList;
        length = list.size();
        tempList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            tempList.add("");
        }
        
        mergeSorting(0, length - 1);
    }
    
    private void mergeSorting(int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        
        int middle = lowIndex + (highIndex - lowIndex) / 2;
        
        mergeSorting(lowIndex, middle);
        mergeSorting(middle + 1, highIndex);
        
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
            if (tempList.get(lowPointer).compareToIgnoreCase(tempList.get(midPointer)) <= 0) {
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
