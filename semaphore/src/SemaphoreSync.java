/**
 * 
 * Groups must populate the stubs below in order to implement 
 * the 3 phases of the requirements for this class
 * Note that no other public methods or objects are allow.
 * 
 * Private methods and objects may be used
 * 
 */
import java.util.concurrent.Semaphore;

//the argument group ID is only used in Phase 2 and 3
//if you want at most 4 threads to be able to enter a section, you could protect it with a semaphore
//and initialise that semaphore to 4

public class SemaphoreSync implements Synchronisable {
	
	Phase phase;
	
	// Constructor 
	SemaphoreSync (Phase p){ 
		this.phase = p; // Phase of testing being performed
		
	}

	@Override
	//Phase 1
	public void waitForThreads() {
		Semaphore s = new Semaphore(4);
		try {
			s.acquire();
		} catch (InterruptedException e) {};
		
		s.release();
		
		
		
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
