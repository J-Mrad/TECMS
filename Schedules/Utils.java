package Schedules;

public abstract class Utils {
	/*=======================================================================================================*/
	/*Scheduling Utilities
	*/
	
	//prices///////////////////////////////
	public static final double NORMAL_PRICE=18000.0,IMAX_PRICE=20000.0,_4DX_PRICE=30000.0,VIP_MONTHLY_SUBSCRIPTION=75000.0;
	
	//showRoom Types//////////////////////
	public static final String NORMAL = "Normal" ,IMAX = "IMAX",_4DX = "4DX",VIP= "VIP";
	
	
	//Clamps a Number/////////////////////
	public static float clamp(float value, int min, int max) {
		return value <= min ? min : value >= max ? max : value;
	}
	/*=======================================================================================================*/
	
}
