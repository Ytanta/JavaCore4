package market;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String phone;

    private  Gender gender;


    public User(String name, int age, String phone, Gender gender) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", gender=" + getGender(gender) +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(phone, user.phone) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, phone, gender);
    }

    String getGender(Gender gender){
        switch(gender) {
            case MALE:
                return "male";
            case FEMALE:
                return "female";
            default:
                return "Undefined";
        }


}}
