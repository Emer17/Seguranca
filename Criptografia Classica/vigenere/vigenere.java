package vigenere;
import java.io.*;
import java.nio.file.*;
public class vigenere {
    public byte[] entrada;
    public vigenere(){}
    public vigenere(byte [] v){
        this.entrada = v;
    }
    public void criptografar(byte[] key) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("vigenere/outputs/out_crip.txt"));
        int a = 0;
        while(a < this.entrada.length)
            for(int k = 0; k < key.length && a < this.entrada.length; k++, a++)
                this.entrada[a] = (byte)((this.entrada[a] + key[k])%256);
        w.write(this.entrada);
        w.close();
    }
    public void descriptografar(byte [] key, byte [] entrada) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("vigenere/outputs/out_descrip.txt"));
        int a = 0;
        while(a < entrada.length)
            for(int k = 0; k < key.length && a < entrada.length; k++, a++)
                entrada[a] = (byte)((entrada[a] - key[k])%256);
        w.write(entrada);
        w.close();
    }
    public void ataqueClaro(byte[] textc){
        System.out.print("(ATAQUE CLARO) chave vigenere: ");
        for(int u = 0; u < this.entrada.length; u++)
            System.out.print((char)((byte)(this.entrada[u] - textc[u])));
        System.out.println();
    }
}
