package com.tutorial.main;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {

        private Handler handler;
        private BufferedImage fast_enemy_image;

        public FastEnemy(float x, float y, ID id, Handler handler){
            super (x, y, id);

            this.handler = handler;

            velX = 2;
            velY = 9;

            SpriteSheet  ss = new SpriteSheet(Game.sprite_sheet);

            fast_enemy_image = ss.imageSelect(1, 3, 96, 96);

        }

        public Rectangle getBounds(){
            return new Rectangle((int)x, (int)y, 16, 16);
        }

        public void tick() {
            x += velX;
            y += velY;

            if(y <- 0 || y >= Game.HEIGHT -32) velY *= -1;
            if(x <- 0 || x >= Game.WIDTH -16) velX *= -1;

            handler.addObject(new Trail(x, y, ID.TRAIL, Color.cyan, 16, 16, 0.1f, handler));

        }

        public void render(Graphics g) {
            g.setColor(Color.cyan);
            g.fillRect((int)x ,(int)y,16,16);
//            g.drawImage(fast_enemy_image, (int) x, (int) y, null);
        }




    }


