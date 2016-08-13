import org.joou.UByte;
import org.joou.UShort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

import static org.joou.Unsigned.*;

/**
 * Created by Wesam on 7/9/2016.
 */
public class CPU {

    // The uppermost 256 bytes (0xF00-0xFFF) are reserved for display refresh
    // 96 bytes below that (0xEA0-0xEFF) were reserved for call stack, internal use, and other variables
    static byte[] memory = new byte[0x1000];
    byte[][] display = new byte[640][320];
    static UByte[] V = new UByte[16];
    UShort I = ushort(0); // address register
    static int PC, len;
    Stack<Integer> gameStack = new Stack<Integer>();
    UByte delayTimer, soundTimer = ubyte(60);
    keyboard keys = new keyboard();

    public CPU() {
        clearScreen();
        Arrays.fill(V, ubyte(0));
        delayTimer = soundTimer = ubyte(60);
        PC = 0x200;
        I = ushort(0);
        gameStack.clear();

        try {
            FileInputStream rom = new FileInputStream("SpaceInvaders.ch8");
            len = rom.read(memory, 0x200, 0x800);
            //System.out.println(Arrays.toString(memory));
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public void clearScreen(){
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                display[i][j] = 0;
            }
        }
    }

    public void decreaseTimers(){
        if (delayTimer.intValue() > 0 || soundTimer.intValue() > 0) {
            delayTimer = ubyte(delayTimer.intValue() - 1);
            soundTimer = ubyte(soundTimer.intValue() - 1);
        }
        else {
            delayTimer = ubyte(60);
            soundTimer = ubyte(60);
        }
    }

    public int fetchOpcode(){
        int opcode =  memory[PC] & 0xFF;
        opcode = opcode << 8;
        opcode = opcode | (memory[PC + 1] & 0x00FF);
        //System.out.println(hex(opcode));
        PC += 2;
        return opcode;
    }

    public static String hex(int n) {
        return String.format("0x%8s", Integer.toHexString(n)).replace(' ', '0');
    }

    public void runOpcode(int opcode){
        int address, lastWord, X, Y, leastSignificantBit, mostSignificantBit;
        address = opcode & 0x0FFF;
        lastWord = opcode & 0x00FF;
        X = opcode & 0x0F00;
        Y = opcode & 0x00F0;
        X = X >> 8;
        Y = Y >> 4;
        switch(opcode & 0xF000){
            case 0x0000:
                if (lastWord == 0x00E0){
                    clearScreen();
                } else if (lastWord == 0x00EE) {
                    PC = gameStack.pop();
                }
                else {
                    System.out.println("opcode: " + hex(opcode) + " calls RCA program");
                }
                break;
            case 0x1000:
                PC = address;
                break;
            case 0x2000:
                gameStack.push(PC);
                PC = address;
                break;
            case 0x3000:
                if (V[X].shortValue() == (short)lastWord){
                    PC += 2;
                }
                break;
            case 0x4000:
                if (V[X].shortValue() != (short)lastWord){
                    PC += 2;
                }
                break;
            case 0x5000:
                if (V[X] == V[Y]){
                    PC += 2;
                }
                break;
            case 0x6000:
                V[X] = ubyte(lastWord);
                break;
            case 0x7000:
                V[X].add(lastWord);
                break;
            case 0x8000:
                switch (address){
                    case 0:
                        V[X] = V[Y];
                        break;
                    case 1:
                        V[X] = ubyte(V[X].shortValue() | V[Y].shortValue());
                        break;
                    case 2:
                        V[X] = ubyte(V[X].shortValue() & V[Y].shortValue());
                        break;
                    case 3:
                        V[X] = ubyte(V[X].shortValue() ^ V[Y].shortValue());
                        break;
                    case 4:
                        V[X].add(V[Y]);
                        if ((V[X].shortValue() + V[Y].shortValue()) > 255) {
                            V[0xF] = ubyte(1);
                        }
                        break;
                    case 5:
                        V[0xF] = ubyte(1);
                        if (V[Y].shortValue() > V[X].shortValue()){
                            V[0xF] = ubyte(0);
                        }
                        V[X].subtract(V[Y]);
                        break;
                    case 6:
                        leastSignificantBit = V[X].shortValue() & 0x0F;
                        V[0xF] = ubyte(leastSignificantBit);
                        V[X] = ubyte(V[X].shortValue() >> 4);
                        break;
                    case 7:
                        V[X] = V[Y].subtract(V[X]);
                        if (V[X].shortValue() > V[Y].shortValue()){
                            V[0xF] = ubyte(0);
                        }
                        break;
                    case 0xE:
                        mostSignificantBit = V[X].shortValue() & 0xF000;
                        mostSignificantBit = mostSignificantBit >> 12;
                        V[0xF] = ubyte(mostSignificantBit);
                        V[X] = ubyte(V[X].shortValue() << 4);
                        break;
                    default:
                        System.out.println("opcode: " + hex(opcode) + " yet to be handled");
                        break;
                }
                break;
            case 0x9000:
                if (V[X] != V[Y]){
                    PC += 2;
                }
                break;
            case 0xA000:
                I = ushort(address);
                break;
            case 0xB000:
                PC = address + V[0].shortValue();
                break;
            case 0xC000:
                int randint = (int)(Math.random()*0xFFF + 1);
                V[X] = ubyte(address & randint);
                break;
            case 0xD000:
                int height = opcode & 0x000F;
                int startX = V[X].intValue();
                int startY = V[Y].intValue();
                V[0xF] = ubyte(0);

                for (int yValue = 0; yValue < height; yValue++) {
                    int data = memory[I.intValue() + yValue] & 0xFF;
                    int bit = 0;
                    for (int xValue = 0; xValue < 8; xValue++, bit--) {
                        int bitPlacement = 1 << bit;
                        if ((data & bitPlacement) > 0) {
                            int x = startX + xValue;
                            int y = startY + yValue;
                            if (display[x][y] == 1) {
                                V[0xF] = ubyte(1);
                            }
                            for (int xvalue = 0; xvalue < 10; xvalue++) {
                                for (int yvalue = 0; yvalue < 10; yvalue++) {
                                    display[(x*10) + xvalue][(y*10) + yvalue] ^= 1;
                                }
                            }
                        }
                    }
                }
                break;
            case 0xE000:
                if (lastWord == 0x9E){
                    byte keyPressed = V[X].byteValue();
                    if (keys.keyValue[keyPressed] == 1) {
                        PC++;
                    }
                }
                else if (lastWord == 0xA1){
                    byte keyPressed = V[X].byteValue();
                    if (keys.keyValue[keyPressed] == 0) {
                        PC++;
                    }
                }
                else {
                    System.out.println("opcode: " + hex(opcode) + " yet to be handled");
                }
                break;
            case 0xF000:
                switch (lastWord){
                    case 0x007:
                        V[X] = delayTimer;
                        break;
                    case 0x0A:
                        int keyWasPressed = -1;
                        for (int i = 0; i <= 0x0F; i++) {
                            if (keys.keyValue[i] == 1) {
                                keyWasPressed = i;
                                V[X] = ubyte(i);
                            }
                        }
                        if (keyWasPressed == -1) {
                            PC--;
                        }
                        break;
                    case 0x15:
                        delayTimer.add(V[X]);
                        break;
                    case 0x18:
                        soundTimer.add(V[X]);
                        break;
                    case 0x1E:
                        I.add(V[X].shortValue());
                        break;
                    case 0x29:
                        I = ushort(V[X].intValue() * 5);
                        break;
                    case 0x33:
                        int value = V[X].intValue();
                        int hundreds = value / 100;
                        int tens = (value / 10) % 10;
                        int units = value % 10;

                        memory[I.intValue()] = (byte)(hundreds);
                        memory[I.intValue() + 1] = (byte)(tens);
                        memory[I.intValue() + 2] = (byte)(units);
                        break;
                    case 0x55:
                        for (int i = 0; i <= X; i++) {
                            memory[I.intValue() + i] = V[i].byteValue();
                        }
                        I.add(X + 1);
                        break;
                    case 0x65:
                        for (int i = 0; i <= X; i++) {
                             V[i] = ubyte(memory[I.intValue() + i]);
                        }
                        I.add(X + 1);
                        break;
                }
                break;
            default:
                System.out.println("opcode: " + hex(opcode) + " yet to be handled");
                break;
        }
    }

}
