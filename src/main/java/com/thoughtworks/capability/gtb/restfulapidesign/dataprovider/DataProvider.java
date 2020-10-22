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
        List<Student> team1Stus = new ArrayList<>();
        Team team1 = new Team(1,"team 1","",team1Stus);
        List<Student> team2Stus = new ArrayList<>();
        Team team2 = new Team(2,"team 2","",team2Stus);
        List<Student> team3Stus = new ArrayList<>();
        Team team3 = new Team(3,"team 3","",team3Stus);
        List<Student> team4Stus = new ArrayList<>();
        Team team4 = new Team(4,"team 4","",team4Stus);
        List<Student> team5Stus = new ArrayList<>();
        Team team5 = new Team(5,"team 5","",team5Stus);
        List<Student> team6Stus = new ArrayList<>();
        Team team6 = new Team(6,"team 6","",team6Stus);
        teamList.add(team1);
        teamList.add(team2);
        teamList.add(team3);
        teamList.add(team4);
        teamList.add(team5);
        teamList.add(team6);
    }

    public static List<Team> getTeams() {
        return teamList;
    }
}
