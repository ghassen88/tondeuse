package com.tondeuse.utils;

import com.tondeuse.model.Lawn;
import com.tondeuse.model.Mower;

public class MowerUtils {


        public static void move(Mower mower, char instruction, Lawn lawn) {
            if (instruction == 'D') {
                rotateRight(mower);
            } else if (instruction == 'G') {
                rotateLeft(mower);
            } else if (instruction == 'A') {
                moveForward(mower, lawn);
            }
        }

        private static void rotateRight(Mower mower) {
            char orientation = mower.getOrientation();
            if (orientation == 'N') {
                mower.setOrientation('E');
            } else if (orientation == 'E') {
                mower.setOrientation('S');
            } else if (orientation == 'S') {
                mower.setOrientation('W');
            } else if (orientation == 'W') {
                mower.setOrientation('N');
            }
        }

        private static void rotateLeft(Mower mower) {
            char orientation = mower.getOrientation();
            if (orientation == 'N') {
                mower.setOrientation('W');
            } else if (orientation == 'W') {
                mower.setOrientation('S');
            } else if (orientation == 'S') {
                mower.setOrientation('E');
            } else if (orientation == 'E') {
                mower.setOrientation('N');
            }
        }

        private static void moveForward(Mower mower, Lawn lawn) {
            char orientation = mower.getOrientation();
            int x = mower.getX();
            int y = mower.getY();

            if (orientation == 'N' && y < lawn.getMaxY()) {
                mower.setY(y + 1);
            } else if (orientation == 'E' && x < lawn.getMaxX()) {
                mower.setX(x + 1);
            } else if (orientation == 'S' && y > 0) {
                mower.setY(y - 1);
            } else if (orientation == 'W' && x > 0) {
                mower.setX(x - 1);
            }
        }
    }