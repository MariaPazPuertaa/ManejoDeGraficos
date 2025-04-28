/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.fairygame.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Maria Paz Puerta
 */
public class Coins extends Sprite{
    public Coins(int x, int y, int width, int height) {
        super(x, y, width, height, new Color(255, 215, 0));
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
