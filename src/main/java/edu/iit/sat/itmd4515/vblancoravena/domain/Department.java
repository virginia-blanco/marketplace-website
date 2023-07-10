/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.domain;

/**
 *
 * @author virginiablancoravena
 */
public enum Department {
    VEHICLES("Vehicles"),
    BEAUTY_HEALTH("Beauty and Health"),
    BOOKS("Books"),
    CAMERAS_PHOTOGRAPHY("Camera and Photography"),
    CELLPHONES_ACCESSORIES("Cellphone and Accessories"),
    ART("Art"),
    FOOD_GLOCERY("Food and Glocery"),
    HOME_GARDEN("Home and Garden"),
    MUSIC("Music"),
    STATIONERY("Stationery"),
    COMPUTING("Computing"),
    PETSUPPLIES("Pet Supplies"),
    SPORTS_OUTDOORS("Sports and Outdoors"),
    DIY_TOOLS("DIY and Tools"),
    GAMES("Games"),
    MOVIES("Movies"),
    VIDEOGAMES("Videogames"),
    CLOTHING("Clothing");
    
       private String description;

    private Department(String description) {
        this.description = description;
    }
       
       

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }


}
