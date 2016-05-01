package w9;

public enum Weight implements Unit {
	
	KILOGRAM( "Kilogram" , 1000 ),
	GRAM( "Gram" , 1 ),
	GRAIN( "Grain", 0.00647 ),
	OUNCE( "Ounce" , 28.349 ),
	POUND( "Pound" , 453.592),
	TON( "Ton" , 1000000 );
	
	
	private String name;
	private double value;
	
	
	
	Weight ( String name , double value ){
		this.name = name;
		this.value = value;
	}
	
	
	
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
