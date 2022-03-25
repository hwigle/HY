package generic;

//ArrayList<Integer>
public class Box<T> {
	T obj;
	
	public void setObj(T obj) {
		this.obj =obj;
	}

		public T getObj() {
			return this.obj;
		}
}
