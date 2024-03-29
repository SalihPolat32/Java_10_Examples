package com.bilgeadam.main;

import com.bilgeadam.repository.entity.Address;
import com.bilgeadam.repository.entity.EAddressType;
import com.bilgeadam.repository.entity.Name;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.repository.enums.EGender;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<String> interest1 = List.of("Müzik", "Dans");
        List<String> interest2 = List.of("Sinema", "Tiyatro");

        // 1. Map
        Map<EAddressType, Address> map1 = new HashMap<>();
        map1.put(EAddressType.HOME, Address.builder().city("Ankara").country("Turkey").build());
        map1.put(EAddressType.WORK, Address.builder().city("İstanbul").country("Turkey").build());

        // 2. Map
        Map<EAddressType, Address> map2 = new HashMap<>();
        map1.put(EAddressType.HOME, Address.builder().city("İzmir").country("Turkey").build());
        map1.put(EAddressType.WORK, new Address("Antalya", "Turkey"));

        // 3. Map
        Map<EAddressType, Address> map3 = new HashMap<>();
        map1.put(EAddressType.HOME, Address.builder().city("Isparta").country("Turkey").build());
        map1.put(EAddressType.WORK, new Address("Burdur", "Turkey"));

        User user = User.builder()
                .name(Name.builder().firstName("Ece").middleName("Beren").lastName("ERENOĞLU").build())
                .username("ecebe")
                .password("456789")
                // .gender(EGender.WOMAN)
                .interests(interest1)
                .addresses(map1)
                .age(18)
                .build();

        User user2 = User.builder()
                .name(Name.builder().firstName("Mustafa").lastName("ÖZTÜRK").build())
                .username("musty")
                .password("12345")
                .gender(EGender.MAN)
                .interests(interest2)
                .addresses(map2)
                .age(35)
                .build();

        User user3 = User.builder()
                .name(Name.builder().firstName("Salih").middleName("Polat").lastName("DÖNMEZ").build())
                .username("spd327")
                .password("987654")
                .gender(EGender.MAN)
                .interests(List.of("Yüzme", "Yürüyüş", "Oyun"))
                .addresses(map3)
                .age(26)
                .build();

            Session session = null;

            Transaction transaction = null;

        try {

            session = HibernateUtility.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.save(user);
            session.save(user2);
            session.save(user3);

            System.out.println("User: " + user);
            System.out.println(user2.getInterests().size());

            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();

            transaction.rollback();

        } finally {

            session.close();

        }
    }
}