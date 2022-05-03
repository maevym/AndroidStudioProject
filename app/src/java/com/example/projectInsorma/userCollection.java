package com.example.projectinsorma_maevymarvella;

import java.util.Vector;

public class userCollection {
    public static Vector<Users> user = new Vector<>();
    public static Integer id=0;

    public static int getNum(){
        return user.size()-1;
    }

    public static void createDummyUser(){
        user.add(new Users(0, "maevy@gmail.com", "maevym70", "085693407908", "maevy12"));
        //user.add(new Users(id, "maevy@gmail.com", "maevym70", "085693407908", "maevy12"));
    }

//    public static void userIdUp(){
//       id+=1;
//    }

    public static void createNewUser(String email, String username, String phoneNum, String password){
        user.add(new Users(user.size(), email, username, phoneNum, password));
//        userIdUp();
//        user.add(new Users(id, email, username, phoneNum, password));
    }

    public static boolean loginUserExist(String email, String password){
        for (Users u: user) {
            if(u.UserEmailAddress.equals(email) && u.UserPassword.equals(password)){
                return true;
            }
        }
        return false;
    }

    public static boolean usernameExist(String username){
        for (Users u: user) {
            if(u.UserUsername.equals(username)){
                return true;
            }
        }
        return false;
    }

    public static boolean emailExist(String email){
        for (Users u: user) {
            if(u.UserEmailAddress.equals(email)){
                return true;
            }
        }
        return false;
    }

    public static Integer findUserID(String email, String password){
        for (Users u: user) {
            if(u.UserEmailAddress.equals(email) && u.UserPassword.equals(password)){
                return u.userID;
            }
        }
        return -1;
    }


    public static Integer findUserIndex(String email, String password){
        for(Integer i = 0; i<user.size();i++){
            if(user.get(i).UserEmailAddress.equals(email) && user.get(i).UserPassword.equals(password)){
                return i;
            }
        }
        return -1;
    }

    public static String findUserUsername(Integer userID){
        for (Users u: user) {
            if(u.userID.equals(userID)){
                return u.UserUsername;
            }
        }
        return null;
    }

    public static void changeUsername(Integer index, String new_username){
        for (Users u: user) {
            if(u.userID.equals(index)){
                u.setUserUsername(new_username);
                return;
            }
        }
        return;
    }

    public static void deleteUser(Integer index){
        for (Users u: user) {
            if(u.userID.equals(index)){
                user.remove(u);
                return;
            }
        }
        return;
    }

}
