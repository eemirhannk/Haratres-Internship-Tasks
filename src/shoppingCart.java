import java.util.*;

public class shoppingCart {
    public void chart() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dizi boyutunu girin: ");
        int size = scanner.nextInt();

        int[] A = new int[size];
        System.out.println("Dizi elemanlarını girin:");
        for (int i = 0; i < size; i++) {

            // bu for döngüsü kullanıcıdan aldığı her girdi için 2000-0 aralığında olup olmadığının kontrolünü sağlar. Eğer;
            // girilen değer bu aralıkta ise arraye kaydedip yeni değer ister. Eğer;
            // girilen değer bu aralıkta değil ise değer girildiği anda konsola exception atıp kendisini durdurur.
            // Durdurması istenmiyorsa basit bir continue eklemesiyle o zamana kadar girilen değerlerle algoritmanın çalışması sağlanabilir.
            A[i] = scanner.nextInt();
            if(A[i] > 2000 || A[i] < 0){
                throw new Exception("Invalid input: Input must be between 0 and 2000.");
            }
        }
        //         5  2  1  3  4  debug için kendim yazdım koddan bağımsız.

        // arrayin uzunluğu 1-100 arasında değilse konsola exception atar.
        if (A.length < 1 || A.length > 100) {
            throw new Exception("Invalid input: Arrays length must be between 1 and 1000.");
        }
        int[] B = new int[A.length];
        int totalCost = 0;
        List<Integer> C = new ArrayList<Integer>();

        B[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            B[i] = A[i];
            if (A[i-1] > A[i]) {
                int discount = A[i];
                B[i - 1] -= discount;
            }
        }
        for (int i = 0; i < A.length; i++) {
            totalCost += B[i];
            if (B[i] == A[i]) {
                C.add(A[i]);
            }
        }

        Collections.sort(C);
        System.out.println("Toplam tutar: " + (totalCost));
        System.out.print("İndirim yapılmayan kalemler, C = {");
        for (int i = 0; i < C.size(); i++) {
            System.out.print(C.get(i));
            if (i != C.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
