package com.thoughtworks.capability.gtb.restfulapidesign.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamUpdateRequestDTO {
    private int id;
    private String name;
}
