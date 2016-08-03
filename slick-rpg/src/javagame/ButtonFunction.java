package javagame;

import org.lwjgl.openal.AL;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ButtonFunction {
	public static String Resolution;
	public static void function(String text, StateBasedGame sbg) throws SlickException {
		switch (text){
			case "EXIT":
					Menu.sound.stop();
					AL.destroy();
					Game.appgc.destroy();
					System.exit(1);
					break;
			case "PLAY":
					sbg.enterState(1);
					break;
			case "OPTIONS":
					sbg.enterState(2);
					break;
			case "BACK":
					sbg.enterState(0);
					break;
			case "WINDOWED":
					Game.settings(false, Game.width, Game.height);
					Options.fullb.setText("FULLSCREEN");
					break;
			case "FULLSCREEN":
					Game.settings(true, Game.width, Game.height);
					Options.fullb.setText("WINDOWED");
					break;	
			case "-Vol":
					Menu.sound.play();
					if(Options.volume>0){
//						System.out.println(Game.appgc.getSoundVolume());
						Options.volume--;
						Options.volButton.setText(""+Options.volume);
						Game.settings(Options.volume);
					}
					break;
			case "+Vol":
					Menu.sound.play();
					if(Options.volume<10){
//						System.out.println(Game.appgc.getSoundVolume());
						Options.volume++;
						Options.volButton.setText(""+Options.volume);
						Game.settings(Options.volume);
					}
					break;
			case "+Res":
				if(Options.activeRes<Options.resolutions.length){
					Options.activeRes++;
					Options.resButton.setText(""+Options.resolutions[Options.activeRes]);
					Resolution = Options.resolutions[Options.activeRes];
					Game.width = Integer.valueOf(Resolution.split("x")[0]);
					Game.height = Integer.valueOf(Resolution.split("x")[1]);
					Menu.updateButtons = true;
					Options.updateButton = true;
					Game.settings(Game.appgc.isFullscreen(), Integer.valueOf(Resolution.split("x")[0]), Integer.valueOf(Resolution.split("x")[1]));
				}
				break;
			case "-Res":
				if(Options.activeRes>0){
					Options.activeRes--;
					Options.resButton.setText(""+Options.resolutions[Options.activeRes]);
					Resolution = Options.resolutions[Options.activeRes];
					Game.width = Integer.valueOf(Resolution.split("x")[0]);
					Game.height = Integer.valueOf(Resolution.split("x")[1]);
					Menu.updateButtons = true;
					Options.updateButton = true;
					Game.settings(Game.appgc.isFullscreen(), Integer.valueOf(Resolution.split("x")[0]), Integer.valueOf(Resolution.split("x")[1]));
				}
				break;
		}
	}
	
}
