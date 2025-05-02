package HW3.Model;

import HW3.Controller.Book;

import java.io.*;
import java.util.ArrayList;

public class BookFile {
    //private static final String FILENAME = "books.txt";

    // Writes a  Book object to the file.
    //  If the file already exists, it appends the object without writing a new stream header.
    //  will throw IOException If an I/O error occurs while writing the file.

    public static void writeFile(Book book) throws IOException {
        File file = new File("file.dat");
        boolean append = file.exists(); // if file exists then append, otherwise create new

        try (
                FileOutputStream fout = new FileOutputStream(file, append);
                AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fout, append);
        ) {
            oout.writeObject(book); // replace "..." with serializable object to be written
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
// Reads book object file
// IOException If an I/O error occurs while reading the file.
//  ClassNotFoundException If a class in the stream cannot be found.

    public static ArrayList<Book> readFile() throws IOException, ClassNotFoundException {
        ArrayList<Book> books = new ArrayList<>();
        File file = new File("file.dat");
        if (!file.exists()) return books; // Return empty list if file doesn't exist

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    books.add((Book) ois.readObject());
                } catch (EOFException eof) {
                    break;
                }
            }
        }
        return books;
    }
}
