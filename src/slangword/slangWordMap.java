/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slangword;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static final String slangOg = "slang-origin.txt";

    public slangWordMap() throws IOException {
        map = nhapXuatFile.readFile(slang);
    }

    public void searchByKey(String key) {
        String definition = map.get(key.toLowerCase());
        Scanner s = new Scanner(System.in);
        if (definition != null) {
            System.out.println("Nghia cua [" + key + "] : [" + definition + "]");
        } else {
            System.out.println("Khong tim thay [" + key + "] trong tu dien!");
        }
        history.add(key);
        System.out.print("Nhan enter de ve Menu chinh...");
        s.nextLine();
    }

    public void searchByDef(String def) {
        ArrayList<String> keyList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        for (String key : map.keySet()) {
            if (map.get(key).toLowerCase().contains(def.toLowerCase())) {
                keyList.add(key);
            }
        }
        if (keyList.isEmpty() == true) {
            System.out.println("Khong tim thay slang word co chua [" + def + "] trong dinh nghia!");
        } else {
            System.out.println("Tim thay cac slang word:");
            for (String key : keyList) {
                System.out.println("[" + key + "] : [" + map.get(key) + "]");
            }
        }
        history.add(def);
        System.out.print("Nhan enter de ve Menu chinh...");
        s.nextLine();
    }

    public void add() {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap vao slangword: ");
        String key = s.nextLine();

        if (checkKey(key) == true) {
            System.out.println("Slang word da co trong tu dien!");
        } else {
            System.out.print("Nhap vao dinh nghia: ");
            String def = s.nextLine();

            map.put(key, def);
            System.out.println("Them vao thanh cong: [" + key + "]" + " : [" + def + "]");
            nhapXuatFile.writeFile("slang.txt", map);
        }
         System.out.print("Nhan enter de ve Menu chinh...");
        s.nextLine();
    }

    public void delete() {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap vao slangword: ");
        String key = s.nextLine();

        if (checkKey(key) == false) {
            System.out.println("[" + key + "] Khong co trong tu dien!");
        } else {
            int choose;
            do{
                System.out.println("Ban co chac chan muon xoa [" + key + "] ?");
                System.out.println("1. Co!");
                System.out.println("2. Khong!");
                choose = s.nextInt();
                if (choose == 1 || choose == 2) break;
            }while (true);

            s.nextLine();
            if (choose == 1) {
                map.remove(key);
                System.out.println("Da xoa thanh cong slang word: [" + key + "]");
                nhapXuatFile.writeFile("slang.txt", map);
            }
        }
        System.out.print("Nhan enter de ve Menu chinh...");
        s.nextLine();
    }

    public boolean checkKey(String key) {
        for (String keyChecker : map.keySet()) {
            if (keyChecker.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void edit() {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap vao slangword: ");
        String key = s.nextLine();

        if (checkKey(key) == false) {
            System.out.println("[" + key + "] khong co trong tu dien!");
        } else {
            System.out.println("Nghia cua [" + key + "] : [" + map.get(key) + "]");
            System.out.print("Nhap vao dinh nghia moi cua [" + key + "] : ");
            String newDef = s.nextLine();
            map.replace(key, newDef);

            System.out.println("Cap nhat thanh cong slang word [" + key + "]. Dinh nghia moi: [" + newDef + "]");
            nhapXuatFile.writeFile("slang.txt", map);
        }
        System.out.print("Nhan enter de ve Menu chinh...");
        s.nextLine();
    }

    public void showHistory() {
        Scanner s = new Scanner(System.in);
        if (history.isEmpty() == true) {
            System.out.println("Chua co tim kiem nao duoc ghi lai!");
        } else {
            System.out.println("Lich su tim kiem: ");
            for (String i : history) {
                System.out.println("[" + i + "]");
            } 
        }
        System.out.print("Nhan enter de ve Menu chinh...");
        s.nextLine();
    }

    public void reset() {
        try {
            Scanner s = new Scanner(System.in);
            map = nhapXuatFile.readFile(slangOg);
            nhapXuatFile.writeFile(slang, map);
            System.out.println("Reset thanh cong danh sach slang word ve phien ban goc!");
            System.out.print("Nhan enter de ve Menu chinh...");
            s.nextLine();
        } catch (IOException ex) {
            Logger.getLogger(slangWordMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TreeMap<String, String> randomSlang(int n, int randomType) {
        // Biến randomType để phân loại lấy random
        // randomType == 0 thì random ra n bộ <key, definition>
        // randomType == 1 thì random ra n bộ <definition, key>
        // Để phân loại phương thức quiz
        Scanner s = new Scanner(System.in);
        Random rand = new Random();
        String randomKey = null;
        ArrayList keys = new ArrayList<String>(map.keySet());
        TreeMap<String, String> result = new TreeMap<String, String>();
        for (int i = 0; i < n; i++) {
            randomKey = (String) keys.get(rand.nextInt(keys.size()));
            if(randomType == 0){
                result.put(randomKey, map.get(randomKey));
            } else if(randomType == 1){
                result.put(map.get(randomKey), randomKey);
            }
            
        }
        return result;
    }

    public void createQuiz(String questionString, int quizType) {
        //Lấy random 4 từ map chính
        TreeMap<String, String> quizMap = randomSlang(4, quizType);
        Random rand = new Random();
        Scanner s = new Scanner(System.in);
        
        //Đưa key của map random vào mảng keyQuiz
        Object[] keyQuizArr = quizMap.keySet().toArray();
        //Lấy ngẫu nhiên 1 key từ mảng keyQuiz
        String key = (String) keyQuizArr[rand.nextInt(keyQuizArr.length)];
        // definition của key được get từ map random ban đầu
        String definition = quizMap.get(key);
        
        System.out.print(questionString + key + "\n");
        int index = 1, correct = 0;
        
        //Với mỗi k trong bộ key của random map, 
        for (String k : quizMap.keySet()) {
            System.out.println(index + ". " + quizMap.get(k));
            if (quizMap.get(k) == definition)
                correct = index;
            index += 1;
        }
        System.out.println("=======================");
        System.out.print("Chon cau tra loi dung: ");
        int choose = s.nextInt(); s.nextLine();
        if (choose == correct){
            System.out.println("Ban da tra loi dung!");
        } else {
            System.out.println("Ban da tra loi sai!");
            if (quizType == 0){
                System.out.println("Ket qua dung la: " + key + " --- " + definition);
            } else if (quizType == 1){
                System.out.println("Ket qua dung la: " + definition + " --- " + key);
            }
        }
        System.out.print("Nhan enter de ve Menu chinh...");
        s.nextLine();
    }
}
