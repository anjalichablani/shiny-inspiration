package WeightedJobScheduling;

/**
 * https://www.youtube.com/watch?v=cr6Ip0J9izc&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=11
 * 
 * http://www.geeksforgeeks.org/weighted-job-scheduling/
 *
 * Given N jobs where every job is represented by following three elements of it.
Start Time
Finish Time
Profit or Value Associated

Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class WeightedJobSchedulingMaximumProfit {

	 /**
     * 1) Sort the jobs by finish time.
     * 2) For every job find the  job which does not overlap with this job
     * next see if current job profit plus total profit of non overlapping job is greater
     * than total profit of current job.
     * @param jobs
     * @return
     */
	
	private static final Comparator<Job> jobFinishTimeComparator = Comparator.comparing(Job::getEnd);
    public int maximum(Job[] jobs) {
        int[] temp = new int[jobs.length];
        int[] results = new int[jobs.length];
        
       // FinishTimeComparator comparator = new FinishTimeComparator();
        //Arrays.sort(jobs, comparator);
        Arrays.sort(jobs, jobFinishTimeComparator);
        
        for (int i = 0; i < jobs.length; i++){
          temp[i] = jobs[i].profit;
        }
        
        for (int i = 0; i < jobs.length; i++){
            results[i] = i;
         }
        
        int maxProfit = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=1; i < jobs.length; i++){       
            for(int j=0; j < i; j++){
                if(jobs[i].start >= jobs[j].end){ //jobs do not overlap
                    int sum =  temp[j]+ jobs[i].profit;
                    if (sum > temp[i]) {
                    	temp[i] = sum;
                    	results[i] = j;
                    	if (temp[i] > maxProfit){
                    		maxProfit = temp[i];
                    		maxIndex = i;
                    	}
                    }
                }
            }
        }
       
        getJobs(results, maxProfit, maxIndex, jobs);
        return maxProfit;
    }
    
    private void getJobs(int[] results, int maxProfit, int maxIndex, Job[] jobs){
    
    	Stack<Job> stack = new Stack<Job>();
    	int jobIndex = maxIndex;
    	int parentIndex = results[jobIndex];
    	
    	while (jobIndex != parentIndex) {
    		stack.add(jobs[jobIndex]);	
    	    jobIndex = parentIndex;
    	    parentIndex = results[jobIndex];
    	}
    	stack.add(jobs[jobIndex]);
    	
    	System.out.println("Do following jobs to get max profit");
    	while(!stack.isEmpty()) {
    		System.out.println(stack.pop());
    	}
    }
	
	public static class Job{
	    int start;
	    int end;
	    int profit;
	   
	    public Job(int start,int end,int profit) {
	        this.start= start;
	        this.end = end;
	        this.profit= profit;
	    }
	    public int getStart() {
	    	return this.start;
	    }
	    public int getEnd() {
	    	return this.end;
	    }
	    public int getProfit() {
	    	return this.profit;
	    }
	    
	    public String toString() {
	    	return String.format("Job{Start:%d, End:%d, Profit:%d}", start, end, profit);
	    }
	}
	
	class FinishTimeComparator implements Comparator<Job>{

	    @Override
	    public int compare(Job job1, Job job2) {
	        if(job1.end <= job2.end){
	            return -1;
	        } else {
	            return 1;
	        }
	    }
	}
}
