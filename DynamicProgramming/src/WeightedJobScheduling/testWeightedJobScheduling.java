package WeightedJobScheduling;

import org.junit.Test;

import WeightedJobScheduling.WeightedJobSchedulingMaximumProfit.Job;



public class testWeightedJobScheduling {

	@Test
	 public void testWJS() {
	        Job jobs[] = new Job[6];
	        jobs[0] = new Job(1,3,5);
	        jobs[1] = new Job(2,5,6);
	        jobs[2] = new Job(4,6,5);
	        jobs[3] = new Job(6,7,4);
	        jobs[4] = new Job(5,8,11);
	        jobs[5] = new Job(7,9,2);
	        WeightedJobSchedulingMaximumProfit mp = new WeightedJobSchedulingMaximumProfit();
	        System.out.println("Max total Profit - " + mp.maximum(jobs));
	    }
}
