import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/* This class generates Uniform Distribution input set, it's parent class is GenerateCSVInput */
public class GeneratingUniformRandomInput {
	
	int total = 0, rangeMin = 0, rangeMax = 0, k = 0;
	
	public GeneratingUniformRandomInput(int total, int rangeMin, int rangeMax, int k) {
		this.total = total;
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		this.k = k;
	}
	
	
	// Method to generate random numbers and store it a csv file
	  public void generateFile() throws IOException{
		int count = 1;
		String fileName = "InputUniformDataSet" + total + ".csv";
		String content = "";
		FileWriter write = new FileWriter(fileName);
		
		System.out.println("Generating Uniform Random Input of " + total + "data...");
		
		content = k + "," + total + "\n"; //Default value of k to 1
		write.append(content);
		content = "";
	  	Random randomGenerator = new Random();
	    NumberFormat formatter = new DecimalFormat("#0.00"); // Restrict the format to xx.xx
	    for (int idx = 1; idx <= total; ++idx){
	      double randomDouble = rangeMin + (rangeMax - rangeMin) * randomGenerator.nextDouble();
	      content = content + formatter.format(randomDouble) + "\n";
	      if(count == 100) {
	    	  write.append(content);
	    	  content = "";
	    	  count = 0;
	      } else{
	    	  count++;
	      }
	    }
	    write.append(content);
	    write.flush();
	    write.close();
	    
	    System.out.println(" Uniform Randon Input Generation Complete..!!!");
	  }
}
