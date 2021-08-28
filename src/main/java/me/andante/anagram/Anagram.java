package me.andante.anagram;

import com.google.common.primitives.Chars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Anagram {
    public static void main(String[] args) {
        // get args
        HashMap<String, Object> argMap = ArgParser.toMap(args);
        String str1 = stringOf(argMap.get("str1"));
        String str2 = stringOf(argMap.get("str2"));
        boolean strict = Boolean.parseBoolean(stringOf(argMap.get("strict")));

        // ---

        ArrayList<Character> chars1 = new ArrayList<>(Chars.asList(str1.toCharArray()));
        ArrayList<Character> chars2 = new ArrayList<>(Chars.asList(str2.toCharArray()));

        if (!strict) {
            toLowerCase(chars1);
            toLowerCase(chars2);
        }

        // loop through comparison string and remove from original
        // to determine match
        for (Character cha : chars2) {
            chars1.remove(cha);
        }
        boolean isAnagram = chars1.isEmpty();

        // ---

        System.out.printf("'%s' %s an anagram of '%s'!%n", str1, isAnagram ? "is" : "is not", str2);
        System.out.println(isAnagram);
    }

    public static void toLowerCase(ArrayList<Character> charList) {
        for (int i = 0; i < charList.size(); i++) {
            Character cha = charList.get(i);
            charList.set(i, cha.toString().toLowerCase(Locale.ROOT).charAt(0));
        }
    }

    public static String stringOf(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
