//Project Header
/*Group 4: Trisan Ramjohn
 * November 25, 2024
 * ICS3U1-01 Mrs. Biswas
 * Laptop Central
 * This program is the laptop template class which creates the blueprint
 *for the objects
 */

public class Laptops {
	
	//define fields/properties 
	private String brand;
	private String model;
	private String type;
	private double price;
	private String os;
	private String CPU;
	private String GPU;
	private int SSD;
	private int RAM;
	private double weight;
	private int numOfUSBPorts;
	private double displaySize;
	private String link;
	
	//Constructor method
	public Laptops(String brand, String model, String type, double price, String operatingSystem, String cPU, String gPU,
			int sSD, int rAM, double weight, int numOfUSBPorts, double displaySize, String link) {
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.price = price;
		this.os = os;
		CPU = cPU;
		GPU = gPU;
		SSD = sSD;
		RAM = rAM;
		this.weight = weight;
		this.numOfUSBPorts = numOfUSBPorts;
		this.displaySize = displaySize;
		this.link = link;
	}
	
	//Getters and setters method 
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOS() {
		return os;
	}

	public void setOS(String os) {
		this.os = os;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public String getGPU() {
		return GPU;
	}

	public void setGPU(String gPU) {
		GPU = gPU;
	}

	public int getSSD() {
		return SSD;
	}

	public void setSSD(int sSD) {
		SSD = sSD;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getNumOfUSBPorts() {
		return numOfUSBPorts;
	}

	public void setNumOfUSBPorts(int numOfUSBPorts) {
		this.numOfUSBPorts = numOfUSBPorts;
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	//toString method which converts everything to a string 
	public String toString() {
		return "Laptop [brand=" + brand + ", model=" + model + ", type=" + type + ", price=" + price
				+ ", operatingSystem=" + os + ", CPU=" + CPU + ", GPU=" + GPU + ", SSD=" + SSD + ", RAM="
				+ RAM + ", weight=" + weight + ", numOfUSBPorts=" + numOfUSBPorts + ", displaySize=" + displaySize
				+ ", link=" + link + "]";
	}
	
	
	
	
	
	
	
	
	

}
