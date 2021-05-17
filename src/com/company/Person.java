package com.company;

import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String sex;
    private String passportId;

    public Person() {

    }

    public void inputPersonInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Your Firstname");
        setFirstName(scanner.next());
        System.out.println("Please input Your Lastname");
        setLastName(scanner.next());
        System.out.println("Please input Your Age");
        setAge(scanner.nextInt());
        System.out.println("Please input Your Sex");
        setSex(scanner.next());
        System.out.println("Please input Your Passport Series");
        setPassportId(scanner.next());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("Inputted firstname is to short");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 6) {
            throw new IllegalArgumentException("Inputted lastname is to short");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 99) {
            throw new IllegalArgumentException("Inputted age out of range");
        }
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if (sex.compareToIgnoreCase("male") != 0 && sex.compareToIgnoreCase("female") != 0) {
            throw new IllegalArgumentException("Inputted sex does not exist");
        }
        this.sex = sex;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        boolean trueID = true;
        if (passportId.length() != 8 || "AN".compareToIgnoreCase(passportId.substring(0, 2)) != 0) {
            throw new IllegalArgumentException("Inputted passport Series is wrong");
        }
        for (int i = 2; i < passportId.length(); i++) {
            trueID = Character.isDigit(passportId.charAt(i));
            if (!trueID) {
                break;
            }
        }
        if (!trueID) {
            throw new IllegalArgumentException("Inputted passport Numbers is wrong");
        }
        this.passportId = passportId;
    }

    public void printPersonId() {
        System.out.println("Firstname " + getFirstName());
        System.out.println("Lastname " + getLastName());
        System.out.println("Age " + getAge());
        System.out.println("Sex " + getSex());
        System.out.println("Id " + getPassportId());
    }
}
