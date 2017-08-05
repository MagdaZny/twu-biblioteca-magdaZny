package com.twu.biblioteca;

import java.util.List;

public abstract class BibliotecaApp<Item>{

    protected List<Item> stock;
    protected List<Item> checkedOut;


    public void checkOut(Item item) {

        if (isInStock(item)) {
            stock.remove(item);
            checkedOut.add(item);
        }
    }

    public Boolean isInStock(Item item) {

        return (stock.contains(item));
    }


    public void returnTheItem(Item item) {

        if (isCheckedOut(item)) {
            checkedOut.remove(item);
            stock.add(item);
        }
    }

    public Boolean isCheckedOut(Item item) {

        return checkedOut.contains(item);
    }


    public List<Item> getTheItemsInStock() {

        return stock;
    }


    public List<Item> getTheItemsCheckedOut() {

        return checkedOut;
    }




}

