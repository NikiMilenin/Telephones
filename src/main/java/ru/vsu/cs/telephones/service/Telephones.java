package ru.vsu.cs.telephones.service;

import ru.vsu.cs.telephones.data.Subscriber;
import ru.vsu.cs.telephones.data.TelephoneNumber;
import ru.vsu.cs.telephones.repository.DataBase;

import java.util.ArrayList;

public class Telephones {
    private final DataBase dataBase = new DataBase("postgres");


    public ArrayList<Subscriber> getAllSubscribers() throws Exception {
        return dataBase.getAllSubscribers();
    }


    public ArrayList<Subscriber> getSubscribersBySurname(String surname) throws Exception {
        return dataBase.getUsersBySurname(surname);
    }


    public Subscriber getSubscriberByPhoneNumber(String number) throws Exception {
        return dataBase.getUserByPhoneNumber(number);
    }


    public int addSubscriber(Subscriber sub) throws  Exception{
        for (TelephoneNumber num:sub.getTelephoneNumber()) {
            String n = num.getNumber();
            if (n.length() > 3) {
                Subscriber marker = this.getSubscriberByPhoneNumber(num.getNumber());
                if (marker != null) {
                    return 1;
                }
            }
        }
        dataBase.addUser(sub);
        return 0;
    }


    public int changeName(String newName, String number) {
        dataBase.changeSubscriberName(newName, number);
        return 0;
    }

    public int changeSurname(String newName, String number) {
        dataBase.changeSubscriberSurname(newName, number);
        return 0;
    }

    public int changePhone1(String new_phone, String old_phone) {
        dataBase.changePhone1(new_phone, old_phone);
        return 0;
    }

    public int changePhone2(String new_phone, String old_phone) {
        dataBase.changePhone2(new_phone, old_phone);
        return 0;
    }

    public int changePhone3(String new_phone, String old_phone) {
        dataBase.changePhone3(new_phone, old_phone);
        return 0;
    }


    public int deleteSubscriber(String number) throws Exception {
        if (number.length() > 3) {
            dataBase.removeSubscriber(number);
            return 0;
        }
        return 1;
    }
}
