package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dataprovider.DataProvider;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepository {

    private final List<Team> teamList = DataProvider.getTeams();

    public List<Team> initTeams() {
        return DataProvider.getTeams();
    }


    public Team findById(int teamId) {
        return teamList.stream().filter(team -> team.getId() == teamId).findFirst().orElse(null);
    }

    public Team updateTeam(Team team, String name) {
        team.setName(name);
        return team;
    }
}
