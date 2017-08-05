package com.twu.biblioteca;

public interface UsersInteractions{

     void checkOutBook();

     void returnBook();

     Book getBooksDetailsFromUser(String activity);

     void printCheckOutMessage(Boolean isCheckOutSuccessfull);

     void printReturnBookMessage(Boolean isReturnedSuccessfully);
}
