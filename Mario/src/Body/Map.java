package Body;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Map {
	public Image icon=null;
	public int x=0, y=0;
	public int width=0, height=0;
	public static ArrayList<MapAttribute> maplist = new ArrayList<MapAttribute>();//构建一个地图组件类属性的结构表
	public int [][] map = {
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//1
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//2
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//3
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//4
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//5
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//6	
		{0,0,0,0,0,0,0,0,0,0,1,0,0,1,1},//7	
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//8
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//9
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//10
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//11
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//12
		{0,0,0,0,2,0,0,0,0,0,1,0,0,1,1},//13
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},//14
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//15
		{0,0,0,0,0,0,0,2,0,0,0,0,0,0,0},//16
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//17
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//18
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//19
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//20
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//21
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//22
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//23
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//24
	};
	public void read() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {//砖块
					x=i*50;
					y=j*50;
					icon = new ImageIcon("Images/brick.jpg").getImage();
					width = icon.getWidth(null);
					height = icon.getHeight(null);
					MapAttribute a = new MapAttribute(x, y, width, height, icon);
					maplist.add(a);
				}else if(map[i][j] == 2) {	
					x=i*50;
					y=j*50;
					icon = new ImageIcon("Images/coin.png").getImage();
					width = icon.getWidth(null);
					height = icon.getHeight(null);
					MapAttribute a = new MapAttribute(x, y, width, height, icon);
					maplist.add(a);
				}
			}
		}
/*		for (int k = 0; k<maplist.size();k++) {
			MapAttribute a = maplist.get(k);
			System.out.println(a.icon+" "+a.x+" "+a.y+"  "+a.width+" "+a.height);
		}
		System.out.println(maplist.size());*/
	}
}
