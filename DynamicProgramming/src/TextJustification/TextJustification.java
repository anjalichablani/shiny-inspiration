package TextJustification;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 * @author anjali.chablani
 *
 */
public class TextJustification {

	public void justify(String str, int width) {

		String[] words = str.split(" ");
		int[][] temp = new int[words.length][words.length];

		// next 2 for loop is used to calculate cost of putting words from
		// i to j in one line. If words don't fit in one line then we put
		// Integer.MAX_VALUE there.
		for (int i = 0; i < words.length; i++) {
			temp[i][i] = width - words[i].length();
			for (int j = i + 1; j < words.length; j++) {
				temp[i][j] = temp[i][j - 1] - words[j].length() - 1;
			}
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i; j < words.length; j++) {
				if (temp[i][j] < 0) {
					temp[i][j] = Integer.MAX_VALUE;
					continue;
				}
				temp[i][j] = (int) Math.pow(temp[i][j], 2);
			}
		}

		printDPTable(temp);
		
        //minCost from i to len is found by trying
        //j between i to len and checking which
        //one has min value
        int minCost[] = new int[words.length];
        int result[] = new int[words.length];
        for(int i = words.length-1; i >= 0 ; i--){
            minCost[i] = temp[i][words.length-1];
            result[i] = words.length;
            for(int j=words.length-1; j > i; j--){
                if(temp[i][j-1] == Integer.MAX_VALUE){
                    continue;
                }
                if(minCost[i] > minCost[j] + temp[i][j-1]){
                    minCost[i] = minCost[j] + temp[i][j-1];
                    result[i] = j;
                }
            }
        }
        System.out.println("Minimum cost is " + minCost[0]);
        System.out.println("\n");
        String justifiedText = printJustifiedText(result, words);
        System.out.println(justifiedText);
		
	}

	private void printDPTable(int[][] cost) {
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost.length; j++) {
				System.out.print(String.format("%8d       ", cost[i][j]));
			}
			System.out.print("\n");
		}
	}
	
	private String printJustifiedText(int[] result, String[] words) {
		int index = 0;
		int nextIndex = result[index];
		
		StringBuilder sb = new StringBuilder();
		
		while(index < words.length) {
		   for (int k =index;k < nextIndex; k++){	
			   sb.append(words[k] + " ");
		   }
		   sb.append("\n");
		   
		   index = nextIndex;
		   if (index >= words.length){
			   break;
		   }
		   nextIndex = result[index];
		}
		
		return sb.toString();
		
	}
}
