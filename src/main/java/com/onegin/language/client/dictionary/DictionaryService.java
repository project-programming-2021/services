package com.onegin.language.client.dictionary;

import com.onegin.language.client.dictionary.entities.Definition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryService {

    @Autowired
    private DefinitionRepository repository;
    //    Раньше было:
    //    private SortedMap<String, Definition> dictionary;

    public DictionaryService() {

    }

    public List<Definition> getAllDefinitions() {
        return this.repository.findAll();
    }

    public Definition getDefinition(String word) {
        return this.repository.findByWord(word).get(0);
    }

}
