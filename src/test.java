
/**
 * Represents a polynomial using a linked list, where each node contains a term of the polynomial.
 * Terms are stored as nodes with coefficients and exponents for x, y, and z variables.
 * Head of the linked list representing the first term of the polynomial.
 */


    /**
     * Constructs an empty PolynomialLinkedList.
     */
   

    /**
     * Adds a new term to the polynomial. If the term already exists (based on its exponents),
     * its coefficient is updated. Otherwise, the term is inserted in a sorted manner based on
     * the exponents' values.
     *
     * @param coefficient The coefficient of the term.
     * @param exponentX   The exponent of x in the term.
     * @param exponentY   The exponent of y in the term.
     * @param exponentZ   The exponent of z in the term.
     */
   

    /**   
     * Helper method to compare a term (node) with given exponents. It determines if the term's
     * exponents are "greater than" the provided exponents based on a predefined order: first by
     * exponent of x, then y, and lastly z.
     *
     * @param node      The term node from the polynomial linked list to compare.
     * @param exponentX The exponent of x to compare against the term node's exponent of x.
     * @param exponentY The exponent of y to compare against the term node's exponent of y.
     * @param exponentZ The exponent of z to compare against the term node's exponent of z.
     * @return true if the term node's exponents are considered greater than the provided exponents,
     *         false otherwise.
     */
   


    /**
     * Parses a polynomial represented as a string and adds its terms to the linked list.
     * The polynomial string format is expected to be a sum of terms, where each term includes
     * coefficients and optionally variables (x, y, z) with their exponents.
     *
     * @param polynomial The polynomial string to be parsed and added.
     */
    

    /**
     * Writes the polynomial to the given PrintWriter. The polynomial is formatted as a string
     * representation with terms ordered and combined properly.
     *
     * @param writer The PrintWriter to which the polynomial string is written.
     */
    


    /**
     * Adds two polynomials represented by PolynomialLinkedLists and returns the result as a new
     * PolynomialLinkedList.
     *
     * @param p1 The first polynomial to add.
     * @param p2 The second polynomial to add.
     * @return The resulting polynomial of adding p1 and p2.
     */
    

    /**
     * Negates a given polynomial by multiplying each term's coefficient by -1. This method is
     * used in polynomial subtraction where negating the second polynomial and then adding it
     * to the first polynomial achieves the subtraction operation.
     *
     * @param polynomial The polynomial to negate.
     * @return A new PolynomialLinkedList instance representing the negated polynomial.
     */
    

    /**
     * Subtracts the second polynomial from the first polynomial. This is achieved by negating
     * the second polynomial and then adding it to the first polynomial.
     *
     * @param p1 The first polynomial.
     * @param p2 The second polynomial to subtract from the first polynomial.
     * @return A new PolynomialLinkedList instance representing the result of the subtraction.
     */
    

    /**
     * Multiplies two polynomials. Each term of the first polynomial is multiplied by each term
     * of the second polynomial. The result is a new polynomial where terms with the same exponents
     * are combined.
     *
     * @param p1 The first polynomial.
     * @param p2 The second polynomial.
     * @return A new PolynomialLinkedList instance representing the result of the multiplication.
     */
    










/**
 * Handles polynomial operations by reading inputs from a file, processing operations like addition,
 * subtraction, and multiplication on polynomials, and writing the results to another file.
 */

    /**
     * Constructs a PolynomialOperations object with specified paths for input and output files.
     *
     * @param inputFilePath  Path to the input file.
     * @param outputFilePath Path to the output file.
     */
    

    /**
     * Executes polynomial operations (addition, subtraction, multiplication) from an input file,
     * writing results to an output file. It reads the number of test cases from the first line,
     * followed by lines with an operation symbol (+, -, *) and two polynomials per test case.
     */
    

    /**
     * Processes a single test case from the scanner, performs the operation on polynomials, and writes
     * the result to the output file.
     *
     * @param scanner   Scanner object to read a test case.
     * @param outputFile PrintWriter object to write the result.
     */
    

    /**
     * Executes a polynomial operation (add, subtract, multiply) based on the operation string, and writes
     * the result to the output file.
     *
     * @param operation Operation string ("+", "-", "*").
     * @param p1        The first polynomial operand.
     * @param p2        The second polynomial operand.
     * @param outputFile PrintWriter object to write the result.
     */
    
     
