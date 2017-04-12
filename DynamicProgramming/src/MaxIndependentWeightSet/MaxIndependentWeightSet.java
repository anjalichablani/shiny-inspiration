package MaxIndependentWeightSet;

public class MaxIndependentWeightSet {

	public int getMaxIndependentWeightSet(int[] weights) {
		if (weights == null || weights.length == 0)
			return 0;

		if (weights.length == 1)
			return weights[0];

		int[] maxCache = new int[weights.length + 1];
		maxCache[0] = 0;
		maxCache[1] = weights[0];

		for (int i = 1; i < weights.length; i++) {
			maxCache[i + 1] = Math.max(weights[i] + maxCache[i - 1], maxCache[i]);
		}

		return maxCache[weights.length];
	}
}
