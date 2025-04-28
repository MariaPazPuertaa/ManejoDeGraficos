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
public class Strawberry extends Sprite{
    public Strawberry(int x, int y, int width, int height) {
        super(x, y, width, height, new Color(139, 69, 19));
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
}
