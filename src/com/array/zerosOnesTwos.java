package com.array;

public class zerosOnesTwos {
// O(2n) O(1)
    public static int[] flagSortBruteForce(int[] input){
        int count0=0,count1=0,count2=0;
        for(int num:input){
            if(num == 0){
                count0++;
            }else if(num == 1){
                count1++;
            }else{
                count2++;
            }
        }

        int index =0;

            while(index < input.length && count0 > 0 ){
                input[index++]=0;
                count0--;
            }

            while(index < input.length && count1 >0){
                input[index++]=1;
                count1--;
            }

            while(index < input.length && count2 >0){
                input[index++]=2;
                count2--;
            }


        return input;
    }
    // O(n) O(1)
    public static int[] flagSortBest(int[] input) {
        int zeroPointer =0;
        int twoPointer=input.length-1;
        int currentPointer = 0;

        while(currentPointer <= twoPointer){
            if(input[currentPointer] == 0){
                swap(input,currentPointer,zeroPointer);
                currentPointer++;
                zeroPointer++;
            }else if(input[currentPointer] == 2){
                swap(input,currentPointer,twoPointer);
                twoPointer--;
            }else{
                currentPointer++;
            }

        }

        return input;
    }

    private static void swap(int[] input, int currentPointer, int secPointer) {
        int temp = input[currentPointer];
        input[currentPointer]=input[secPointer];
        input[secPointer]=temp;
    }

    public static void main(String[] args){
        int[] input = new int[]{0,1,1,0,1,2,1,0,0,0,1};
       // input = flagSortBruteForce(input);
        input = flagSortBest(input);
        for(int num:input){
            System.out.print(num+" ");
        }
    }
}
