import java.util.Scanner;

/* This class is used to get an option of which type of random numbers should be generated
 * and redirect to the corresponding file accordingly */
public class GenerateCSVInput {
  
	Scanner csvInputStream = new Scanner(System.in);
	int inputType, total, min, max, k;
	
  public void generateInput(){
	  int total = 0, min = 0, max = 0;
	  System.out.println("Welcome to CSV Generator --->");
	  System.out.println("1. Uniform Random Input \n" + 
			  "2. Normal Random Input \n");
	  
	  // Get the input number type
	  while(true) {
		  System.out.println("What type of input you need?");
		  try {
			  inputType = Integer.parseInt(csvInputStream.nextLine());
			  // This loop decides what type of input to be generated
			  // 1 - Uniform; 2 - Normal Distribution
			  if (inputType == 1 || inputType == 2) {
				  System.out.println("Enter the total number of input required:");
				  total = Integer.parseInt(csvInputStream.nextLine());
				  System.out.println("Enter the value of k:");
				  k = Integer.parseInt(csvInputStream.nextLine());
				  if(inputType == 1) {
					  System.out.println("Enter the minimum number for the input:");
					  min = Integer.parseInt(csvInputStream.nextLine());
					  System.out.println("Enter the maximum number for the input:");
					  max = Integer.parseInt(csvInputStream.nextLine());
					  GeneratingUniformRandomInput uniform = 
							  new GeneratingUniformRandomInput(total, min, max, k);
					  uniform.generateFile();
					  break;
				  }
				  GenerateNormalRandomInput normal = 
						  new GenerateNormalRandomInput(total, k);
				  normal.generateFile();
				  break;
			  }
		  } catch(Exception e) {
			  // do nothing
		  }
		  System.out.println("Invalid Option, Try again..!!! \n");
	  }
	  
	System.out.println("Check the same folder for the generated csv file");
    
  }
}
 
