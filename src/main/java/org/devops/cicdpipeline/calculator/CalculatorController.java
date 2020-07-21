package org.devops.cicdpipeline.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calc")
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;

	@GetMapping(path = "/add")
	public double add(@RequestParam("a") Double a, @RequestParam("b") Double b) {
		return calculatorService.add(a,b);
	}
	
	@GetMapping(path = "/sub")
	public double sub(@RequestParam("a") Double a, @RequestParam("b") Double b) {
		return calculatorService.sub(a,b);
	}
	
	@GetMapping(path = "/mul")
	public double mul(@RequestParam("a") Double a, @RequestParam("b") Double b) {
		return calculatorService.mul(a,b);
	}
	
	@GetMapping(path = "/div")
	public double div(@RequestParam("a") Double a, @RequestParam("b") Double b) {
		return calculatorService.div(a,b);
	}
	
	@GetMapping(path = "/pow")
	public double pow(@RequestParam("a") Double a, @RequestParam("b") Double b) {
		return calculatorService.pow(a,b);
	}
	
	@GetMapping(path = "/log")
	public double log(@RequestParam("a") Double a, @RequestParam("b") Double b) {
		return calculatorService.log(a,b);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<String> handleAllExceptions(RuntimeException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
