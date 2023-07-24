package com.bilgeadam.repository;

import com.bilgeadam.repository.ICrud;
import com.bilgeadam.repository.entity.Name;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
 * findbyUsername metodunu hql sorgusu olarak yazalım
 * findById metodunu yazalım
 * databasedeki bütün isimleri getirelim metot bize List<Name> listesini dönecek
 * databasedeki bütün firstName'leri getirelim
 * Dışarıdan bir harf gireceğiz ismi bu harfle başlayan kullanıcıları getirelim
 * postCount'ların toplamını bulalım
 * postCount'a göre gruplayalım
 */

/*
 * =====--- ÖDEV ---=====
 * En çok post atan kullanıcıyı bulalım
 * Bütün kullanıcıların userName, gender ve postCount'u dönen sorguyu yazalım
 * Her cinsiyetteki kullanıcıları ve toplam attıkları post sayısını dönen sorguyu yazalım
 * -- optional hql sorgusu post repostiroy'de --> 1 nuramalı postu atan kullanıcıyı getiren sorgu ==> JOIN
 */
public class UserRepository implements ICrud<User> {

    Session session;
    Transaction transaction;

    @Override
    public User save(User user) {

        try {

            session = HibernateUtility.getSessionFactory().openSession();

            System.out.println("Oturum Açıldı");

            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();

            System.out.println("Kayıt Başarılı");

        } catch (Exception e) {

            e.printStackTrace();

            transaction.rollback();

            System.out.println("Kayıt Başarısız!!!");

        } finally {

            System.out.println("Oturum Kapanıyor...");

            session.close();

        }
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {

        // String sql = "SELECT * FROM tbl_user";
        String hql = "SELECT u.username FROM User AS u";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

        List<User> userList = typedQuery.getResultList();

        return userList;
    }

    @Override
    public Optional<User> findById(Long id) {

        String hql = "SELECT u FROM User AS u WHERE u.id =: myid";

        // String hql2 = "SELECT u FROM User AS u WHERE u.id =" + id;

        session=HibernateUtility.getSessionFactory().openSession();

        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

        typedQuery.setParameter("myid",id); // SELECT u FROM User AS u WHERE u.id = 1;

        User user = null;

        try {

            user = typedQuery.getSingleResult();

        } catch (Exception e) {

            System.out.println(e.toString());

        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findByUsername(String username) {

        String hql = "SELECT u FROM User AS u WHERE u.username =: myusername";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

        typedQuery.setParameter("myusername", username);

//        Query query=session.createQuery(hql);
//
//        query.setParameter("myusername",username);
//
//        Query query = session.createQuery(hql, User.class);
//
//        query.setParameter("myusername", username);
//
//        User user1 = typedQuery.getSingleResult();
//
//        User user2 = (User) query.getSingleResult();
//
//        System.out.println("typedQuery ==> " + user1);
//        System.out.println("query ==> " + user2);

        // getSingleResult Bulunamadığı Zaman Exception Fırlatır

        User user = null;

        try {

            user = typedQuery.getSingleResult();

        } catch (Exception e) {

            System.out.println(e.toString());

        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findById2(Long id) {

        User user = session.find(User.class, id);

        if (user == null) {
            System.out.println("Kullanıcı Bulunamadı!!!");
        }
        return Optional.ofNullable(user);
    }

    public List<Name> findAllName() {

        String hql = "SELECT u.name FROM User AS u";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<Name> typedQuery = session.createQuery(hql, Name.class);

        List<Name> allNameList = typedQuery.getResultList();

        return allNameList;
    }

    public List<String> findAllFirstName() {

        String hql = "SELECT u.name.firstName FROM User AS u";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<String> typedQuery = session.createQuery(hql, String.class);

        List<String> allFirstNameList = typedQuery.getResultList();

        return allFirstNameList;
    }

    public List<User> findAllFirstNameStartWith (String value) {

        String hql = "SELECT u FROM User AS u WHERE u.name.firstName LIKE : x";

//        String hql2 = "SELECT u FROM User AS u WHERE u.name.firstName LIKE " + "'" + value + "%'";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

        typedQuery.setParameter("x", value + "%"); // M%

        return typedQuery.getResultList();
    }

    public List<User> findAllFirstNameStartWithAndGtPostCount (String value, int postCount) {

        String hql = "SELECT u FROM User AS u WHERE u.name.firstName LIKE : x AND u.postCount >: y";

//        String hql2 = "SELECT u FROM User AS u WHERE u.name.firstName LIKE " + "'" + value + "%'";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

        typedQuery.setParameter("x", value + "%"); // M%

        typedQuery.setParameter("y", postCount);

        return typedQuery.getResultList();
    }

    public Long sumPostCount() {

        String hql = "SELECT SUM(postCount) FROM User";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);

        return typedQuery.getSingleResult();
    }

    public Double avgPostCount() {

        String hql = "SELECT AVG(postCount) FROM User";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<Double> typedQuery = session.createQuery(hql, Double.class);

        return typedQuery.getSingleResult();
    }

    // id   postCount, Kişi Sayısı
    // Long int      , Kişi Sayısı
    public List<Object[]> groupByPostCount() {

        String hql = "SELECT postCount, COUNT(u.postCount) FROM User AS u GROUP BY postCount";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<Object[]> typedQuery = session.createQuery(hql, Object[].class);

        return typedQuery.getResultList();
    }

    public Optional<User> mostPostingUser() {

        String hql = "SELECT u FROM User AS u WHERE postCount = (SELECT MAX(postCount) FROM User)";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

        User user = null;

        List<User> list = typedQuery.getResultList();

        if ((!list.isEmpty())) {
            user = list.get(0);
        }

        return Optional.ofNullable(user);
    }

    public Optional<User> mostPostingUser2() {

        String hql = "SELECT u FROM User AS u ORDER BY postCount DESC";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

        typedQuery.setMaxResults(2);

        User user = null;

        try {

            user = typedQuery.getResultList().get(0);

        } catch (Exception e) {

            System.out.println(e.toString());
        }

        typedQuery.getResultList().forEach(System.out::println);

        return Optional.ofNullable(user);
    }

    public List<Object[]> getUsernameGenderPostCount() {

        String hql = "SELECT u.username, u.gender, u.postCount FROM User AS u";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<Object[]> typedQuery = session.createQuery(hql, Object[].class);

        List<Object[]> list = new ArrayList<>();

        list = typedQuery.getResultList();

        if (list.isEmpty()) {
            System.out.println("Herhangi Bir Sonuç Bulunamadı!!!");
        }

        return list;
    }

    public List<Object[]> getUserGendersWithTotalPost() {

        String hql = "SELECT gender, SUM(postCount) FROM User GROUP BY gender";

        session = HibernateUtility.getSessionFactory().openSession();

        TypedQuery<Object[]> typedQuery = session.createQuery(hql, Object[].class);

        List<Object[]> list = typedQuery.getResultList();

        if (list.isEmpty()) {
            System.out.println("Herhangi Bir Sonuç Bulunamadı!!!");
        }

        return list;
    }
}