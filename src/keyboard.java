import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import static javafx.scene.input.KeyCode.V;
import static org.joou.Unsigned.ubyte;

/**
 * Created by Wesam on 7/30/2016.
 */
public class keyboard implements KeyListener {
    byte[] keyValue = new byte[0x0F];

    public keyboard(){
        Arrays.fill(keyValue, (byte)(0));
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case(KeyEvent.VK_X):
                keyValue[0x0] = 1;
                break;
            case(KeyEvent.VK_1):
                keyValue[0x1] = 1;
                break;
            case(KeyEvent.VK_2):
                keyValue[0x2] = 1;
                break;
            case(KeyEvent.VK_3):
                keyValue[0x3] = 1;
                break;
            case(KeyEvent.VK_Q):
                keyValue[0x4] = 1;
                break;
            case(KeyEvent.VK_W):
                keyValue[0x5] = 1;
                break;
            case(KeyEvent.VK_E):
                keyValue[0x6] = 1;
                break;
            case(KeyEvent.VK_A):
                keyValue[0x7] = 1;
                break;
            case(KeyEvent.VK_S):
                keyValue[0x8] = 1;
                break;
            case(KeyEvent.VK_D):
                keyValue[0x9] = 1;
                break;
            case(KeyEvent.VK_Z):
                keyValue[0xA] = 1;
                break;
            case(KeyEvent.VK_C):
                keyValue[0xB] = 1;
                break;
            case(KeyEvent.VK_4):
                keyValue[0xC] = 1;
                break;
            case(KeyEvent.VK_R):
                keyValue[0xD] = 1;
                break;
            case(KeyEvent.VK_F):
                keyValue[0xE] = 1;
                break;
            case(KeyEvent.VK_V):
                keyValue[0xF] = 1;
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case(KeyEvent.VK_X):
                keyValue[0x0] = 0;
                break;
            case(KeyEvent.VK_1):
                keyValue[0x1] = 0;
                break;
            case(KeyEvent.VK_2):
                keyValue[0x2] = 0;
                break;
            case(KeyEvent.VK_3):
                keyValue[0x3] = 0;
                break;
            case(KeyEvent.VK_Q):
                keyValue[0x4] = 0;
                break;
            case(KeyEvent.VK_W):
                keyValue[0x5] = 0;
                break;
            case(KeyEvent.VK_E):
                keyValue[0x6] = 0;
                break;
            case(KeyEvent.VK_A):
                keyValue[0x7] = 0;
                break;
            case(KeyEvent.VK_S):
                keyValue[0x8] = 0;
                break;
            case(KeyEvent.VK_D):
                keyValue[0x9] = 0;
                break;
            case(KeyEvent.VK_Z):
                keyValue[0xA] = 0;
                break;
            case(KeyEvent.VK_C):
                keyValue[0xB] = 0;
                break;
            case(KeyEvent.VK_4):
                keyValue[0xC] = 0;
                break;
            case(KeyEvent.VK_R):
                keyValue[0xD] = 0;
                break;
            case(KeyEvent.VK_F):
                keyValue[0xE] = 0;
                break;
            case(KeyEvent.VK_V):
                keyValue[0xF] = 0;
                break;
        }
    }
}
