/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangword;

import java.io.IOException;
import java.util.Scanner;

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
                    System.out.println("Nhap vao keyword: ");
                    String kw = s.nextLine();
                    swmap.searchByKey(kw);
                    break;
                case 2:
                    System.out.println("Nhap vao keyword co trong definition: ");
                    String kwDef = s.nextLine();
                    swmap.searchByDef(kwDef);
                    break;
                case 3:
                    //TODO show history
                    break;
                case 4:
                    //TODO add
                    swmap.add();
                    break;
                case 5:
                    //TODO edit
                    break;
                case 6:
                    //TODO delete
                    break;
                case 7:
                    //TODO reset
                    break;
                case 8:
                    //TODO Random
                    System.out.println("Slang word on this day: ");
                    break;
                case 9:
                    //TODO quiz
                    break;
                case 10:
                    //TODO quiz 2
                    break;
                }
            
            }while (choose != 0);
    }
}
