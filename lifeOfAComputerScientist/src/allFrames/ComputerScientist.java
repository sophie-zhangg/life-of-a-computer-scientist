package allFrames;
// Sophie Zhang, 653342
import java.util.ArrayList;
import java.lang.Math;

//Class for ComputerScientist Object
public class ComputerScientist {
	
	//Instance Variables
	private String title;
	private int numOfHours;
	private double hourWage;
    private String company;
    private double moneyEarned;
    private ArrayList<String> knownLang=new ArrayList<String>(0);
    private boolean fluent;
	private String name;
	private int happiness;
    
    // Constructors
    public ComputerScientist() //Default
    {
    	this.title="Computer Scientist";
    	this.numOfHours=8;
    	this.hourWage=14;
        this.moneyEarned=0;
        this.happiness=10;
    }
    
	public ComputerScientist(String name, String title, int numOfHours, String company, ArrayList<String> knownLang) { //Specialized
		super();
		this.name = name;
		this.title = title;
		if (title.equals("Programmer") || title.equals("Web Developer")) {
			hourWage=20;
		}
		else if (title.equals("Software Engineer") || title.equals("System Engineer")|| title.equals("IT Professional")) {
			hourWage=26;
		}
		else if (title.equals("Manager")) {
			hourWage=34;
		}
		else {
			hourWage=65;
		}
		this.numOfHours = numOfHours;
		this.company = company;
		this.knownLang = knownLang;
		happiness=10;
	}
	
	//Behavioral Methods
	public String hired(String comp, int numHour) {
		company=comp;
		numOfHours=numHour;
		return name+" has been hired! You now work for "+company+" and work "+numOfHours+" hours a day.";
	}
	
	public String takeBreak(int weekLength) {
		if (weekLength<1 && happiness<9) {
			happiness++;
		}
		else if (weekLength<3 && happiness<8) {
			happiness=happiness+2;
		}
		else if (weekLength<5 && happiness<7) {
			happiness=happiness+3;
		}
		else {
			happiness=10;
		}
		moneyEarned=moneyEarned-hourWage*numOfHours*7*weekLength;
		return name+" took a break for "+weekLength+" weeks!";
	}
	
	public void worked(int numOfDays) {
		happiness--;
		moneyEarned=moneyEarned+numOfDays*hourWage*numOfHours;
		moneyEarned=moneyEarned-((int)(Math.random() * 500 + 1));
	}
	
	public String trained(String newLang) {
		if (knownLang.contains("newLang")){
			return name+" already understood that language ("+newLang+")!";
		}
		else {
			knownLang.add(newLang);
			if (fluent==false) {
				fluent=true;
			}
			return name+" now understands "+newLang+"!";
		}
		
	}
	
	public String fired(String yourTitle, String company) {
		company="";
		title="Unemployed";
		return name+" is now "+title+"!";
	}
	
	public String promoted(String wantTitle, int yearsWork, ArrayList<String> lang) {
		if (yearsWork>2 && lang.size()>=2) {
			title=wantTitle;
			if (title.equals("Programmer") || title.equals("Web Developer")) {
				hourWage=20;
			}
			else if (title.equals("Software Engineer") || title.equals("System Engineer")|| title.equals("IT Professional")) {
				hourWage=26;
			}
			else if (title.equals("Manager")) {
				hourWage=34;
			}
			else {
				hourWage=65;
			}
			return name+" has been promoted! You now earn $"+hourWage+" per hour and have the title of "+title+".";
		}
		return name+", apply again next year!";
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfHours() {
		return numOfHours;
	}

	public void setNumOfHours(int numOfHours) {
		this.numOfHours = numOfHours;
	}

	public double getHourWage() {
		return hourWage;
	}

	public void setHourWage(double hourWage) {
		this.hourWage = hourWage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getMoneyEarned() {
		return moneyEarned;
	}
	
	public void setMoneyEarned(double moneyEarned) {
		this.moneyEarned = moneyEarned;
	}
	
	public ArrayList<String> getKnownLang() {
		return knownLang;
	}

	public boolean isFluent() {
		return fluent;
	}

	public void setFluent(boolean fluent) {
		this.fluent = fluent;
	}
    
	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
    
    
}
