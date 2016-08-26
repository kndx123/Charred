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
	static TrueTypeFont font2;
	static TrueTypeFont title;
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
	    playb = new Button("PLAY",Game.width/2-(font2.getWidth("PLAY")/2), Game.height/2, "PLAY", font2, true, true);
	    optionb = new Button("OPTIONS",Game.width/2-(font2.getWidth("OPTIONS")/2), Game.height/2+(font2.getHeight()*2), "OPTIONS", font2, true, true);
	    exitb = new Button("EXIT",Game.width/2-(font2.getWidth("EXIT")/2), Game.height/2+(font2.getHeight()*4), "EXIT", font2, true, true);
	    gameTitle = new Button(Game.gamename,Game.width/2-(title.getWidth(Game.gamename)/2), Game.height/4, Game.gamename, title, false, false);
	}
	
	public static void reInit(){
		playb = new Button(playb.getName(), Game.width/2-(font2.getWidth("PLAY")/2), Game.height/2, playb.getText(), playb.getFont(), playb.getHover(), playb.getSound());
		optionb = new Button(optionb.getName(),Game.width/2-(font2.getWidth("OPTIONS")/2), Game.height/2+(font2.getHeight()*2), optionb.getText(), optionb.getFont(), optionb.getHover(), optionb.getSound());
		exitb = new Button(exitb.getName(),Game.width/2-(font2.getWidth("EXIT")/2), Game.height/2+(font2.getHeight()*4), exitb.getText(), exitb.getFont(), exitb.getHover(), exitb.getSound());
		gameTitle = new Button(gameTitle.getName(), Game.width/2-(title.getWidth(Game.gamename)/2), Game.height/4, gameTitle.getText(), gameTitle.getFont(), gameTitle.getHover(), gameTitle.getSound());
	    updateButtons = false;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		back.draw(0, 0, Game.width, Game.height);
		g.setColor(new Color(re, bl, gr, trans));
		g.fillRect(0, 0, Game.width, Game.height);
		

		gameTitle.render(title);
		playb.render(font2);
		optionb.render(font2);
		exitb.render(font2);
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {	
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
	}
	
	public int getID() {	
		return 0;
	}
}
