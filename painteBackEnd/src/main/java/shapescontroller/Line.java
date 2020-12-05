package shapescontroller;

public class Line extends Shape{

	double xMax;
	double xMin;
	double yMax;
	double yMin;
	
	public Line(int id, double x, double y, double x1, double y1, String color, String lineThickness, String shapeType,boolean filled ) {
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
			double m = Math.abs((x1-a)*(x1-x)+(y1-b)*(y1-y));
			double n = Math.sqrt(Math.pow((x1-a), 2)+Math.pow((y1-b), 2));
			double p = Math.sqrt(Math.pow((x1-x), 2)+Math.pow((y1-y), 2));

			double c = m/(n*p);

			double per = Math.sqrt(Math.pow(n, 2)-Math.pow((n*c), 2));

			if(per<100){
				return true;
			}
			else{
				return false;
			}
			
		}else {
			return false;
		}
	}

}
