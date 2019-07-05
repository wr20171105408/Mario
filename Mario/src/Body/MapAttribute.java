package Body;
//这是地图组件的属性类
import java.awt.Image;

public class MapAttribute {
	public Image icon;
	public int x, y;
	public int width, height;
	public MapAttribute(int x, int y, int width, int height, Image icon) {
		this.icon = icon;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
