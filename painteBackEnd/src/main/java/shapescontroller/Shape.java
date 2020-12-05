package shapescontroller;

public class Shape {
	
    public double x;
    public double y;
    public double x1;
    public double y1;
    public String color;
    public String lineThickness;
	public int id;
	public String shapeType;
	public boolean filled ;
	
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public Shape(int id,double x, double y, double x1, double y1, String color, String lineThickness,String shapeType,boolean filled) {
		super();
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.color = color;
		this.lineThickness = lineThickness;
		this.id=id;
		this.shapeType=shapeType;
		this.filled=filled;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getY1() {
		return y1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public String getLineThickness() {
		return lineThickness;
	}
	///////////////////////////////////////////////////////////////////////////
	public void setLineThickness(String lineThickness) {
		this.lineThickness = lineThickness;
		//
		// staksteps.push  new shape (this.x,this.y)
		 // search for shape which inciude the given point from frontend to edit it then in stack of shapes 
		 
	}
	
	///////////////////////////////////////////////////////////////////////
	
	public  boolean isInclude(double a,double b) 
	{return false;}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	public Shape copy(double x2,double y2,int idNew,double a,double b) {
		Shape copied;
		double distanceX = Math.abs(x2-a);
		double distanceY = Math.abs(y2-b);
		double xx=x+distanceX;
		double xx1=x1+distanceX;
		double yy=y+distanceY;
		double yy1=y1+distanceY;
		
		if(a>x2) {
			//we should move left
			xx=x-distanceX;
			xx1=x1-distanceX;
		}
		if(b>y2){//we should move left
			yy=y-distanceY;
			yy1=y1-distanceY;
		}
		ShapesFactory factory = new ShapesFactory() ;
		copied= factory.getShape(idNew,shapeType,xx, yy, xx1, yy1, color, lineThickness,filled);
				
		return copied;
	}

}