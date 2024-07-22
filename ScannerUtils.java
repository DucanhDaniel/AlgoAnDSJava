package JustSomeAlgo;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc;

    public static void initializeScanner() {
        sc = new Scanner(System.in);
    }

    public static void closeScanner() {
        if (sc != null)
            sc.close();
    }

    public static Scanner getScanner() {
        if (sc == null) initializeScanner();
        return sc;
    }
}
