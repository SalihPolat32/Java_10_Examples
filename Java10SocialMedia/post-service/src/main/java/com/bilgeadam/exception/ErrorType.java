package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR_SERVER(HttpStatus.INTERNAL_SERVER_ERROR, 5200, "Sunucu Hatası!"),

    BAD_REQUEST(HttpStatus.BAD_REQUEST, 4200, "Parametre Hatası!"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, 4210, "Böyle Bir Kullanıcı Bulunamadı!"),

    INVALID_CODE(HttpStatus.BAD_REQUEST, 4212, "Geçersiz Kod!"),

    UNEXPECTED_ERROR(HttpStatus.BAD_REQUEST, 4213, "Beklenmeyen Bir Hata Oluştu!"),

    INVALID_TOKEN(HttpStatus.BAD_REQUEST, 4214, "Geçersiz Token!"),

    TOKEN_NOT_CREATED(HttpStatus.BAD_REQUEST, 4215, "Token Oluşturulamadı!"),

    POST_NOT_CREATED(HttpStatus.BAD_REQUEST, 4216, "Post Oluşturulamadı!");


    HttpStatus httpStatus;

    private int code;

    private String message;
}