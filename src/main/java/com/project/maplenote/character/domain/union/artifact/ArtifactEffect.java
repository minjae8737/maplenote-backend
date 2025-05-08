package com.project.maplenote.character.domain.union.artifact;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArtifactEffect {

    @JsonProperty("name")
    private String name; // 아티팩트 효과 명

    @JsonProperty("level")
    private Long level; // 아티팩트 효과 레벨

}
