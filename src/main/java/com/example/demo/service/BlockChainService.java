package com.example.demo.service;

import org.web3j.crypto.Credentials;

public interface BlockChainService {
	Credentials connectToEthereum(); 
    void deploySmartContract();
}
