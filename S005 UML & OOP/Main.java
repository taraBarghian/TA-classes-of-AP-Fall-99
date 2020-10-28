package com.company;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Scanner;

enum Priviliges{
    Insert, Update, Delete, Get
}
class UserManager{
    public User myUser;
    public boolean logIn(String username , String password){
        if(this.myUser.getUsername().equals(username)){
            if(this.myUser.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public boolean logOut(){
        this.myUser.setLogged(false);
        return true;
    }
}
class User{
    private  String name;
    private  boolean isLogged;
    private  Priviliges priviliges;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, boolean isLogged, Priviliges priviliges) {
        this.name = name;
        this.isLogged = isLogged;
        this.priviliges = priviliges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public Priviliges getPriviliges() {
        return priviliges;
    }

    public void setPriviliges(Priviliges priviliges) {
        this.priviliges = priviliges;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Priviliges getPrivileges() {
        return priviliges;
    }
}
class ContentManager{
    public User myUser;
    private void funcName(){

    }
}
class Article extends  ContentManager{
    public boolean addArticle(){
        return true;
    }
    public boolean removeArticle(){
        return true;
    }
    public boolean modifyArticle(){
        return true;
    }
    public boolean showArticle(){
        return true;
    }
}
class Announcment extends ContentManager{

}
class Advertisment extends ContentManager{

}
class Comment extends ContentManager{

}
class Animal{
    public void move(){}
}
class Dog extends Animal{
    @Override
    public void move() {
        System.out.println("A dog is jumping");
    }
}
class Bird extends  Animal{
    @Override
    public void move() {
        System.out.println("A Bird is flying");
    }
}
class Demo1{
    String name;
    String comment;
    public void display(){
        System.out.println("[" + name + "]" + ":" + "[" + comment + "]");
    }
}
class  Demo2 extends Demo1{
    int age;

    @Override
    public void display() {
        System.out.println("[" + name + "]" + ":" + "[" + comment + "]" + "[" + age + "]"  );
    }
}
class Main{
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //UserManager userManager = new UserManager();
        //User user1 = new User("mreskini" , "@mr123");
        //userManager.myUser = user1;
        //user1.setLogged(userManager.logIn(scanner.next() , scanner.next()));
        Dog fido = new Dog();
        Bird angryBird = new Bird();
        fido.move();
        angryBird.move();
        Demo2 a = new Demo2();
        a.name  =" Jack Doresy";
        a.comment = "buy more crypto";
        a.age = 35;
        a.display();

    }
}