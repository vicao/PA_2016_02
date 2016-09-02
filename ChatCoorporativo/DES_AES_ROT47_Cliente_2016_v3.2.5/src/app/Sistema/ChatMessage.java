package app.Sistema;

import java.io.Serializable;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author Vinicius Dutra Cerqueira Rocha - 315112918
 *
 * @version 5.0
 *
 */
public class ChatMessage implements Serializable {

    private String name;
    private String text;

    /*
     Variaveis usadas na Criptografia
     bytetxt -> texto criptografado em DES
     tpCrypt -> tipo de criptografia escolhido;
     chaveDES -> Chave utilizada para criptografar e descriptografar
     keygenerator -> Chave gerada aleatoriamente
     isGenaratedKey -> variavel auxiliar para validar se a chave de criptografia foi gerada.
    
     */
    private byte[] bytetxt;
    private int tpCrypt = 0;
    private KeyGenerator keygenerator = null;
    private boolean isGenaratedKey = false;
    private String nameReserved;
    private Set<String> setOnlines = new HashSet<String>();
    private Action action;
    
    //AES
    private String chaveAES = null;
    //----------------------------------

    //DES CBC
    private IvParameterSpec iv;
    private SecretKey chaveDESCBC = null;
    private SecretKey chaveDES = null;
    //----------------------------------

    //RSA
    public static RSAPrivateKey chavePrivadaRSA;
    public static RSAPublicKey chavePublicaRSA;



    public boolean isIsGenaratedKey() {
        return isGenaratedKey;
    }

    public void setIsGenaratedKey(boolean isGenaratedKey) {
        this.isGenaratedKey = isGenaratedKey;
    }

    public SecretKey getChaveDES() {
        return chaveDES;
    }

    public void setChaveDES(SecretKey chaveDES) {
        this.chaveDES = chaveDES;
    }

    public SecretKey getChaveDESCBC() {
        return chaveDESCBC;
    }

    public void setChaveDESCBC(SecretKey chaveDESCBC) {
        this.chaveDESCBC = chaveDESCBC;
    }

    public KeyGenerator getKeygenerator() {
        return keygenerator;
    }

    public void setKeygenerator(KeyGenerator keygenerator) {
        this.keygenerator = keygenerator;
    }

    public int getTpCrypt() {
        return tpCrypt;
    }

    public void setTpCrypt(int tpCrypt) {
        this.tpCrypt = tpCrypt;
    }

    public String getName() {
        return name;
    }

    public byte[] getBytetxt() {
        return bytetxt;
    }

    public void setBytetxt(byte[] bytetxt) {
        this.bytetxt = bytetxt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNameReserved() {
        return nameReserved;
    }

    public void setNameReserved(String nameReserved) {
        this.nameReserved = nameReserved;
    }

    public Set<String> getSetOnlines() {
        return setOnlines;
    }

    public void setSetOnlines(Set<String> setOnlines) {
        this.setOnlines = setOnlines;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getChaveAES() {
        return chaveAES;
    }

    public void setChaveAES(String chaveAES) {
        this.chaveAES = chaveAES;
    }

    public IvParameterSpec getIv() {
        return iv;
    }

    public void setIv(IvParameterSpec iv) {
        this.iv = iv;
    }

    public static RSAPrivateKey getChavePrivadaRSA() {
        return chavePrivadaRSA;
    }

    public static void setChavePrivadaRSA(RSAPrivateKey chavePrivadaRSA) {
        ChatMessage.chavePrivadaRSA = chavePrivadaRSA;
    }

    public static RSAPublicKey getChavePublicaRSA() {
        return chavePublicaRSA;
    }

    public static void setChavePublicaRSA(RSAPublicKey chavePublicaRSA) {
        ChatMessage.chavePublicaRSA = chavePublicaRSA;
    }

        @Override
    public String toString() {
        return "ChatMessage{" + "name=" + (name.isEmpty() ? "Vazio" : name)+ "\n, text=" + (text.isEmpty() ? "Vazio" : text) + 
                "\n, bytetxt=" + (bytetxt.toString().isEmpty() ? "Vazio" : bytetxt) + 
                "\n, tpCrypt=" + (new String().valueOf(tpCrypt).isEmpty() ? "Vazio" : tpCrypt) + 
                "\n, keygenerator=" + (keygenerator.toString().isEmpty() ? "Vazio" : keygenerator) + 
                "\n, isGenaratedKey=" + (isGenaratedKey ? "Verdadeiro" : "Falso") + 
                "\n, nameReserved=" + (nameReserved.isEmpty() ? "Vazio" : nameReserved)+ 
                "\n, action=" + action + 
                "\n, chaveAES=" +( chaveAES.toString().isEmpty() ? "Vazio" :  chaveAES)+ 
                "\n, iv=" + (iv.toString().isEmpty() ? "Vazio" : iv) + 
                "\n, chaveDESCBC=" + ( chaveDESCBC.toString().isEmpty() ? "Vazio" :  chaveDESCBC) + 
                "\n, chaveDES=" + ( chaveDES.toString().isEmpty() ? "Vazio" :  chaveDES) + '}';
    }
    
    
    /*
    
     Enum contendo as acoes diponiveis,
     Connect
     Disconnect,
     SEND_ONE,
     SEND_ALL
     USERS_ONLINE
    
     */
    public enum Action {

        CONNECT, DISCONNECT, SEND_ONE, SEND_ALL, USERS_ONLINE
    }
}
