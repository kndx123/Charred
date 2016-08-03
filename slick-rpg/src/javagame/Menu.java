package javagame;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class Menu extends BasicGameState{
	TrueTypeFont font;
	TrueTypeFont font2;
	TrueTypeFont title;
	//test
	int test;
	//test
	int trans = 0;
	int re = 0, bl =0, gr = 0;
	Input input;
	
	public static Sound sound;
	Image back;
	Color col = Color.black;
	
	boolean transplus;
	boolean transminus;
	
	public static boolean updateButtons = false;
	
	public static Button exitb;
	public static Button playb;
	public static Button optionb;
	public static Button gameTitle;
	
	public Menu(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		back = new Image("res/fireback.png");
		sound = new Sound("res/slam.ogg");
		
		input = gc.getInput();
	    // load a default java font
	    Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
	    font = new TrueTypeFont(awtFont, false);
	    test =sbg.getStateCount();
	    System.out.println("STATES: "+test);
	    // load font from a .ttf file
	    try {
	        InputStream inputStream = ResourceLoader.getResourceAsStream("res/Underdog-Regular.ttf");
	         
	        Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
	        font2 = new TrueTypeFont(awtFont2.deriveFont(48F), true);
	        title = new TrueTypeFont(awtFont2.deriveFont(60F), true);
	             
	    } catch (Exception e) {
	        e.printStackTrace();
	    }  
	    playb = new Button(Game.width/2-(font2.getWidth("PLAY")/2), Game.height/2, "PLAY", font2, true, true);
	    optionb = new Button(Game.width/2-(font2.getWidth("OPTIONS")/2), Game.height/2+(font2.getHeight()*2), "OPTIONS", font2, true, true);
	    exitb = new Button(Game.width/2-(font2.getWidth("EXIT")/2), Game.height/2+(font2.getHeight()*4), "EXIT", font2, true, true);
	    gameTitle = new Button(Game.width/2-(title.getWidth(Game.gamename)/2), Game.height/4, Game.gamename, title, false, false);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(updateButtons){
			playb = new Button(Game.width/2-(font2.getWidth("PLAY")/2), Game.height/2, "PLAY", font2, true, true);
		    optionb = new Button(Game.width/2-(font2.getWidth("OPTIONS")/2), Game.height/2+(font2.getHeight()*2), "OPTIONS", font2, true, true);
		    exitb = new Button(Game.width/2-(font2.getWidth("EXIT")/2), Game.height/2+(font2.getHeight()*4), "EXIT", font2, true, true);
		    gameTitle = new Button(Game.width/2-(title.getWidth(Game.gamename)/2), Game.height/4, Game.gamename, title, false, false);
		    updateButtons = false;
		}
	    
		
		back.draw(0, 0, Game.width, Game.height);
		g.setColor(new Color(re, bl, gr, trans));
		g.fillRect(0, 0, Game.width, Game.height);
		
//		font2.drawString(100, 100, xpos+"test"+ypos, col);
		
//		title.drawString(Game.width/2-(title.getWidth(Game.gamename)/2), Game.height/4, Game.gamename, new Color(tc,tc,tc,200));
//		font2.drawString(Game.width/2-(font2.getWidth("PLAY")/2), Game.height/2, "PLAY", col);
//		font2.drawString(Game.width/2-(font2.getWidth("OPTIONS")/2), Game.height/2+(font2.getHeight()*2), "OPTIONS", col2);
//		font2.drawString(Game.width/2-(font2.getWidth("EXIT")/2), Game.height/2+(font2.getHeight()*4), "EXIT", col1);
		gameTitle.render(title);
		playb.render(font2);
		optionb.render(font2);
		exitb.render(font2);
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
//		playb = new Rectangle(Game.width/2-(font2.getWidth("PLAY")/2), Game.height/2, font2.getWidth("PLAY"), font2.getHeight());
//		optionb = new Rectangle(Game.width/2-(font2.getWidth("OPTIONS")/2), Game.height/2+(font2.getHeight()*2), font2.getWidth("OPTIONS"), font2.getHeight());
//		exitb = new Rectangle(Game.width/2-(font2.getWidth("EXIT")/2), Game.height/2+(font2.getHeight()*4), font2.getWidth("EXIT"), font2.getHeight());
		
		playb.update(input, sbg);
		optionb.update(input, sbg);
		exitb.update(input, sbg);
		
		if(transplus){
			trans++;
		}else{
			trans--;
		}
		if(trans<100&&!transminus){
			transplus = true;
		}else{
			transminus = true;
			transplus = false;
		}
		if(trans<1&&!transplus){
			transplus = true;
			transminus = false;
		}
//		if(playb.contains(mouse)||optionb.contains(mouse)){
//			if(!isPlaying){
//				sound.play();	
//				isPlaying = true;
//			}
//		}else{
//			isPlaying = false;
//		}
//		
//		if(exitb.contains(mouse)){
//			col1 = new Color(tc, tc, tc, 50);
//			if(input.isMouseButtonDown(0)){
//				col1 = new Color(tc, tc, tc, 15);
//					mousedown2 = true;	
//				}
//				if(mousedown2 && !input.isMouseButtonDown(0)){
//					sound.stop();
//					AL.destroy();
//					System.exit(1);
//				}
//		}else{
//			mousedown2 = false;
//			col1 = new Color(tc,tc,tc, 200);
//		}	
//		if(playb.contains(mouse)){	
//			col = new Color(tc, tc, tc, 50);
//			if(input.isMouseButtonDown(0)){
//			col = new Color(tc, tc, tc, 15);
//				mousedown = true;	
//			}
//			if(mousedown && !input.isMouseButtonDown(0)){
//				mousedown = false;
//				sbg.enterState(1);
//			}
//		}else{
//			mousedown = false;
//			col = new Color(tc, tc, tc, 200);
//		}		
//		if(optionb.contains(mouse)){	
//			col2 = new Color(tc, tc, tc, 50);
//			if(input.isMouseButtonDown(0)){
//			col2 = new Color(tc, tc, tc, 15);
//				mousedown3 = true;	
//			}
//			if(mousedown3 && !input.isMouseButtonDown(0)){
//				mousedown3 = false;
//				sbg.enterState(2);
//			}
//		}else{
//			mousedown3 = false;
//			col2 = new Color(tc, tc, tc, 200);
//		}
//		
	}
	
	public int getID() {	
		return 0;
	}
}
