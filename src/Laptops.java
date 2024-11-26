/*PROJECT HEADER
 * Group 4; Trisan Ramjohn
 * -----------------------
 * Monday, November 25, 2024
 * -----------------------
 * ICS3U1-01 Mrs. Biswas
 * -----------------------
 * Laptop Central
 * -----------------------
 * This program is the laptop template class which creates the 
 * blueprint for the objects
 * -----------------------
 * Skills used in this program involve figuring out the fields and
 * knowing where needs to be input validated
 * -----------------------
 * None
 * -----------------------
 * None
 * -----------------------
 * Completed all methods in the program
 * Completed 100% of the work in this program
 * -----------------------
 */

//Laptop class
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
	public Laptops(String brand, String model, String type, double price, String os, String cPU, String gPU,
			int sSD, int rAM, double weight, int numOfUSBPorts, double displaySize, String link) {
		
		this.brand = brand;
		this.model = model;
		setType(type);
		setPrice(price);
		this.os = os;
		CPU = cPU;
		GPU = gPU;
		setSSD(sSD);
		setRAM(rAM);
		setWeight(weight);
		setNumOfUSBPorts(numOfUSBPorts);
		setDisplaySize(displaySize);
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
	//input validiation if user enters a string that is not Gaming, Professional or Student
	public void setType(String type) {
		if (type.equals("Gaming") || type.equals("Professional") || type.equals("Student"))
			this.type = type;
		else
			System.out.println("Invalid input");
	}

	public double getPrice() {
		return price;
	}
	//input validation if value is less than 0
	public void setPrice(double price) {
		if (price > 0)
			this.price = price;
		else
			System.out.println("Invalid input");
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
	//input validation if value is less than 0
	public void setSSD(int sSD) {
		if (sSD > 0)
			SSD = sSD;
		else 
			System.out.println("Invalid input");
	}

	public int getRAM() {
		return RAM;
	}
	//input validation if value is less than 0
	public void setRAM(int rAM) {
		if (rAM > 0)
			RAM = rAM;
		else
			System.out.println("Invalid input");
	}

	public double getWeight() {
		return weight;
	}
	//input validation if value is less than 0
	public void setWeight(double weight) {
		if (weight > 0)
			this.weight = weight;
		else
			System.out.println("Invalid input");
	}

	public int getNumOfUSBPorts() {
		return numOfUSBPorts;
	}
	
	//input validation if value is less than 0
	public void setNumOfUSBPorts(int numOfUSBPorts) {
		if (numOfUSBPorts > 0)
			this.numOfUSBPorts = numOfUSBPorts;
		else 
			System.out.println("Invalid input");
	}

	public double getDisplaySize() {
		return displaySize;
	}
	//input validation if value is less than 0
	public void setDisplaySize(double displaySize) {
		if (displaySize > 0)
			this.displaySize = displaySize;
		else
			System.out.println("Invalid input");
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	//toString method which converts everything to a string 
	public String toString() {
		return "Laptops [brand=" + brand + ", model=" + model + ", type=" + type + ", price=" + price
				+ ", os=" + os + ", CPU=" + CPU + ", GPU=" + GPU + ", SSD=" + SSD + ", RAM="
				+ RAM + ", weight=" + weight + ", numOfUSBPorts=" + numOfUSBPorts + ", displaySize=" + displaySize
				+ ", link=" + link + "]";
	}
}
