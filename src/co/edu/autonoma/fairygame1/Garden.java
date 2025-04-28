/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.fairygame1;

import co.edu.autonoma.fairygame.elements.Coins;
import co.edu.autonoma.fairygame.elements.Fairy;
import co.edu.autonoma.fairygame.elements.Sprite;
import co.edu.autonoma.fairygame.elements.Strawberry;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Maria Paz Puerta
 */
public class Garden extends Sprite{
    private Fairy fairy;
    private ArrayList<Coins> coins = new ArrayList<>();
    private ArrayList<Strawberry> Strawberries = new ArrayList<>();
    
    public Garden (int x, int y, int width, int height)
    {
        super(x, y, width, height, new Color(0, 100, 0));
        
        fairy = new Fairy(100, 100, 50, 50);
    }
    
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
        fairy.draw(g);
        
        for(Coins coin : coins){
            coin.draw(g);
        }
       
        
        for(Strawberry strawberry : Strawberries){
            strawberry.draw(g);
        }
    }
    
    public void handleKey(KeyEvent e)
    {
        int fairyX = fairy.getX();
        int fairyY = fairy.getY();
    
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (fairyY - Fairy.STEP >= 0) { 
                    fairy.setY(fairyY - Fairy.STEP);
                    checkForCoinsEaten();
                    checkForStrawberriesEaten();
                }
            break;
        
            case KeyEvent.VK_DOWN:
                if (fairyY + fairy.getHeight() + Fairy.STEP <= getHeight()) {  
                    fairy.setY(fairyY + Fairy.STEP);
                    checkForCoinsEaten();
                    checkForStrawberriesEaten();
                }
            break;
        
            case KeyEvent.VK_LEFT:
                if (fairyX - Fairy.STEP >= 0) { 
                    fairy.setX(fairyX - Fairy.STEP);
                    checkForCoinsEaten();
                    checkForStrawberriesEaten();
                }
            break;
        
            case KeyEvent.VK_RIGHT:
                if (fairyX + fairy.getWidth() + Fairy.STEP <= getWidth()) {  
                    fairy.setX(fairyX + Fairy.STEP);
                    checkForCoinsEaten();
                    checkForStrawberriesEaten();
                }
            break;
        
            case KeyEvent.VK_A:
                addApple();  
                checkForCoinsEaten();
                checkForStrawberriesEaten();
            break;
        
            case KeyEvent.VK_X:
                addStrawberry();  
                checkForCoinsEaten();
                checkForStrawberriesEaten();
            break;
        }
    }
    
    private void checkForCoinsEaten()
    {
        for(int i=0; i<coins.size(); i++)
        {
            Coins coin = coins.get(i);
            
            if(fairy.hit(coin))
            {
                coins.remove(coin);
                i --;
                
                fairy.grow();
            }
        }
    }
    
    private void checkForStrawberriesEaten()
    {
        for(int i=0; i<Strawberries.size(); i++)
        {
            Strawberry strawberry = Strawberries.get(i);
            
            if(fairy.hit(strawberry))
            {
                Strawberries.remove(strawberry);
                i --;
                
                fairy.shrink();
            }
        }
    }
    
    private void addApple()
    {
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        
        Coins coin = new Coins(x, y, 25, 25);
        
        coins.add(coin);
    }
    
    private void addStrawberry()
    {
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        
        Strawberry strawberry = new Strawberry(x, y, 25, 25);
        
        Strawberries.add(strawberry);
    }
}
