/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.parkinggarageapp;

/**
 *
 * @author Billy-Mac
 */
public class ConsoleOutput implements OutputStrategy {

    private final String EXCEPTION = "Exception caught during Console output";

    @Override
    public final void getOutput(String output) {
        if (output == null || output.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            System.out.println(output);

        }

    }
    
}
