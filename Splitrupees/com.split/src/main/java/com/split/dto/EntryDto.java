package com.split.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntryDto {

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
