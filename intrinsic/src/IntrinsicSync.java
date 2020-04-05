
/**
 * 
 * Groups must populate the stubs below in order to implement 
 * the 3 phases of the requirements for this class
 * Note that no other public methods or objects are allow.
 * 
 * Private methods and objects may be used
 * 
 */

/**
 * This implementation must make use of the synchronized keyword, 
 * together with the java.lang.Object  methods .wait() 
 * and .notifyAll(). 
 * note that .notify() may also be used as an alternative 
 * to .notifyAll(). 
 * No classes can be used from the java concurrent package 
 * (java.util.concurrent).
 * * 
 * 
 */


public class IntrinsicSync implements Synchronisable {

	Phase phase; 

	// Constructor 
	IntrinsicSync (Phase p){ 
		this.phase = p; // Phase of testing being performed
	}

	@Override
	public void waitForThreads() {
		// TODO Auto-generated method stub

	}
	@Override
	public void waitForThreadsInGroup(int groupId) {
		// TODO Auto-generated method stub

	}
	@Override
	public void finished(int groupId) {
		// TODO Auto-generated method stub
	}
}
