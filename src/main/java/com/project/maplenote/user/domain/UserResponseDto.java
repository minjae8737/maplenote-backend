package com.project.maplenote.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private String email;
//   private List<MyCharacter> myCharacters  //내 캐릭터 모음


    public UserResponseDto(String email) {
        this.email = email;
    }
}
