package com.tts;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String address;
    String openingHours;
    private List<Book> books;
    String returned;

    public Library(String address){
        this.address=address;
        books=new ArrayList<>();
    }

    public String setAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public static void printOpeningHours(){

        System.out.printf("Libraries are open daily from 9 AM to 5 PM daily");
    }
    public void printAddress(){
        System.out.println(this.address);
    }
    public void borrowBook(String title){
        boolean found=false;
        for(Book book:books){
            if(book.getTitle().equalsIgnoreCase(title) ){
                found=true;
                if(!book.isBorrowed() ){
                    book.rented();
                    System.out.printf("You successfully borrowed %S\n",title);
                    break;
                }
                else{
                    System.out.println("Sorry, this book is already borrowed.");
                }
            }}
        if(!found)
            System.out.println("Sorry, this book is not in our catalog.");
    }


    public String returnBook(String bookTitle) {
        boolean found = false;

        for(int i = 0; i < this.books.size(); ++i) {
            Book libraryBook = (Book)this.books.get(i);
            String libraryBookTitle = libraryBook.getTitle();
            if (libraryBookTitle.equals(bookTitle)) {
                if (libraryBook.isBorrowed()) {
                    libraryBook.returned();
                    System.out.println("You successfully returned " + libraryBookTitle + "!");
                    found = true;
                    break;
                }

                if (!found) {
                    System.out.println("Are you sure you got the book from here? It isn't in our system.");
                }
            }
        }

        System.out.println();
        return null;
    }
    public void printAvailableBooks(){
        boolean empty=true;
        for(Book book: books){
            if(!book.isBorrowed()) {
                empty=false;
                System.out.println(book.getTitle());
            }
        }
        if(empty){
            System.out.println("No book in catalog ");
        }
    }
    public void addBook(Book book){
        this.books.add(book);
    }

//    // Add the missing implementation to this class
//    String libraryAddress;
//    ArrayList<Book> books;

////    String borrowedBook;
//
//    public Library(String address) {
//        this.libraryAddress = address;
//        this.books = new ArrayList();
//    }
//    public void addBook(Book book) {
//        this.books.add(book);
//    }
//
//    private static void printOpeningHours() {
//
//        System.out.println(" 9 AM to 5 PM daily");
//    }
//
//
//    private void printAddress() {
//        System.out.println(this.libraryAddress);
//    }
//
//
//    private void borrowBook(String myBorrowedBook) {
//        System.out.println(myBorrowedBook);
//    }
//
//    private void returnBook(String returnedBook) {
//        System.out.println(returnedBook);
//    }
//
//    private void printAvailableBooks() {
//        System.out.println();
//    }



    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));


        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }







}



