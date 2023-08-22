package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR_SERVER(5100, "Sunucu Hatası!", HttpStatus.INTERNAL_SERVER_ERROR),

    BAD_REQUEST(4100, "Parametre Hatası!", HttpStatus.BAD_REQUEST),

    USER_NOT_FOUND(4110, "Böyle Bir Kullanıcı Bulunamadı!", HttpStatus.NOT_FOUND),

    ACCOUNT_NOT_ACTIVE(4111, "Hesabınız Aktif Değildir!", HttpStatus.BAD_REQUEST),

    INVALID_CODE(4112, "Geçersiz Kod!", HttpStatus.BAD_REQUEST),

    ALREADY_ACTIVE(4113, "Hesabınız Zaten Aktif!", HttpStatus.BAD_REQUEST),

    UNEXPECTED_ERROR(4114, "Beklenmeyen Bir Hata Oluştu!", HttpStatus.BAD_REQUEST),

    USERNAME_ALREADY_EXISTS(4115, "Kullanıcı Adı Zaten Kullanılıyor!", HttpStatus.BAD_REQUEST),

    DATA_INTEGRITY(4116, "Veri Bütünlüğü Hatası!", HttpStatus.BAD_REQUEST),

    LOGIN_ERROR(4117, "Kullanıcı Adı veya Şifre Hatalı!", HttpStatus.BAD_REQUEST),

    INVALID_TOKEN(4118, "Geçersiz Token!", HttpStatus.BAD_REQUEST);

    private int code;

    private String message;

    HttpStatus httpStatus;
}