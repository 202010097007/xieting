import java.util.Scanner;

public class ScannerUtils {

    private static final Scanner sc = new Scanner(System.in);

    public static int scanInt() {
        String ret = sc.nextLine();
        return Integer.parseInt(ret);
    }

    public static String scanString() {
        return sc.nextLine();
    }
}
