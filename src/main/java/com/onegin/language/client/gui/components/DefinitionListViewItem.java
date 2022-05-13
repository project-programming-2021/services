package com.onegin.language.client.gui.components;

import com.onegin.language.client.dictionary.entities.Definition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DefinitionListViewItem extends HBox {

    @FXML
    Label wordLabel;

    @FXML
    Label commentLabel;

    @FXML
    VBox rooty;

    public DefinitionListViewItem(boolean ordered) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DefinitionListViewItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!ordered) {
            //this.getChildren().removeAll();
            //this.getChildren().add(commentLabel);
            this.rooty.getChildren().get(0).toFront();
        }
    }

    public void setDefinition(Definition definition) {
        this.wordLabel.setText(definition.getWord());
        int n = definition.getWordDefinitions().size();
        if (n % 10 == 1) {
            this.commentLabel.setText("Найдена " + n + " статья.");
        } else if ((n % 10 >= 2) && (n % 10 <= 4)) {
            this.commentLabel.setText("Найдено " + n + " статьи.");
        } else {
            this.commentLabel.setText("Найдено " + n + " статей.");
        }
    }


}
