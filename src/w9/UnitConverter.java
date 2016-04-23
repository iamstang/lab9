package w9;


public class UnitConverter {
	
	/*
	 * convert amount from unit to another
	 */
	public double convert( double amount , Unit fromUnit , Unit toUnit ){
		
		return ( amount * fromUnit.getValue() ) / toUnit.getValue();
	}
	
	/*
	 * return all unit in length
	 */
	public Unit[] getUnits(){
		
		return Length.values();
	}
}
