package window.model;

public class Light_Bulb {
	private Boolean stateLight;
	
	
	public Light_Bulb(Boolean swich_On_Or_Off) {
		this.stateLight = swich_On_Or_Off;
	}
	public Boolean getSwich_On_Or_Off() {
		return stateLight;
	}
	public void setSwich_On_Or_Off(Boolean swich_On_Or_Off) {
		this.stateLight = swich_On_Or_Off;
	}
	
	 public void toggleState() {
		 stateLight = !stateLight;
	}

}
