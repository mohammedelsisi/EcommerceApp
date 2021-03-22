package com.iti.model.utils.authentication;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;

class Encryptor {
    private static final StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
    AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
    static Encryptor encryptor = new Encryptor();

    private Encryptor() {
        textEncryptor.setPassword("7obTanyL2");
    }

    String encryptPassword(String ss){
        return passwordEncryptor.encryptPassword(ss);
    }
    boolean check(String toCheck,String encrypted){
        return passwordEncryptor.checkPassword(toCheck,encrypted);
    }
    public static synchronized Encryptor getEncryptor (){
        return encryptor;
    }
    String encrypt(String ss){
        return textEncryptor.encrypt(ss);
    }
    String decrypt(String ss){
        return textEncryptor.decrypt(ss);
    }

}
