import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamClass {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream reader=new FileInputStream("C:\\Users\\User\\hi.txt");
            DataInputStream dataReader=new DataInputStream(reader);
            byte[] value=new byte[dataReader.available()];
            dataReader.read(value);
            for(byte letter: value){
                System.out.print((char)letter);
            }
            dataReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
