package ru.vsu.cs.telephones.repository;

import ru.vsu.cs.telephones.data.Subscriber;
import ru.vsu.cs.telephones.data.TelephoneNumber;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {

    DBConnection dbconnection = null;


    public DataBase(String dbname) {
        if (dbname == "postgres") {
            this.dbconnection = new PostgresConnection();
        }
    }


    public ArrayList<Subscriber> getAllSubscribers() throws Exception{
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        try (Connection connection = dbconnection.initConnection()) {
            Statement statement = connection.createStatement();
            ResultSet all = statement.executeQuery("SELECT * FROM telephones");
            while (all.next()) {
                String name = all.getString("name");
                String surname = all.getString("surname");
                String phone1 = all.getString("phone1");
                String phone2 = all.getString("phone2");
                String phone3 = all.getString("phone3");
                String[] numbers = {phone1, phone2, phone3};
                Subscriber subscriber = new Subscriber(name, surname, numbers);
                subscribers.add(subscriber);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subscribers;
    }


    public ArrayList<Subscriber> getUsersBySurname(String sname) throws Exception{
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        try (Connection connection = dbconnection.initConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM telephones WHERE surname = (?)");
            statement.setString(1, sname);
            ResultSet all = statement.executeQuery();
            while (all.next()) {
                String name = all.getString("name");
                String surname = all.getString("surname");
                String phone1 = all.getString("phone1");
                String phone2 = all.getString("phone2");
                String phone3 = all.getString("phone3");
                String[] numbers = {phone1, phone2, phone3};
                Subscriber subscriber = new Subscriber(name, surname, numbers);
                subscribers.add(subscriber);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subscribers;
    }


    public Subscriber getUserByPhoneNumber(String phoneNumber) throws Exception{
        try (Connection connection = dbconnection.initConnection()) {
            String sql = "SELECT * FROM telephones WHERE phone1 = ? OR phone2 = ? or phone3 = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, phoneNumber);
            statement.setString(2, phoneNumber);
            statement.setString(3, phoneNumber);
            ResultSet all = statement.executeQuery();
            all.next();
            String name = all.getString("name");
            String surname = all.getString("surname");
            String phone1 = all.getString("phone1");
            String phone2 = all.getString("phone2");
            String phone3 = all.getString("phone3");
            String[] numbers = {phone1, phone2, phone3};
            return  new Subscriber(name, surname, numbers);
        } catch (Exception ex) {
            //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public void addUser(Subscriber subscriber) throws Exception {
        try (Connection connection = dbconnection.initConnection()) {
            String sql = "INSERT INTO telephones VALUES(?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, subscriber.getName());
            statement.setString(2, subscriber.getSurname());
            TelephoneNumber[] numbers = subscriber.getTelephoneNumber();
            for (int i = 3; i < 6; i++) {
                statement.setString(i, numbers[i - 3].getNumber());
            }
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void removeSubscriber(String phoneNumber) {
        try (Connection connection = dbconnection.initConnection()) {
            String sql = "DELETE from telephones where phone1 = ? OR phone2 = ? or phone3 = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, phoneNumber);
            statement.setString(2, phoneNumber);
            statement.setString(3, phoneNumber);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public int changeSubscriberName(String newName, String number) {
        try (Connection connection = dbconnection.initConnection()) {
            String sql = "UPDATE telephones SET name = ? WHERE phone1 = ? OR phone2 = ? OR phone3 = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setString(2, number);
            statement.setString(3, number);
            statement.setString(4, number);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int changeSubscriberSurname(String newName, String number) {
        try (Connection connection = dbconnection.initConnection()) {
            String sql = "UPDATE telephones SET surname = ? WHERE phone1 = ? OR phone2 = ? OR phone3 = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setString(2, number);
            statement.setString(3, number);
            statement.setString(4, number);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int changePhone1(String new_phone, String old_phone)
    {
        return 0;
    }

    public int changePhone2(String new_phone, String old_phone)
    {
        try (Connection connection = dbconnection.initConnection()) {
            String sql = "UPDATE telephones SET phone2 = ? WHERE phone1 = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, new_phone);
            statement.setString(2, old_phone);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int changePhone3(String new_phone, String old_phone)
    {
        try (Connection connection = dbconnection.initConnection()) {
            String sql = "UPDATE telephones SET phone3 = ? WHERE phone1 = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, new_phone);
            statement.setString(2, old_phone);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
