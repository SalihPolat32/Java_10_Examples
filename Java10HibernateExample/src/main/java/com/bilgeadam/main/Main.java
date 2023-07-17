package com.bilgeadam.main;

import com.bilgeadam.repository.entity.User;
import com.bilgeadam.repository.enums.EGender;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        User user = User.builder()
                .name("Mustafa")
                .username("musty")
                .password("123")
                .gender(EGender.MAN)
                .age(25)
                .build();

        User user2 = User.builder()
                .name("MUSTAFA")
                .username("musty2")
                .password("12345")
                .gender(EGender.MAN)
                .age(35)
                .build();

            Session session = null;

            Transaction transaction = null;

            session = HibernateUtility.getSessionFactory().openSession();

            transaction = session.beginTransaction();

        try {

            session.save(user);
            session.save(user2);

            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();

            transaction.rollback();

        } finally {

            session.close();

        }
    }
}