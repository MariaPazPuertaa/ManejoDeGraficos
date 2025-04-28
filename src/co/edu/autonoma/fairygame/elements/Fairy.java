/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.fairygame.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Maria Paz Puerta
 */
public class Fairy extends Sprite{
    public static final int STEP = 10;
    public static final int EAT_SIZE = 10;
    
    public Fairy(int x, int y, int width, int height) {
        super(x, y, width, height, new Color(255, 182, 193));
        
        
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
        
    }
    
    public void grow()
    {
        width += EAT_SIZE;
        height += EAT_SIZE;
    }
    
    public void shrink() {
        if (width > EAT_SIZE && height > EAT_SIZE) {  
            width -= EAT_SIZE;   
            height -= EAT_SIZE;
        }
    }
    
    public void handleKey(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                y -= STEP;
                break;
                
            case KeyEvent.VK_DOWN:
                y += STEP;
                break;
                
            case KeyEvent.VK_LEFT:
                x -= STEP;
                break;
                
            case KeyEvent.VK_RIGHT:
                x += STEP;
                break;
        }  
    }
    
}
