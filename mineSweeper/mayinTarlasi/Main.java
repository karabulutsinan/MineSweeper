import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Mayın Tarlasına Hoşgeldiniz !");
        System.out.println("Ne kadar büyük bir haritada oynamak istiyorsunuz ?");

        System.out.print("Satır sayısını giriniz : ");
        int row = input.nextInt();
        System.out.print("Sutun sayısını giriniz : ");
        int col = input.nextInt();
        System.out.println("===============================");
        //MineSweeper sınıfının çağırılması(Değerlendirme Formu - 5)
        //Dizi matris boyutunun kullanıcı tarafından alınması (Değerlendirme Formu - 7)
        MineSweeper mine = new MineSweeper(row, col);
        mine.run();

    }
}