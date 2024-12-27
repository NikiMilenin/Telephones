package ru.vsu.cs.telephones.data;

public class TelephoneNumber {
    private String number;


    public TelephoneNumber(String number) {
        setNumber(number);
    }


    public void setNumber(String number) {
        if (checkStringForNumber(number))
            this.number = number;
        else this.number = "-1";
    }


    public String toString() {
        if (this.number != null && !this.number.equals("-1")) {
            return number + " ";
        } else {
            return "";
        }
    }


    public String getNumber() {
        return this.number;
    }


    public static boolean checkStringForNumber(String str) {
        return str.matches("\\+7\\d{10}");
    }
}
