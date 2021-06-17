package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Maze {
    static int maxIndegree(int[] array) {
        //solution here
        int maxWeight =Integer.MIN_VALUE;
        int maxIndegreeNode = -1;
        int[] weight = new int[array.length+1];

       // System.out.println("given array ");
        for(int index=0;index<array.length;index++){
            //System.out.print(num+" ");
            if(array[index] != -1){
                weight[array[index]] +=index;
                if(weight[array[index]] > maxWeight){
                    maxWeight =weight[array[index]];
                    maxIndegreeNode = array[index];
                }

            }
        }
       // System.out.println();
        return maxIndegreeNode;
    }

    static int maxCycleSum(int[] arr) {
        ArrayList<Integer> sum = new ArrayList<>();
        for(int i = 0; i < arr.length; i ++)
        {
            ArrayList<Integer> path = new ArrayList<>();
            int j = i;
            int tempSum = 0;
            while(arr[j]<arr.length && arr[j]!=i && arr[j]!=-1 && !path.contains(j))
            {
                path.add(j);
                tempSum+=j;
                j=arr[j];
                if(arr[j]==i)
                {
                    tempSum+=j;
                    break;
                }
            }
            if(j<arr.length && i == arr[j])
                sum.add(tempSum);
        }
        if(sum.isEmpty())
            return -1;
        return Collections.max(sum);
    }

    static int maxCycleLen(int[] arr) {
  //      ArrayList<Integer> Len = new ArrayList<>();
        int maxLen = -1;
        for(int i = 0; i < arr.length; i ++)
        {
            ArrayList<Integer> path = new ArrayList<>();
            int j = i;
            int tempLen = 0;
            while(arr[j]<arr.length && arr[j]!=i && arr[j]!=-1 && !path.contains(j))
            {
                path.add(j);
                j=arr[j];
                tempLen++;

            }
            if(j<arr.length && i == arr[j]){
                tempLen++;
                maxLen = Math.max(maxLen,tempLen);
            }

        }

        return maxLen;
    }



    static int findMeet(int[] arr,int N,int a,int b){
        int[] visited = new int [N];
        visited[a] = 1;
        if (visited[b] == 1)
            return a;
        visited[b] = 1;
       int t = arr[a];
        while (t != -1 && visited[t] == 0){
            visited[t] = 1;
            t = arr[t];
        }

        t = arr[b];

        while (t != -1 && visited[t] == 0){
            visited[t] = 1;
            t = arr[t];
        }


        if( t == -1){
            return -1;
        }

        return t;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int loop=0; loop<testCases; loop++) {
            int numOfBlocks = scanner.nextInt();
            int array[] = new int[numOfBlocks];
            int src, des;
            for (int i=0; i<numOfBlocks; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println("max InDegree Node "+maxIndegree(array));
            System.out.println("max Cycle Sum "+maxCycleSum(array));
            System.out.println("max Cycle Length "+maxCycleLen(array));
           // System.out.println("nearest meeting point "+leastCommonDescendent(array,numOfBlocks,9,2));
            System.out.println("nearest find meet point "+findMeet(array,numOfBlocks,7,9));
        }
        scanner.close();
    }
}
