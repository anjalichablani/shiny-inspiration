package CoinChanging;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} 
 * valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 
 For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
 So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
 and {5,5}. So the output should be 5.*/

public class CoinChanging {

	public int numberOfSolutionsOnSpace(int total, int[] coins){

        int temp[] = new int[total+1];

        temp[0] = 1;
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total ; i++){
                if(i < coins[j]) {
                	continue;
                }
                int residualValue = i - coins[j];
                temp[i] = temp[i]+ temp[residualValue];               
            }
        }
        return temp[total];
    }
	
	public void printCoinChangingSolution(int total,int coins[]){
       // List<Integer> result = new ArrayList<>();
		Stack<Integer> result = new Stack<>();
        System.out.print("\nActual solution\n");
        printActualSolution(result, total, coins, 0);
    }
    
	private void printActualSolution(Stack<Integer> result,int total,int coins[],int pos){
        if(total == 0){
            for(int r : result){
                System.out.print(r + " ");
            }
            System.out.print("\n");
            return;
        }
        for(int i=pos; i < coins.length; i++){
            if(total >= coins[i]){
                result.add(coins[i]);
                int newTotal = total - coins[i]; 
                printActualSolution(result,newTotal,coins,i);
                result.pop();
                //result.remove(result.size()-1);
            }
        }
    }
}
