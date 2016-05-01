package w9;

public enum Currency implements Unit {

	USD("US Dollar", 1),
	EURO("Euro" , 0.873),
	DONG("Dong", 22178.5),
	BAHT("Baht",34.827),
	SKRWON("South-Korean Won",1144.03),
	NKRWON("North-Korean Won",135),
	Peso("Peso",656.142),
	Yen("Yen",106.29),
	KIP("Kip",8026.22);
	
	
	

	
	
	private String name;
	private double value;
	
	
	Currency(String name, double value){
		this.name = name;
		this.value = value;
	}
	
	
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public String toString(){
		return name;
	}

}
