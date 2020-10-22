package com.thoughtworks.capability.gtb.restfulapidesign.dataprovider;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static List<Student> studentList = new ArrayList<>();
    public static List<Team> teamList = new ArrayList<>();

    static {
        initTeams();
    }

    public static void initTeams() {
        int groupId;
        for (int i = 0; i < 6; i++) {
            groupId = i + 1;
            teamList.add(new Team(groupId, String.format("Team %s", groupId), "", new ArrayList<>()));
        }
    }

    public static List<Team> getTeams() {
        return teamList;
    }
}
