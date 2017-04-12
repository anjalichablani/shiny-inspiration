package OptimalStrategyGamePickFromEndsOfArray;

public class OptimalStrategyGamePickFromEndsOfArray {

	public Pair[][] computeOptimalStrategy(int[] input) {

		Pair[][] moves = new Pair[input.length][input.length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				moves[i][j] = new Pair();
			}
		}

		for (int i = 0; i < input.length; i++) {
			Pair p = moves[i][i];
			p.first = input[i];
			p.second = 0;
			p.pick = i;
		}

		for (int len = 2; len <= input.length; len++) {
			for (int i = 0; i <= input.length - len; i++) {
				int j = i + len - 1;

				int pick1 = input[i] + moves[i + 1][j].second;
				int pick2 = input[j] + moves[i][j - 1].second;

				if (pick1 > pick2) {
					Pair p = moves[i][j];
					p.first = pick1;
					p.second = moves[i + 1][j].first;
					p.pick = i;
				} else {
					Pair p = moves[i][j];
					p.first = pick2;
					p.second = moves[i][j - 1].first;
					p.pick = j;
				}
			}

		}

		return moves;
	}

	public void printMoves(Pair[][] moves) {
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i].length; j++) {
				System.out.print(moves[i][j] + "  ");
			}
			System.out.print("\n");
		}
	}
	
	//prints the sequence of values and indexes
    public void printSequence(int input[], Pair moves[][]){
        int i = 0;
        int j = input.length - 1;
        int step;
        for (int k = 0; k < input.length; k++) {
            step = moves[i][j].pick;
            //this is the value of pick and its index
            System.out.print("value: " + input[step] + " " + "index: " + step + " ");
            if (step <= i) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
    }
	public static class Pair {
		public int first = 0;
		public int second = 0;
		public int pick = 0;

		public String toString() {
			return first + " " + second + " " + pick;
		}
	}

}
