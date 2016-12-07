package transposicao;
import java.io.*;
import java.nio.file.*;
public class transposicao{
    public byte[] entrada; //começa como entrada mas depois vira o texto criptografado
    public int linhas, colunas;
    public String local_crip = "transposicao/outputs/out_crip.txt";
    public String local_descrip = "transposicao/outputs/out_descrip.txt";
    public transposicao(){}
    public transposicao(byte[] v, int chave) throws IOException{
        this.colunas = chave;// a chave é o numero de colunas
        this.linhas = v.length/this.colunas;
        this.entrada = v;//Cria matriz normal
    }
    public byte[][] criarMatriz(byte[] textn){
        if((textn.length % this.colunas) != 0) this.linhas++;
        byte[][] aux = new byte[this.colunas][this.linhas];
        for(int l = 0, b = 0; l < this.linhas; l++)
            for(int c = 0; c < this.colunas && b < textn.length; c++, b++)
                aux[c][l] = textn[b]; //variavel b anda pelo vetor de entrada, para colocar os valores na matriz
        return aux;
    }
    public byte[] transposta(byte[][] matriz_ent) {//recebe a matriz, escreve a transposta em um array de bytes, retornando esse array.
        byte[] aux = new byte[this.linhas*this.colunas];
        for(int c = 0, a = 0; c < this.colunas; c++)
            for(int l = 0; l < this.linhas && a < aux.length; l++, a++)//fazendo a transposta, primeiro escreve as linhas.
                aux[a] = matriz_ent[c][l];
        return aux;
    }
    public void criptografar() throws IOException{
        FileOutputStream w = new FileOutputStream(new File(local_crip));
        this.entrada = transposta(criarMatriz(this.entrada));
        w.write(this.entrada);
        w.close();
    }
    public void descriptografar(int chave, byte[] entrada) throws IOException{
        FileOutputStream w = new FileOutputStream(new File(local_descrip));
        this.linhas = chave;// pra descriptografar, é o processo contrario a chave vira as linhas.
        this.colunas = entrada.length/this.linhas;
        w.write(transposta(criarMatriz(entrada)));//Primeiro cria a matriz, dps faz a transposta da transpota, que é a propria matriz original
        w.close();
    }
    public void ataqueClaro(){
        System.out.println("(ATAQUE CLARO) chave transposicao: " + criarMatriz(this.entrada).length);
    }
}