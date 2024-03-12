import java.io.PrintWriter;

/**
 * Represents a polynomial using a linked list, where each node contains a term of the polynomial.
 * Terms are stored as nodes with coefficients and exponents for x, y, and z variables.
 * Head of the linked list representing the first term of the polynomial.
 */
public class PolynomialLinkedList {
    TermNode head;

    /**
     * Constructs an empty PolynomialLinkedList.
     */
    public PolynomialLinkedList() {
        this.head = null;
    }

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
    public void addTerm(int coefficient, int exponentX, int exponentY, int exponentZ) {
        if (coefficient == 0) return; 
        TermNode newNode = new TermNode(coefficient, exponentX, exponentY, exponentZ);
        if (head == null || isTermGreaterThan(head, exponentX, exponentY, exponentZ)) {
            newNode.next = head;
            head = newNode;
            return;
        }
        TermNode current = head, prev = null;
        while (current != null && !isTermGreaterThan(current, exponentX, exponentY, exponentZ)) {
            if (current.exponentX == exponentX && current.exponentY == exponentY && current.exponentZ == exponentZ) {
                current.coefficient += coefficient;
                if (current.coefficient == 0) {
                    if (prev != null) {
                        prev.next = current.next;
                    } else {
                        head = current.next;
                    }
                }
                return; 
            }
            prev = current;
            current = current.next;
        }
        newNode.next = prev.next; 
        prev.next = newNode;
    }

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
    private boolean isTermGreaterThan(TermNode node, int exponentX, int exponentY, int exponentZ) {
        if (node.exponentX < exponentX) return true;
        if (node.exponentX == exponentX && node.exponentY < exponentY) return true;
        return node.exponentX == exponentX && node.exponentY == exponentY && node.exponentZ < exponentZ;
    }

    /**
     * Parses a polynomial represented as a string and adds its terms to the linked list.
     * The polynomial string format is expected to be a sum of terms, where each term includes
     * coefficients and optionally variables (x, y, z) with their exponents.
     *
     * @param polynomial The polynomial string to be parsed and added.
     */
    public void addPolynomial(String polynomial) {
        String[] terms = polynomial.split("(?=[+-])");
        for (String term : terms) {
            term = term.trim();
            if (term.isEmpty()) continue;

            int coefficient = 0, exponentX = 0, exponentY = 0, exponentZ = 0, i = 0;
            boolean hasSign = term.charAt(i) == '+' || term.charAt(i) == '-';

            if (hasSign) i++;
            int start = i;
            while (i < term.length() && Character.isDigit(term.charAt(i))) i++;
                if (i > start) coefficient = Integer.parseInt(term.substring(start, i)) * (term.startsWith("-") ? -1 : 1);
                else coefficient = hasSign && term.charAt(0) == '-' ? -1 : 1;

            while (i < term.length()) {
                char var = term.charAt(i++);
                int count = (i < term.length() && Character.isDigit(term.charAt(i))) ? term.charAt(i++) - '0' : 1;
                switch (var) {
                    case 'x': exponentX = count; break;
                    case 'y': exponentY = count; break;
                    case 'z': exponentZ = count; break;
                }
            }
            addTerm(coefficient, exponentX, exponentY, exponentZ);
        }
    }

    /**
     * Writes the polynomial to the given PrintWriter. The polynomial is formatted as a string
     * representation with terms ordered and combined properly.
     *
     * @param writer The PrintWriter to which the polynomial string is written.
     */
    public void writePolynomialToFile(PrintWriter writer) {
        if (head == null) {
            writer.println("0");
            return;
        }
        TermNode current = head;
        while (current != null) {
            if (current.coefficient > 0 && current != head) writer.print("+");
            if (Math.abs(current.coefficient) != 1 || (current.exponentX == 0 && current.exponentY == 0 && current.exponentZ == 0)) writer.print(current.coefficient);
            else if (current.coefficient == -1) writer.print("-");
            if (current.exponentX > 1) writer.print("x" + current.exponentX);
            else if (current.exponentX == 1) writer.print("x");
            if (current.exponentY > 1) writer.print("y" + current.exponentY);
            else if (current.exponentY == 1) writer.print("y");
            if (current.exponentZ > 1) writer.print("z" + current.exponentZ);
            else if (current.exponentZ == 1) writer.print("z");

            current = current.next;
        }
        writer.println();
    }

    /**
     * Adds two polynomials represented by PolynomialLinkedLists and returns the result as a new
     * PolynomialLinkedList.
     *
     * @param p1 The first polynomial to add.
     * @param p2 The second polynomial to add.
     * @return The resulting polynomial of adding p1 and p2.
     */
    public static PolynomialLinkedList add(PolynomialLinkedList p1, PolynomialLinkedList p2) {
        PolynomialLinkedList result = new PolynomialLinkedList();
        TermNode current = p1.head;
        while (current != null) {
            result.addTerm(current.coefficient, current.exponentX, current.exponentY, current.exponentZ);
            current = current.next;
        }
        current = p2.head;
        while (current != null) {
            result.addTerm(current.coefficient, current.exponentX, current.exponentY, current.exponentZ);
            current = current.next;
        }
        return result;
    }

    /**
     * Negates a given polynomial by multiplying each term's coefficient by -1. This method is
     * used in polynomial subtraction where negating the second polynomial and then adding it
     * to the first polynomial achieves the subtraction operation.
     *
     * @param polynomial The polynomial to negate.
     * @return A new PolynomialLinkedList instance representing the negated polynomial.
     */
    private static PolynomialLinkedList negate(PolynomialLinkedList polynomial) {
        PolynomialLinkedList negatedPolynomial = new PolynomialLinkedList();
        TermNode current = polynomial.head;
        while (current != null) {
            negatedPolynomial.addTerm(-current.coefficient, current.exponentX, current.exponentY, current.exponentZ);
            current = current.next;
        }
        return negatedPolynomial;
    }

    /**
     * Subtracts the second polynomial from the first polynomial. This is achieved by negating
     * the second polynomial and then adding it to the first polynomial.
     *
     * @param p1 The first polynomial.
     * @param p2 The second polynomial to subtract from the first polynomial.
     * @return A new PolynomialLinkedList instance representing the result of the subtraction.
     */
    public static PolynomialLinkedList subtract(PolynomialLinkedList p1, PolynomialLinkedList p2) {
        PolynomialLinkedList negatedP2 = negate(p2);
        return add(p1, negatedP2);
    }

    /**
     * Multiplies two polynomials. Each term of the first polynomial is multiplied by each term
     * of the second polynomial. The result is a new polynomial where terms with the same exponents
     * are combined.
     *
     * @param p1 The first polynomial.
     * @param p2 The second polynomial.
     * @return A new PolynomialLinkedList instance representing the result of the multiplication.
     */
    public static PolynomialLinkedList multiply(PolynomialLinkedList p1, PolynomialLinkedList p2) {
        PolynomialLinkedList result = new PolynomialLinkedList();

        TermNode current1 = p1.head;
        while (current1 != null) {
            TermNode current2 = p2.head;
            while (current2 != null) {
                int newCoefficient = current1.coefficient * current2.coefficient;
                int newExponentX = current1.exponentX + current2.exponentX;
                int newExponentY = current1.exponentY + current2.exponentY;
                int newExponentZ = current1.exponentZ + current2.exponentZ;

                // adding the new term to the result polynomial, combining like terms
                result.addTerm(newCoefficient, newExponentX, newExponentY, newExponentZ);

                current2 = current2.next;
            }
            current1 = current1.next;
        }
        return result;
    }
}
