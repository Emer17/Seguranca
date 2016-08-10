import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec; 
import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
   
public class AES {       
	static String IV = "G1c7zp9e32Fs4qMx"; //16
	static String textopuro; //qualquer tamanho
	static String chaveencriptacao = "Tw98Y4zj5ls7&3as";  //16
	
	public static void main(String [] args) {
		Scanner ler = new Scanner(System.in);
		System.out.printf("Informe o nome de arquivo texto:\n");
		String nome = ler.nextLine();
 
    try {
      FileReader arq = new FileReader(nome);
      BufferedReader lerArq = new BufferedReader(arq);
      String linha = lerArq.readLine(); // lê a primeira linha
	  textopuro = linha;
	  
	  //System.out.printf("\nConteúdo do arquivo texto:\n");
      while (linha != null) {
        //System.out.printf("%s\n", linha);
        linha = lerArq.readLine(); // lê da segunda até a última linha
        if(linha != null) textopuro += "\n"+linha;
      }
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
		try { 
			System.out.println("Texto Puro      : " + textopuro + "\n");                       
			byte[] textoencriptado = encrypt(textopuro, chaveencriptacao);                      
			System.out.print("Texto Encriptado: ");  
			for (int i=0; i<textoencriptado.length; i++)
				 System.out.print(new Integer(textoencriptado[i])+" ");                     
			System.out.println("\n");                     
			String textodecriptado = decrypt(textoencriptado, chaveencriptacao);                     
			System.out.println("Texto Decriptado: " + textodecriptado);              
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	   
	public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
		Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
		return encripta.doFinal(textopuro.getBytes("UTF-8"));
	}   
	
	public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception{
		Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(decripta.doFinal(textoencriptado),"UTF-8");
	}
}
