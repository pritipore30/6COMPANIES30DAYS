package solution;

public class AirplaneSeatProbability {
	 public static double nthPersonGetsNthSeat(int n) {
	        if(n==1){
	            return 1;
	        }
	        return 0.5;
	        
	    }
	 public static void main(String [] args) {
		 int n = 1;
		 System.out.println(nthPersonGetsNthSeat(n));
	 }

}
