package com.example.demo.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ReportService;



@RestController
public class ReportController {
	
	private final static Logger log = LoggerFactory.getLogger(ReportController.class);

	
	@Autowired ReportService reportService;
	
	@GetMapping("/report")
	  public @ResponseBody String getSentences() {
		log.info("Going to create report ...");
		return 
				"<h3>Report</h3><br/>" +	  
				reportService.buildReport() + "<br/><br/>" +
				reportService.buildReport() + "<br/><br/>" +
				reportService.buildReport() + "<br/><br/>" +
				reportService.buildReport() + "<br/><br/>" +
				reportService.buildReport() + "<br/><br/>"
				;
	  }
}
