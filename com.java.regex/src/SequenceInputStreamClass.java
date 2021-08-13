import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;


public class SequenceInputStreamClass {
    public static void main(String[] args) throws IOException {

        try{
            FileInputStream reader1=new FileInputStream("C:\\Users\\User\\hi.txt");
            FileInputStream reader2=new FileInputStream("C:\\Users\\User\\hi1.txt");
            FileInputStream reader3=new FileInputStream("C:\\Users\\User\\hi1.txt");
            Vector<FileInputStream> v=new Vector<FileInputStream>();
            v.add(reader1);
            v.add(reader2);
            v.add(reader3);
            Enumeration<FileInputStream> e=v.elements();
            // FileOutputStream writer=new FileOutputStream("C:\\Users\\User\\textOut.txt");
            SequenceInputStream seqReader=new SequenceInputStream(e);
            int byteValue=seqReader.read();
            while(byteValue!=-1){
                System.out.print((char) byteValue);
                // writer.write(byteValue);
                byteValue=seqReader.read();
            }
            seqReader.close();
            reader3.close();
            reader2.close();
            reader1.close();
            // writer.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}
