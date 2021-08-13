import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamClass {
    public static void main(String[] args) throws IOException {
        // try{
        // FileOutputStream writer=new FileOutputStream("C:\\Users\\User\\hi.txt");
        // byte[] bytes="hi how are you?".getBytes();
        // writer.write(bytes);
        // writer.close();
        // System.out.println("success");
        // }
        // catch(Exception e){
        // System.out.println(e);
        // }

        // Buffered OutputStream
        try {
            FileOutputStream writer = new FileOutputStream("hi.txt");
            BufferedOutputStream buffer = new BufferedOutputStream(writer);
            byte[] bytes = "hi,Mohan how are you? and how old are you?".getBytes();
            buffer.write(bytes);
            buffer.flush();
            buffer.close();
            writer.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
