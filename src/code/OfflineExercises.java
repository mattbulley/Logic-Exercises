package code;

import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original,
	// there are two chars.

	// doubleChar("The") → "TThhee"
	// doubleChar("AAbb") → "AAAAbbbb"
	// doubleChar("Hi-There") → "HHii--TThheerree"

	public String doubleChar(String input) {
		String output = "";
		
		for(int i = 0; i < input.length(); i++) {
			output += Character.toString(input.charAt(i)); output += Character.toString(input.charAt(i));
		}
		
		return output;
	}
	//
	// A sandwich is two pieces of bread with something in between. Return the
	// string that is between the first and last appearance of "bread" in the
	// given string, or return the empty string "" if there are not two pieces
	// of bread.

	// getSandwich("breadjambread") → "jam"
	// getSandwich("xxbreadjambreadyy") → "jam"
	// getSandwich("xxbreadyy") → ""

	public String getSandwich(String input) {
		
		int breadCount = 0;
		input = input.toLowerCase();
		boolean foundBread = false;
		int beginIndex = 0;
		int endIndex = 0;
		
		for(int i = 0; i < input.length(); i++) {
			
			if(input.charAt(i) == 'b') {
				
				
					if(input.charAt(i+1) == 'r' && input.charAt(i+2) == 'e' && input.charAt(i+3) == 'a' && input.charAt(i+4) == 'd') {
						if(!foundBread) {
							beginIndex = i + 4;
							foundBread = true;
							breadCount++;
						} else if (foundBread) {
							foundBread = false;
							endIndex = i;
							breadCount++;
						}
					}
			}
		}
		
		if(breadCount == 2)
			return input.substring(beginIndex, endIndex);
		
		return "";
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false

	public boolean evenlySpaced(int a, int b, int c) {
		
		int biggest = 0;
		int middle = 0;
		int smallest = 0;
		int space = 0;
		
		if(a>b) {
			if(a>c) {
				biggest = a;
				if(c>b) {
					middle = c;
					smallest = b;
				} else {
					middle = b;
					smallest = c;
				}
			}
			else if (a<c) {
				biggest = c;
				middle = a;
				smallest = b;
			}
		} else if (b>a) {
			if(b>c) {
				biggest = b;
				if(c>a) {
					middle = c;
					smallest = a;
				} else {
					middle = a;
					smallest = c;
				}
			}
			else if (b<c) {
				biggest = c;
				middle = b;
				smallest = a;
			}
		}
	
		
		space = biggest - middle;
		
		if((biggest - middle) == space && (middle - smallest) == space)
			return true;
		else
			return false;
		
		
		
	}

	// Given a string and an int n, return a string made of the first and last n
	// chars from the string. The string length will be at least n.

	// nTwice("Hello", 2) → "Helo"
	// nTwice("Chocolate", 3) → "Choate"
	// nTwice("Chocolate", 1) → "Ce"

	public String nTwice(String input, int a) {
		String output = "";
		String end = "";
		
		for(int i = 0, j = input.length()-a; i < a; i++, j++) {
			output += (input.charAt(i));
			end += (input.charAt(j));
		}
		
		
		return output + end;
	}

	// Given a string, return true if it ends in "ly".

	// endsLy("oddly") → true
	// endsLy("y") → false
	// endsLy("oddy") → false

	public boolean endsly(String input) {
		
		if(input.length() == 1 || input.length() == 0)
			return false;
		
		if(input.charAt(input.length()-2) == 'l' && input.charAt(input.length()-1) == 'y')
			return true;
		
		return false;
	}

	// Given a string, return recursively a "cleaned" string where adjacent
	// chars that are the same have been reduced to a single char. So "yyzzza"
	// yields "yza".

	// stringClean("yyzzza") → "yza"
	// stringClean("abbbcdd") → "abcd"
	// stringClean("Hello") → "Helo"
	public String stringClean(String input) {
		
		
		String output = "";
		boolean checking = false;
		
		for(int i = 0; i < input.length() - 1; i++) {
				
				if(input.charAt(i) == input.charAt(i+1)) {
					if(!checking) {
						output += Character.toString(input.charAt(+i));
						checking = true;
					
					}
					
				} else if(input.charAt(i) != input.charAt(i+1)) {
					output += Character.toString(input.charAt(i));
					checking = false;
					
				}

		}
		
		return output;
	}

	// The fibonacci sequence is a famous bit of mathematics, and it happens to
	// have a recursive definition. The first two values in the sequence are 0
	// and 1 (essentially 2 base cases). Each subsequent value is the sum of the
	// previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
	// 21 and so on. Define a recursive fibonacci(n) method that returns the nth
	// fibonacci number, with n=0 representing the start of the sequence.

	// fibonacci(0) → 0
	// fibonacci(1) → 1
	// fibonacci(2) → 1

	public int fibonacci(int input) {
		
		int[] sequence = new int[100];
		sequence[0] = 0;
		sequence[1] = 1;
		
		for(int i = 2; i < sequence.length -1; i++) {
			sequence[i] = sequence[i-1] + sequence[i-2];
		}
		
		
		return sequence[input];
	}

	// We have a number of bunnies and each bunny has two big floppy ears. We
	// want to compute the total number of ears across all the bunnies
	// recursively (without loops or multiplication).
	//
	// bunnyEars(0) → 0
	// bunnyEars(1) → 2
	// bunnyEars(2) → 4

	public int bunnyEars(int input) {
		
		
		
		if(input < (input + input)) {
			input += input;
			bunnyEars(input);
		}
		
		
		
		
		return input;
	}

}
