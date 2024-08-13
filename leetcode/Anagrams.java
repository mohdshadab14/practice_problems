package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagrams {

    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        int i = 'a';
        System.out.println(i);
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }else{
            int[] arr = new int[26];
            for(char c : s.toCharArray()){
                arr[c-97]+=1;
            }
            for(char c : t.toCharArray()){
                arr[c-97]-=1;
            }
            for(int i=0;i<26;i++){
                if(arr[i]!=0) return false;
            }
            return true;
        }
    }
}
