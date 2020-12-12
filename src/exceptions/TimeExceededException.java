/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author ugobarbato
 */
public class TimeExceededException extends Exception {

    /**
     * Creates a new instance of <code>TimeExceededException</code> without
     * detail message.
     */
    public TimeExceededException() {
    }

    /**
     * Constructs an instance of <code>TimeExceededException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public TimeExceededException(String msg) {
        super(msg);
    }
}
