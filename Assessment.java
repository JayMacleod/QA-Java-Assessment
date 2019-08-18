package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {

		String lowerCaseString = "";
		int indexBert1 = 0;
		int indexBert2 = 0;
		String bertCheck = "bert";
		String noTwoBerts = "";		
		String stringWithoutBert = "";
		String reverse = "";

		//Change input string to all lowercase so we can search for lowercase "bert" (bertCheck variable)
		lowerCaseString = input.toLowerCase();
		
		//find 1st "bert" in new lowercase string
		indexBert1=lowerCaseString.indexOf(bertCheck);//returns the index of bert substring
		//increase index of 1st "bert" by 4 spaces to get the end of the full 1st "bert"
		indexBert1 = indexBert1 + 4;
		
		//find 2nd "bert" in new lowercase string
		indexBert2=lowerCaseString.lastIndexOf(bertCheck);//returns the last index of bert substring
		
		//if there is only one "bert" (test to see if both variables match) return an empty string		
		if (indexBert2 == indexBert1 - 4) {
			return noTwoBerts;
		}
		
		//else create a new string from the one between the two "berts" and then reverse the string
		else {
		//create  new string
		stringWithoutBert = input.substring(indexBert1, indexBert2);
		
		//reverse this new string
		for(int i = stringWithoutBert.length() - 1; i >= 0; i--) {
	           reverse = reverse + stringWithoutBert.charAt(i);
	        }
		
		//Return the new reversed string
		return reverse;
		}
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false
	
	public boolean evenlySpaced(int a, int b, int c) {
		
		int checkNum1 = 0;
		int checkNum2 = 0;
		int checkNum3 = 0;
		int space1 = 0;
		int space2 = 0;
		
		//Place the int a, b and c into order (largest first)
		if (a>b) {
			checkNum1 = a;
			checkNum2 = b;
		}
		
		else {
			checkNum1 = b;
			checkNum2 = a;
		}
		
		if (c>checkNum1) {
			checkNum3 = checkNum2;
			checkNum2 = checkNum1;
			checkNum1 = c;
		}
		
		else if (c>checkNum2) {
			checkNum3 = checkNum2;
			checkNum2 = c;
		}
		
		else {
			checkNum3 = c;
		}
		
		//get values for the spaces
		space1 = checkNum2 - checkNum3;
		space2 = checkNum1 - checkNum2;
		
		// if the values equal then return true
		if (space1 == space2) {
			return true;
		}
		
		// else return false
		else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		
		int midIndex = 0;
		int removeFromMid = 0;
		int stringTotalLength = 0;
		String originalWord = "";
		String newWord = "";
		String front = "";
		String back = "";
		int startingChar = 0;
		int endingChar = 0;
			
		//assign the input word to a variable
		originalWord = input;
			
		//get length of string
		stringTotalLength = input.length();
			
		//get mid index number of string
		midIndex = (stringTotalLength / 2) + 1;
			
		//calculate how many characters to remove left an right of mid
		removeFromMid = (a / 2);
			
		if (a > 1){
			
			//calc how many characters to remove
			startingChar = (midIndex - 1) - removeFromMid;
			endingChar = (midIndex + 1) - removeFromMid;
			
			//Removing characters
			front = originalWord.substring(0, startingChar);
		    back = originalWord.substring((endingChar + 1), originalWord.length());
		    newWord = front + back;
		    
		    //return the new word
			return newWord;
			}
			
			else {
			
			//Removing just mid character
			front = originalWord.substring(0, (midIndex - 1));
			back = originalWord.substring(midIndex, originalWord.length());
			newWord = front + back;

			//return the new word
			return newWord;
			}
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		
		String blockString = "";
		int stringLength = 0;
		char charLetter;
		int count1 = 0;
		int finalInt = 0;
		
		//assign the input word to a variable
		blockString = input;
		
		//get the length of string
		stringLength = blockString.length();
		
		//check that there are some characters in the string
		if (stringLength > 0) {
		
			//run through the given string
			for (int i = 0; i < blockString.length(); i++) {
				
				//assign each character
				charLetter = (blockString.charAt(i));
				//set the count to 0
				count1 = 0;
				
				//run through the string with that character looking for matches
				for (int j = 0; j < blockString.length(); j++) {
					
					//add to count if characters match	
				    if (blockString.charAt(j) == charLetter) {
				        count1++;
				        
				        //increase final count to the largest matches found
				        if (finalInt < count1) {
				        	finalInt = count1;
				        }
				        
				        //keep the final count number the same if no extra matches are found
				        else {
				        	finalInt = finalInt;
				        }
				    }
				    
				    //do not add to count if characters do not match
				    else {
				    	count1 = count1;
				    }
				}
			}
			
			//return the final count
			return finalInt;
		}
		
		//if the length of string is 0 then return 0
		else {
			
			finalInt = 0;
			
			//return the final count
			return finalInt;
		}
	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		
		String strFind = "am";
		String inputString = "";
		int count = 0;
		int fromIndex = 0;
		char testCharStart;
		char testCharEnd;
		
		//Change input string to all lowercase so we can search for lowercase "bert" (bertCheck variable)
		inputString = arg1.toLowerCase();

		//set variable to the length of the string
		int inputStringLength = inputString.length();
		
		//use loop to move through the string
		while ((fromIndex = inputString.indexOf(strFind, fromIndex)) != -1 ){
			
			//if a is the first letter of the string then it counts  
			if (fromIndex == 0) {
				
				//set the starting index as the a in am, and get the character after the m in am
				testCharStart = inputString.charAt(fromIndex);
				testCharEnd = inputString.charAt(fromIndex + 2);
	    		
				//increase fromIndex by 1
	    		fromIndex++;
				
	    		//if the character after the m in am is a space then increase the count by 1
				if (!(testCharEnd >= 'a' && testCharEnd <= 'z')) {
					count++;
				}
				
				//else if the character after the m in am is not a space do not increase the count 
				else {
					count = count;
				}
			}
			
			//else if the m in am is the last character of the string then it counts
			else if ((fromIndex + 2) == inputStringLength) {
				
				//get the character before the a in am, and set the last index to be m
				testCharStart = inputString.charAt(fromIndex - 1);
				testCharEnd = inputString.charAt(fromIndex);

				//increase fromIndex by 1
	    		fromIndex++;
				
				//if the character before the a in am is a space then increase the count by 1
				if (!(testCharStart >= 'a' && testCharStart <= 'z')) {
					count++;
				}
				
				//else if the character before the a in am is not a space do not increase the count
				else {
					count = count;
				}
			}
			
			// else if the a in am is not the first character AND the m in am is not the last character then do this
			else {
				
				//get the character before the a in am, and get the character after the m in am
				testCharStart = inputString.charAt(fromIndex - 1);
				testCharEnd = inputString.charAt(fromIndex + 2);
				
				//increase fromIndex by 1
				fromIndex++;
				
				//if the character before the a in am is a space then need to check the last character
				if (!(testCharStart >= 'a' && testCharStart <= 'z')) {
					count = count;
					
					//if the character after the m in am is also a space then increase count
					if (!(testCharEnd >= 'a' && testCharEnd <= 'z')) {
						count++;
					}
					
					//the character after the m in am is not a space so do not increase the count
					else {
						count = count;
					}
				
				}
				
				//if the character before the a in am is not a space then do not increase count
				else {
					count = count;
				}
			}
		}

		//return the count
		return count;	
	}
		

	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5 return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		
		String returnString = "";
		
		//check to see if divisible by 3
		if (arg1 % 3 == 0) {
			
			//if divisible by 3 check to see if also divisible by 5
			if (arg1 % 5 == 0) {
				returnString = "fizzbuzz";
			}
			
			//not divisible by 5 as well as 3
			else {
				returnString = "fizz";
			}

		}
		
		//not divisible by 3 so check to see if divisible by 5
		else if (arg1 % 5 == 0){
			returnString = "buzz";
		}
		
		//not divisible by either 3 or 5
		else {
			returnString = "none";
		}
		
		//return the string required
		return returnString;
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		
		String inputArg1 = arg1;
		char charCharacter;
		int charInteger = 0;
		int countInt = 0;
		int finalCount = 0;
		
		//set variable to the length of the string
		int inputStringLength = inputArg1.length();
			
		//initialise the charCharacter
		charCharacter = (inputArg1.charAt(0));
		
		//run through the given string
		for (int i = 0; i < inputArg1.length(); i++) {
			
			//initialise the charCharacter
			charCharacter = (inputArg1.charAt(i));
			
			//check to see if this is the last character on the string
			if (i == inputStringLength - 1) {
				
				//change the char to int
				charInteger = Integer.parseInt(String.valueOf(charCharacter));
				
				//add on the new int
				countInt = countInt + charInteger;
				
				//if the numbers added are larger than the previous numbers then set finalCount to this number
				if (countInt > finalCount) {
					finalCount = countInt;
					countInt = 0;
				}
				
				//else do not change finalCount
				else {
					countInt = 0;
				}
			}
			
			//check to see if it is a character or a space
			if (charCharacter != ' ') {
			
			//change the char to int
			charInteger = Integer.parseInt(String.valueOf(charCharacter));
			
			//add on the new int
			countInt = countInt + charInteger;
			}
			
			else {
				
				//if the numbers added are larger than the previous numbers then set finalCount to this number
				if (countInt > finalCount) {
					finalCount = countInt;
					countInt = 0;
				}
				
				//else do not change finalCount
				else {
					countInt = 0;
				}
			}
		}
		//return the finalCount
		return finalCount;
	}
}