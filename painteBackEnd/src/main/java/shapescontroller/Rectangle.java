package shapescontroller;

public class Rectangle extends Shape{
	
	double xMax;
	double xMin;
	double yMax;
	double yMin;

	public Rectangle(int id, double x, double y, double x1, double y1, String color, String lineThickness,
			String shapeType ,boolean filled) {
		super(id, x, y, x1, y1, color, lineThickness, shapeType,filled);
		// TODO Auto-generated constructor stub
	}

	public boolean isInclude(double a ,double b) {
		if(x<x1) {
			xMin=x;
			xMax=x1;
			}else {
				xMin=x1;
				xMax=x;}
		if(y<y1) {
			yMin=y;
			yMax=y1;
		}else {
			yMin=y1;
			yMax=y;}
		if(xMin<=a&&xMax>=a&&yMin<=b&&yMax>=b) {
			return true;
		}else {
			return false;
		}
	}

	
	

}