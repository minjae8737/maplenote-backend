package com.project.maplenote.character.domain.union.matrix;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlockCoordinate {

    @JsonProperty("x")
    private Long x; // X 좌표

    @JsonProperty("y")
    private Long y; // Y 좌표

}
