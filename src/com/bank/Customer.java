package com.bank;

public class Customer {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String city;
    private long contact;
    private String accountType;

    public Customer() {

    }
    public Customer( String fname, String lname, String email, String city, long contact, String accountType) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.city = city;
        this.contact = contact;
        this.accountType = accountType;
    }

    public Customer(int id, String fname, String lname, String email, String city, long contact, String accountType) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.city = city;
        this.contact = contact;
        this.accountType = accountType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    @Override
    public String toString() {
        return "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", contact=" + contact +
                ", accountType='" + accountType + '\'' ;
    }
}
