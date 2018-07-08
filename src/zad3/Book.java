package zad3;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Book {

    private final SimpleStringProperty author;
    private final SimpleStringProperty title;
    private final SimpleStringProperty price;
    private ImageView image;

    public Book(final String author, final String title, final String price, final Image image) {
        this.author = new SimpleStringProperty(author);
        this.title = new SimpleStringProperty(title);
        this.price = new SimpleStringProperty(price);
        this.image = new ImageView(image);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author.set(author);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(final String title) {
        this.title.set(title);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(final String price) {
        this.price.set(price);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(final ImageView image) {
        this.image = image;
    }
}
