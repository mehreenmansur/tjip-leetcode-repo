import java.util.*;
import java.io.*;
import java.math.*;

class RandomizedSet { //O(1) time & space
    public static HashMap<Integer, Integer> hash_map;
    public static List<Integer> num_list;
    public static RandomizedSet rs;
    public static Random rand = new Random();
    
    public RandomizedSet() {
        hash_map = new HashMap<>();
        num_list = new ArrayList<Integer>();
    }
    
    public static boolean insert(int val) {
        if(hash_map.containsKey(val)) return false;

        hash_map.put(val, num_list.size());
        num_list.add(num_list.size(), val);
        return true;
    }
    
    public static boolean remove(int val) {
        if(hash_map.containsKey(val)){
            int last_index = num_list.size() - 1;

            int del_index = hash_map.get(val);
            int del_num = num_list.get(del_index);
            int last_num = num_list.get(last_index);

            num_list.set(del_index, last_num);
            num_list.set(last_index, del_num);
            hash_map.put(last_num, del_index);
            
            num_list.remove(last_index);
            hash_map.remove(val);

            return true;
        }
        return false;
    }
    
    public static int getRandom() {
        return num_list.get(rand.nextInt(num_list.size()));
    }
    public static void main(String[] args){
        String[] s_arr = {"RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"};
        // int[][] arr = new arr[200001][1];
        int[][] arr = { {}, {1}, {2}, {2}, {}, {1}, {2}, {} };

        // arr = {{}, {1}, {2}, {2}, {}, {1}, {2}, {}};
        for(int i=0; i<s_arr.length; i++){
            if(s_arr[i] == "RandomizedSet"){
                rs = new RandomizedSet();
            } else if(s_arr[i] == "insert"){
                boolean answer = rs.insert(arr[i][0]);
                System.out.println("--insert--answer--- : " + answer);
            } else if(s_arr[i] == "remove"){
                boolean answer = rs.remove(arr[i][0]);
                System.out.println("--remove--answer--- : " + answer);
            } else{
                int answer = rs.getRandom();
                System.out.println("--getRandom--answer--- : " + answer);
            }
        }   
    }
}