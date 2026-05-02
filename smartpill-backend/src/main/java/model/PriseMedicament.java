package com.smartpill.smartpill_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "prises")
public class PriseMedicament {

    @Id
    private String id;
    private String medicament;
    private LocalDateTime dateHeure;
    private boolean pris;
    private String remarque;
}