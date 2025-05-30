package com.project.maplenote.user.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    private String id; //ObjectId
    private String email;
    private String password;
//   private List<MyCharacter> myCharacters  //내 캐릭터 모음

    public User(LoginDto loginDto) {
        this.email = loginDto.getEmail();
        this.password = loginDto.getPassword();
    }

}
