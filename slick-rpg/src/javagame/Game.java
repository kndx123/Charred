package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
	
	public static final String gamename = "Charred";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int options = 2;
	
	public static int width = 1280;
	public static int height = 720;
	
	public static boolean fullscreen = false;
	
	public static AppGameContainer appgc;
	
	
	public Game(String gaamename){
		super(gamename);
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(new Play(play));
		this.addState(new Menu(menu));
		this.addState(new Options(options));
		
//		this.getState(menu).init(gc, this);
//		this.getState(play).init(gc, this);
//		this.getState(options).init(gc, this);
		
		this.enterState(menu);
		gc.setShowFPS(false);
		gc.setTargetFrameRate(60);
	}
	
	public static void main(String[] args){
		start();		
	}
	
	public static void start(){
		try{
			System.setProperty("org.newdawn.slick.pngloader", "false");
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(width, height, fullscreen);
			appgc.setIcons(new String[] {"res/cha16.png", "res/cha24.png", "res/cha32.png" });
			appgc.setAlwaysRender(true);
			appgc.setVSync(true);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
	public static void settings(boolean fullscreen, int winwidth, int winheight){
		try {
			appgc.setDisplayMode(winwidth, winheight, fullscreen);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void settings(int volume) throws SlickException{
			appgc.setSoundVolume(0.1F*volume);	
	}
	
}
