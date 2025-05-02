package Practice;

import HW3.Controller.Book;
import HW3.Model.BookFile;

import java.io.*;
import java.util.ArrayList;

public class FileBookCopy {

//import HW3.Controller.Book;
//
//import java.io.*;
//import java.util.ArrayList;
//
//    public class BookFile {
//        private static final String FILENAME = "books.txt";
//
//        public static void writeFile(Book book) throws IOException {
//            boolean append = new File(FILENAME).exists();
//            try (ObjectOutputStream oos = append
//                    ? new HW3.Model.BookFile.AppendableObjectOutputStream(new FileOutputStream(FILENAME, true))
//                    : new ObjectOutputStream(new FileOutputStream(FILENAME))) {
//                oos.writeObject(book);
//            }
//        }
//
//        public static ArrayList<Book> readFile() throws IOException, ClassNotFoundException {
//            ArrayList<Book> books = new ArrayList<>();
//            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
//                while (true) {
//                    try {
//                        books.add((Book) ois.readObject());
//                    } catch (EOFException eof) {
//                        break;
//                    }
//                }
//            }
//            return books;
//        }
//
//        private static class AppendableObjectOutputStream extends ObjectOutputStream {
//            public AppendableObjectOutputStream(OutputStream out) throws IOException {
//                super(out);
//            }
//
//            @Override
//            protected void writeStreamHeader() throws IOException {
//                reset();
//            }
//        }
//    }
}
