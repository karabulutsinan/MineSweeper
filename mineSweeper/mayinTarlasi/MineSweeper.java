import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    //Sınıfın elemanları
    private int rowNumber, colNumber;
    private String[][] board;
    private String[][] map;
    //Değişkenler
    private int size;
    private int totalMines;
    private boolean game = true;
    private boolean isGameSuccessfullyFinished = false;

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    //Constructor
    MineSweeper(int rowNumber, int colNumber) {
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.size = colNumber * rowNumber;
    }

    //Oyunun çalıştırılması(Değerlendirme Formu - 6)
    public void run() {
        makeBoard();
        System.out.println("Oyun Başladı İyi Eğlenceler !");
        printBoard();
        System.out.println("===============================");
        printMap();
        gameProcess();
    }

    //Oyunun kontrolleri
    private void gameProcess() {
        int selectedRow, selectedCol;

        while (game) {

            //Kullacının seçmek istediği satır ve sütun bilgisinin alınması (Değerlendirme Formu - 9)
            System.out.print("Satır giriniz : ");
            selectedRow = input.nextInt();
            System.out.print("Sütun giriniz : ");
            selectedCol = input.nextInt();
            System.out.println("---------------------");

            //Alınan değerin dizi sınırları içerinde olup olmadığının kontrolü (Değerlendirme Formu - 10)
            if (isValidCoordinate(selectedRow, selectedCol)) {
                //Seçilen noktanın mayın bilgisi ve varsa çevresindeki mayınların sayan kısım
                turn(selectedRow, selectedCol);
                //Oyunun başarıyla bittiğinin kontrolü
                checkGameIsSuccessfullyFinished();

                // Oyunun kaybetme veya kazanma durumuna ilişkin uygun mesajların gösterilmesi (Değerlendirme Formu - 15)
                if (!game) {
                    if (isGameSuccessfullyFinished) {
                        System.out.println("Oyunu Kazandınız !");
                        System.out.println("********Tebrikler********");

                    } else {
                        System.out.println("Mayına bastınız oyunu kaybettiniz. Oyun bitmiştir !");
                        break;
                    }
                }
                printMap();
                System.out.println("---------------------");
            } else {
                System.out.println("Geçersiz bir koordinat girdiniz. Koordinatları tekrardan giriniz.");
            }
        }
    }

    //Tahtanın oluşturulması
    private void makeBoard() {
        this.board = new String[rowNumber][colNumber];
        map = new String[rowNumber][colNumber];
        generateMap();
        generateMines();
    }

    //Haritanın oluşturulması
    private void generateMap() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                map[i][j] = "-";
            }
        }
    }

    //Mayınların yerleştirilmesi (Değerlendirme Formu - 8)
    private void generateMines() {
        totalMines = (size / 4);
        int generatedMineCounter = 0;
        do {
            int mineXLocation = random.nextInt(rowNumber);
            int mineYLocation = random.nextInt(colNumber);

            if ((board[mineXLocation][mineYLocation]) != "*") {
                generatedMineCounter++;
                board[mineXLocation][mineYLocation] = "*";
            }
        } while (generatedMineCounter < totalMines);
    }

    //Oyunun kazanılması durumu(Değerlendirme Formu - 14)
    private void checkGameIsSuccessfullyFinished() {
        int remainingTurnCount = 0;
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                if ((map[i][j]) == "-") {
                    remainingTurnCount++;
                }
            }
        }

        // Kalan hamle sayısı tahtadaki mayın sayısıyla eşleşiyorsa oyun başarıyla bitmiştir.
        if (remainingTurnCount == totalMines) {
            isGameSuccessfullyFinished = true;
            game = false;
        }
    }

    //Hamle işlemi
    private void turn(int selectedRow, int selectedCol) {
        //Oyunun kaybedilme durumunun kontrolü (Değerlendirme Formu - 13)
        if (board[selectedRow][selectedCol] == "*") {
            game = false;
            return;
        }

        int mineCount = 0;
        //Çevresindeki mayınların kontrolü (Değerlendirme Formu - 12)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = selectedRow + i;
                int newCol = selectedCol + j;

                if (i == 0 && j == 0) {
                    continue; // Seçilen noktayı kontrol etmeden geç
                }
                //Etrafındaki noktanın tahtaya bakılarak mayın olma durumunun kontrolü
                if (isValidCoordinate(newRow, newCol) && board[newRow][newCol] == "*") {
                    mineCount++;
                }
            }
        }
        // Hamle sonrası tahtayı güncelleme (Değerlendirme Formu - 11)
        map[selectedRow][selectedCol] = String.valueOf(mineCount);
    }

    //Girilen değerin dizi sınırlarında olup olmadığı kontrolü
    private boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < rowNumber && col >= 0 && col < colNumber;
    }

    //Tahtayı mayınlarla birlikte yazdır
    private void printBoard() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                if ((board[i][j]) == "*") {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    //Akıştaki tahtayı yazdır
    private void printMap() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
