package com.tensquare.encrypt.service;

import java.util.HashMap;

/**
 * 
* @ClassName: RsaService
* @Description: rsa加密解密服务接口
* @author 李建
* @date 2018年6月21日 下午3:27:34
*
 */
public interface RsaService {
	
	/***
     * RSA解密
     *
     * @param encryptData
     * @return
     * @throws Exception
     */
	public String RSADecryptDataPEM(String encryptData, String prvKey) throws Exception;
	
	/***
     * RSA解密
     *
     * @param encryptBytes
     * @return
     * @throws Exception
     */
	public String RSADecryptDataBytes(byte[] encryptBytes, String prvKey) throws Exception;
    
    /***
     * RSA加密
     *
     * @param data
     * @return
     * @throws Exception
     */
	public String RSAEncryptDataPEM(String data, String pubKey) throws Exception;
	
	public String getRsaAlgorithm();
}
