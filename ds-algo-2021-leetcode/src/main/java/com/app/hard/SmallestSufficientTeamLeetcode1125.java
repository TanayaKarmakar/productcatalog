package com.app.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 19/07/23
 * @project ds-algo-2021-leetcode
 */
public class SmallestSufficientTeamLeetcode1125 {
  //private static int[] team;

  private static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
    Set<String> requiredSkillSet = new HashSet<>();
    Set<String> allSkills = new HashSet<>();
    for(List<String> skill: people) {
      if(skill.isEmpty()) {
        skill.add("#");
      }
      allSkills.addAll(skill);
    }
    List<String> allSkillList = new ArrayList<>(allSkills);
    requiredSkillSet.addAll(Arrays.asList(req_skills));
    long totalCombination = (long)Math.pow(2, allSkills.size());
    int minLen = people.size() + 1;
    String minTeam = "";
    for(long current = 1; current < totalCombination; current++) {
      long temp = current;
      Map<String, Integer> currentAccuiredSkill = new HashMap<>();
      StringBuilder sb = new StringBuilder();
      int j = 0;
      while(temp != 0) {
        List<String> skills = new ArrayList<>();
        if((temp & 1) == 1) {
          skills.add(allSkillList.get(j));

          if(!requiredSkillSet.contains(allSkillList.get(j)))
            break;
          currentAccuiredSkill.put(allSkillList.get(j), currentAccuiredSkill.getOrDefault(allSkillList.get(j), 0) + 1);
          sb.append(j + " ");
        }
        temp = temp >> 1;
        j++;
      }


      int currentLen = sb.toString().trim().split("\\s+").length;
      if(currentLen < minLen && currentAccuiredSkill.size() == requiredSkillSet.size()) {
        minLen = currentLen;
        minTeam = sb.toString();
      }
    }
    if(!minTeam.isEmpty()) {
      int[] team = new int[minTeam.trim().split("\\s+").length];

      System.out.println(minTeam);

      int i = 0;
      for(String str: minTeam.trim().split("\\s+")) {
        team[i++] = Integer.parseInt(str);
      }

      return team;
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    String[] requiredSkills = {"java","nodejs","reactjs"};
    List<List<String>> people = new ArrayList<>();
    people.add(Arrays.asList("java"));
    people.add(Arrays.asList("nodejs"));
    people.add(Arrays.asList("nodejs", "reactjs"));

    //people.add(Arrays.asList("vza","mrxyc"));

    int[] ans = smallestSufficientTeam(requiredSkills, people);

    System.out.println(Arrays.toString(ans));
  }

//  private static void smallestSufficientTeamRec(List<List<String>> people, Set<String> requiredSkillSet, Set<String> currentAccuiredSkillSet, String teamStr,int indx) {
//    if(indx >= people.size()) {
//      if(currentAccuiredSkillSet.size() >= requiredSkillSet.size()) {
//        for(String skill: currentAccuiredSkillSet) {
//          if(!requiredSkillSet.contains(skill))
//            return;
//        }
//        int currentTeamSize = teamStr.trim().split("\\s+").length;
//        if(team != null && currentTeamSize > team.length)
//          return;
//        team = new int[currentTeamSize];
//        int i = 0;
//        for(String str: teamStr.trim().split("\\s+")) {
//          team[i++] = Integer.parseInt(str.trim());
//        }
//      }
//      return;
//    }
//    smallestSufficientTeamRec(people, requiredSkillSet, currentAccuiredSkillSet, teamStr, indx + 1);
//    currentAccuiredSkillSet.addAll(people.get(indx));
//    smallestSufficientTeamRec(people, requiredSkillSet, currentAccuiredSkillSet, teamStr + " " + indx, indx + 1);
//    currentAccuiredSkillSet.removeAll(people.get(indx));
//  }

}
