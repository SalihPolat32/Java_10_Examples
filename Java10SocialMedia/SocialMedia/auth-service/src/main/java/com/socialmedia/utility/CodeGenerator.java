package com.socialmedia.utility;

import java.util.UUID;

public class CodeGenerator {

    // random bir kod oluşturucaz
    // random bir uuid oluşturuyoruz
    // c5b5283c-ca39-4113-8000-3fcc7932350e
    // cc43
    // metotda bize string olarak kodu döndürsün

    public static String generateCode() {

        String code = "";

        UUID uuid = UUID.randomUUID();

        code = uuid.toString().substring(0, 4);
        
        return code;
    }
}