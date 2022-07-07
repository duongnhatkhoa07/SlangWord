/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slangword;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author ANTON
 */
public class slangWordMap {

    /**
     * @param args the command line arguments
     */
    //public HashMap<String, String> map;
    public Map<String, String> map;
    public ArrayList<String> history = new ArrayList<>();
    //Map<String, String> pref = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
    private static final String historyFile = "history.txt";
    private static final String slang = "slang.txt";
    
    public slangWordMap() throws IOException {
        map = nhapXuatFile.readFile(slang);
    }
    
    public void searchByKey(String key){
        String definition = map.get(key.toLowerCase(Locale.ROOT));
        if (definition != null){
            System.out.println("Nghia cua: " + key + " la: " + definition);
        }
        else {
            System.out.println("Khong tim thay keyword nhap vao!");
        }
        history.add(key);
    }
    
    public void searchByDef(String def){
        ArrayList<String> keyList = new ArrayList<>();
        
        for (String key : map.keySet()){
            if (map.get(key).contains(def))
                keyList.add(key);
        }
        for (String key : keyList){
            System.out.println(key + ": " + map.get(key));
        }
        history.add(def);
    }
}
