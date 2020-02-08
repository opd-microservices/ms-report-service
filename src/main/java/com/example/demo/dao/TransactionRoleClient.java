package com.example.demo.dao;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.DataElement;

@FeignClient("TRANSACTIONROLE")
public interface TransactionRoleClient {
	
	@GetMapping("/")
	public DataElement getData();
}
