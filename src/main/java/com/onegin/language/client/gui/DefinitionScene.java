package com.onegin.language.client.gui;

import com.onegin.language.client.dictionary.entities.Definition;
import com.onegin.language.client.dictionary.entities.PartOfSpeech;
import com.onegin.language.client.dictionary.entities.WordDefinition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DefinitionScene extends HBox {

    @FXML
    Label word;

    @FXML
    VBox definitionBox;

    public DefinitionScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("definition.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDefinition(Definition s) {
        this.word.setText(s.getWord());
        int i = 1;
        for (WordDefinition w : s.getWordDefinitions()) {
            String text = i++ + ". ";
            if (w.getPartOfSpeech() == PartOfSpeech.Noun) {
                text += "сущ. ";
            }
            if (w.getPartOfSpeech() == PartOfSpeech.Adjective) {
                text += "прил. ";
            }
            if (w.getPartOfSpeech() == PartOfSpeech.Adverb) {
                text += "нар. ";
            }
            if (w.getPartOfSpeech() == PartOfSpeech.Verb) {
                text += "гл. ";
            }
            this.definitionBox.getChildren().add(new Label(text + w.getMeaning()));
        }
    }


}
