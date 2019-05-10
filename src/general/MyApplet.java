package general;import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.*;


/*<applet code="MyApplet" width="600" height="600"></applet>*/
public class MyApplet extends Applet{
public void paint(Graphics g){
	int x1=10;
	int y1=100;
	int x2=150;
	int y2=50;
	g.drawLine(x1, y1, x2, y2);
	g.draw3DRect(15, 15,30, 30, true);
	g.setColor(Color.CYAN);
	g.fill3DRect(15, 15, 30, 30, true);
	
}
	
}