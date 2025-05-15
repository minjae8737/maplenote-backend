package com.project.maplenote.character.domain.union.matrix;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * <strong>blockControlPoint 블록 기준점 좌표</strong>
 * <p>
 * 중앙 4칸 중 오른쪽 아래 칸이 x : 0, y : 0 포지션 <br>
 * 좌측으로 1칸씩 이동하면 x가 1씩 감소 <br>
 * 우측으로 1칸씩 이동하면 x가 1씩 증가 <br>
 * 아래로 1칸씩 이동하면 y가 1씩 감소 <br>
 * 위로 1칸씩 이동하면 y가 1씩 증가 <br>
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class UnionBlock {

    @JsonProperty("block_type")
    private String blockType; // 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)

    @JsonProperty("block_class")
    private String blockClass; // 블록의 캐릭터 직업

    @JsonProperty("block_level")
    private String blockLevel; // 블록의 캐릭터 레벨

    @JsonProperty("block_control_point")
    private BlockCoordinate blockControlPoint; // 블록 기준점 좌표

    @JsonProperty("block_position")
    private List<BlockCoordinate> blockPosition; // 블록이 차지하고 있는 영역 좌표들

}