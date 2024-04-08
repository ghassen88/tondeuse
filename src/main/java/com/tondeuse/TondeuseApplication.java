package com.tondeuse;

import com.tondeuse.model.Lawn;
import com.tondeuse.service.MowerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class TondeuseApplication {
    public static void main(String[] args) {
        SpringApplication.run(TondeuseApplication.class, args);


        try {
            // Lecture des dimensions de la pelouse à partir du fichier input.txt
            ClassPathResource resource = new ClassPathResource("input.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line = reader.readLine();
            String[] lawnDimensions = line.split(" ");
            if (lawnDimensions.length != 2) {
                throw new IllegalArgumentException("Dimensions de la pelouse invalides dans le fichier input.txt");
            }
            int maxX = Integer.parseInt(lawnDimensions[0]);
            int maxY = Integer.parseInt(lawnDimensions[1]);

            // Création de la pelouse
            Lawn lawn = new Lawn(maxX, maxY);

            MowerService mowerservice = new MowerService();

            // Lecture des instructions pour chaque tondeuse
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    char orientation = parts[2].charAt(0);
                    String instructions = reader.readLine();
					mowerservice.deployMower(x, y, orientation, instructions, lawn);
                }
            }

            // Récupération des positions finales
            List<String> finalPositions = mowerservice.getFinalPositions();
            for (String position : finalPositions) {
                System.out.println(position);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}