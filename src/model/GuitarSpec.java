package model;
public class GuitarSpec {
   private String builder;
   private String type;
   private String numStrings;
   private String topWood;
   private String backWood;
   
  public GuitarSpec(String builder, String type,
		   String numStrings, String topWood, String backWood) {
   this.builder = builder;
   this.type = type;
   this.numStrings = numStrings;
   this.backWood = backWood;
   this.topWood = topWood;
}

public String getBuilder() {
	return builder;
}
public void setBuilder(String builder) {
	this.builder = builder;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getNumStrings() {
	return numStrings;
}
public void setNumStrings(String numStrings) {
	this.numStrings = numStrings;
}
public String getTopWood() {
	return topWood;
}
public void setTopWood(String topWood) {
	this.topWood = topWood;
}
public String getBackWood() {
	return backWood;
}
public void setBackWood(String backWood) {
	this.backWood = backWood;
}
public boolean matches(GuitarSpec otherSpec) {
    if (builder != otherSpec.builder)
      return false;
    if (type != otherSpec.type)
      return false;
    if (numStrings != otherSpec.numStrings)
      return false;
    if (backWood != otherSpec.backWood)
      return false;
    if (topWood != otherSpec.topWood)
      return false;
    return true;
  }

}
