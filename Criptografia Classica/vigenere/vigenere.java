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
	public String[] ataqueEscuro(byte[] key, byte[] textc, int op) throws IOException{
        int a = 0;
        while(a < textc.length)
            for(int k = 0; k < key.length && a < textc.length; k++, a++)
                textc[a] = (byte)((textc[a] - key[k])%256);
        if (op == 1) return new String(textc, "UTF-8").toLowerCase().split(" ");//OP 1: 75% de acerto, bem mais rápido.
        else return new String(textc, "UTF-8").replaceAll("[^a-zA-Z1-9 ]", " ").toLowerCase().split(" ");//OP 2: 90% de acerto, porem mais lento.
    }
    public void ataqueClaro(byte[] textc){
        System.out.print("(ATAQUE CLARO) chave vigenere: ");
        for(int u = 0; u < this.entrada.length; u++)
            System.out.print((char)((byte)(this.entrada[u] - textc[u])));
        System.out.println();
    }
}
