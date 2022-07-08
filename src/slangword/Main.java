/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangword;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author ANTON
 */
public class Main {
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("0. Thoat chuong trinh.");
        System.out.println("1. Tim kiem theo slang word.");
        System.out.println("2. Tim kiem theo definition.");
        System.out.println("3. Hien thi history.");
        System.out.println("4. Them Slang word moi.");
        System.out.println("5. Cap nhat Slang word.");
        System.out.println("6. Xoa Slang word.");
        System.out.println("7. Reset danh sach Slang word goc.");
        System.out.println("8. Random mot Slang word");
        System.out.println("9. Do vui Slang word.");
        System.out.println("10. Do vui definition.");
        System.out.println("---------------------------");
        
    }
    
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        slangWordMap swmap = new slangWordMap();
        int choose;
        
        do {
            showMenu();
            System.out.print("Chon mot chuc nang: ");
            choose = s.nextInt();
            s.nextLine();
            switch (choose){
                case 0:
                    break;
                case 1:
                    System.out.print("Nhap vao keyword: ");
                    String kw = s.nextLine();
                    swmap.searchByKey(kw);
                    break;
                case 2:
                    System.out.print("Nhap vao keyword co trong definition: ");
                    String kwDef = s.nextLine();
                    swmap.searchByDef(kwDef);
                    break;
                case 3:
                    swmap.showHistory();
                    break;
                case 4:
                    swmap.add();
                    break;
                case 5:
                    swmap.edit();
                    break;
                case 6:
                    swmap.delete();
                    break;
                case 7:
                    swmap.reset();
                    break;
                case 8:
                    TreeMap<String, String> randMap = new TreeMap<>();
                    randMap = swmap.randomSlang(1, 0);
                    System.out.println("Random slang word cua ngay: ");
                    for (String key : randMap.keySet()){
                        System.out.println("[" + key + "] : [" + randMap.get(key) + "]");
                    }
                    System.out.println("Nhan enter de tiep tuc...");
                    s.nextLine();
                    break;
                case 9:
                    swmap.createQuiz("Chon dap an la dinh nghia cua: ", 0);
                    break;
                case 10:
                    swmap.createQuiz("Chon slang word cho dinh nghia sau: ", 1);
                    break;
                }
            
            }while (choose != 0);
    }
}