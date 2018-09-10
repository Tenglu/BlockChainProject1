package com.example.demo.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import com.example.demo.contract.InfoUtil;
import com.example.demo.service.BlockChainService;

import com.example.demo.contract.Contract3;
import com.example.demo.contract.Contract3;

@Controller
@RequestMapping("/BC")
public class BlockChainController {
	String file="UTC--2018-09-04T09-03-23.515793222Z--dedbba016ca1e4ab64452199667eb04dd17d86fa";
	String dir="/home/blockchain/Blockchain/geth/data/keystore";
	private final Logger logger = LoggerFactory.getLogger(getClass());
	Web3j web3j = Web3j.build(new HttpService());

	Credentials credentials;
	String contractAddress="0xa789f2dfc038d53ffbcede80219010a5239f686f";
	@Autowired
	BlockChainService bcService;
	
	@RequestMapping("/login")
	public ModelAndView index(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
		
	}
	
	@RequestMapping("/index")
	public ModelAndView index2(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		return mav;
		
	}
	@RequestMapping("/info")
	public void checkInfo(){
		try {
			System.out.println("web3j.ethBlockNumber()"+web3j.ethBlockNumber().sendAsync().get());
			System.out.println("web3j.ethMining()"+web3j.ethMining().sendAsync().get());
			System.out.println("web3j.ethAccounts()"+web3j.ethAccounts().sendAsync().get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@RequestMapping("/checkConnection")
	public String checkConnection(){
		Web3ClientVersion web3ClientVersion = null;
		try {
			
			web3ClientVersion = web3j.web3ClientVersion().sendAsync().get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
		return clientVersion;
	}
	
	@RequestMapping("/connect")
	public @ResponseBody String connectEthereum(){
		System.out.println(">>>>>Start to connect Ethereum");
		credentials=bcService.connectToEthereum();
		System.out.println(">>>>>Finish to connect Ethereum");
		return credentials.getAddress();
		
	}

	@RequestMapping("/callContract")
	public @ResponseBody String callContract(){
		System.out.println(">>>>>Start to callContract");
		Web3j web3j = Web3j.build(new HttpService());
		Credentials credentials;
		try {
			credentials = WalletUtils.loadCredentials("123", dir+"/"+file);

			
			Contract3 contract3=Contract3.load(contractAddress, web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);
			
			System.out.println("Contract3.getContractAddress():"+contract3.getContractAddress());
			
			
			System.out.println("contract3.getTransactionReceipt():"+contract3.getTransactionReceipt());
			System.out.println("contract3.get().send():"+contract3.get().send());
			System.out.println("contract3.set().send():"+contract3.set(BigInteger.valueOf(1)).send());
			System.out.println("contract3.get().send():"+contract3.get().send());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contractAddress;
	
	}
	

	/**
	@RequestMapping("/deployContract3")
	public @ResponseBody String deployContract3()
	{
		System.out.println(">>>>>Start to deploy contract");
		try {
			Web3j web3j = Web3j.build(new HttpService());
			Credentials credentials = WalletUtils.loadCredentials("123", dir+"/"+file);
			
			//Get account balance
			String address="0x294b3934ca1eface929f6850c77074499a778b07";
			EthGetBalance ethGetBalance= web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
			System.out.println(">>>>>>Account Balance:");
			if(ethGetBalance!=null){
				System.out.println(ethGetBalance.getBalance());
				System.out.println(Convert.fromWei(ethGetBalance.getBalance().toString(), Convert.Unit.ETHER));

			}
			
			Contract3 contract = Contract3.deploy(web3j,credentials ,DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT).send();
			contractAddress=contract.getContractAddress();
			System.out.println("contract.isValid():"+contract.isValid());	
			System.out.println("DefaultGasProvider.GAS_PRICE:"+DefaultGasProvider.GAS_PRICE);
			System.out.println("DefaultGasProvider.GAS_LIMIT:"+DefaultGasProvider.GAS_LIMIT);
			System.out.println(">>>>>>>>>Contract address: "+contractAddress);
			System.out.println(">>>>>>>>>credentials address: "+credentials.getAddress());
			System.out.println("contract.getTransactionReceipt():"+contract.getTransactionReceipt());
			
				
			Contract3 contract3=Contract3.load(contractAddress, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
			System.out.println("Contract3.getContractAddress():"+contract3.getContractAddress());
			
			contract3.add("TEST").send();
			System.out.println("Contract3.get().send():"+contract3.getStrAt(BigInteger.valueOf(1)).send());
			
			
			
			System.out.println(">>>>>Finish to deploy contract");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contractAddress;
		
	}
	**/
	

	
	@RequestMapping("/invoke")
	public @ResponseBody String invokeContract(){
		System.out.println(">>>>>Start to Invoke Contrack");
		Object a = null;
		try {
			System.out.println(">>>>>>>>>Contrack address: "+contractAddress);
			System.out.println(">>>>>>>>>credentials address: "+credentials.getAddress());
			InfoUtil contract=InfoUtil.load(contractAddress, web3j, credentials, BigInteger.valueOf(200000), BigInteger.valueOf(20000000));
			if(contract.isValid()){
				contract.set(BigInteger.valueOf(12345)).send();
				a=contract.get().send();
				System.out.println(">>>>>>>>>>Get Contract Integer:"+a.toString());
			}else{
				System.out.println(">>>>>>>Contract is not valid!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a.toString();
	}
	
	

}
