package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Borrow;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BorrowRepository implements ICrud<Borrow> {

    Session session;
    Transaction transaction;

    @Override
    public Borrow save(Borrow borrow) {

        try {

            session = HibernateUtility.getSESSION_FACTORY().openSession();

            transaction = session.beginTransaction();

            System.out.println("Oturum Açıldı");

            session.save(borrow);

            transaction.commit();

            System.out.println("Kayıt Başarılı");

        } catch (Exception e) {

            e.printStackTrace();

            transaction.rollback();

        } finally {

            System.out.println("Oturum Kapandı");

            session.close();

        }
        return borrow;
    }

    @Override
    public Borrow update(Borrow address) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Borrow> findAll() {
        return null;
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return Optional.empty();
    }
}