import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamClass {
    public static void main(String[] args) throws IOException {
        // try{
        //     FileInputStream reader=new FileInputStream("C:\\Users\\User\\hi.txt");
        //     int byteValue=reader.read();
        //     while(byteValue!=-1){
        //         System.out.print((char) byteValue);
        //         byteValue=reader.read();
        //     }
        //     reader.close();
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }

        try{
            FileInputStream reader=new FileInputStream("hi.txt");
            BufferedInputStream buffer=new BufferedInputStream(reader);
            int byteValue=buffer.read();
            while(byteValue!=-1){
                System.out.print((char) byteValue);
                byteValue=buffer.read();
            }
            buffer.close();
            reader.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
