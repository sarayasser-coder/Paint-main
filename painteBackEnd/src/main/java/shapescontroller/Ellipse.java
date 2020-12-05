package shapescontroller;

public class Ellipse extends Shape {

	public Ellipse(int id, double x, double y, double x1, double y1, String color, String lineThickness, String shapeType,boolean filled) {
		super(id, x, y, x1, y1, color, lineThickness, shapeType,filled);
		// TODO Auto-generated constructor stub
	}


	public boolean isInclude(double a ,double b){
		double rx = Math.abs(x-x1);
		double ry = Math.abs(y-y1);

		double c =(Math.pow((a-x), 2)/Math.pow(rx, 2)) + (Math.pow((b-y), 2)/Math.pow(ry, 2));

		if(c<1||c==1){
			return true;
		}
		else{
			return false;
		}
	}	

}
