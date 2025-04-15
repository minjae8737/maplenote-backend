package com.project.maplenote.character.repository;

import com.project.maplenote.character.domain.character.CharacterExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterExpRepository extends JpaRepository<CharacterExp, Long> {

    boolean existsByOcidAndDate(String ocid, String date);

    @Query("SELECT c FROM CharacterExp c WHERE c.ocid = :ocid ORDER BY c.date DESC LIMIT 14")
    List<CharacterExp> findAllByOcid(String ocid);

}
