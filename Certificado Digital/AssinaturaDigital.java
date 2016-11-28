import java.security.InvalidKeyException;
  import java.security.NoSuchAlgorithmException;
  import java.security.PublicKey;
  import java.security.SignatureException;
  import java.security.SecureRandom;
   
   
  public class AssinaturaDigital {
   
         public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
             //Remetente Gera Assinatura Digital para uma Mensagem
             Remetente remetente = new Remetente();
             String mensagem = "Exemplo de mensagem.";
             byte[] assinatura = remetente.geraAssinatura(mensagem);
             PublicKey pubKey = remetente.getPubKey();	//chave publica para ser enviada ao destinatario
   
             //Destinatário recebe dados correto
             Destinatario destinatario = new Destinatario();
             destinatario.recebeMensagem(pubKey, mensagem, assinatura);
             
             //Destinatário recebe mensagem alterada
             String msgAlterada = "Exemplo de mensagem alterada.";
             destinatario.recebeMensagem(pubKey, msgAlterada, assinatura);
   
             //Criando outra Assinatura
               String mensagem2 = "Exemplo de outra mensagem.";  
             byte[] assinatura2 = remetente.geraAssinatura(mensagem2);
             PublicKey pubKey2 = remetente.getPubKey();	//outra chave publica
   
             //Testando com outra assinatura
             destinatario.recebeMensagem(pubKey, mensagem, assinatura2);
             
             //Testando com outra chave
             destinatario.recebeMensagem(pubKey2, mensagem, assinatura);
   
   
         }
         
  }
