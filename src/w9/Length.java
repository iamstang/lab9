package w9;

public enum Length implements Unit{



	/* define the members of the enumeration
	 * the attributes are:
	 * name = a string name for this unit
	 * value = multiplier to convert to meters
	 */
	METER( "Meter" , 1 ),
	CENTIMETER( "Centimeter" , 0.01 ),
	MILLIMETER( "Millimeter" , 0.001 ),
	KILOMETER( "Kilometer" , 1000.0 ),
	NANOMETER( "Nanometer" , 0.0 ),
	MILE( "Mile" , 1609.344 ),
	FOOT( "Foot" , 0.3048 ),
	WA( "Wa" , 2 ),
	YARD( "Yard" , 0.9144 ),
	INCH( "Inch" , 0.0254);

	/** name of this unit */
	private String name;
	/** multiplier to convert this unit to std unit */
	private double value;

	/*
	 * constructer for enum members
	 */
	private Length(String name, double value){
		this.name = name;
		this.value = value;
	}

	/** public properties of the enum members*/
	public double getValue(){
		return value;
	}

	public String toString(){
		return name;
	}
}
