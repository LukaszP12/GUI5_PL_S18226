/**
 * @author Piwowarski Łukasz S18226
 */
package zad3;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private TableView<Book> table = new TableView<>();
    private final ObservableList<Book> data = DataHelper.getDataFromFile("bookData.txt");
    private final HBox hb = new HBox();

    public Main() throws FileNotFoundException {}

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Library");
        stage.setWidth(300);
        stage.setHeight(500);

        final Label label = new Label("Library");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        final TableColumn author = new TableColumn("Autor");
        author.setMinWidth(100);
        author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        final TableColumn title = new TableColumn("Tytuł");
        title.setMinWidth(100);
        title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        final TableColumn price = new TableColumn("Cena");
        price.setMinWidth(200);
        price.setCellValueFactory(new PropertyValueFactory<Book, String>("price"));
        final TableColumn<Book, ImageView> image = new TableColumn<Book, ImageView>("Images");
        image.setCellValueFactory(new PropertyValueFactory<Book, ImageView>("image"));
        image.setPrefWidth(60);

        table.setItems(data);
        table.getColumns().addAll(author, title, price,image);

        final TextField authorT = new TextField();
        authorT.setPromptText("Author");
        authorT.setMaxWidth(authorT.getPrefWidth());
        final TextField titleT = new TextField();
        titleT.setMaxWidth(title.getPrefWidth());
        titleT.setPromptText("Title");
        final TextField priceT = new TextField();
        priceT.setMaxWidth(price.getPrefWidth());
        priceT.setPromptText("Price");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Book(authorT.getText(), titleT.getText(), priceT.getText(), null));
                authorT.clear();
                titleT.clear();
                priceT.clear();
            }
        });

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Book selectedItem = (Book) table.getSelectionModel().getSelectedItem();
            table.getItems().remove(selectedItem);
        });

        hb.getChildren().addAll(authorT, titleT, priceT, addButton, deleteButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}
