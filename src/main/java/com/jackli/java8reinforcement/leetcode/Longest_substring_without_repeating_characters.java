package com.jackli.java8reinforcement.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int result =0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<=len; j++){
                if(noRepeatedChar(s, i, j)){
                    result = Math.max(result, j-i);
                }
            }
        }
        return result;
    }
    private boolean noRepeatedChar(String s, int start, int end){
        Set<Character> charSet =new HashSet<>();
        for(int i=start; i<end; i++){
            boolean isAdded = charSet.add(s.charAt(i));
            if(isAdded==false) return false;
        }
        return true;
    }

    public int method2(String s){
        int len = s.length();
        int result =0, right =0, left=0;
        Set<Character> charSet =new HashSet<>();
        while(right<len && left<len){
            if(!charSet.contains(s.charAt(left))){
                charSet.add(s.charAt(left));
                left++;
                result = Math.max(result, left-right);
            }
            else{
                charSet.remove(s.charAt(right));
                right++;
            }
        }
        return result;

    }

    public int method3(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }
}
