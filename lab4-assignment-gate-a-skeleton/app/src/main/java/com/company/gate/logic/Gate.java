package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1; // Ворота открываются внутрь
    public static final int OUT = -1; // Ворота открываются наружу
    public static final int CLOSED = 0; // Ворота остановлены

    private int mSwing; // текущее направление поворота ворот
    private int mCount; // количество улиток в загоне

    public Gate() {
        mSwing = CLOSED; // по умолчанию ворота остановлены
        mCount = 0; // по умолчанию в загоне нет улиток
    }

    public int getSwingDirection() {
        return mSwing;
    }

    public boolean setSwing(int swing) {
        if (swing == IN || swing == OUT || swing == CLOSED) {
            mSwing = swing;
            return true;
        } else {
            return false;
        }
    }

    public boolean open(int direction) {
        if (direction == IN || direction == OUT) {
            setSwing(direction);
            return true;
        } else {
            return false;
        }
    }

    public void close() {
        setSwing(CLOSED);
    }


    public int thru(int count) {
        if (mSwing == IN) {
            mCount += count;
            return count;
        } else if (mSwing == OUT) {
            mCount -= count;
            return -count;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (mSwing == CLOSED) {
            return "This gate is closed";
        } else if (mSwing == IN) {
            return "This gate is open and swings to enter the pen only";
        } else if (mSwing == OUT) {
            return "This gate is open and swings to exit the pen only";
        } else {
            return "This gate has an invalid swing direction";
        }
    }

}