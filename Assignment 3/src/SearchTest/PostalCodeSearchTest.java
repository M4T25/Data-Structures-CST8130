package SearchTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import Entry.PostalCodeEntry;

/**
 * PostalCodeSearchTest class to test the search of postal codes 
 * in a CSV file of Canadian postal codes
 * @author James, Georger
 */

public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Filename of the CSV file
		String filename = "ottawa_postal_codes.csv";
		// Map to store postal codes and their corresponding entries
		Map <String, PostalCodeEntry> postalCodesMap = new HashMap<>();//Create map
		
		// Creating Path object from the filename
		Path path = Paths.get(filename);
		// Reading the file line by line
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			// Reading the file line by line
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				// Splitting each line by comma and storing them in an array
				String[] postalCode = line.split(",");
				// Adding postal code entry to the map
				postalCodesMap.put(postalCode[0],
						new PostalCodeEntry(postalCode[0], postalCode[1], postalCode[2], postalCode[3], postalCode[4]));
			}
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();

		} 
		// no need to close input. Used try-with-resources above
		// Looping 10 times to search for 10 randomly generated postal codes
		for (int i = 0; i < 10; i++) {
			// Generating a random postal code prefix
			String prefix = PostalCodeEntry.getRandomPrefix();
			// Printing the prefix being searched for
			System.out.printf("Retrieving: %3s\n" , prefix);
			// Retrieving postal code entry from the map
			PostalCodeEntry code = postalCodesMap.get(prefix);
			
			if (code == null) {
				// If postal code not found
				System.out.printf("%17s\n","NOT found");
			} else {
				// If postal code found, print the entry
				System.out.printf("        %s\n", code.toString());
			}

		}
		
	}// main()

}// class
