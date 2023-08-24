package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR_SERVER(HttpStatus.INTERNAL_SERVER_ERROR, 5100, "Sunucu Hatası!"),

    BAD_REQUEST(HttpStatus.BAD_REQUEST, 4100, "Parametre Hatası!"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, 4110, "Böyle Bir Kullanıcı Bulunamadı!"),

    ACCOUNT_NOT_ACTIVE(HttpStatus.BAD_REQUEST, 4111, "Hesabınız Aktif Değildir!"),

    INVALID_CODE(HttpStatus.BAD_REQUEST, 4112, "Geçersiz Kod!"),

    ALREADY_ACTIVE(HttpStatus.BAD_REQUEST, 4113, "Hesabınız Zaten Aktif!"),

    UNEXPECTED_ERROR(HttpStatus.BAD_REQUEST, 4114, "Beklenmeyen Bir Hata Oluştu!"),

    USERNAME_ALREADY_EXIST(HttpStatus.BAD_REQUEST, 4115, "Kullanıcı Adı Zaten Kullanılıyor!"),

    DATA_INTEGRITY(HttpStatus.BAD_REQUEST, 4116, "Veri Bütünlüğü Hatası!"),

    LOGIN_ERROR(HttpStatus.BAD_REQUEST, 4117, "Kullanıcı Adı veya Şifre Hatalı!"),

    INVALID_TOKEN(HttpStatus.BAD_REQUEST, 4118, "Geçersiz Token!"),

    TOKEN_NOT_CREATED(HttpStatus.BAD_REQUEST, 4119, "Token Oluşturulamadı!");


    HttpStatus httpStatus;

    private int code;

    private String message;
}