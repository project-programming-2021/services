package com.onegin.language.client.dictionary;

import java.util.List;

import com.onegin.language.client.dictionary.entities.Definition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefinitionRepository extends JpaRepository<Definition, Long> {

    List<Definition> findByWord(String word);

}