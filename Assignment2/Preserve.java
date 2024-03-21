import java.util.Formatter;
import java.util.Scanner;

public class Preserve extends FoodItem {
	
	private float jarSize;

	public Preserve() {}

	@Override
	public String toString() {
		return super.toString() + " size: " + jarSize + "mL";
	}

	public void outputItem(Formatter writer) {
		super.outputItem(writer);
		writer.format("\n%f", jarSize);
	}

	public boolean addItem(Scanner scanner, boolean fromFile) {
		if (!super.addItem(scanner, fromFile)) {
			return false;
		}

		if (fromFile) {
			try {
				if (!scanner.hasNextLine()) {
					return false;
				}
				jarSize = Float.parseFloat(scanner.nextLine());
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			String userInput;
			while (true) {
				System.out.print("Enter the size of the jar in millilitres: ");
				userInput = scanner.nextLine();
				if (userInput.trim().isEmpty()) {
					System.out.println("You must enter the size of the jar");
					continue;
				}
				try {
					float temp = Float.parseFloat(userInput);
					if (temp < 0) {
						throw new NumberFormatException();
					} else {
						jarSize = temp;
						return true;
					}
				} catch (NumberFormatException e) {
					System.out.print("Invalid entry");
				}
			}
		}
	}
}