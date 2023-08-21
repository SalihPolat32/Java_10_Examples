package com.bilgeadam.utility;

import java.util.UUID;

public class CodeGenerator {

    // random bir kod oluşturacağız
    // random bir uuid oluşturuyoruz
    // af7c1fe6-d669-414e-b066-e9733f0de7a8
    // ad4be
    // metot bize string olarak kodu döndürsün
    public static String generateCode() {

        String uuid = UUID.randomUUID().toString();

        //546654-546465-46132-87-9

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