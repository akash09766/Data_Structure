package com.nexsterstudios.android.datastructure.tree;

import android.util.Log;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Akash Wangalwar.(Github:akash09766) on 02-11-2021 at 16:10.
 */
public class Ds {

    public int findGroupOfAnagram(String[] anagramsList) {
        if (anagramsList == null || anagramsList.length == 0) {
            return 0;
        }
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < anagramsList.length; i++) {

            for (int j = 0; j < anagramsList.length; j++) {

                if (i != j) {

                    boolean status = isAnagram(anagramsList[i], anagramsList[j]);

                    if (status) {
                        if (map.containsKey(anagramsList[i])) {
                            int count = map.get(anagramsList[i]) + 1;
                            map.put(anagramsList[i], count);
                        } else {
                            boolean anagramKeyContainsInMap = false;
                            for (String item : map.keySet()) {
                                if (isAnagram(anagramsList[i], item)) {
                                    anagramKeyContainsInMap = true;
                                    break;
                                }
                            }
                            if (!anagramKeyContainsInMap)
                                map.put(anagramsList[i], 1);
                        }
                    }

                }
            }
        }

     /*   for (String item : map.keySet()) {
            Log.d(TAG, "findGroupOfAnagram: --> " + item);
        }*/

        return map.keySet().size() + 1;
    }

    private static final String TAG = Ds.class.getSimpleName();

    public boolean isAnagram2(String val1, String val2) {

        if (val1 == null || val2 == null) {
            return false;
        } else if (val1.isEmpty() || val2.isEmpty()) {
            return false;
        } else if (val1.length() != val2.length()) {
            return false;
        }
        
        char[] val1CharArray = val1.toCharArray(); 
        char[] val2CharArray = val2.toCharArray();

        Arrays.sort(val1CharArray);
        Arrays.sort(val2CharArray);

        for (int i = 0; i < val1CharArray.length; i++) {
            if(val1CharArray[i] != val2CharArray[i]){
                return false;
            }
        }

        return true;
    }
    public boolean isAnagram(String val1, String val2) {

        if (val1 == null || val2 == null) {
            return false;
        } else if (val1.isEmpty() || val2.isEmpty()) {
            return false;
        } else if (val1.length() != val2.length()) {
            return false;
        }

        Map<Character, Integer> val1map = new TreeMap<>();
        Map<Character, Integer> val2Map = new TreeMap<>();

        for (int i = 0; i < val1.toCharArray().length; i++) {

            Character character = val1.toCharArray()[i];

            if (val1map.containsKey(character)) {
                int count = val1map.get(character) + 1;
                val1map.put(character, count);
            } else {
                val1map.put(character, 1);
            }
        }


        for (int i = 0; i < val2.toCharArray().length; i++) {

            Character character = val2.toCharArray()[i];

            if (val2Map.containsKey(character)) {
                int count = val2Map.get(character) + 1;
                val2Map.put(character, count);
            } else {
                val2Map.put(character, 1);
            }
        }

        for (Character item : val1map.keySet()) {
            if (!val2Map.containsKey(item)) {
                return false;
            } else if (val1map.get(item) != val2Map.get(item)) {
                return false;
            }
        }
        return true;
    }
}
