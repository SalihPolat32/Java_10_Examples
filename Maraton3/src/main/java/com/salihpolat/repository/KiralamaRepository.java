package com.salihpolat.repository;

import com.salihpolat.model.Arac;
import com.salihpolat.model.Kiralama;
import com.salihpolat.model.Kisi;
import com.salihpolat.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class KiralamaRepository {

    public Kiralama kiralamaEkle(Kiralama kiralama) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(kiralama);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        }
        return kiralama;
    }

    public void kiradakiAraclar() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.createQuery("FROM Arac", Kisi.class).list();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public List<Arac> kisiIdsineGorekiralananAraclar(Long id) {

        String hql = "SELECT k.arac FROM Kiralama AS k WHERE k.kisi.id =: id";

        Session session = HibernateUtil.getSessionFactory().openSession();

        TypedQuery<Arac> typedQuery = session.createQuery(hql, Arac.class);

        typedQuery.setParameter("id", id);

        return typedQuery.getResultList();
    }
}