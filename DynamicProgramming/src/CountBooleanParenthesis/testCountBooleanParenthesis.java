package CountBooleanParenthesis;

import org.junit.Test;

public class testCountBooleanParenthesis {

	@Test
	public void test(){
		CountBooleanParenthesis cbp = new CountBooleanParenthesis();
		char[] symbols = {'T', 'F', 'T'};
		char[] operator = {'^', '&'};
		int result = cbp.computeBooleanParenthesis(symbols, operator);
		System.out.println(result);
	}
	
	@Test
	public void test_1(){
		CountBooleanParenthesis cbp = new CountBooleanParenthesis();
		char[] symbols = {'T', 'F', 'F'};
		char[] operator = {'|', '^'};
		int result = cbp.computeBooleanParenthesis(symbols, operator);
		System.out.println(result);
	}
	
	@Test
	public void test_2(){
		CountBooleanParenthesis cbp = new CountBooleanParenthesis();
		char[] symbols = {'T', 'F', 'F', 'T'};
		char[] operator = {'|', '^', '&'};
		int result = cbp.computeBooleanParenthesis(symbols, operator);
		System.out.println(result);
	}
	
	@Test
	public void test_3(){
		CountBooleanParenthesis cbp = new CountBooleanParenthesis();
		char[] symbols = {'T', 'T', 'F', 'T'};
		char[] operator = {'|', '&', '^' };
		int result = cbp.computeBooleanParenthesis(symbols, operator);
		System.out.println(result);
	}
}
