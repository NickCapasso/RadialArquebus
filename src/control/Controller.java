package control;
import gameElements.World;

import java.util.Scanner;

public class Controller {
	private static Scanner in;
	private static boolean playing;
	private static boolean running;
	private static boolean loaded;
	private static DayController dayController = new DayController();
	
	public static void main(String[] args) {
		if(!running){
			setup();
			intro();
		}
		while(running){
			if(!playing){
				print("MENU");
				startMenu(arg());
			}else{
				print("READY");
				nextDay(arg());
			}
		}
	}
	
	private static void setup(){
		in = new Scanner(System.in);
		playing = false;
		running = true;
	}
	
	private static void intro(){
		print("##########");
		print("RADIAL ARQUEBUS");
		print("Version 0.0");
		print("##########");
		print();
		print("HELP is always an option.");
		print();
	}
	
	private static void startMenu(String arg){
		switch (arg.toUpperCase()){
		case "PLAY":
			playing=true;
			if(!loaded){
				dayController.setWorld(new World());
			}
			break;
		case "LOAD":
			//TODO load saves
			loaded = true;
			break;
		case "QUIT":
			running = false;
			break;
		case "RESET":
			//TODO load saves
			break;
		case "HELP":
			print("COMMAND LIST:");
			print("|| HELP - Displays this list.");
			print("|| PLAY - Begins the game. If no save is loaded, creates a new game.");
			print("|| LOAD - Load a saved game.");
			print("|| QUIT - End the program.");
			print("|| RESET - Creates a new game over the currently loaded save.");
			break;
		}
			
	}
	
	public static void print(){
		System.out.println();
	}
	public static void print(String toPrint){
		System.out.println(toPrint);
	}
	
	public static String nextArg(){
		return in.next();
	}
	
	private static String arg(){
		return in.next();
	}
	
	private static boolean nextDay(String arg){
		switch(arg.toUpperCase()){
		case "MOVE":
			print("How far would you like to go?");
			int temp = in.nextInt();
			print("What direction would like to go? (0-359)");
			int temptheta = in.nextInt();
			dayController.world.movePlayer(temp,temptheta);
			dayController.world.playerLoc();
			break;
		case "END":
			print("Starting next day.");
			dayController.nextDay();
			break;
		}
		return false;
	}

}
