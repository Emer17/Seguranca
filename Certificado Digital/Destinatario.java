import java.security.InvalidKeyException;
  import java.security.NoSuchAlgorithmException;
  import java.security.PublicKey;
  import java.security.Signature;
  import java.security.SignatureException;
  import java.security.SecureRandom;
  import java.security.KeyPair;
  import java.security.KeyPairGenerator;
   
   
  public class Destinatario{
   
         public void recebeMensagem(PublicKey pubKey, String mensagem, byte[] assinatura) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
			// Gerando nova chave
			KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();

			// Verificar assinatura
			Signature clientSig = Signature.getInstance("SHA1withRSA");  
             clientSig.initVerify(pubKey);  
             clientSig.update(mensagem.getBytes());  
               
             if (clientSig.verify(assinatura)) {  
                 //Mensagem corretamente assinada
                System.out.println("A Mensagem recebida foi assinada corretamente.");
             } else {
                 //Mensagem não pode ser validada
                System.out.println("A Mensagem recebida NÃO pode ser validada.");
             }  
         }
         
  }
