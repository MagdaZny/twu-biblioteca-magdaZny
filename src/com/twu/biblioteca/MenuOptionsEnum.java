package com.twu.biblioteca;

public enum MenuOptionsEnum {

    LIST_BOOKS("1"),
    CHECK_OUT_BOOK("2"),
    RETURN_BOOK("3"),
    LIST_MOVIES("4"),
    CHECK_OUT_MOVIE("5"),
    RETURN_MOVIE("6");

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
            case LIST_MOVIES:
                return "List movies";
            case CHECK_OUT_MOVIE:
                return "Check out a movie";
            case RETURN_MOVIE:
                return "Return a movie";
        }
        return "";
    }
}
