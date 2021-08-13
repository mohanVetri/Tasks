import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    static String word;

    public static void main(String[] args) {
        try {
            // ArithmeticException
            int numerator = 20, denominator = 0;
            int result = numerator / denominator;
            System.out.println(result);

            // NullPointException
            word = null;
            System.out.println(word.charAt(1));

            // InpuMismatchException
            Scanner input = new Scanner(System.in);
            int no = input.nextInt();
            System.out.println(no);
            input.close();

            // NumberFormatException
            String alpha = "hi";
            int num = Integer.parseInt(alpha);
            System.out.println(num);

            // ArrayIndexOutOfBoundsException
            int[] age = { 2, 3, 3 };
            for (int i = 0; i <= age.length; i++) {
                System.out.println(age[i]);
            }

            // IOException
            File file = new File("C:\\Users\\User\\hi.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            int words = 0;
            while (words != -1) {
                System.out.print((char) words);
                words = fileInputStream.read();
            }
            fileInputStream.close();
        }
         catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
