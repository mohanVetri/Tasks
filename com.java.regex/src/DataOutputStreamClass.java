import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamClass {
    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream writer =new FileOutputStream("C:\\Users\\User\\dataOutput.txt");
            DataOutputStream dataWriter=new DataOutputStream(writer);
            dataWriter.write(65);
            dataWriter.flush();
            dataWriter.close();
            // writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
