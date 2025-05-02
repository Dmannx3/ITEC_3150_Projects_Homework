package HW3.Controller;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private String genre;
    private int numChapters;
    private boolean inLibrary;
    private String libraryName;

    public Book() {
this.title = "This is a book";
this.author = "author";
this.genre = "History";
this.numChapters = 10;
this.inLibrary = false;
this.libraryName = "";
    }
    public Book(String title, String author, String genre, int numChapters, boolean inLibrary, String libraryName) throws BookException {
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setNumChapters(numChapters);
        setLibraryName(libraryName);
        setInLibrary(inLibrary);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws BookException {
        if (title.length() < 2){
            throw new BookException("Title must be two characters!");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws BookException {
        if (author.length() < 5){
            throw new BookException("Author must be five characters!");
        }
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) throws BookException {
        if (!(genre.contains("History") || genre.contains("Military") ||
                genre.contains("Science Fiction") || genre.contains("Fantasy") || genre.contains("Romance"))){
            throw new BookException("Genre must be either History, Military, Science Fiction, Fantasy or Romance!");
        }
        this.genre = genre;
    }
    public int getNumChapters() {
        return numChapters;
    }

    public void setNumChapters(int numChapters) throws BookException {
        if (numChapters < 1 || numChapters > 100){
            throw new BookException("Number of chapters must be between 1 and 100!");
        }
        this.numChapters = numChapters;
    }

    public boolean isInLibrary() {

        return inLibrary;
    }

    public void setInLibrary(boolean inLibrary) throws BookException {
        if (inLibrary){
            if (libraryName == null || libraryName.trim().split(" ").length < 2){
                throw new BookException("Library name must be two Words!");
            }
        }
        this.inLibrary = inLibrary;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    @Override
    public String toString() {
        return
                "Book Title: " + title + '\'' +
                ", Author: " + author + '\'' +
                ", Genre: " + genre + '\'' +
                ", Number of Chapters: " + numChapters +
                ", In Library: " + inLibrary +
                ", LibraryName: " + libraryName + '\'';
    }
}
