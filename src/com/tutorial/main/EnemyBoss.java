package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBoss extends GameObject {

        private Handler handler;
        private int timer = 80;
        private int timer2 = 50;
        Random r = new Random();

        private BufferedImage boss_enemy_image;


    public EnemyBoss(float x, float y, ID id, Handler handler){
            super (x, y, id);

            this.handler = handler;

            velX = 0;
            velY = 2;

        SpriteSheet  ss = new SpriteSheet(Game.sprite_sheet);

        boss_enemy_image = ss.imageSelect(1, 6, 96, 96);

        }

        public Rectangle getBounds(){
            return new Rectangle((int)x, (int)y, 96, 96);
        }

        public void tick() {
            x += velX;
            y += velY;

            if(timer <= 0) velY = 0;
            else timer--;

            if(timer <= 0) timer2--;
            if(timer <=9){
                if(velX ==0) velX = 2;

                if(velX > 0){
                    velX += 0.005f;
                } else if (velX < 0) {
                    velX -= 0.005f;
                }

                velX = Game.clamp(velX, -5, 5);

                int spawn = r.nextInt(10);
                if(spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 24, (int) y + 48, ID.BasicEnemy, handler));
            }

//            if(y <- 0 || y >= Game.HEIGHT -32) velY *= -1;
            if(x <- 0 || x >= Game.WIDTH -96) velX *= -1;

//            handler.addObject(new Trail(x, y, ID.TRAIL, Color.red, 96, 96, 0.01f, handler));

        }

        public void render(Graphics g) {
            g.setColor(Color.red);
            g.fillRect((int)x,(int)y,96,96);

//            g.drawImage(boss_enemy_image, (int) x, (int) y, null);


        }




    }


