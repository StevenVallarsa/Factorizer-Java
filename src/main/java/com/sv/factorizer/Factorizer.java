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
        
        // get user number
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
        
        
        
        // find factors
        List<Integer> factors = new ArrayList<>();
                
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        
        
        
        // find if perfect
        if (factors.stream().reduce(0, ((subtotal, element) -> subtotal + element)) == number) {
            isPerfect = true;
        }
            
        
        // find if prime
        if (number % 2 != 0) {
            for (int i = 3; i < number / 2; i += 2) {
                if (number % i == 0) {
                    break;
                }
            }
            isPrime = true;
        }
        
        System.out.printf("For the number %d:", number);
        System.out.println(factors);
        
        Integer.
        
    }

    
    
}
