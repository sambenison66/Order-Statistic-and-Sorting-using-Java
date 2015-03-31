import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/* This class generates Normal Distribution input set, it's parent class is GenerateCSVInput */
public class GenerateNormalRandomInput {

int total = 0, k = 0;
	
	public GenerateNormalRandomInput(int total, int k) {
		this.total = total;
		this.k = k;
	}
	
	
	// Method to generate random numbers and store it a csv file
	  public void generateFile() throws IOException{
		int count = 1;
		double MEAN = total / 3; 
		double VARIANCE = 5.0f;
		String fileName = "InputNormalDataSet" + total + ".csv";
		String content = "";
		FileWriter write = new FileWriter(fileName);
		content = k + "," + total + "\n";
		write.append(content);
		content = "";
	  	Random randomGenerator = new Random();
	    NumberFormat formatter = new DecimalFormat("#0.00");
	    for (int idx = 1; idx <= total; ++idx){
	      double randomDouble = MEAN + randomGenerator.nextGaussian() * VARIANCE;
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
	    
	    System.out.println(" Normal Distribution Randon Input Generation Complete..!!!");
	  }
}
