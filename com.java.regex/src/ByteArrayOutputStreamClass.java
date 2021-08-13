import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ByteArrayOutputStreamClass {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream reader=new FileInputStream("C:\\Users\\User\\hi.txt");
            FileOutputStream writer1=new FileOutputStream("C:\\Users\\User\\textout1.txt");
            FileOutputStream writer2=new FileOutputStream("C:\\Users\\User\\textout2.txt");
            ByteArrayOutputStream byteArrayWriter=new ByteArrayOutputStream();
            int byteValue=reader.read();
            while(byteValue!=-1){
                byteArrayWriter.write(byteValue);
                byteValue=reader.read();
            }
            byteArrayWriter.writeTo(writer1);
            byteArrayWriter.writeTo(writer2);
            byteArrayWriter.close();
            writer1.close();
            writer2.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
                }
    }
}
