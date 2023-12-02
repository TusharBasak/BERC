/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;

/**
 *
 * @author ISLAM
 */
public class URLTableCell<T> extends  TableCell<T, URL> {
    @Override
    protected void updateItem(URL item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
        } else {
            T data = (T) getTableRow().getItem(); // Access the 'T' type data
            // Use the 'data' object to extract relevant information
           // String additionalInfo = data.getAdditionalInfo();

            Hyperlink hyperlink = new Hyperlink(item.toString() + " - " );
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                   // Desktop.getDesktop().open(data);
                }
            });

            setText(hyperlink.toString());
        }
    }
}
