package Skyline;

public class BuildingPoint implements Comparable<BuildingPoint>{
	
	public int x;
	public boolean isStart;
	public int height;
	
	public BuildingPoint() {}
	
	public BuildingPoint(int x, boolean isStart, int height) {
		this.x  = x;
		this.isStart = isStart;
		this.height = height;
	}
	
	@Override
	public int compareTo(BuildingPoint o) {
		
		//first compare by x. if not same ..sort in ascending order
        //If they are same then use this logic
        //if two starts are compared then higher height building should be picked first
        //if two ends are compared then lower height building should be picked first
        //if one start and end is compared then start should appear before end
		if (this.x != o.x) {
			if (this.x < o.x)
				return -1;
			else
				return 1;
		}  else  { //if(this.x == o.x)
			//return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
			
			if(this.isStart == true && o.isStart == true) {
				if (this.height > o.height) 
					return -1;
				else 
					return 1;
					
			} else if (this.isStart == false && o.isStart == false) {
				if (this.height < o.height) 
					return -1;
				else
					return 1;
				
			} else {
				if (this.isStart) 
					return -1;
				else 
					return 1;
			}
		}
	}
	
	public String toString() {
		return "BuildingPoint [x=" + x + ", isStart=" + isStart
                + ", height=" + height + "]";
	}
}
