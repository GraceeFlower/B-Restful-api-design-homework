package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.controller.dto.TeamUpdateRequestDTO;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
@Validated
public class TeamController {

    private final StudentService studentService;
    private final TeamService teamService;

    public TeamController(StudentService studentService, TeamService teamService) {
        this.studentService = studentService;
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<Team> separateTeam() {
        List<Student> students = studentService.findAll();
        Collections.shuffle(students);
        List<Team> teams = teamService.initTeams();
        for (int stuIndex = 0; stuIndex < students.size(); stuIndex++) {
            teams.get(stuIndex % teams.size()).getStudents().add(students.get(stuIndex));
        }
        return teams;
    }

    @PatchMapping("/teams")
    public Team update(@RequestBody @Valid TeamUpdateRequestDTO teamUpdateRequestDTO) {
        return teamService.updateTeamById(teamUpdateRequestDTO.getId(), teamUpdateRequestDTO.getName());
    }
}
