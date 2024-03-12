import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Handles polynomial operations by reading inputs from a file, processing operations like addition,
 * subtraction, and multiplication on polynomials, and writing the results to another file.
 */
public class PolynomialOperations {

    private String inputFilePath;
    private String outputFilePath;

    /**
     * Constructs a PolynomialOperations object with specified paths for input and output files.
     *
     * @param inputFilePath  Path to the input file.
     * @param outputFilePath Path to the output file.
     */
    public PolynomialOperations(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    /**
     * Executes polynomial operations (addition, subtraction, multiplication) from an input file,
     * writing results to an output file. It reads the number of test cases from the first line,
     * followed by lines with an operation symbol (+, -, *) and two polynomials per test case.
     */
    public void processOperations() {
        try (Scanner scanner = new Scanner(new File(inputFilePath));
             PrintWriter outputFile = new PrintWriter(outputFilePath)) {

            int testCases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;
            for (int i = 0; i < testCases; i++) {
                processTestCase(scanner, outputFile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Processes a single test case from the scanner, performs the operation on polynomials, and writes
     * the result to the output file.
     *
     * @param scanner   Scanner object to read a test case.
     * @param outputFile PrintWriter object to write the result.
     */
    private void processTestCase(Scanner scanner, PrintWriter outputFile) {
        if (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(" ");
            String operation = input[0];
            PolynomialLinkedList p1 = new PolynomialLinkedList();
            PolynomialLinkedList p2 = new PolynomialLinkedList();
            p1.addPolynomial(input[1]);
            p2.addPolynomial(input[2]);
            executeOperation(operation, p1, p2, outputFile);
        }
    }

    /**
     * Executes a polynomial operation (add, subtract, multiply) based on the operation string, and writes
     * the result to the output file.
     *
     * @param operation Operation string ("+", "-", "*").
     * @param p1        The first polynomial operand.
     * @param p2        The second polynomial operand.
     * @param outputFile PrintWriter object to write the result.
     */
    private void executeOperation(String operation, PolynomialLinkedList p1, PolynomialLinkedList p2, PrintWriter outputFile) {
        PolynomialLinkedList result;
        switch (operation) {
            case "+":
                result = PolynomialLinkedList.add(p1, p2);
                break;
            case "-":
                result = PolynomialLinkedList.subtract(p1, p2);
                break;
            case "*":
                result = PolynomialLinkedList.multiply(p1, p2);
                break;
            default:
                outputFile.println("Invalid operation");
                return;
        }
        result.writePolynomialToFile(outputFile);
    }
}
