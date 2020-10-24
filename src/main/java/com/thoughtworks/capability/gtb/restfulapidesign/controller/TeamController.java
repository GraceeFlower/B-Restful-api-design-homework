package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.controller.dto.TeamUpdateRequestDTO;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@Validated
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @PatchMapping("/teams")
    public List<Team> separateTeams() {return teamService.separateTeams();}

    @PatchMapping("/teams/{id}")
    public Team update(@PathVariable @Valid int id,
                       @RequestBody TeamUpdateRequestDTO teamUpdateRequestDTO) {
        return teamService.updateTeamById(id, teamUpdateRequestDTO.getName());
    }
}
