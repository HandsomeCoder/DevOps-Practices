package org.devops.cicdpipeline.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public double add(Double a, Double b) {
		return a+b;
	}

	public double sub(Double a, Double b) {
		return a-b;
	}

	public double mul(Double a, Double b) {
		return a*b;
	}

	public double div(Double a, Double b) {

			return a/b;		
		
	}

	public double pow(Double a, Double b) {
		return Math.pow(a, b);
	}

	public double log(Double a, Double b) {
		return Math.round(Math.log(a)/Math.log(b));
	}

}
