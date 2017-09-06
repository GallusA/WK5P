package com.example.gallusawa.wk5p;

import java.util.Hashtable;
import java.util.Stack;

/**
 * Created by gallusawa on 9/6/17.
 */

public class CodeTest {

    public static void main(String[] args) {
        System.out.println(MatchingBrakets("({[] })[]"));
        System.out.println(makeCopies("catcowcat", "cow", 1));
    }

    public static boolean MatchingBrakets(String s){
        Hashtable<String, String> hash = new Hashtable<String, String>();
        hash.put("(",")");
        hash.put("[","]");
        hash.put("{","}");
        hash.put("<",">");

        Stack<String> b = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if(hash.containsKey(String.valueOf(s.charAt(i))))
                b.push(String.valueOf(s.charAt(i)));
            if(hash.containsValue(String.valueOf(s.charAt(i))))
                if(hash.get(b.get(b.size()-1)).equals(String.valueOf(s.charAt(i))))
                    b.pop();
                else
                    return false;
        }
        return b.isEmpty();
    }

    public static boolean makeCopies(String s, String sub, int n) {
        if (n == 0)
            return true;
        if (s.length() < sub.length())
            return false;

        if (s.substring(0, sub.length()).equals(sub))
            return makeCopies(s.substring(1), sub, n - 1);

        return makeCopies(s.substring(1), sub, n);
    }
}