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
    public String[] ataqueEscuro(int key, byte[] textc, int op) throws IOException{
        for(int i = 0; i < textc.length; i++)
            textc[i] = (byte)(( textc[i] - key)%256);
        if(op == 1) return new String(textc, "UTF-8").toLowerCase().split(" ");//OP 1: 75% de acerto, bem mais rápido.
        else return new String(textc, "UTF-8").replaceAll("[^a-zA-Z1-9 ]", " ").toLowerCase().split(" ");//OP 2: 90% de acerto, porem mais lento.
    }
    public void ataqueClaro(byte textn){
        System.out.println("(ATAQUE CLARO) chave cesar: " + ((int) this.entrada[0] - textn));
    }
}
