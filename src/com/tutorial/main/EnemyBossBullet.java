package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

    private Handler handler;
    Random r  = new Random();

    private BufferedImage boss_bullet_image;



    public EnemyBossBullet(float x, float y, ID id, Handler handler){
        super (x, y, id);

        this.handler = handler;

        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;

        SpriteSheet  ss = new SpriteSheet(Game.sprite_sheet);

        boss_bullet_image = ss.imageSelect(1, 4, 96, 96);

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

//        if(y <- 0 || y >= Game.HEIGHT -32) velY *= -1;
//        if(x <- 0 || x >= Game.WIDTH -16) velX *= -1;

        if(y >= Game.HEIGHT) handler.removeObject((this));

//        handler.addObject(new Trail(x, y, ID.TRAIL, Color.green, 16, 16, 0.1f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x,(int)y,16,16);

//        g.drawImage(boss_bullet_image, (int) x, (int) y, null);
    }




}
