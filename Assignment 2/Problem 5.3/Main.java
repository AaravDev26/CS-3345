/*
Aarav Dev
Assignment 2
Problem 5.3
*/

import java.io.*;
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;  // Import the Scanner class
import java.util.List;  // Import the List class

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        // Read input file
        String inputFile = "input.txt";
        File input = new File(inputFile);
        Scanner s = new Scanner(input);
        List<Integer> values = new ArrayList<>(); // holds all values to be inserted into hash table
        while (s.hasNext()) // scanning through input
        {
            Integer value = Integer.parseInt(s.nextLine());
            values.add(value);
        }

        // size is prime number larger than 2 * size of input to prevent infinite collisions in quadratic probing
        int tableSize = nextPrime(values.size() * 2);
        int[] linearTable = new int[tableSize]; // hash table for linear probing

        int linearCollisions = 0; // count of collisions during linear probing
        for (int key : values) // looping through all values
        {
            int index = key % tableSize;
            while (linearTable[index] != 0) // if value already present
            {
                linearCollisions++;
                index = (index + 1) % tableSize;
            }
            linearTable[index] = key;
        }

        int[] quadraticTable = new int[tableSize]; // hash table for quadratic probing
        int quadraticCollisions = 0; // count of collisions during quadratic probing
        for (int key : values)
        {
            int index = key % tableSize;
            int i = 1;
            while (quadraticTable[index] != 0)
            {
                quadraticCollisions++;
                index = (index + (i * i)) % tableSize;
                i++;
            }
            quadraticTable[index] = key;
        }
        
        int[] doubleTable = new int[tableSize]; // hash table for double hashing
        int doubleCollisions = 0; // count of collisions during double hashing
        int r = previousPrime(tableSize); // used for second hash function
        for (int key : values)
        {
            int index = key % tableSize;
            int i = 1;
            int hash2 = r - (key % r); // second hash function
            while (doubleTable[index] != 0)
            {
                doubleCollisions++;
                index = (index + (i * hash2)) % tableSize;
                i++;
            }
            doubleTable[index] = key;
        }
        
        // Print results
        System.out.println("Linear probing collisions: " + linearCollisions);
        System.out.println("Quadratic probing collisions: " + quadraticCollisions);
        System.out.println("Double hashing collisions: " + doubleCollisions);
    }
    
    // finds the next largest prime number greater than the one in the parameter
    public static int nextPrime(int n)
    {
        int ans = n;
        boolean found = false;
    
        // loop continuously until isPrime returns true for a number above n
        while (!found)
        {
            ans++;
            if (isPrime(ans))
            {
                found = true;
            }
        }
        return ans;
    }
    
    // finds the largest prime number which is less than the number in the parameter
    public static int previousPrime(int n)
    {
        int ans = n;
        boolean found = false;
    
        // loop continuously until isPrime returns true for a number below n
        while (!found)
        {
            ans--;
            if (isPrime(ans))
            {
                found = true;
            }
        }
        return ans;
    }

    // given a number n, determine if it is prime
    public static boolean isPrime(int n)
    {
        // loop from 2 to n/2 to check for factors
        for (int i = 2; i <= n/2; i++)
        {
            if (n % i == 0) // found a factor that isn't 1 or n, therefore not prime
            {
                return false;
            }
        }
        return true;
    }
}
