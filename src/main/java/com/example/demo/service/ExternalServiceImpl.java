package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientClient;
import com.example.demo.dao.CouponClient;
import com.example.demo.dao.DealClient;
import com.example.demo.dao.ParAmountClient;
import com.example.demo.dao.TransactionRoleClient;
import com.example.demo.dao.TransactionTypeClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class ExternalServiceImpl implements ExternalService {

	ParAmountClient parAmountService;
	ClientClient clientService;
	TransactionTypeClient transactionTypeService;
	DealClient dealService;
	TransactionRoleClient transactionRoleService;
	CouponClient couponService;
	
	
	
	@Autowired
	public void setParAmountService(ParAmountClient parAmountService) {
		this.parAmountService = parAmountService;
	}

	@Autowired
	public void setClientService(ClientClient clientService) {
		this.clientService = clientService;
	}

	@Autowired
	public void setTransactionTypeService(TransactionTypeClient transactionTypeService) {
		this.transactionTypeService = transactionTypeService;
	}
	
	@Autowired
	public void setCouponService(CouponClient couponService) {
		this.couponService = couponService;
	}

	@Autowired
	public void setDealService(DealClient dealService) {
		this.dealService = dealService;
	}

	@Autowired
	public void setTransactionRoleService(TransactionRoleClient transactionRoleService) {
		this.transactionRoleService = transactionRoleService;
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackParAmount")
	public String getParAmount(String type)  {
		return parAmountService.getData().getString();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackClient")
	public String getClient(String type) {
		return clientService.getData().getString();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackTransactionType")
	public String getTransactionType(String type) {
		return transactionTypeService.getData().getString();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackDeal")
	public String getDeal(String type) {
		return dealService.getData().getString();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackTransactionRole")
	public String getTransactionRole(String type) {
		return transactionRoleService.getData().getString();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackCoupon")
	public String getCoupon(String type) {
		return couponService.getData().getString();
	}
	
	
	public String getFallbackCoupon(String type) {
		return "FallBack_" + type;
	}
	
	public String getFallbackTransactionRole(String type) {
		return "FallBack_" + type;
	}
	public String getFallbackDeal(String type) {
		return "FallBack_" + type;
	}
	public String getFallbackTransactionType(String type) {
		return "FallBack_" + type;
	}
	public String getFallbackClient(String type) {
		return "FallBack_" + type;
	}
	public String getFallbackParAmount(String type) {
		return "FallBack_" + type;
	}
	public String getFallbackValue(String type) {
		return "FallBack_" + type;
	}

}
