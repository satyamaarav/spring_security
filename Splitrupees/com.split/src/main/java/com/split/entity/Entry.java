package com.split.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int entryId;
    public Date date;
    public String type;
    public String category;
    public int amount;
    public String description;
    public String modeOfPayment;
    public int ledgerId;
    public int userId;
}
