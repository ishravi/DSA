package com.array;

public class MergeArray {

    public static void merge(int[] A,int[] B){
        int first = 0;


        int m=A.length,n=B.length;

        while(first < m ){
            if(A[first] > B[0]) {
                swap(A, B, first);
                int cache = B[0];
                int k=1;
                for(;k<B.length && B[k] < cache ;k++){
                    B[k-1]=B[k];
                }
                B[k-1]=cache;
            }

           first++;

        }
    }

    private static void insertSort(int[] b) {
        for(int i=1;i<b.length;i++){
            int cache = b[i];
            int j=i-1;

            while(j>=0 && b[j] > b[i]){
                b[j+1]=b[j];
                j--;
            }
            b[j+1]=cache;
        }
    }

    private static void swap(int[] a, int[] b, int first) {
        int temp =a[first];
        a[first]=b[0];
        b[0]=temp;
    }

    public static void main(String[] args){
        int[] A = new int[]{1, 5, 9, 10, 15, 20};
        int[] B = new int[]{2, 3, 8, 13};

        merge(A,B);
     //   mergeArray(A,B);
        System.out.println("After the merge");

        for(int num: A){
            System.out.print(num+" ");
        }
        System.out.println();

        for(int num:B){
            System.out.print(num+" ");
        }
    }

    public static void mergeArray(int[] arr1, int[] arr2)
    {

        // length of first arr1
        int n = arr1.length;

        // length of second arr2
        int m = arr2.length;

        // Now traverse the array1 and if
        // arr2 first element
        // is less than arr1 then swap
        for (int i = 0; i < n; i++) {

            if (arr1[i] > arr2[0]) {

                // swap
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                // after swapping we have to sort the array2
                // again so that it can be again swap with
                // arr1

                // we will store the firstElement of array2
                // and left shift all the element and store
                // the firstElement in arr2[k-1]

                int firstElement = arr2[0];

                int k;
                for (k = 1; k < m && arr2[k] < firstElement; k++)
                {
                    arr2[k - 1] = arr2[k];
                }
                arr2[k - 1] = firstElement;
            }
        }


    }
}
