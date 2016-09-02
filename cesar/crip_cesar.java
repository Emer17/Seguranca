import java.io.*;
import java.nio.file.*;
class crip_cesar{
    public static void main(String [] agrs) throws IOException{
        int key = 17;
        byte[] tc = Files.readAllBytes(Paths.get("1.input"));               // vetor com a entrada convertida em bytes
        FileOutputStream w = new FileOutputStream(new File("outputs/out_crip.txt"));
        for(int i = 0; i < tc.length; i++)
            tc[i] = (byte)((tc[i] + key)%256);
        w.write(tc);
        w.close();
    }
}
