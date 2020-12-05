package shapescontroller;

public class States  {
	//singleton class that holds three stacks that saves the operations and they will be full of data from the factory of shapes
		private  StackMethods stackShaps = new StackMethods();
		private  StackMethods redoStack = new StackMethods();
		private  StackMethods stepsStack= new StackMethods();
		private static  States statesInstance;
		
		//the singleton consept
		private  States() {
			
		}
		
	
		public static States getInstance() {
			if(statesInstance==null) {
				synchronized (States.class) {
					if(statesInstance==null) {
						statesInstance=new States();
					}
				}
			}
			return statesInstance;
		}
		
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	 //getters for the three stacks to be called in the factory 
	public StackMethods getStackShaps() {
		return stackShaps;
	}
	
	public StackMethods getRedoStack() {
		return redoStack;
	}
	
	public StackMethods getStepsStack() {
		return stepsStack;
	}

	// function to convert stake to Array 
	
	public  Object[][] convertStackToArray(StackMethods given) {
		//converts stack of shapes to array of objects to be sent to front end
		Object[][] arr= new Object[stackShaps.size()][9];
		//a copy from the stack given to pop from it 
		StackMethods s = new StackMethods();
		//int id,float x, float y, float x1, float y1, String color, String lineThickness
		int i=0;
		while(given.isEmpty()==false) {
			arr[i][0]=((Shape)given.peek()).id;
			arr[i][1]=((Shape)given.peek()).x;
			arr[i][2]=((Shape)given.peek()).y;
			arr[i][3]=((Shape)given.peek()).x1;
			arr[i][4]=((Shape)given.peek()).y1;
			arr[i][5]=((Shape)given.peek()).color;
			arr[i][6]=((Shape)given.peek()).lineThickness;
			arr[i][7]=((Shape)given.peek()).shapeType;
			arr[i][8]=((Shape)given.peek()).filled;
			i++;
			s.push(given.pop());
		}
		while(s.isEmpty()==false) {
			given.push(s.pop());
		}
		return arr;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	//function to send the stack of shapes as array of points to the front end 
	public Object[][] sendStackOfShapesToFrontEnd() {
		return this.convertStackToArray(stackShaps);
	}
	///////////////////////////////////////////////////////////////////////
	//search stack of shapes and return all the shapes include this point 
	public  StackMethods getIncluded(double a,double b){
		//loop in stack shapes and search then return included shapes

		StackMethods s=new StackMethods();
		
		StackMethods included=new StackMethods();
		while(stackShaps.isEmpty()==false) {
			if(((Shape)stackShaps.peek()).isInclude(a,b)) {
				included.push(stackShaps.peek());
			}
			s.push(stackShaps.pop());
		}
		while(s.isEmpty()==false) {
			stackShaps.push(s.pop());
		}

		return included;
	}

	public Object[]ConvertStackStepsTo1DArray(StackMethods stepsStackkk) {
		Object[]arr=new Object[stepsStackkk.size()];
		StackMethods tmp=new StackMethods();
		StackMethods.copy(stepsStackkk, tmp);int i=0;//the array is the same order of stack from last to first
		while(i<arr.length) {
			arr[i]=tmp.pop();
			i++;
		}
		return arr;
	}

	public StackMethods ConvertArr1DToStackSteps(Object []arr) {
		StackMethods tmp=new StackMethods();
		int i=arr.length-1;//the array is the same order of stack from last to first
		while(i>=0) {
			tmp.push((Shape)arr[i]);
			i--;
		}
		StackMethods.copy(tmp, stepsStack);
		return tmp;
	}

	public StackMethods ConvertArr2DToStackShapes(Object[][]arr) {///////////needs modification
		int i=arr.length-1;
		StackMethods tmp=new StackMethods();
		int id;double x,y,x1,y1;String color;String lineThickness;boolean filled;String shapeType;
		while(i>=0) {
			Shape shape;
			id=Integer.parseInt(arr[i][0].toString());
			x=Double.parseDouble(arr[i][1].toString());
			y=Double.parseDouble(arr[i][2].toString());
			x1=Double.parseDouble(arr[i][3].toString());
			y1=Double.parseDouble(arr[i][4].toString());
			color=arr[i][5].toString();
			lineThickness=arr[i][6].toString();
			shapeType=arr[i][7].toString();
			filled=Boolean.parseBoolean(arr[i][8].toString());
			shape=new Shape(id, x, y, x1, y1, color, lineThickness, shapeType, filled);
			tmp.push(shape);
			i--;
		}
		StackMethods.copy(tmp, stackShaps);
		return tmp;
	}

	}