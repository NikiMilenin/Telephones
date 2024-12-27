package ru.vsu.cs.telephones.data;

public class Subscriber {
    private TelephoneNumber[] telephoneNumber = new TelephoneNumber[3];
    private String name;
    private String surname;


    public Subscriber(String name, String surname, String[] numbers) {
        this.name = name;
        this.surname = surname;
        for (int i = 0; i <= (numbers.length - 1) % 3; i++) {
            telephoneNumber[i] = new TelephoneNumber(numbers[i]);
        }
        for (int i = numbers.length; i < 3; i++) {
            telephoneNumber[i] = new TelephoneNumber("-1");
        }
    }


    public String getName() {
        return this.name;
    }


    public String getSurname() {
        return this.surname;
    }


    public TelephoneNumber[] getTelephoneNumber(){
        return this.telephoneNumber;
    }


    public void changeName(String name) {
        this.name = name;
    }


    public void changeSurname(String surname) {
        this.surname = surname;
    }


    public void  addNumber(TelephoneNumber number) {
        return;
    }


    public void removeNumber(TelephoneNumber number) {
        return;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ");
        sb.append(surname).append(" ");
        for (TelephoneNumber telephoneNumber1:telephoneNumber) {
            sb.append(telephoneNumber1.toString());
        }
        return sb.toString();
    }
}
