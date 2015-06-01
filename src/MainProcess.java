
public class MainProcess {
	static double velo;

	static VeloGenerator vg;
	static VeloProcess vp;
	static long interval = 25; //Milliseconds interval to check velocity
	
	public static void main(String[] args) throws InterruptedException {

		testVelo();
	}
	
	//need loop like in testVelo to fetch the drones velo at each point
	//take that value and create a VeloPacket object
	//proces that object using packetParse(object) from VeloProcess
	
	
	
	public static void testVelo() throws InterruptedException{
		//loops to simulate moving across a distance,
		//fetching the velocity every (interval) ms
		//creates a test packet to simulate getting the velocity at that time
		System.out.println("for:");
		vp.updatePacket(0, vg.getTime());
		for(int i=0; i<100;i++){			//simulate moving - getting a constant velocity
			Thread.sleep(interval);				//get reading every 25 mili
			
			if(i<50){						//increase
				double pkt[] = vg.veloPkt(velo,1);
				VeloPacket vpp = new VeloPacket(pkt[0],pkt[1]);
				vp.packetParse(vpp);
			}
			else{							//decrease
				double pkt[] = vg.veloPkt(velo,-1);
				VeloPacket vpp = new VeloPacket(pkt[0],pkt[1]);
				vp.packetParse(vpp);
			}
			
		}
		
	}

}
