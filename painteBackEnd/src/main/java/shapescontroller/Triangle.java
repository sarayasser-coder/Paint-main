package shapescontroller;

public class Triangle extends Shape {
	
	double c1 ;
	double c2;
	double c3;

	public Triangle(int id, double x, double y, double x1, double y1, String color, String lineThickness,
			String shapeType,boolean filled) {
		super(id, x, y, x1, y1, color, lineThickness, shapeType,filled);
		// TODO Auto-generated constructor stub
	}

	public boolean isInclude(double a , double b) {
		c1=(x1-x)*(b-y);
		c2=(-x1/2)*(b-y)-(y1-y)*(a-x1);
		c3=(x-(x1/2))*(b-y1)-(y-y1)*(a-(x1/2));
		
		if((c1<0&&c2<0&&c3<0)||(c1>0&&c2>0&&c3>0)){
			return true;
		}else {
			return false;
		}
	}
	
}
