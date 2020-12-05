package shapescontroller;

public class Square extends Shape {
	
	double xMax;
	double xMin;
	double yMax;
	double yMin;
	double requiredY;

	public Square(int id, double x, double y, double x1, double y1, String color, String lineThickness, String shapeType,boolean filled) {
		super(id, x, y, x1, y1, color, lineThickness, shapeType,filled);
		// TODO Auto-generated constructor stub
	}

	public boolean isInclude (double a , double b) {
		double l = x1-x ;
		double t1 = x1-x;
		double t2 = y1-y;
		double w;
		 
		if((t1*t2)<0) {
			w=-l;
		}else {
			w=l;
		}
		requiredY= y+w;
		
		if(x<x1) {
			xMin=x;
			xMax=x1;
			}else {
				xMin=x1;
				xMax=x;}
		if(y<requiredY) {
			yMin=y;
			yMax=requiredY;
		}else {
			yMin=requiredY;
			yMax=y;}
		if(xMin<=a&&xMax>=a&&yMin<=b&&yMax>=b) {
			return true;
		}else {
			return false;
		}
	}

	

}