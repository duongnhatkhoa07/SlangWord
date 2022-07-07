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

/**
 *
 * @author ANTON
 */
public class nhapXuatFile {
    public static HashMap<String, String> readFile (String filename) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = bf.readLine()) != null){
            String parts[] = line.split("`", 2);
            if (parts.length >= 2){
                hashMap.put(parts[0].toLowerCase(Locale.ROOT), parts[1]);
            }
        }
        return hashMap;
    }
    
    
}
