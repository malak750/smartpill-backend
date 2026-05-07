package com.smartpill.smartpill_backend.service;

import com.smartpill.smartpill_backend.model.PriseMedicament;
import com.smartpill.smartpill_backend.repository.PriseMedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class NtfyListenerService {

    @Autowired
    private PriseMedicamentRepository repository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String NTFY_URL = "https://ntfy.sh/rappel-medicament-123/json?poll=1&since=1m";

    @Scheduled(fixedDelay = 10000)
    public void ecouterNtfy() {
        try {
            String response = restTemplate.getForObject(NTFY_URL, String.class);
            if (response == null || response.isEmpty()) return;

            String[] lines = response.split("\n");
            for (String line : lines) {
                if (line.contains("\"message\"")) {
                    PriseMedicament prise = new PriseMedicament();
                    prise.setDateHeure(LocalDateTime.now());

                    if (line.contains("Medicament pris")) {
                        prise.setMedicament("Médicament");
                        prise.setPris(true);
                        prise.setRemarque("Pris via pilulier");
                    } else if (line.contains("Prenez medicament")) {
                        prise.setMedicament("Médicament");
                        prise.setPris(false);
                        prise.setRemarque("Rappel non pris");
                    } else {
                        continue;
                    }

                    repository.save(prise);
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur ntfy: " + e.getMessage());
        }
    }
}
