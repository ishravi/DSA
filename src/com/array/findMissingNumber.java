package com.array;

import java.util.HashSet;

public class findMissingNumber {

//O(n^2) O(1)
    public static int missingNumBruteForce(int[] input){

        int n = input.length;

        for(int i=1;i<=n+1;i++){
            boolean flag = false;
            for(int num:input){
                if(num == i) flag = true;
            }
            if(!flag) return i;
        }
        return 0;
    }
//O(n) O(n)
    public static int missingNumBetter(int[] input){
        HashSet<Integer> set = new HashSet();
        int n = input.length;
        for(int i=1;i<=n+1;i++){
            set.add(i);
        }

        for(int num:input){
            if(set.contains(num)){
                set.remove(num);
            }
        }

        return set.iterator().next();
    }

    //O(n) O(1)
    public static int missingNumBest(int[] input){
        int n = input.length+1;
        int totalSum = (n*(n+1) ) /2;
        int sum =0;

        for(int num :input){
            sum +=num;
        }


        return totalSum-sum;
    }

    //O(n) O(1)
    public static int missingNumBest2(int[] input){
        int n = input.length;
        int totalXor = 1;
        int currentXor = input[0];

        for(int i=2;i<=n+1;i++){
            totalXor  ^= i;
        }

        for(int i=1;i<input.length;i++){
            currentXor  ^= input[i];
        }

        return totalXor ^ currentXor;
    }

    public  static void main(String[] args){
        int[] input = new int[]{1, 2, 4, 6, 3, 7, 8};
      //  System.out.println(missingNumBruteForce(input));
        //System.out.println(missingNumBetter(input));
      //  System.out.println(missingNumBest(input));
        System.out.println(missingNumBest2(input));
    }
}
