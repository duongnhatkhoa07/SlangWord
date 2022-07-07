/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slangword;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 *
 * @author ANTON
 */
public class slangWordMap {

    /**
     * @param args the command line arguments
     */
    public HashMap<String, String> map;
    public ArrayList<String> history = new ArrayList<>();
    
    private static final String historyFile = "history.txt";
    private static final String slang = "slang.txt";
    
    public slangWordMap() throws IOException {
        map = nhapXuatFile.readFile(slang);
    }
    
    public void search(String key){
        String definition = map.get(key.toLowerCase(Locale.ROOT));
        if (definition != null){
            System.out.println("Nghia cua: " + key + " la: " + definition);
        }
        else {
            System.out.println("Khong tim thay keyword nhap vao!");
        }
        history.add(key);
    }
}
