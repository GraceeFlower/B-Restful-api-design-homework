package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.exception.InvalidStudentException;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final StudentService studentService;

    public TeamService(TeamRepository teamRepository, StudentService studentService) {
        this.teamRepository = teamRepository;
        this.studentService = studentService;
    }

    private List<Team> initTeams() {
        return teamRepository.initTeams();
    }

    public List<Team> separateTeams() {
        List<Student> students = studentService.findAll();
        Collections.shuffle(students);
        List<Team> teams = initTeams();
        for (int stuIndex = 0; stuIndex < students.size(); stuIndex++) {
            teams.get(stuIndex % teams.size()).getStudents().add(students.get(stuIndex));
        }
        return teams;
    }

    public Team updateTeamById(int teamId, String name) {
        Team team = teamRepository.findById(teamId);
        if (team == null) {
            throw new InvalidStudentException("小组不存在！");
        }
        return teamRepository.updateTeam(team, name);
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
