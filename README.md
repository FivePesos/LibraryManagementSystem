# LibraryManagementSystem

Tasked with developing a simple library management system that involves managing books. 
The primary focus is to create a Book class that will help manage individual book records
in the library. The Book class should demonstrate encapsulation principles by keeping its data
private and provide controlled access through public methods.

Requirements:
    * title(String): The title of the book. This should be kept private to prevent
    unauthorized modification
    * author(String): The author of the book. This should also be kept private
    * isbn(String): The International Standard Book Number of the book. This is
    unique and private
    * availableCopies(int): The number of available copies of the book in the library
    This should be private to prevent direct access and manipulation

Use Case:
    * User should be able to create a book, borrow a book, return a book, get the details of the book
    and get it's available number of copies
