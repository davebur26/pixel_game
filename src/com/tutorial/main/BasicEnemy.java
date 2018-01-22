package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject {

    private Handler handler;
    private BufferedImage basic_enemy_image;

    public BasicEnemy(float x, float y, ID id, Handler handler){
        super (x, y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;

        SpriteSheet  ss = new SpriteSheet(Game.sprite_sheet);

        basic_enemy_image = ss.imageSelect(1, 5, 96, 96);



    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(y <- 0 || y >= Game.HEIGHT -32) velY *= -1;
        if(x <- 0 || x >= Game.WIDTH -16) velX *= -1;

        handler.addObject(new Trail(x, y, ID.TRAIL, Color.red, 16, 16, 0.1f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,16,16);
//        g.drawImage(basic_enemy_image, (int) x, (int) y, null);
    }




}
