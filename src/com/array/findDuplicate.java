package com.array;

import java.util.Arrays;

public class findDuplicate {

    public static void main(String[] args){
        int[] input = new int[]{4,3,2,1,2};
     //   System.out.println(getDuplicateBruteForce(input));
     //   System.out.println(getDuplicateBetter(input));

        System.out.println(getDuplicateBest(input));
    }


//O(nlogn)  O(1)
    private static int getDuplicateBruteForce(int[] input) {
        Arrays.sort(input);
        for(int i=1;i<input.length;i++){
            if(input[i-1] == input[i]){
                return input[i];
            }
        }
        return -1;
    }
    //O(2n)  O(1)
    private static int getDuplicateBetter(int[] input) {
        for(int i=0;i<input.length;i++){
            if(input[i] != i+1){
                swap(input,input[i]-1,i);
            }
        }

        for(int i=0;i<input.length;i++){
            if(input[i] != i+1){
                return input[i];
            }
        }

        return -1;
    }

    private static void swap(int[] input, int first, int sec) {
        int temp = input[first];
        input[first]=input[sec];
        input[sec]=temp;
    }

    //O(n)  O(1)  --> single pass
    private static int getDuplicateBest(int[] input) {
        int slow = input[0];
        int fast =input[input[0]];
        while(slow != fast){
            slow = input[slow];
            fast = input[input[fast]];
        }
        return input[slow];
    }
}
