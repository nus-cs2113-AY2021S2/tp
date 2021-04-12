package seedu.allinonenus.teamplannerclasses;

import java.util.ArrayList;


public class TeamManager {
    private ArrayList<TeamMember> team;
    private int memberCount = 0;
    private String password = "";

    public TeamManager() {
        this.team = new ArrayList<TeamMember>();
    }

    public void addMember(TeamMember teamMember) {
        team.add(teamMember);
        memberCount++;
    }

    public void removeMember(int memberNum) {
        if (memberNum < memberCount && memberCount >= 0) {
            System.out.println(team.get(memberNum) + " has been removed");
            team.remove(memberNum);
            memberCount--;
        } else {
            System.out.println("Index out of range");
        }
    }

    public int getMemberCount() {
        return memberCount;
    }

    public TeamMember getTeamMember(int index) {
        return team.get(index);
    }

    public int getIndexOfTeamMember(String teamMemberName) {
        for (int i = 0; i < memberCount; i++) {
            if (team.get(i).getName().trim().equals(teamMemberName)) {
                return i;
            }
        }
        return -1;
    }

    public void clearTeam() {
        team.clear();
        memberCount = 0;
    }

    public void increaseMemberCount() {
        memberCount++;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
