package com.twu.biblioteca;

public enum MenuOptionsEnum {

    LIST_BOOKS("1"),
    CHECK_OUT_BOOK("2"),
    RETURN_BOOK("3");

    private String id;

    MenuOptionsEnum(String id) {
        this.id = id;
    }

    public String returnId(){  return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case LIST_BOOKS:
                return "List Books";
            case CHECK_OUT_BOOK:
                return "Check out a book";
            case RETURN_BOOK:
                return "Return a book";
        }
        return "";
    }
}
