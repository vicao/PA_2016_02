package criptografia;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

/**
 * Classe de criptografia RSA
 */
public class Cifrarsa {
	
	public static RSAPrivateKey chavePrivadaRSA;
        public static RSAPublicKey chavePublicaRSA;
    
    public static void main(String[] args) {
        try {
            Cifrarsa encrypt = new Cifrarsa();

            String encryptText = "Ola mundo!";

            KeyPair ParChaves = GeraChavesRSA();



            byte[] e = encrypt.encryptRSA(chavePublicaRSA, encryptText.getBytes());
            byte[] de = encrypt.decryptRSA(chavePrivadaRSA, e);
            System.out.println("*************RSA******************");
            System.out.println("Texto Claro : " + encryptText);
            System.out.println(encrypt.bytesToString(e));
            System.out.println("*************RSA******************");
            System.out.println("Decifrado : " + encrypt.bytesToString(de));
        } catch (Exception e) {
            e.printStackTrace();
       	}
	}

	/**
	 * Byte array para string
	 * @param encrytpByte
	 * @return
	 */
	public String bytesToString(byte[] encrytpByte) {
		String result = "";
		for (Byte bytes : encrytpByte) {
			result += (char) bytes.intValue();
		}
		return result;
	}

	/**
	 * O m�todo de criptografia
	 * @param publicKey
	 * @param obj
	 * @return
	 */
	public byte[] encryptRSA(RSAPublicKey publicKey, byte[] obj) {
		if (publicKey != null) {
			try {
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				return cipher.doFinal(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * O m�todo de decifra��o
	 * @param privateKey
	 * @param obj
	 * @return
	 */
	public byte[] decryptRSA(RSAPrivateKey privateKey, byte[] obj) {
		if (privateKey != null) {
			try {
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				return cipher.doFinal(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
        
    public static KeyPair GeraChavesRSA() {
        KeyPairGenerator keyPairGen = null;
        KeyPair keyPair = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA"); //Seleciona o modo de trabalho de criptografia
            keyPairGen.initialize(1024); //Inicializa o par de chaves em 1024

            keyPair = keyPairGen.generateKeyPair();//Gera Par de chaves

            /*Generate keys*/
            chavePrivadaRSA = (RSAPrivateKey) keyPair.getPrivate(); // A chave Privada
            chavePublicaRSA = (RSAPublicKey) keyPair.getPublic(); // A chave p�blica
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Cifrarsa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return keyPair;
    }
    
    
    
}