/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ANTON
 */
public class nhapXuatFile {
    //public static HashMap<String, String> readFile (String filename) throws IOException {
    public static Map<String, String> readFile (String filename) throws IOException {
        Map<String, String> map = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = bf.readLine()) != null){
            String parts[] = line.split("`", 2);
            if (parts.length >= 2){
                map.put(parts[0].toLowerCase(Locale.ROOT), parts[1]);
            }
        }
        return map;
    }
    
    
}
