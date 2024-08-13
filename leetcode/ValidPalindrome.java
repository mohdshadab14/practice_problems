package leetcode;

import java.util.Locale;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "");

        if(s.isEmpty()){
            return true;
        }

        s=s.toLowerCase();

        int i=0, j=s.length()-1;

        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
