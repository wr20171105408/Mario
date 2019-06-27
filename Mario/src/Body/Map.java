package Body;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Map {
	public  Image icon = new ImageIcon("Images/brick.jpg").getImage();
	public static ArrayList<Integer> mapxlist = new  ArrayList<Integer>();//记录地图组件的坐标
	public static ArrayList<Integer> mapylist = new  ArrayList<Integer>();//记录地图组件的坐标
	public int bwidth=50,bheight=50;
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
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//12
		{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},//13
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//14
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//15
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//16
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
				if (map[i][j] == 1) {
					mapxlist.add(i*bwidth);
					mapylist.add(j*bheight);
					icon=new ImageIcon("Images/brick.jpg").getImage();// 绘制地图组件
				}else if(map[i][j] == 0) {
					icon=null;
				}
			}
		}
		for(int k =0;k<mapylist.size();k++) {
			System.out.println(mapylist.get(k));
		}
	}
	public ArrayList<Integer> getMapxlist() {
		return this.mapxlist;
	}
	public void setMapxlist(ArrayList<Integer> mapxlist) {
		this.mapxlist = mapxlist;
	}
	public ArrayList<Integer> getMapylist() {
		return this.mapylist;
	}
	public void setMapylist(ArrayList<Integer> mapylist) {
		this.mapylist = mapylist;
	}
}
