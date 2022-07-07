/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
    public static TreeMap<String, String> readFile (String filename) throws IOException {
        TreeMap<String, String> map = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        try{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null){
            String parts[] = line.split("`", 2);
            if (parts.length >= 2){
                map.put(parts[0].toLowerCase(Locale.ROOT), parts[1]);
            }
        }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        return map;
    }
    
    public static void writeFile(String fileName, TreeMap<String, String> map){
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(writer);
            for (String key : map.keySet()) {
                String line = String.join("`", key, map.get(key));
                line += "\n";
                bw.write(line);
            }
        } catch(IOException ex){
            System.err.format("IOException: %s%n", ex);
        }
    }
}
