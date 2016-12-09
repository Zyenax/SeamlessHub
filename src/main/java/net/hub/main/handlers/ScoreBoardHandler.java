package net.hub.main.handlers;

import net.hub.main.Main;
import net.hub.main.utils.BungeeUtil;
import net.hub.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreBoardHandler implements Listener{
	
	private static Main plugin;
	public ScoreBoardHandler(Main listener) {
		ScoreBoardHandler.plugin = listener;
		boardUpdater();
		makeScoreBoard();
	}
	
	public static Scoreboard board;
	public static Objective objective;

    public static void makeScoreBoard(){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        board = scoreboardManager.getNewScoreboard();
        objective = board.registerNewObjective("lobby1","dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(Utils.color("&e&lServer Name"));
        Score score1 = objective.getScore(ChatColor.AQUA + "");
        score1.setScore(15);
        Score score = objective.getScore(ChatColor.BLACK + "");
        score.setScore(14);
        Score score2 = objective.getScore(ChatColor.BLUE + "");
        score2.setScore(13);
        Score score3 = objective.getScore(ChatColor.WHITE + "");
        score3.setScore(12);
        Score score4 = objective.getScore(ChatColor.DARK_AQUA + "");
        score4.setScore(11);
        Score score5 = objective.getScore(ChatColor.DARK_BLUE + "");
        score5.setScore(10);
        /*Score score6 = objective.getScore(ChatColor.DARK_GRAY + "");
        score6.setScore(9);
        Score score7 = objective.getScore(ChatColor.DARK_GREEN + "");
        score7.setScore(8);
        Score score8 = objective.getScore(ChatColor.DARK_PURPLE + "");
        score8.setScore(7);
        Score score9 = objective.getScore(ChatColor.DARK_RED + "");
        score9.setScore(6);
        Score score10 = objective.getScore(ChatColor.GOLD + "");
        score10.setScore(5);
        Score score11 = objective.getScore(ChatColor.GRAY + "");
        score11.setScore(4);
        Score score12 = objective.getScore(ChatColor.GREEN + "");
        score12.setScore(3);
        Score score13 = objective.getScore(ChatColor.LIGHT_PURPLE + "");
        score13.setScore(2);
        Score score14 = objective.getScore(ChatColor.RED + "");
        score14.setScore(1);*/
        
        Team team1 = board.registerNewTeam("team1");
        team1.addEntry(ChatColor.AQUA + "");
        
        Team team2 = board.registerNewTeam("team2");
        team2.addEntry(ChatColor.BLACK + "");

        Team team3 = board.registerNewTeam("team3");
        team3.addEntry(ChatColor.BLUE + "");
        
        Team team4 = board.registerNewTeam("team4");
        team4.addEntry(ChatColor.WHITE + "");
        
        Team team5 = board.registerNewTeam("team5");
        team5.addEntry(ChatColor.DARK_AQUA + "");
		
		Team team6 = board.registerNewTeam("team6");
        team6.addEntry(ChatColor.DARK_BLUE + "");
        
        /*Team team7 = board.registerNewTeam("team7");
        team7.addEntry(ChatColor.DARK_GRAY + "");

        Team team8 = board.registerNewTeam("team8");
        team8.addEntry(ChatColor.DARK_GREEN + "");
        
        Team team9 = board.registerNewTeam("team9");
        team9.addEntry(ChatColor.DARK_PURPLE + "");
        
        Team team10 = board.registerNewTeam("team10");
        team10.addEntry(ChatColor.DARK_RED + "");
        
        Team team11 = board.registerNewTeam("team11");
        team11.addEntry(ChatColor.GOLD + "");
        
        Team team12 = board.registerNewTeam("team12");
        team12.addEntry(ChatColor.GRAY + "");

        Team team13 = board.registerNewTeam("team13");
        team13.addEntry(ChatColor.GREEN + "");
        
        Team team14 = board.registerNewTeam("team14");
        team14.addEntry(ChatColor.LIGHT_PURPLE + "");
        
        Team team15 = board.registerNewTeam("team15");
        team15.addEntry(ChatColor.RED + "");*/
    }
    
    
    public static void boardUpdater(){
    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
        		public void run() {
        			
        			for(final Player p : Bukkit.getOnlinePlayers()){
        				if(!(p.equals(null))){
        					
        					Team team1 = p.getScoreboard().getTeam("team1");
            				team1.setPrefix(Utils.color("&bServers:"));
            				team1.setSuffix(Utils.color("  "));

            				Team team2 = p.getScoreboard().getTeam("team2");
            				team2.setPrefix(Utils.color("&eNetwork:"));
            				team2.setSuffix(Utils.color(" &a" + BungeeUtil.playerCountOfServer(p, "ALL")));
            				
            				Team team3 = p.getScoreboard().getTeam("team3");
            				team3.setPrefix(Utils.color("&eKitPvP:"));
            				team3.setSuffix(Utils.color(" &a" + BungeeUtil.playerCountOfServer(p, "KitPvP")));
            				
            				Team team4 = p.getScoreboard().getTeam("team4");
            				team4.setPrefix(Utils.color("&eRankedKPvP:"));
            				team4.setSuffix(Utils.color(" &a" + BungeeUtil.playerCountOfServer(p, "RankedKPVP")));

            				Team team5 = p.getScoreboard().getTeam("team5");
            				team5.setPrefix(Utils.color(" "));
            				team5.setSuffix(Utils.color(""));
        			
            				Team team6 = p.getScoreboard().getTeam("team6"); 
            				team6.setPrefix(Utils.color("&cwebsite.net"));
            				team6.setSuffix(Utils.color(""));
    				
            				/*Team team7 = p.getScoreboard().getTeam("team7");
            				team7.setPrefix(Utils.color("7"));
            				team7.setSuffix(Utils.color(""));
    				
            				Team team8 = p.getScoreboard().getTeam("team8");
            				team8.setPrefix(Utils.color("8"));
            				team8.setSuffix(Utils.color(""));
    				
            				Team team9 = p.getScoreboard().getTeam("team9");
            				team9.setPrefix(Utils.color("9"));
            				team9.setSuffix(Utils.color(""));
    				
            				Team team10 = p.getScoreboard().getTeam("team10");
            				team10.setPrefix(Utils.color("10"));
            				team10.setSuffix(Utils.color(""));
    				
            				Team team11 = p.getScoreboard().getTeam("team11");
            				team11.setPrefix(Utils.color("11"));
            				team11.setSuffix(Utils.color(""));
        			
            				Team team12 = p.getScoreboard().getTeam("team12"); 
            				team12.setPrefix(Utils.color("12"));
            				team12.setSuffix(Utils.color(""));
    				
            				Team team13 = p.getScoreboard().getTeam("team13");
            				team13.setPrefix(Utils.color("13"));
            				team13.setSuffix(Utils.color(""));
    				
            				Team team14 = p.getScoreboard().getTeam("team14");
            				team14.setPrefix(Utils.color("14"));
            				team14.setSuffix(Utils.color(""));
    				
            				Team team15 = p.getScoreboard().getTeam("team15");
            				team15.setPrefix(Utils.color("15"));
            				team15.setSuffix(Utils.color(""));*/
        					}
        				}
        			}
            	}, 0, 5);
					//END OF SCOREBOARD DISPLAYNAME
    }
}
