package dto;

public class Library {
    private String name;
    //private Libarian librarian;
    //private Book book;
    private Dvd dvd;

    //Composition is the mechanism that allows for the "objects can be made up
    //of other objects" characteristic. E.g. the library object is made up of
    //the objects: librarians, dvds and books, instead of primitive types or string.

    //It allows us to express a has-a relationship - a library has books, dvds and a
    //librarian. Library is not 'a' dvd but 'has' one etc.

    //Composition allows us to reuse code and delegate to the contain object when we want
    //to take advantage of the capabilities of that object.

    public Library(String name) {
        this.name = name;
    }


    //Getters, no setters as we can't change the information of these items in a library.
//    public Libarian getLibrarian() {
//        return librarian;
//    }
//
//    public Book getBook() {
//        return book;
//    }

    public Dvd getDvd() {
        return dvd;
    }

    public String getName() {
        return name;
    }


}
