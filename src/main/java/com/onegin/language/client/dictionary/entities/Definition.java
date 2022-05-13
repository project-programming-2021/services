package com.onegin.language.client.dictionary.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Definition {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String word;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<WordDefinition> wordDefinitions;

    /* весь код ниже, кроме addDefinition, сделан благодаря Generate... */

    public Definition() {

    }

    public Definition(String word) {
        this.word = word;
        this.wordDefinitions = new ArrayList<>();
    }

    // Не пугайтесь. Здесь вместо void стоит Definition,
    // чтобы можно было добавлять значения в одну строчку:
    // (new Definition("яблоко")).addDefinition(new WordDefinition())
    public Definition addDefinition(WordDefinition wordDefinition) {
        this.wordDefinitions.add(wordDefinition);
        return this;
    }

    public String getWord() {
        return word;
    }

    public List<WordDefinition> getWordDefinitions() {
        return wordDefinitions;
    }

}
