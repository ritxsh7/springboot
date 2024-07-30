package com.infosys.spring_rest_logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping("/")
	@ResponseBody
	public String testMethod() {
		logger.trace("this is a trace log example");
		logger.info("this is a info log example");
		logger.debug("this is a debug log example");
		logger.error("this is a error log example");
		return "Check the console logs";
	}
}
