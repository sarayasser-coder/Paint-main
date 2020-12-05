package shapescontroller;

public class Circle extends Shape {
	
	double radius ;
	
	

	public Circle(int id, double x, double y, double x1, double y1, String color, String lineThickness, String shapeType,boolean filled) {
		super(id, x, y, x1, y1, color, lineThickness, shapeType,filled);
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isInclude(double a ,double b) {
		radius = Math.sqrt( Math.pow((x-x1),2) + Math.pow((y-y1),2));
		double d = Math.sqrt( Math.pow((x-a),2) + Math.pow((y-b),2));
		if(d<radius) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

}
