package ec.edu.utpl.adopcionmascotas.controlador;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase de Gestion de Cifrado AES
 * 
 * @author Grupo 3 - Ingeniería de Software
 * @version 1.0
 */
public class CifradoAes {
   
    private static final String SEGURITY_PROPERTIES = "SECURITY.properties";
    private Utilitarios util;
    private String encoding;
    private String salt;
    private String algoritmo;
    private String transformacion;
    private String key;
    private String mode;
    private String padding;
    private Integer bits;
    
    public CifradoAes (){
        
        this.util = new Utilitarios();
        this.salt = util.getPropiedad("security.salt", SEGURITY_PROPERTIES);
        this.encoding = util.getPropiedad("security.encoding", SEGURITY_PROPERTIES);
        this.key = util.getPropiedad("security.key", SEGURITY_PROPERTIES);
        this.mode = util.getPropiedad("security.mode", SEGURITY_PROPERTIES);
        this.padding = util.getPropiedad("security.padding", SEGURITY_PROPERTIES);
        this.algoritmo = util.getPropiedad("security.algorithm", SEGURITY_PROPERTIES);
        this.bits = Integer.parseInt(util.getPropiedad("security.bits", SEGURITY_PROPERTIES));
        this.transformacion = String.format("%s/%s/%s", algoritmo, mode, padding);
    }
 
     /**
     * Crea la clave de encriptacion usada internamente
     * @param clave Clave que se usara para encriptar
     * @return Clave de encriptacion
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException 
     */
    private SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        
        byte[] claveEncriptacion = clave.getBytes(encoding);  
        MessageDigest sha = MessageDigest.getInstance(key); 
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, bits);
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, algoritmo);
        return secretKey;
    }
    /**
     * Aplica la encriptacion AES a la cadena de texto usando la clave indicada
     * @param datos Cadena a encriptar
     * @return Información encriptada
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public String encriptar(String datos) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        SecretKeySpec secretKey = this.crearClave(salt); 
        Cipher cipher = Cipher.getInstance(transformacion);        
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] datosEncriptar = datos.getBytes(encoding);
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
        return encriptado;
    }
 
    /**
     * Desencripta la cadena de texto indicada usando la clave de encriptacion
     * @param datosEncriptados Datos encriptados
     * @return Informacion desencriptada
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public String desencriptar(String datosEncriptados) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        SecretKeySpec secretKey = this.crearClave(salt);
        Cipher cipher = Cipher.getInstance(transformacion);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        String datos = new String(datosDesencriptados);         
        return datos;
    }
}