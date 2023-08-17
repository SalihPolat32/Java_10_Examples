package com.socialmedia.utility;

import java.util.UUID;

public class CodeGenerator {

    // random bir kod oluşturucaz
    // random bir uuid oluşturuyoruz
    // c5b5283c-ca39-4113-8000-3fcc7932350e
    // cc43
    // metotda bize string olarak kodu döndürsün

    public static String generateCode() {

        String uuid = UUID.randomUUID().toString();

        String[] data = uuid.split("-");

        String newCode = "";

        int i = 0;

        while (i < data.length) {
            newCode += data[i].charAt(0);
            i++;
        }

        return newCode;
    }
}