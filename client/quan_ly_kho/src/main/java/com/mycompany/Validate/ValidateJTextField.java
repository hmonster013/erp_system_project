/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Validate;

/**
 *
 * @author Khoahihi79
 */
public class ValidateJTextField {
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean validateFields(String... fields) {
        for (String field : fields) {
            if (isEmpty(field)) {
                return false;
            }
        }
        return true;
    }
}
