package BurstBalloons;

public class practiseBurstBalloon {

	public int getMaxValueBurstingBalloons(int[] nums) {
        
        if (nums == null || nums.length == 0)
           return 0;
           
         if (nums.length == 1) {
             return nums[0];
         }
         
         int[][] temp = new int[nums.length][nums.length];
         
         for (int i = 0; i < nums.length; i++) {
             int val = 0;
             if (i ==0) {
                 val = nums[i]*nums[i+1];
             }else if (i == nums.length-1){
                 val = nums[i-1] * nums[i];
             } else {
                 val = nums[i-1]*nums[i]*nums[i+1];
             }
             
             temp[i][i] = val;
         }
         
         for (int len = 2; len <= nums.length; len++) {
             for (int i =0; i <= nums.length-len; i++){
                 int j = i + len -1;
                 int max =0;
                 for(int k =i; k <= j; k++){
                     int val = 0;
                     int leftSide = 1;
                     int rightSide = 1;
                     if (i != 0) {
                         leftSide = nums[i-1];
                     }
                     if (j != nums.length -1) {
                         rightSide = nums[j+1];
                     }
                     val = leftSide * nums[k] * rightSide;
                     
                     int leftProduct = 0;
                     int rightProduct = 0;
                     
                     if (k > i && k < j){
                         leftProduct = temp[i][k-1];
                         rightProduct = temp[k+1][j];
                     } else if (k == i) {
                         rightProduct = temp[k+1][j];
                     } else if (k == j) {
                         leftProduct = temp[i][k-1];
                     }
                     
                     int totalValue = val + leftProduct + rightProduct;
                     if (totalValue > max){
                         max = totalValue;
                     }
                 }
                 temp[i][j] = max;
             }
         }
         
         return temp[0][temp.length-1];
    }
}
