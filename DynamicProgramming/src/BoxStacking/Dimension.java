package BoxStacking;


public class Dimension implements Comparable<Dimension>{
	int height;
	int length;
	int width;
		
	public Dimension(int height, int length, int width) {
		this.height = height;
		this.length = length;
		this.width = width;
	}
	
	public Dimension() {
	}
	
	/**
     * Sort in descending/decreasing order by base area(length X width)
     */
	public int compareTo(Dimension d) {
		if (this.length * this.width >= d.length*d.width) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public static Dimension createDimension(int height, int side1, int side2) {
        Dimension d = new Dimension();
        d.height = height;
        if (side1 >= side2) {
            d.length = side1;
            d.width = side2;
        } else {
            d.length = side2;
            d.width = side1;
        }
        return d;
    }
	
	 public String toString() {
	        return "Dimension [height=" + height + ", length=" + length
	                + ", width=" + width + "]";
	 }
}