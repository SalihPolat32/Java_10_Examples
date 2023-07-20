package com.salihpolat.repository;

import com.salihpolat.repository.entity.UserInformation;
import com.salihpolat.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserInformationRepository implements ICrud<UserInformation> {

    Session session;
    Transaction transaction;

    @Override
    public UserInformation save(UserInformation userInformation) {

        try {

            session = HibernateUtility.getSESSION_FACTORY().openSession();

            transaction = session.beginTransaction();

            System.out.println("Oturum Açıldı");

            session.save(userInformation);

            transaction.commit();

            System.out.println("Kayıt Başarılı");

        } catch (Exception e) {

            e.printStackTrace();

            transaction.rollback();

        } finally {

            System.out.println("Oturum Kapandı");

            session.close();

        }
        return userInformation;
    }

    @Override
    public UserInformation update(UserInformation userInformation) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<UserInformation> findAll() {

        String hql = "SELECT ui FROM UserInformation AS ui";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<UserInformation> typedQuery = session.createQuery(hql, UserInformation.class);
        List<UserInformation> userInformations = typedQuery.getResultList();
        return userInformations;
    }

    @Override
    public Optional<UserInformation> findById(Long id) {
        return Optional.empty();
    }
}