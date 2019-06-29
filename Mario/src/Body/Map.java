package Body;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Map {
	public  MapAttribute a;
	public static ArrayList<MapAttribute> maplist = new ArrayList<MapAttribute>();
	public int [][] map = {
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//1
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//2
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//3
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//4
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//5
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//6	
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//7	
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//8
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//9
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//10
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//11
		{0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},//12
		{0,0,0,0,2,0,0,0,0,0,0,1,0,1,1},//13
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//14
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
					a = new MapAttribute(i*50, j*50, 50, 50, new ImageIcon("Images/brick.jpg").getImage());
					maplist.add(a);
				}else if(map[i][j] == 2) {
					a = new MapAttribute(i*50, j*50, 30, 35, new ImageIcon("Images/coin.png").getImage());
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
