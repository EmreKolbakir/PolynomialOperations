# Polynomial Operations in Java

## Overview
This project provides an implementation of polynomial operations using a linked list data structure in Java. It's designed to handle polynomials in multiple variables and supports operations such as addition, subtraction, and multiplication. The core of the project is built around four main classes: `Main`, `PolynomialLinkedList`, `PolynomialOperations`, and `TermNode`. Additionally, a `test` class is included to demonstrate the functionality and usage of the polynomial operations.

## Features
- **Addition and Subtraction:** Combine or differentiate polynomials with ease.
- **Multiplication:** Multiply two polynomials to obtain a new polynomial.
- **Support for Multiple Variables:** Unlike many polynomial implementations, this project can handle polynomials in multiple variables (e.g., x, y, z).
- **Dynamic Polynomial Manipulation:** Easily add new terms to or remove terms from a polynomial.

## Getting Started
To get started with this project, clone the repository to your local machine and ensure you have Java installed.

git clone https://github.com/EmreKolbakir/PolynomialOperations

- Compile and run the Main class to see the project in action. Depending on your IDE or build system, the steps to do this may vary.

## Usage
The project is structured around simple usage patterns. Here is a basic example of creating two polynomials and performing operations on them:


```java
PolynomialLinkedList poly1 = new PolynomialLinkedList();
poly1.addTerm(3, 2, 4); // Adds 3x^2y^4
PolynomialLinkedList poly2 = new PolynomialLinkedList();
poly2.addTerm(5, 3, 2); // Adds 5x^3y^2

PolynomialLinkedList result = PolynomialOperations.add(poly1, poly2);
System.out.println(result); // Outputs the result of poly1 + poly2
```

## Testing

- The test class includes several predefined tests to verify the correctness of polynomial operations. Run this class to ensure the implementation behaves as expected.




