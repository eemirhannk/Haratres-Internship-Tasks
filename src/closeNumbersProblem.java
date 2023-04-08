import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class closeNumbersProblem {
    public static String[] findClosestNumbers(int[] arr) throws Exception {

        // arrayin 1000 - 1 aralığında olmasını kontrol eder.Değilse konsola exception gönderir.
        if (arr.length > 1000 || arr.length < 1 ) {
            throw new Exception("Invalid input: Array length must be between 1 and 1000.");
        }
        Arrays.sort(arr); // arrayi küçükten büyüğe sıralar.
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i+1]); // kütüphane kullanıldı.
            if (diff < minDiff && diff != 0) {
                minDiff = diff;
            }
        }
        List<String> closestPairs = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if (diff == minDiff) {
                closestPairs.add(arr[i] + " " + arr[i+1]);
            }
        }
        String[] result = new String[closestPairs.size()];
        result = closestPairs.toArray(result);
        return result;
    }

    // Girdilerin 20.000 -20.000 aralığında olup olmadığını kontrol eden fonksiyon.
    public static boolean isWithinRange(int[] arr) {
        for (int num : arr) {
            if (num < -20000 || num > 20000) {
                return false;
            }
        }
        return true;
    }
    public void numberFinder() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Diziniz kaç elemandan oluşsun? : ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Dizinin elemanlarını girin :");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        if (!isWithinRange(arr)) {
            throw new IllegalArgumentException("Array values must be between -20000 and 20000");
        }

        String[] result = findClosestNumbers(arr);
        System.out.println(Arrays.toString(result)); // ["12 15", "32 35"]
    }

    public static void main(String[] args) {

    }

}
