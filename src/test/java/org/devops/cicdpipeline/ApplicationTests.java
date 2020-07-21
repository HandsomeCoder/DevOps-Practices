package org.devops.cicdpipeline;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.devops.cicdpipeline.calculator.CalculatorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private CalculatorService calculatorService;
	
	@BeforeAll
	private static void init() {
	
	}

	@Test
	void contextLoads() {
		assertThat(calculatorService).isNotNull();
	}
	
	@Test
	public void testAdd() {	
		assertEquals(60.0, calculatorService.add(20.0,40.0));
	}
	
	@Test
	public void testSub() {	
		assertEquals(10.0, calculatorService.sub(20.0, 10.0));
	}
	
	@Test
	public void testMul() {	
		assertEquals(900.0, calculatorService.mul(10.0,90.0));
	}
	
	@Test
	public void testDiv() {	
		assertEquals(30.0, calculatorService.div(300.0,10.0));
	}
	
	@Test
	public void testPow() {	
		assertEquals(16.0, calculatorService.pow(2.0,4.0));
	}
	
	@Test
	public void testLog() {	
		assertEquals(3.0, calculatorService.log(1000.0, 10.0));
	}
	
	@Test
	public void testEquation1() {
		double add = calculatorService.add(10.0, 10.0);
		double mul = calculatorService.mul(add, 10.0);
		double div = calculatorService.div(mul, 10.0);
		assertEquals(20.0, div);
	}
	
	@Test
	public void testEquation2() {
		double a = 60;
		double mul = calculatorService.mul(a, 10.0);
		double div = calculatorService.div(mul, 10.0);
		assertEquals(a, div);
	}
	
	@Test
	public void testEquation3() {
		double a = 10.0;
		double b = 3.0;
		double pow = calculatorService.pow(a, b);
		double log = calculatorService.log(pow, a);
		assertEquals(log, b);
	}

}
