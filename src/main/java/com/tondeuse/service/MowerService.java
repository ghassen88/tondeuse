package com.tondeuse.service;

import com.tondeuse.utils.MowerUtils;
import com.tondeuse.model.Mower;
import com.tondeuse.model.Lawn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MowerService {
    private final List<Mower> mowers = new ArrayList<>();

    public void deployMower(int x, int y, char orientation, String instructions, Lawn lawn) {
        Mower mower = new Mower(x, y, orientation);
        for (char instruction : instructions.toCharArray()) {
            MowerUtils.move(mower, instruction, lawn); // Utilisation de la méthode move de MowerUtils
        }
        mowers.add(mower);
    }

    public List<String> getFinalPositions() {
        List<String> positions = new ArrayList<>();
        for (Mower mower : mowers) {
            positions.add(mower.getPosition());
        }
        return positions;
    }
}