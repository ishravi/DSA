package com.array;

public class findMissingAndDuplicate {
  static   int missingNum;
    static  int duplicateNum;

    public static void solution(int[] input){
        int xor = input[0];
        int n = input.length;
        for(int num:input){
            xor ^= num;
        }

        for(int i=1;i<=n;i++){
            xor ^=i;
        }

        int setBit = xor & ~(xor-1);

       for(int num:input){
           if((num & setBit) != 0){
               missingNum^=num;
           }else{
               duplicateNum^=num;
           }
       }

       for(int i=1;i<=n;i++){
           if((i & setBit) != 0){
               missingNum^=i;
           }else{
               duplicateNum^=i;
           }
       }


    }


    public static void main(String[] args){
        int[] input = new int[]{4,3,2,1,2};
        solution(input);
        System.out.println(" The missing element is  "
                + missingNum + "and the "
                + "repeating number is "
                + duplicateNum);
    }
}
