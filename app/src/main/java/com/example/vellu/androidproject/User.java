package com.example.vellu.androidproject;



public class User {

    public static final String USERS_TABLE_NAME = "users";

    public static final String USERS_COLUMN_ID = "id";
    public static final String USERS_COLUMN_NAME = "name";
    public static final String USERS_COLUMN_SURNAME = "surname";
    public static final String USERS_COLUMN_ADDRESS = "address";
    public static final String USERS_COLUMN_CITY = "city";
    public static final String USERS_COLUMN_COUNTRY = "country";

    //Initializing Table and assign table attributes
    public static final String CREATE_TABLE = "CREATE TABLE users " + "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT,  surname TEXT, address TEXT, city TEXT, country TEXT)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS users";

    int id;
    String name;
    String surname;
    String address;
    String city;
    String country;

    public User(){

    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, String address, String city, String country) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public User(int id, String name, String surname, String address, String city, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
