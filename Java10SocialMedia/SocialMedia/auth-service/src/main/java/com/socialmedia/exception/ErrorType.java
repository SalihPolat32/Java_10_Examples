package com.socialmedia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    USER_NOT_FOUND(5100, "Böyle Bir Kullanıcı Bulunamadı!!!", HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4100, "Hesabınız Aktif Değil!!!", HttpStatus.BAD_REQUEST),
    INVALID_CODE(4101, "Geçersiz Aktivasyon Kodu!!!", HttpStatus.BAD_REQUEST),
    ALREADY_ACTIVE(4200, "Hesabınız Zaten Aktif!!!", HttpStatus.BAD_REQUEST);

    HttpStatus httpStatus;

    private int code;

    private String message;
}