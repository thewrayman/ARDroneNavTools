
public class VeloGenerator {
	/*The purpose of this is to generate some velocity data to simulate the drone
	 *This class will pass on the velocity (and maybe the time) to the calculator
	 * 
	 * 
	 */
	
	
	
	
	//creates a double within the limit velocity
	public static double makeVelo(double oldvelo, double limit){
		double velo = oldvelo;
		if (oldvelo <= 0.9){		//make sure it doesn't go over limit
			velo = oldvelo + (limit/100);	//increment by 10% every time(accel)
		}
		
		MainProcess.velo = velo;
		return velo;
	}
	
	
	
	//creates an array containing the velocity and time
	public static double[] veloPkt(double velo, double limit){
		double[] packet = new double[2];
		packet[0] = makeVelo(velo,limit);			//get a velocity
		packet[1] = getTime();
		
		printStats(packet);
		return packet;
	}
	
	
	
	
	
	
	
	
	public static long getTime(){
		  long time;
		  time = System.nanoTime()/1000000;	//get time in mili
		  return time;
		  
	  }
	  
	  public static double calcTime(long start,long end){
	  	long totalTime = end - start;
	  	double rTime = (double)totalTime/1000000;	//time in miliseconds
	  	return rTime;
	  }
	  
	  //prints out the packet details
	  public static void printStats(double[] velopkt){
		  System.out.println("velo: "+velopkt[0]+", time: "+velopkt[1]);
	  }
	

}
