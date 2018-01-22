package com.tutorial.main;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

import java.awt.*;

        import java.awt.*;
import java.awt.image.BufferedImage;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    private BufferedImage smart_enemy_image;

    public SmartEnemy(float x, float y, ID id, Handler handler){
        super (x, y, id);

        this.handler = handler;

        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }

        SpriteSheet  ss = new SpriteSheet(Game.sprite_sheet);

        smart_enemy_image = ss.imageSelect(1, 1, 96, 96);

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;

        float xDim = (float) Math.pow((x - player.getX()),2);
        float yDim = (float) Math.pow((y - player.getY()),2);
        float distance = (float) Math.sqrt(xDim + yDim);

        velX = (-1/distance) * diffX;
        velY = (-1/distance) * diffY;

        if(y <- 0 || y >= Game.HEIGHT -32) velY *= -1;
        if(x <- 0 || x >= Game.WIDTH -16) velX *= -1;

        handler.addObject(new Trail(x, y, ID.TRAIL, Color.green, 16, 16, 0.1f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y,16,16);
//        g.drawImage(smart_enemy_image, (int) x, (int) y, null);
    }




}

