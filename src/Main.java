public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/input.txt";
        String outputFilePath = "src/output.txt";
        PolynomialOperations operations = new PolynomialOperations(inputFilePath, outputFilePath);
        operations.processOperations();
    }
}
