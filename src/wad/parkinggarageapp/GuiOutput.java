/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.parkinggarageapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Billy-Mac
 */
public class GuiOutput implements OutputStrategy {
    private final String EXCEPTION = "Exception caught during GUI output";
    
    @Override
    public final void getOutput(String output) {
        if (output == null || output.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            JOptionPane.showMessageDialog(null, output);

        }
    }
    
}
