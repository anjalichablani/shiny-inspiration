package SubsquareSurrounedByXs;

import org.junit.Test;

public class testSubsquareSurrounedByXs {

	@Test
	public void test(){
		char[][] input = createSquare();
		SubsquareSurrounedByXs ss = new SubsquareSurrounedByXs();
		int max = ss.findSubSquare(input);
		System.out.println("Max square size of x's on side - " + max);
	}
	
	@Test
	public void test1(){
		char[][] input = createSquare1();
		SubsquareSurrounedByXs ss = new SubsquareSurrounedByXs();
		int max = ss.findSubSquare(input);
		System.out.println("Max square size of x's on side - " + max);
	}
	
	@Test
	public void test2(){
		char[][] input = createSquare2();
		SubsquareSurrounedByXs ss = new SubsquareSurrounedByXs();
		int max = ss.findSubSquare(input);
		System.out.println("Max square size of x's on side - " + max);
	}
	
	@Test
	public void test3(){
		char[][] input = createSquare3();
		SubsquareSurrounedByXs ss = new SubsquareSurrounedByXs();
		int max = ss.findSubSquare(input);
		System.out.println("Max square size of x's on side - " + max);
	}
	
	private char[][] createSquare() {
		
		//5 by 5 matrix
		char[][] input = {{'0', '0','0', '0', 'x'},
			              {'x', '0','x', 'x', 'x'},
			              {'x', '0','x', '0', 'x'},
			              {'x', 'x','x', 'x', 'x'},
			              {'0', '0','x', 'x', 'x'}};
		
		return input;
			
		}
		
	
    private char[][] createSquare1() {
		
    	//6 by 6
    	char[][] input = {{'X','O','O','O','O','O'},
                          {'O','O','O','O','O','O'},
                          {'X','X','X','X','O','O'},
                          {'X','X','X','X','X','O'},
                          {'X','O','O','X','X','O'},
                          {'X','O','X','X','X','O'}};
		
		return input;
			
		}
		
     private char[][] createSquare2() {
		
    	 char [][] input = {{'O', 'O', 'O', 'O', 'O', 'X'},
                             {'O', 'X', 'O', 'X', 'X', 'X'},
                             {'O', 'X', 'O', 'X', 'O', 'X'},
                             {'O', 'X', 'X', 'X', 'X', 'X'},
                             {'O', 'O', 'O', 'O', 'O', 'O'}};
    	 return input;
     }
     
     private char[][] createSquare3() {
 		
 		
    	 char [][] input = {{'O', 'O', 'X', 'O', 'X'},
                            {'O', 'X', 'X', 'O', 'X'},
                            {'O', 'X', 'O', 'X', 'X'},
                            {'X', 'X', 'X', 'X', 'X'},
                            {'O', 'X', 'X', 'X', 'O'},
                            };
 			
    	 return input;
 		}
 		
}
