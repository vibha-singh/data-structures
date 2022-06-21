/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 *         Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 *         Example 1:
 *
 *         Input: s = "A man, a plan, a canal: Panama"
 *         Output: true
 *         Explanation: "amanaplanacanalpanama" is a palindrome.
 *         Example 2:
 *
 *         Input: s = "race a car"
 *         Output: false
 *         Explanation: "raceacar" is not a palindrome.
 *         Example 3:
 *
 *         Input: s = " "
 *         Output: true
 *         Explanation: s is an empty string "" after removing non-alphanumeric characters.
 *         Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 *         Constraints:
 *
 *         1 <= s.length <= 2 * 105
 *         s consists only of printable ASCII characters.
 * **/

public class ValidPalindrome{
    public boolean isValidPallindrome(String s){
        int startPointer = 0;
        int endPointer = s.length() -1;
        while(startPointer < endPointer){
            Character startChar = Character.toLowerCase(s.charAt(startPointer));
            Character endChar = Character.toLowerCase(s.charAt(endPointer));
            if(!isAlphanumeric(startChar) && isAlphanumeric(endChar))
                startPointer++;
            else if(isAlphanumeric(startChar) && !isAlphanumeric(endChar))
                endPointer--;
            else if(isAlphanumeric(startChar) && isAlphanumeric(endChar) && startChar != endChar)
                return false;
            else {
                startPointer++;
                endPointer--;
            }
        }
        return true;
    }

    public boolean isAlphanumeric(Character c){
        if(c >= '0' && c <= '9' || c >= 'a' && c <= 'z')
            return true;
        return false;
    }
}