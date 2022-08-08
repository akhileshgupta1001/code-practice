package com.dsa.geeksforgeek.heap;

public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    MinHeap(int capacity){
        arr = new int[capacity];
        size=0;
        this.capacity=capacity;
    }

    public int left(int index){
        return 2* index+1;
    }
    public int right(int index){
        return 2* index+2;
    }
    public int parent(int index){
        return (index-1)/2;
    }
}
