/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fsd.ds.day01teammembers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mer
 */
public class Day01TeamMembers {

    public static void main(String[] args) {
    
        HashMap<String, ArrayList<String>> playerTeams = new HashMap<>();
        ArrayList<String> allPlayers = new ArrayList<>();
        
        
        
                try (Scanner scanner = new Scanner(new File("teams.txt"))) {
            
            while (scanner.hasNext()) {
                String[] str = scanner.nextLine().split(":");
                String team = str[0];
               // System.out.println(team);
                
                String[] teamPlayers = str[1].split(",");
                
                for (String player : teamPlayers) {
                   // System.out.println(player);
                    
                    if (playerTeams.containsKey(player)) {
                        playerTeams.get(player).add(team);
                        
                    } else {
                        ArrayList<String> teams = new ArrayList<>();
                        teams.add(team);
                        playerTeams.put(player, teams);
                        allPlayers.add(player);
                        
                    }
                }
            }
            
            for (String player : allPlayers) {
                
                System.out.print(player + " plays in: ");
                for (String team : playerTeams.get(player)) {
                    System.out.print(team);
                    if (!team.equals(playerTeams.get(player).get(playerTeams.get(player).size()-1))) {
                                    System.out.print(", ");
                                    
                    } else {
                         System.out.println();
                    }
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    }
//
//    public static HashMap<String, ArrayList<String>> getPlayersByTeams() {
//        
//
//}
