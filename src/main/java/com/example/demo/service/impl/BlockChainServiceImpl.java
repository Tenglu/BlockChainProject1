package com.example.demo.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.example.demo.service.BlockChainService;
@Service
public class BlockChainServiceImpl implements BlockChainService{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	String file="UTC--2018-08-29T06-23-51.856192135Z--294b3934ca1eface929f6850c77074499a778b07";
	String dir="/home/blockchain/Blockchain/geth/data/keystore";
	@Override
	public Credentials connectToEthereum() {
		  // defaults to http://localhost:8545/
		Credentials credentials=null;
		try {
			credentials = WalletUtils.loadCredentials("123", dir+"/"+file);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CipherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credentials;
	}
	@Override
	public void deploySmartContract(){
		
	}

}
