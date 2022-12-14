import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public String replaced_word = "";
    public String main_word = "";
    public static int getReplaced(String source, int start_index, int end_index, String target) {
        if (start_index > end_index) return end_index;
        boolean is_matched = false;
        int end = start_index;
        for(int j = 0; j<source.length(); j++) {
            if(source.charAt(j) != main_word.charAt(end)) {
                is_matched = false;
                end = end_index;
                break;
            }
            is_matched = true; 
            end++;
        }
        if(is_matched == false) {
            if(start_index == end_index){
                replaced_word += main_word.substring(start_index, end + 1);
            } else {
                replaced_word += main_word.substring(start_index, end);
            }
        } else {
            replaced_word += target.substring(0, target.length());
        }

        return end;
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        main_word = s;
        int end = -1; 
        
        for(int i=0; i<indices.length; i++) {
            if(indices[0] != 0) {
                end = getReplaced("", 0, indices[0] - 1, "");
            }
            end = getReplaced(sources[0], indices[i], indices[1] - 1, targets[0]);
        }
        end = getReplaced(sources[0], indices[0], indices[1] - 1, targets[0]);
        end = getReplaced("", end, indices[1] - 1, "");
        end = getReplaced(sources[1], indices[1], main_word.length() - 1, targets[1]);

        if(end != main_word.length()) getReplaced("", end, main_word.length() - 1, "");

        return replaced_word;
    }

    public static void main(String args[]) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"ab", "ce"};
        String[] targets = {"eee", "ffff"};

        String replaced_word = findReplaceString(s, indices, sources, targets);
        System.out.println("replaced_word-----------" + replaced_word);
    }
}

