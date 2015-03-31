import java.io.FileWriter;
import java.io.IOException;

// This Methods writes the result array to a CSV file
public class WriteOutputToCSV {
	
	// Primary Method to generate output csv file
	public static void generateOutput(double[] dataSet, String outputType) throws IOException {
		
		String content = "";
		int total = dataSet.length;
		
		System.out.println("Generate output file...");
		String fileName = outputType + "OutputDataSet" + total + ".csv";
		FileWriter write = new FileWriter(fileName);
		content = "1," + total + "\n"; //Default value of k to 1
		write.append(content);
		
		writeDatatoFile(write, dataSet);
		
		write.flush();
	    write.close();
		
		System.out.println("Output successfully generated... Check the same folder..!!");
	}
	
	// Perform Data to CSV file process
	private static void writeDatatoFile(FileWriter write, double[] dataSet) {
		try {
			for(int i=0; i<dataSet.length; i++) {
				write.append(String.valueOf(dataSet[i]));
				write.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
