package com.itersdesktop.javatechs.map;// Java code to illustrate the putAll() method
import java.util.*;
  
public class HashMapDemo {
    public static void main(String[] args) {
        
        // Creating an empty HashMap
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
    
        // Mapping string values to int keys 
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");
    
        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);
    
        // Creating a new hash map and copying
        HashMap<Integer, String> new_hash_map = new HashMap<Integer, String>();
        new_hash_map.put(35, "Tung");
        new_hash_map.put(40, "Hue");
        new_hash_map.put(45, "Khang");
        new_hash_map.put(50, "Khang");
        new_hash_map.putAll(hash_map);
    
        // Displaying the final HashMap
        System.out.println("The new map looks like this: " + new_hash_map);
    }
}
