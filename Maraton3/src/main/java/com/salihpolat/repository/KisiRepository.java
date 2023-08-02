package com.salihpolat.repository;

import com.salihpolat.model.Kisi;
import com.salihpolat.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KisiRepository {

    public Kisi kisiEkle(Kisi kisi) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(kisi);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
        return kisi;
    }

    public Kisi idyeGoreKisiGetir(Long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Kisi.class, id);

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }
    }
}