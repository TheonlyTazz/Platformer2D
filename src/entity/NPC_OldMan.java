package entity;

import main.GamePanel;
import java.awt.*;
import java.util.Random;

public class NPC_OldMan extends Entity{

    public NPC_OldMan(GamePanel gp){
        super(gp);
        // SPRITES
        spriteWidth = 48;
        spriteHeight = 96;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        direction = "down";
        speed = 1;
        name = "OldMan";
        getImage();
        setDialogue();

    }

    public void getImage() {

        up1 = setup("/npc/oldman_up_1");
        up2 = setup("/npc/oldman_up_2");
        down1 = setup("/npc/oldman_down_1");
        down2 = setup("/npc/oldman_down_2");
        left1 = setup("/npc/oldman_left_1");
        left2 = setup("/npc/oldman_left_2");
        right1 = setup("/npc/oldman_right_1");
        right2 = setup("/npc/oldman_right_2");
    }
    public void setDialogue() {
        dialogues[0] = "Guten Tag!\nWie geht es dir?\n\nIch habe Spaß mit Dialogen.";
        dialogues[1] = "Ich bin der Zauberer von OZ";
        dialogues[2] = "Kann ich Sie behilflich sein?";
        dialogues[3] = "Hello there!";

    }
    public void setAction() {

        actionLockCounter++;
        if(actionLockCounter <= 120) return;
        Random random = new Random();
        int i = random.nextInt(100)+1; // random number 1-100
        if (i <= 25) direction = "up";
        if (i > 25 && i <= 50) direction = "down";
        if (i > 50 && i <= 75) direction = "left";
        if (i > 75) direction = "right";
        actionLockCounter = 0;
    }
    public void speak(){super.speak();gp.time.addMinutes(5);}
}
