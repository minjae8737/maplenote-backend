package com.project.maplenote.global.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;       //성공 여부
    private T data;                //데이터
    private String message;        //메세지
    private int statusCode;        //HTTP status code

}
