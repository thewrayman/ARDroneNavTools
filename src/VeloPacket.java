
public class VeloPacket {

	static double velocity;	//in m/s
	static double Vtime;		//in milis
	

	public VeloPacket(double velo, double time){
		velocity = velo;
		Vtime = time;
	}
	
	
	public static double getVelo(){
		return velocity;
	}
	
	public static double getTime(){
		return Vtime;
	}
	
}
