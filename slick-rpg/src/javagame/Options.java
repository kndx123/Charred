package javagame;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class Options extends BasicGameState{
	Input input;

	public Options(int state){
	}
	static TrueTypeFont font;
	static TrueTypeFont font2;
	static TrueTypeFont title;
	public static Button backb;
	public static Button fullb;
	public static Button plusVol;
	public static Button minusVol;
	public static Button plusRes;
	public static Button minusRes;
	public static Button volButton;
	public static Button resButton;
	public static int volume = 10;
	public static int activeRes = 2;
	public static String[] resolutions = {"800x600", "1280x1024", "1280x720", "1680x1050", "1920x1080"};
	Color col = Color.white;

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		input = gc.getInput();
		
		 try {
		        InputStream inputStream = ResourceLoader.getResourceAsStream("res/Underdog-Regular.ttf");
		         
		        Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		        font2 = new TrueTypeFont(awtFont2.deriveFont(48F), true);
		        title = new TrueTypeFont(awtFont2.deriveFont(60F), true);
		             
		    } catch (Exception e) {
		        e.printStackTrace();
		    } 
		
		backb = new Button("BACK",font2.getWidth("BACK")/3, font2.getHeight()/2,"BACK", font2, true, true);
		fullb = new Button("FULLSCREEN",Game.width/2-font2.getWidth("FULLSCREEN")/2, Game.height/2,"FULLSCREEN", font2, true, true);
		plusVol = new Button("+Vol",Game.width/2-font2.getWidth("+Vol")/2+90, Game.height/2-font2.getHeight(),"+Vol", font2, true, true);
		minusVol = new Button("-Vol",Game.width/2-font2.getWidth("-Vol")*2+30, plusVol.y,"-Vol", font2, true, true);
		plusRes = new Button("+Res",Game.width/2-font2.getWidth("+Res")/2+90, Game.height/2-(font2.getHeight()*2),"+Res", font2, true, true);
		minusRes = new Button("-Res",Game.width/2-font2.getWidth("-Res")*2+50, plusRes.y,"-Res", font2, true, true);
		volButton = new Button("vol",Game.width/2-font2.getWidth("-Vol")*2+145, plusVol.y,""+volume, font2, false, false);
		resButton = new Button("res",Game.width/2-font2.getWidth(""+resolutions[activeRes])+100, Game.height/2-(font2.getHeight()*3),""+resolutions[activeRes], font2, false, false);
	}

	public static void reInit(){
		fullb = new Button(fullb.getName(), Game.width/2-font2.getWidth("FULLSCREEN")/2, Game.height/2, fullb.getText(), fullb.getFont(), fullb.getHover(), fullb.getSound());
		backb = new Button(backb.getName(), font2.getWidth("BACK")/3, font2.getHeight()/2, backb.getText(), backb.getFont(), backb.getHover(), backb.getSound());
		plusVol = new Button(plusVol.getName(), Game.width/2-font2.getWidth("+Vol")/2+90, Game.height/2-font2.getHeight(), plusVol.getText(), plusVol.getFont(), plusVol.getHover(), plusVol.getSound());
		minusVol = new Button(minusVol.getName(), Game.width/2-font2.getWidth("-Vol")*2+30, plusVol.y, minusVol.getText(), minusVol.getFont(), minusVol.getHover(), minusVol.getSound());
		plusRes = new Button(plusRes.getName(),Game.width/2-font2.getWidth("+Res")/2+90, Game.height/2-(font2.getHeight()*2), plusRes.getText(), plusRes.getFont(), plusRes.getHover(), plusRes.getSound());
		minusRes = new Button(minusRes.getName(),Game.width/2-font2.getWidth("-Res")*2+50, plusRes.y, minusRes.getText(), minusRes.getFont(), minusRes.getHover(), minusRes.getSound());
		volButton = new Button(volButton.getName(), Game.width/2-font2.getWidth("-Vol")*2+145, plusVol.y, volButton.getText(), volButton.getFont(), volButton.getHover(), volButton.getSound());
		resButton = new Button(resButton.getName(), Game.width/2-font2.getWidth(""+resolutions[activeRes])+100, Game.height/2-(font2.getHeight()*3),""+resolutions[activeRes], resButton.getFont(), resButton.getHover(), resButton.getSound());
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		backb.render(font2);
		fullb.render(font2);
		plusVol.render(font2);
		minusVol.render(font2);
		plusRes.render(font2);
		minusRes.render(font2);
		volButton.render(font2);
		resButton.render(font2);
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		backb.update(input, sbg);
		fullb.update(input, sbg);
		plusVol.update(input, sbg);
		minusVol.update(input, sbg);
		plusRes.update(input, sbg);
		minusRes.update(input, sbg);
		volButton.update(input, sbg);
		resButton.update(input, sbg);
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(0);
		}
	}


	public int getID() {
		return 2;
	}

}
