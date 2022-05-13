package com.onegin.language.client.dictionary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WordDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private PartOfSpeech partOfSpeech;
    private String meaning;

    /* Весь код ниже я сделал с помощью Generate... */

    public WordDefinition() {

    }

    public WordDefinition(PartOfSpeech partOfSpeech, String meaning) {
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getMeaning() {
        return meaning;
    }

}
