package javagame;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class Play extends BasicGameState{
	TrueTypeFont font;
	TrueTypeFont font2;
	TrueTypeFont title;
	Input input;
	public static Button atkb;
	
	public Play(int state){
	}

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
		
		atkb = new Button(Game.width/2-font2.getWidth("Attack")/2, Game.height/2-font2.getHeight()/2, "Attack", font2, true, false);
	}
	

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		atkb.render(font2);
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		atkb.update(input, sbg);
	}
	
	public int getID() {
		return 1;
	}

}
