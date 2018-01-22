package com.tutorial.main;

import java.awt.image.BufferedImage;
import java.lang.management.BufferPoolMXBean;

public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }


    public BufferedImage imageSelect(int col, int row, int width, int height) {
         return image.getSubimage((row * 96) - 96, (col * 96) -96, width, height);

    }
}
