package com.meng.Set;

import java.util.Objects;

/**
 *
 */
public class User implements Comparable{

    private  String name;
    private  int age;

    public User(){

    }

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setAge(){
        this.age = age;
    }

    public int getAge(int age){
        return age;
    }

    public void setName(){
        this.name = name;
    }

    public String getName(String name){
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    //按照姓名从小到大排列，年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if (o instanceof  User){
            User user = (User) o;
//            return this.name.compareTo(user.name);
            int compare = this.name.compareTo(user.name);
            if (compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }

    }
}
