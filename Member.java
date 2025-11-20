/*
 * 1. Abdulaziz Alabdulkareem - 446103513
 * 2. Saleh Alolyan - 446100843
 */

public class Member {
    private int id;
    private String name;
    private int borrowedCount;
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;
    public static double TotalRevenue = 0.0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    //Constructor
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }
    //Methods
    private boolean canBorrow() {
        return borrowedCount < 5;
    }

    private boolean canReturn() {
        return borrowedCount > 0;
    }

    public void viewBorrowedCount() {
        numViewBorrowed++;
        TotalViewBorrowed++;
        System.out.println("Currently borrowed books: " + this.borrowedCount);
    }

    public boolean borrowOne() {
        if (canBorrow()) {
            borrowedCount++;
            numBorrows++;
            TotalBorrows++;
            sessionFees += 0.50;
            TotalRevenue += 0.50;
            System.out.println("Book borrowed successfully Fee: 0.50");
            return true;
        } else {
            System.out.println("Error: You cannot borrow more than 5 books");
            return false;
        }
    }

    public boolean returnOne() {
        if (canReturn()) {
            borrowedCount--;
            numReturns++;
            TotalReturns++;
            System.out.println("Book returned successfully");
            return true;
        } else {
            System.out.println("Error: No books to return");
            return false;
        }
    }

    public void displayStatistics() {
        System.out.println("\n*** Session Summary ***");
        System.out.println("Books borrowed: " + this.numBorrows);
        System.out.println("Books returned: " + this.numReturns);
        System.out.printf("Total fees: %.2f%n", this.sessionFees);
    }

    public void reset() {
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getBorrowedCount() {
        return borrowedCount;
    }
}