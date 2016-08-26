package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
//import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Button{
	public int x;
	public int y;
	public String ButtonName;
//	public Rectangle rect;
	public String text;
	public Color col = new Color(0,0,0,200);
	public int tc = 0;
	public TrueTypeFont font;
	public Rectangle rect;
	Input input;
	public boolean mousedown;
	public boolean hover;
	public boolean playSound;
	public int posx;
	public int posy;
	public Point mouse;
	public boolean isPlaying;
	
	public Button(String ButtonName, int x, int y, String text,TrueTypeFont font, boolean hover, boolean playSound){
		this.ButtonName = ButtonName;
		this.x = x;
		this.y = y;
		this.text = text;
		this.font = font;
		this.hover = hover;
		this.playSound = playSound;
		this.rect = this.getBounds(x, y, text, font);
	}
	
	public Rectangle getBounds(int x, int y, String text, TrueTypeFont font){
//		this.x = x;
//		this.y = y;
//		this.text = text;
//		this.font = font;
		rect = new Rectangle(x,y, font.getWidth(text),font.getHeight());
		return rect;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		System.out.println("test");
		
	}

	public void render(TrueTypeFont font) throws SlickException {
//		if(text=="BACK"){
//			tc=255;
//			font.drawString(x, y, text, col);
//		}else{
//			tc=0;
//			font.drawString(x, y, text, col);
//		}
//		g.setColor(col);
		font.drawString(x, y, text, col);
		
	}


	public void update(Input input, StateBasedGame sbg) throws SlickException {
		posx = Mouse.getX();
		posy = -Mouse.getY()+Game.height;
		mouse = new Point(posx, posy);
		
		if(sbg.getCurrentState().getID()==2||sbg.getCurrentState().getID()==1){
			tc = 255;
		}else{
//			System.out.println(sbg.getCurrentStateID());
			tc = 0;
		}
		col = new Color(tc,tc,tc,200);
		if(rect.contains(mouse)){
			if(!isPlaying&&playSound){
				Menu.sound.play();	
				isPlaying = true;
			}
		}else{
			isPlaying = false;
		}
		
		if(hover){	
			if(rect.contains(mouse)){
//				col.a = (1F/255)*50;
				col = new Color(tc,tc,tc,50);
//				System.out.println(col);
				if(input.isMouseButtonDown(0)){
					col = new Color(tc, tc, tc, 15);
					mousedown = true;	
					}
					if(mousedown && !input.isMouseButtonDown(0)){
						ButtonFunction.function(ButtonName, sbg);
						mousedown = false;
					}
			}else{
				mousedown = false;
				col =  new Color(tc, tc, tc, 200);
			}
		}
	
	}
	public void setText(String text){
		this.text = text;
	}
	public String getText(){
		return text;
	}
	public String getName(){
		return ButtonName;
	}
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	public TrueTypeFont getFont(){
		return font;
	}
	public void setFont(TrueTypeFont font){
		this.font = font;
	}
	public boolean getHover(){
		return hover;
	}
	public void setHover(boolean hover){
		this.hover = hover;
	}
	public boolean getSound(){
		return playSound;
	}
	public void setSound(boolean playSound){
		this.playSound = playSound;
	}
	
//	public int getID() {
//		return 0;
//	}
}
