package w9;

public enum Time implements Unit {
	
	MINUTE("Minute",1),
	SECOND("Second",0.0166666667),
	HOUR("Hour",60),
	DAY("Day",1440),
	WEEK("Week",10080),
	MONTH("Month",43800),
	YEAR("Year",525600),
	DECADE("Decade",5256000),
	CENTURY("Century",52560000 ),
	MILLENNIUM("Millennium",525600000);
	
	
	private String name;
	private double value;
	
	Time(String name ,double value){
		this.name = name;
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
	
	public String toString(){
		return name;
	}

}
