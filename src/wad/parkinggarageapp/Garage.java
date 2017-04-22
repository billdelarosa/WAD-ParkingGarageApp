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
public class Garage {
    private String garageName;
    private final String EXCEPTION = "Garage name cannot be null or empty";
    
    public Garage(){
    }
    
    public Garage(String garageName){
        this.garageName = garageName;
    }

    public final String getGarageName() {
        return garageName;
    }

    public final void setGarageName(String garageName) {
        if (garageName == null || garageName.isEmpty()){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.garageName = garageName;
    }
    
    
}
