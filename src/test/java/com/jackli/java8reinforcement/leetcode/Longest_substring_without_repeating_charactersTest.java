package com.jackli.java8reinforcement.leetcode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Longest_substring_without_repeating_charactersTest {
     Longest_substring_without_repeating_characters lswrc = new Longest_substring_without_repeating_characters();
     @Test
     void shouldBeEqual(){
         Integer exp = 1;
      //   Integer real= lswrc.lengthOfLongestSubstring(" ");
        // assertEquals(exp, real);
int real = lswrc.method3("abcddfee");
         assertEquals(4, real);
     }
}