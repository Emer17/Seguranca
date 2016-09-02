import java.io.*;
import java.nio.file.*;
class descrip_vigenere{
    public static void main(String [] agrs) throws IOException{
        byte[] tc = Files.readAllBytes(Paths.get("outputs/out_crip.txt"));
        FileOutputStream w = new FileOutputStream(new File("outputs/out_descrip.txt"));
        byte[] chave = "abcd".getBytes();// chave em string passando para um vetor de bytes
        int a = 0;
        while(a < tc.length)
            for(int k = 0; k < chave.length && a < tc.length; k++, a++)
                tc[a] = (byte)((tc[a] - chave[k])%256);
        w.write(tc);
        w.close();
    }
}
