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
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author ANTON
 */
public class slangWordMap {

    /**
     * @param args the command line arguments
     */
    //public HashMap<String, String> map;
    public TreeMap<String, String> map;
    public ArrayList<String> history = new ArrayList<>();
    //Map<String, String> pref = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
    private static final String historyFile = "history.txt";
    private static final String slang = "slang.txt";
    
    public slangWordMap() throws IOException {
        map = nhapXuatFile.readFile(slang);
    }
    
    public void searchByKey(String key){
        String definition = map.get(key.toLowerCase());
        Scanner s = new Scanner(System.in);
        if (definition != null){
            System.out.println("Nghia cua [" + key + "] : [" + definition + "]");
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
        }
        else {
            System.out.println("Khong tim thay [" + key + "] trong tu dien!");
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
        }
        history.add(key);
    }
    
    public void searchByDef(String def){
        ArrayList<String> keyList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        for (String key : map.keySet()){
            if (map.get(key).toLowerCase().contains(def.toLowerCase()))
                keyList.add(key);
        }
        if(keyList.isEmpty() == true){
            System.out.println("Khong tim thay slang word co chua [" + def + "] trong dinh nghia!");
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
        }
        else {
            System.out.println("Tim thay cac slang word:");
            for (String key : keyList){
                System.out.println("[" + key + "] : [" + map.get(key) + "]");
            }
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
        }
        history.add(def);
    }
    
    public void add () {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap vao slangword: ");
        String key = s.nextLine();
        
        if (checkKey(key) == true){
            System.out.println("Slang word da co trong tu dien!");
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
        }else{
            System.out.print("Nhap vao dinh nghia: ");
            String def = s.nextLine();

            map.put(key, def);
            System.out.println("Them vao thanh cong: [" + key + "]" + " : [" + def + "]");
            nhapXuatFile.writeFile("slang.txt", map);
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
            
        } 
    }
    
    public void delete(){
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap vao slangword: ");
        String key = s.nextLine();
        
        if (checkKey(key) == false){
            System.out.println("[" + key + "] Khong co trong tu dien!");
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
        }else{
            System.out.println("Ban co chac chan muon xoa [" + key + "] ?");
            System.out.println("1. Co!");
            System.out.println("2. Khong!");
            int choose = s.nextInt();
            s.nextLine();
            if (choose == 1){
                map.remove(key);
                System.out.println("Da xoa thanh cong slang word: [" + key + "]");
                nhapXuatFile.writeFile("slang.txt", map);
                System.out.println("Nhan enter de tiep tuc...");
                s.nextLine();
            }
            else {
                System.out.println("Tro ve Menu chinh. Nhan enter de tiep tuc...");
                s.nextLine();
            }
        } 
    }
    public boolean checkKey(String key) {
        for (String keyChecker : map.keySet()) {
                if (keyChecker.equals(key))
                        return true;
        }
        return false;
    }
    
    public void edit(){
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap vao slangword: ");
        String key = s.nextLine();
        
        if (checkKey(key) == false){
            System.out.println("[" + key + "] khong co trong tu dien!");
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
        }else{
            System.out.println("Nghia cua [" + key + "] : [" + map.get(key) + "]");
            System.out.print("Nhap vao dinh nghia moi cua [" + key + "] : ");
            String newDef = s.nextLine();
            map.replace(key, newDef);
            
            System.out.println("Cap nhat thanh cong slang word [" + key + "]. Dinh nghia moi: [" + newDef + "]");
            nhapXuatFile.writeFile("slang.txt", map);
            
            System.out.println("Nhan enter de tiep tuc...");
            s.nextLine();
        } 
    }
}
