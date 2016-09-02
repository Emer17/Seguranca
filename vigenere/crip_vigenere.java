import java.io.*;
import java.nio.file.*;
class crip_vigenere{
    public static void main(String [] agrs) throws IOException{
        byte[] tc = Files.readAllBytes(Paths.get("1.input"));
        FileOutputStream w = new FileOutputStream(new File("outputs/out_crip.txt"));
        byte[] chave = "abcd".getBytes();
        int a = 0;
        while(a < tc.length)
            for(int k = 0; k < chave.length && a < tc.length; k++, a++)
                tc[a] = (byte)((tc[a] + chave[k])%256);
        w.write(tc);
        w.close();
    }
}
