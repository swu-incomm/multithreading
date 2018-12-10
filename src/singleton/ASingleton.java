package singleton;


//implement a singleton class through synchronize control
public class ASingleton {
	/*
	 * code with comment can't perform singleton class because multiple threads can access it at the same time.
	 * when the instance hasn't been initialized
	private static ASingleton instance = null;
	private ASingleton () {
		
	}
	public static ASingleton getInstance() {
		if(instance == null) {
			instance = new ASingleton();
		}
		return instance;
	}
	*/
	private static volatile ASingleton instance;
	private static Object mutex = new Object();
	
	//set constructor to private so that this class won't be instantialized
	private ASingleton () {
		
	}
	
	public static ASingleton getInstance() {
		ASingleton result = instance;
		if(result == null) {
			synchronized(mutex) {
				result = instance;
				//most of the time our instance is already initialized, return result instead of instance is 
				//very important in regard to volatile keyword
				if(result == null) {
					instance = result = new ASingleton();
				}
			}
		}
		return result;
		
	}
}
