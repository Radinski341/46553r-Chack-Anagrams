package com.kireradinski;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first word: ");
        String firstWord = scanner.next();
        System.out.print("Enter second word: ");
        String secondWord = scanner.next();
        boolean anagram = checkAnagram(firstWord, secondWord);
        if(anagram) System.out.println(firstWord + " and " + secondWord + " are anagrams!");
        else System.out.println(firstWord + " and " + secondWord + " are NOT anagrams!");
    }
    public static boolean checkAnagram(String word1, String word2){
        //1.Split the words to separate characters and store them in to array
        String[] word1Split = word1.toLowerCase().split("");
        String[] word2Split = word2.toLowerCase().split("");
        boolean isEqual = false;
        //2. Check the length of two words and if they are the same continue with the algorithms
        if(word1Split.length == word2Split.length) {
            //3.Loop through first word
            for (String character1 : word1Split) {
                //4.Re-assign values for the next character
                isEqual = false;
                int character1Count = 0;
                int character2Count = 0;
                //5.See how many times is character in the word
                for(String character1Check: word1Split){
                    if(character1.equals(character1Check)) character1Count++;
                }
                //6.For every character in first loop check equality with every character in second word
                for (String character2 : word2Split) {
                    //7.If one of the characters in second word are equal with the specific character from first word,
                    // and it is displayed equal times in both words set is equal to true
                    if (character1.equals(character2)) {
                        character2Count++;
                        if(character1Count == character2Count){
                            isEqual = true;
                            break;
                        }
                    }
                }
                //8.If there is no equal character brake from the loop
                if(!isEqual) break;
            }
        }
        //9.If isEqual is true to this point that means that this two words are anagrams
        return isEqual;
    }
}
