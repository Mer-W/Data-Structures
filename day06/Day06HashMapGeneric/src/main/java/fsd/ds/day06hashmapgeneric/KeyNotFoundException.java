/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fsd.ds.day06hashmapgeneric;

/**
 *
 * @author mer
 */

public class KeyNotFoundException extends Exception {

    public KeyNotFoundException() {

    }

    public KeyNotFoundException(String message) {
        super(message);
    }

    public KeyNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }

    public KeyNotFoundException(Throwable cause) {
        super(cause);

    }
}