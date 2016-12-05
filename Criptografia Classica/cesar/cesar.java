package cesar;
import java.io.*;
import java.nio.file.*;
public class cesar{
    public byte[] entrada;
    public cesar(){}
    public cesar(byte [] v){
        this.entrada = v;
    }
    public void criptografar(int key) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("cesar/outputs/out_crip.txt"));
        for(int i = 0; i < this.entrada.length; i++)
            this.entrada[i] = (byte)(( this.entrada[i] + key)%256);
        w.write(this.entrada);
        w.close();
    }
    public void descriptografar(int key, byte[] entrada) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("cesar/outputs/out_descrip.txt"));
        for(int i = 0; i < entrada.length; i++)
            entrada[i] = (byte)(( entrada[i] - key)%256);
        w.write(entrada);
        w.close();
    }
    public void ataqueClaro(byte textn){
        System.out.println("(ATAQUE CLARO) chave cesar: " + ((int) this.entrada[0] - textn));
    }
}
