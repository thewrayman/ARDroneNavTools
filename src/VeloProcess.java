
public class VeloProcess {
	//process the veloticity and times
	//try to calculate distance
	//takes in the packet of velocity and time
	//take the previous packet and next packet
	//compare to work out the trapesium between them
	
	
	static double distance=0;//in meters - initialise to 0
	static double previousTime;//the previous time
	static double previousVelo;//the previous velo
	
	
	//maybe start by creating an initial packet
	//distance = initial velo + 1/2(accel)(time^2)
	//process each packet, compare it to previous one
	public static void packetParse(VeloPacket pkt){
		double velo = pkt.getVelo();
		double time = pkt.getTime();
		
		double Dtime = (time - previousTime)/1000;	//get the time since the last velocity
		double accel = ((velo-previousVelo)/Dtime);	//work out the acceleratioon
	
		double dist = getDistance(Dtime,accel,velo);
		previousTime = time;
	}
	
	
	//takes in the new time, the accel and velo(t,a,vi), calculates distance from previous point
	public static double getDistance(double time, double accel, double velo){
		double dist = distance;		//get the previous distance
		double additionalDistance = Math.abs(velo + ((0.5)*(accel)*Math.pow(time,2)));		//s= vi+ 1/2 at^2
		
		dist += additionalDistance;
		distance = dist;
		previousVelo = velo;
		
		System.out.println("distance: "+distance);
		return distance;
	}
	
	//creates an initial(0 velocity,starting time) for moving from a stopped postion
	public static void updatePacket(double velo, double time){
		previousTime = time;
		previousVelo = velo;
	}
	

}
