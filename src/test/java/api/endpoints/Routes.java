package api.endpoints;

public class Routes {
	
	//BaseURL
	public static String base_url="https://bingo-api-dev.cubestagearea.xyz";
	
	//AdminPanel System
	//Sign-in module
	public static String signin_post_url= base_url + "/api/admin/sign-in";
	
	//changepassword
	public static String changepassword_post_url= base_url + "/api/admin/change-password";
	
	//logout
	public static String logout_post_url= base_url + "/api/admin/logout";
	
	//admindashboard
	public static String admindashboard_get_url= base_url + "/api/admin/admin-Dashboard-Data";
	
	//chest
	public static String shortcode_get_url= base_url + "/api/admin/chest/shortcodes";
	public static String adminchest_get_url= base_url + "/api/admin/chest";
	public static String adminchest_post_url= base_url + "/api/admin/chest";
	public static String adminchest_put_url= base_url + "/api/admin/chest/";
	public static String adminchest_delete_url= base_url + "/api/admin/chest/";
	
	//powerups
	public static String powerupcreate_post_url= base_url + "/api/admin/powerUp";
	public static String powerupfetch_get_url= base_url + "/api/admin/powerUps/";
	public static String powerup_put_url= base_url + "/api/admin/powerUp/";
	public static String powerup_delete_url= base_url + "/api/admin/powerUp/";
	
	//spinrewards
	public static String spinrewardcreate_post_url= base_url + "/api/admin/spin-rewards";
	public static String spinrewardfetch_get_url= base_url + "/api/admin/spin-rewards";
	public static String spinrewardupdate_put_url= base_url + "/api/admin/spin-rewards/";
	public static String spinrewarddelete_delete_url= base_url + "/api/admin/spin-rewards/";
	
	//dailyreward
	public static String dalilyrewardcreate_post_url= base_url + "/api/admin/daily-rewards";
	public static String dailyrewardfetch_get_url= base_url + "/api/admin/daily-rewards";
	public static String dalilyrewardupdate_put_url= base_url + "/api/admin/daily-rewards/";
	public static String dailyrewarddelete_delete_url= base_url + "/api/admin/daily-rewards/";
	
	//avatar
	public static String avatarcreate_post_url= base_url + "/api/admin/avatar";
	public static String avatarfetch_get_url= base_url + "/api/admin/avatar";
	public static String avatarupdate_put_url= base_url + "/api/admin/avatar/";
	public static String avatardelete_delete_url= base_url + "/api/admin/avatar/";
	
	//pointswager
	public static String pointwagercreate_post_url= base_url + "/api/admin/ticket-wager";
	public static String pointwagerfetch_get_url= base_url + "/api/admin/ticket-wager";
	public static String pointwagerupdate_put_url= base_url + "/api/admin/ticket-wager/";
	public static String pointwagerdelete_delete_url= base_url + "/api/admin/ticket-wager/";
	
	//users
	public static String userfetchbyid_get_url= base_url + "/api/admin/users/";
	public static String userfetch_get_url= base_url + "/api/admin/users";
	
	//marketplace
	public static String marketplacecreate_post_url= base_url + "/api/admin/marketplace";
	public static String marketplacefetch_get_url= base_url + "/api/admin/marketplace";
	public static String marketplaceshortcodefetch_get_url= base_url + "/api/admin/marketplace/power-ups-shortcode";
	public static String marketplaceupdate_put_url= base_url + "/api/admin/marketplace/";
	public static String marketplacedelete_delete_url= base_url + "/api/admin/marketplace/";
	
	//currency
	public static String currencyupdate_put_url= base_url + "/api/admin/currency/";
	public static String currencyfetch_get_url= base_url + "/api/admin/currency";
	
	
	//ranktournament
	public static String ranktournamentcreate_post_url= base_url + "/api/admin/tournament-ranks";
	public static String ranktournamentupdate_put_url= base_url + "/api/admin/tournament-ranks/";
	public static String ranktournamentdelete_delete_url= base_url + "/api/admin/tournament-ranks/";
	public static String ranktournamentfetch_get_url= base_url + "/api/admin/tournament-ranks";
	
	//leaderboard
	public static String leaderboardfetch_get_url= base_url + "/api/admin/leaderboard";

}
