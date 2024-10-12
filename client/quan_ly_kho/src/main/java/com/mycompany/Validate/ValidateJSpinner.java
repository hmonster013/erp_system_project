/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Validate;

import javax.swing.JSpinner;

/**
 *
 * @author Khoahihi79
 */
public class ValidateJSpinner {
    
    public static boolean isPositive(int value) {
            return value > 0;
    }

    public static boolean validateSpinners(Integer... spinners) {
        for (Integer spinner : spinners) {
            if (!isPositive(spinner)) {
                return false;
            }
        }
        return true;
    }
}
