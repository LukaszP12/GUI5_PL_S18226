package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class DataHelper {

    public static ObservableList getDataFromFile(String nameFile) throws FileNotFoundException {
        final File file = new File(nameFile);
        final Scanner in = new Scanner(file);
        final ObservableList<Book> books = FXCollections.observableArrayList();

        while (in.hasNextLine()) {
            final String[] dataFromFile = in.nextLine().split(",");
            final Book book = new Book(dataFromFile[0], dataFromFile[1], dataFromFile[2], new Image(dataFromFile[3]));
            books.add(book);
        }

        return books;
    }
}
