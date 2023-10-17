import java.lang.Math;

/*
 * Question 2 of COSC 3P95 Assignment 1.
 * @Course: COSC 3P95 Software Analysis and Testing
 * @Author: Luke Reinaerts
 * @Date: 10/13/2023
 * 
 * This program generates random test cases with given parameters by the user. 
 * Its purpose is to find bugs in the code of the bubblesort algorithm.
 */
public class Question2 {

    public Question2(){
        int[] randomTestCase = generateRandomTestCase(15, 100); //This is an integer array created randomly with given range and maxvalues.
        bubbleSort(randomTestCase); //bubblesort the randomTestCase
    }

    /*
     * This integer array creates a random test cases of random length filled with random integers by the given max value.
     * @param range: the max value that the length of the array can be.
     * @param maxValue: the max value that each integer in the array can be.
     */
    public static int[] generateRandomTestCase(int range, int maxValue){ //Give a range for the random selection of length for each array, and the max value of an int in this array.
        int length = (int)(range*Math.random())+1; //For the length of the array.
        
        int randarr[] = new int[length]; //The random array of length length

        for(int i=0; i<length; i++){ //This for loop populates the array with random integers of maxValue.
            int rand = (int)(maxValue*Math.random())+1;
            randarr[i] = rand;
        }
        return randarr;
    }
    
    /*
     * This method sorts the given integer array in ascending order using a bubblesort technique.
     * @param arr[]: This integer array is given by the user. Can be any length.
     */
    private void bubbleSort(int arr[]){
        
        int temp = 0;

        System.out.print("Unsorted Array:\t"); //Print out the unsorted array.
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        for(int i=0; i<=arr.length; i++){ //This for loop runs through every integer in the array and checks if the one before it is greater than itself.
            for(int j=1; j<(arr.length-i); j++){

                if(arr[j-1] > arr[j]){ //If the integer before it is greater than itself, swap the integers.
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("Sorted Array:\t"); //Print out the sorted array.
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
    }
    public static void main(String[] args)  {new Question2();}
}
