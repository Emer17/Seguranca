package substituicao;
import java.io.*;
import java.nio.file.*;
public class substituicao{
    public byte[] entrada;
    public byte[] key;
    public char[] ascii = new char[256];
    public substituicao(byte[] v) throws IOException{
        this.entrada = v;// esse é o vetor que recebe a entrada.
        this.key = Files.readAllBytes(Paths.get("keys/key1"));
        for(int a = 0; a < 256; a++)
            ascii[a] = (char) a;
    }
    public void criptografar() throws IOException{
        FileOutputStream w = new FileOutputStream(new File("substituicao/outputs/out_crip.txt"));
        for(int u = 0; u < this.entrada.length; u++)
            this.entrada[u] = this.key[(int)this.entrada[u]];
        w.write(this.entrada);
        w.close();
    }
    public void descriptografar() throws IOException{
        FileOutputStream w = new FileOutputStream(new File("substituicao/outputs/out_descrip.txt"));
        for(int u = 0; u < entrada.length; u++){
            //this.entrada[u] = (byte)this.ascii[Math.abs((int)this.entrada[u])];
        }
        w.write(this.entrada);
        w.close();
    }
}
