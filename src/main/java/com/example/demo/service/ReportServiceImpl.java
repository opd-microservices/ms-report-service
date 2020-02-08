package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReportServiceImpl implements ReportService {
	
	private final static Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

	@Autowired
	ExternalService externalService;
	
	@Override
	public String buildReport() {
		
		log.info("Going to invoke feign clients ....");
		String reportData = "There was a problem assembling the report!";
		reportData =  
			String.format("%s Deal (%s) belongs to %s has Par Amount of $%s at %s percent Coupon in which TheBank plays %s.",
					externalService.getTransactionType("TransactionType"),
					externalService.getDeal("Deal"),
					externalService.getClient("Client"),
					externalService.getParAmount("ParAmount"),
					externalService.getCoupon("Coupon"),				
					externalService.getTransactionRole("TransactionRole") );
		log.info("Invoked all feign clients ....");
		//reportData =  dealService.getData().getString();
		return reportData;
	}
	
	
}
