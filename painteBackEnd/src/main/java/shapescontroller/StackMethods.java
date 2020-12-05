package shapescontroller;


class SNode{
	Object data;
	SNode next;
}
class LinkedList{
	SNode head;
	SNode tail;
	int size=0;
}
public class StackMethods implements Cloneable{
	LinkedList s=new LinkedList();
	public Object pop() {
		if(s.size==1) {
			SNode h=s.head;
			s.head=s.tail=null;
			s.size--;
			return h.data;
		}
		else if(s.size==2) {
			SNode tmp=s.head.next;
			s.head.next=null;
			s.tail=s.head;
			s.size--;
			return tmp.data;
		}
		else if(s.size>2) {
		SNode h=s.head;
		SNode tmp=new SNode();
		while(h.next.next!=null) {
			h=h.next;
		}
		tmp.data=h.next.data;
		tmp.next=null;
		h.next=null;
		s.tail=h;
		s.size--;
		return tmp.data;
		}
		else{
			throw new RuntimeException("The Stack is empty (pop)");
		}
		
	}
	
	
	public Object peek() {
		if(s.size>0) {
		return s.tail.data;
		}
		else {
			throw new RuntimeException("The Stack is empty (peek)");
		}
	}
	
	
	public void push(Object element) {
		//Add last
		SNode tmp=new SNode();
		tmp.data=element;
		tmp.next=null;
		if(s.size==0) {
			//add at head
			s.head=tmp;
			s.tail=s.head;
			s.size++;
		}
		else {
			SNode h=s.head;
			while(h.next!=null) {
				h=h.next;
			}
			h.next=tmp;
			s.tail=tmp;
			s.size++;
		}
	}
	
	
	
	
	
	public static StackMethods getNumberOfOcuurencesOfElementID(StackMethods st,int id) {
		Shape x= (Shape)st.peek();
		if(st.isEmpty()||st.equals(null)) {
			return null;
		}else {
			StackMethods tmp=st;
			StackMethods tmp2=new StackMethods();
			StackMethods occ=new StackMethods();
			while(tmp.isEmpty()==false) {
				if(id==((Shape)(tmp.peek())).id) {
				occ.push(tmp.peek());
				tmp2.push(tmp.pop());
				}else {
					tmp2.push(tmp.pop());
				}
			}
			while(tmp2.isEmpty()==false) {
				tmp.push(tmp2.pop());
			}st=tmp2;
			StackMethods s=new StackMethods();
			occ=s.ReverseStack(occ);
			return occ;
		}
	}
	
	public static StackMethods ReverseStack(StackMethods st) {
		StackMethods tmp =new StackMethods();
		while(st.isEmpty()==false) {
			tmp.push(st.pop());
		}
		st=tmp;return tmp;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	public  StackMethods getNumberOfOcuurencesOfLastElementID(StackMethods st) {
		Shape x= (Shape)st.peek();
		if(st.isEmpty()||st==null) {
			return null;
		}else {
			StackMethods tmp=st;
			StackMethods tmp2=new StackMethods();
			StackMethods occ=new StackMethods();
			StackMethods occ2=new StackMethods();
			while(tmp.isEmpty()==false) {
				if(x.id==((Shape)(tmp.peek())).id) {
				occ.push(tmp.peek());
				tmp2.push(tmp.pop());
				}else {
					tmp2.push(tmp.pop());
				}
			}
			while(tmp2.isEmpty()==false) {
				tmp.push(tmp2.pop());st=tmp;
			}
			/*while(occ.isEmpty()==false) {
				occ2.push(occ.pop());st=tmp;
			}*/
			return occ;
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	public StackMethods GetShapeById(StackMethods shapes,int id,Shape ModifiedShape) {
		System.out.println("size of the given stack from the other method ");
		System.out.println(shapes.size());
		
		StackMethods sh1=new StackMethods();
		while(shapes.isEmpty()==false) {
			if(((Shape)shapes.peek()).id==id) {
				//we got shape with this id 
				sh1.push(ModifiedShape);
				shapes.pop();
			}else {
			sh1.push(shapes.pop());
			}
		}
		//the elements are revered in the stack
		//so return them again in shapes stack
		while(sh1.isEmpty()==false) {
			shapes.push(sh1.pop());
		}
       System.out.println("size of stack from the other method");
       System.out.println(shapes.size());
		return shapes;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	public StackMethods DelShapeById(StackMethods shapes,int id) {
		StackMethods sh1=new StackMethods();
		while(shapes.isEmpty()==false) {
			if(((Shape)shapes.peek()).id==id) {
				//we got shape with this id 
				//we willnot add it in this stack
				shapes.pop();
			}else {
			sh1.push(shapes.pop());
			}
		}
		//the elements are revered in the stack
		//so return them again in shapes stack
		while(sh1.isEmpty()==false) {
			shapes.push(sh1.pop());
		}
		return shapes;
	}
	////////////////////////////////////////////////////////////////////////////////
	public boolean isEmpty() {
		if(s.size==0||s.head==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public int size() {
		return s.size;
	}

	public static StackMethods copy(StackMethods s1,StackMethods tmp2) {
		StackMethods tmp=new StackMethods();
		while(tmp2.isEmpty()==false) {
			tmp2.pop();
		}
		while(s1.isEmpty()==false) {
			tmp.push(s1.pop());
		}
		while(tmp.isEmpty()==false) {
			s1.push(tmp.peek());
			tmp2.push(tmp.peek());
			tmp.pop();
		}
		return tmp2;
	}
	/////////////////////////////////////////////////////////////
	/*public StackMethod copyOfStack (StackMethod given) {
		StackMethod copied1 = new StackMethod();
		StackMethod copied2 = new StackMethod();
		while(given.isEmpty()==false) {
			copied1.push(given.pop());
		}
		while(copied1.isEmpty()==false) {
			copied2.push(copied1.pop());
		}
		
	}*/
	
}
