import java.util.Scanner;

/**
 * @className: ScanUtil
 * @description: util class to read user input
 * @author: Yan Tong
 **/
public class ScanUtil {
    private static Scanner sc = new Scanner(System.in);

    // scan int element from [low, high]
    public static int scanInt(int low, int high) {
        while (true) {
            if (sc.hasNext()) {
                int num = sc.nextInt();
                if (low == Integer.MIN_VALUE && high == Integer.MAX_VALUE) {
                    return num;
                }
                if (low == Integer.MIN_VALUE) {
                    if (num > high) {
                        System.out.printf("invalid. please input number <= %d:\n", high);
                        continue;
                    }
                } else if (high == Integer.MAX_VALUE) {
                    if (num < low) {
                        System.out.printf("invalid. please input number >= %d:\n", low);
                        continue;
                    }
                } else {
                    if (num < low || num > high) {
                        System.out.printf("invalid. please input number from %d--%d\n", low, high);
                        continue;
                    }
                }
                return num;
            }
        }
    }


    public static String scanString() {
        System.out.print("please enter: ");
        while (true) {
            if (sc.hasNext()) {
                String s = sc.next();
                return s;
            }
        }
    }
}
