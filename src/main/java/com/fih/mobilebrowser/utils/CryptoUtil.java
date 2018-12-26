package com.fih.mobilebrowser.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.core.io.ClassPathResource;

public class CryptoUtil {

	private RSAPrivateKey rsaPriKey;
	private RSAPublicKey rsaPubKey;
	private String pubKeyStr;

	public CryptoUtil(ClassPathResource rsaPriKeyResource, ClassPathResource rsaPubKeyResource) throws Exception {
		rsaPriKey = getPrivateKey(rsaPriKeyResource.getFile().getPath());
		rsaPubKey = getPublicKey(rsaPubKeyResource.getFile().getPath());
		pubKeyStr = base64Encode(rsaPubKey.getEncoded());
	}

	private byte[] rsaDecrypt(RSAPrivateKey priKey, byte[] srcBytes) throws Exception {

		if (priKey == null || srcBytes == null || srcBytes.length == 0) {
			return null;
		}

		byte[] resBytes = null;

		// Get an instance of Cipher based on RSA algorithm.
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		// According to the private key, initialize the Cipher object.
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		// Decrypt.
		resBytes = cipher.doFinal(srcBytes);

		return resBytes;
	}

	private byte[] aesDecrypt(SecretKey aesKey, byte[] srcBytes) throws Exception {

		if (aesKey == null || srcBytes == null || srcBytes.length == 0) {
			return null;
		}
        
		byte[] resBytes = null;

		// Get an instance of Cipher based on AES algorithm.
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		// According to the key, initialize the Cipher object.
		cipher.init(Cipher.DECRYPT_MODE, aesKey);
		// Decrypt.
		resBytes = cipher.doFinal(srcBytes);

		return resBytes;
	}

	private byte[] base64Decode(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		return Base64.getDecoder().decode(s);
	}

    private String base64Encode(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		return Base64.getEncoder().encodeToString(bytes);
    }

	private RSAPrivateKey getPrivateKey(String path) throws Exception {

		Path myPath = Paths.get(path);
		RSAPrivateKey key;

		byte[] data = Files.readAllBytes(myPath);
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(data);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		key = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);

		return key;
	}

	private SecretKey getAESKey(String srcStr) throws Exception {

		if (srcStr == null) {
			return null;
		}

		SecretKey key;

		byte[] srcBytes = base64Decode(srcStr);
		byte[] decrypedKey = rsaDecrypt(rsaPriKey, srcBytes);

		key = new SecretKeySpec(decrypedKey, "AES");

		return key;
	}

	public String getDecryptedJSONString(String srcJSONStr, String srcAESStr) throws Exception {

		SecretKey aesKey = getAESKey(srcAESStr);

		byte[] srcBytes = base64Decode(srcJSONStr);
		byte[] resultBytes = aesDecrypt(aesKey, srcBytes);

		if (srcBytes == null || resultBytes == null) {
			return null;
		}

		return new String(resultBytes, StandardCharsets.UTF_8);
	}

	private RSAPublicKey getPublicKey(String path) throws Exception {

		Path myPath = Paths.get(path);
		RSAPublicKey key;

		byte[] data = Files.readAllBytes(myPath);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(data);
		key = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);

		return key;
	}

	public String getPubKeyStr() {
		return pubKeyStr;
	}
}
