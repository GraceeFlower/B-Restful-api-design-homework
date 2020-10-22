package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.exception.InvalidStudentException;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> initTeams() {
        return teamRepository.initTeams();
    }

    public Team updateTeamById(int teamId, String name) {
        Team team = teamRepository.findById(teamId);
        if (team == null) {
            throw new InvalidStudentException("小组不存在！");
        }
        return teamRepository.updateTeam(team, name);
    }
}
