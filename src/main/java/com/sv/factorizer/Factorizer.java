/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sv.factorizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-05
 * purpose: Take a user inputted number and find its factors
 *          as well as if it's a prime number and a perfect number
 */
public class Factorizer {
    
    public static void main(String[] args) {
        
        // GET USER NUMBER 
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean isLooping = true;
        boolean isPerfect = false;
        boolean isPrime = false;
        
        while (isLooping) {
            System.out.println("Input whole number between 3 and 100:");
            
            try {
                
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
                if (number < 3 || number > 100) {
                    throw new Exception("Please select a number between 3 and 100");
                }
                isLooping = false;
                
            } catch(NumberFormatException e) {
                System.out.println("That's not a number.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        
        
        // FIND FACTORS
        List<Integer> factors = new ArrayList<>();
                
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        
        
        
        // Is perfect?
        if (factors.stream().reduce(0, ((subtotal, element) -> subtotal + element)) == number) {
            isPerfect = true;
        }
            
        
        
        // Is prime?
        // This could be done by checking if the size of the "factors" array = 2
        // But this is brute force way of checking for prime.
        if (number % 2 != 0) {
            isPrime = true;
            for (int i = 3; i < number / 2; i += 2) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        
        
        // Display the results
        System.out.printf("%nFor the number %d:%n", number);
        System.out.printf("- %d has %d factors: ", number, factors.size());
        
        for (int factor : factors) {
            System.out.printf("%d ", factor);
        }
        
        System.out.println();
        
        System.out.printf("- %d is " + (isPerfect ? "" : "NOT ") + "a perfect number.%n", number);
        System.out.printf("- %d is " + (isPrime ? "" : "NOT ") + "a prime number.%n", number);
        
        
        
    }

    
    
}
