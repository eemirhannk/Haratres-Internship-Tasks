import java.util.Scanner;

public class mergeString {
    public StringBuilder stringBirlestir(String a, String b) throws Exception {
        if (a.length() < 1 || a.length() > 2500 || b.length() < 1 || b.length() > 2500) {
            throw new Exception("Invalid input: String lengths must be between 1 and 2500.");
        }
        StringBuilder sb = new StringBuilder();
        if(a.length()>b.length()) {
            for (int i = 0; i < b.length(); i++) {
                sb.append(a.charAt(i));
                sb.append(b.charAt(i));
            }
        }
        else {
            for (int i = 0; i < a.length(); i++) {
                sb.append(a.charAt(i));
                sb.append(b.charAt(i));
            }
        }

        return sb;
    }
    public void mergeString() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("İlk parametreyi girin: ");
        String a = scanner.nextLine();
        System.out.print("İkinci parametreyi girin: ");
        String b = scanner.nextLine();
        String output = String.valueOf(stringBirlestir(a, b));
        System.out.println(output);

    }

    public static void main(String[] args) {

    }
}
