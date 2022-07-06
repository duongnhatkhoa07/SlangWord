/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slang.word;

/**
 *
 * @author ANTON
 */
public class SlangWord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        showMenu();
    }
    public static void showMenu() {
        System.out.println("-----------menu------------");
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
        System.out.print("Chon mot chuc nang: ");
    }
    
}
