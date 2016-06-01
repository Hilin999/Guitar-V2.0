package model;
public class Guitar {
    private String serialNumber;
    private String price;
    GuitarSpec spec;
    
    public Guitar(String serialNumber, String price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
      }
    
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public GuitarSpec getSpec() {
		return spec;
	}
	public void setSpec(GuitarSpec spec) {
		this.spec = spec;
	}
    
}
