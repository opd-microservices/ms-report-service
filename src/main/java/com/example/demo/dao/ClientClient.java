package com.example.demo.dao;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.DataElement;

@FeignClient("CLIENT")
public interface ClientClient {
	
	@GetMapping("/")
	public DataElement getData();

}
