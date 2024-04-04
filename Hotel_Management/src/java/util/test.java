/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import dao.UserDAO;

/**
 *
 * @author lvhn1
 */
public class test {
    public static void main(String[] args) {
        System.out.println(new UserDAO().readAllUsers());
    }
}