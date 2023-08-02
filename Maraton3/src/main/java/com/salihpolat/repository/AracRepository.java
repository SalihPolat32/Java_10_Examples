package com.salihpolat.repository;

import com.salihpolat.model.Arac;
import com.salihpolat.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class AracRepository {

    public Arac aracEkleme(Arac arac) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(arac);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        }
        return arac;
    }

    public List<Arac> kiradakiAraclar() {

        String hql = "SELECT a FROM Arac AS a WHERE a.durum = 'KIRADA'";

        Session session = HibernateUtil.getSessionFactory().openSession();

        TypedQuery<Arac> typedQuery = session.createQuery(hql, Arac.class);

        return typedQuery.getResultList();
    }

    public Arac idyeGoreAracBulma(Long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            System.out.println("Araç Durumu: " + session.get(Arac.class, id));

            return session.get(Arac.class, id);

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    public List<Arac> musaitAraclar() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM Arac WHERE durum = 'MUSAIT'", Arac.class).list();

        } catch (Exception ex) {

            ex.printStackTrace();

            return null;
        }
    }
}