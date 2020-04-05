
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.EnumMap;

/**
 * @author mikec
 * 
 * Example JUnit test for class ExtrinsicSync
 * 
 *  Hello this is a smple comment
 *
 */


class TestTask1 implements Runnable{
	//This is an example task (implementation of Runnable) 
	//that is used by the JUnit test below
	//Note that you can extend this to other phases 
	//OR implement separate test tasks for each of the phases.
	
	final int group; //Used only Phase TWO and THREE 
	final ExtrinsicSync s1;  
	final Phase phase;
     
    TestTask1(int group, ExtrinsicSync s1, Phase p){ 
    	this.group = group; //Used only Phase TWO and THREE 
    	this.s1 = s1;
    	this.phase = p;
    };
    
    //The task:		      
    public void run() { 
    	//String threadName = Thread.currentThread().getName();
    	//System.out.println(threadName + " started, grp = " + group + ", phase: " + this.phase);
    	switch (this.phase) {
	    	case ONE:
	    		//System.out.println(threadName + ", phase: " + this.phase + "Calling waitForThreads");
	    		s1.waitForThreads();
	    	break;
	    	case TWO:
	    		//System.out.println(threadName + ", grp = " + group + ", phase: " + this.phase + "Calling waitForThreadsInGroup");
	    		//Your code here
	    	break;    	
	    	case THREE:
	    		//System.out.println(threadName + ", PHASE 3, grp = " + group + ", phase: " + this.phase + "Calling waitForThreadsInGroup");
	    		//Your code here
	    	break;
    	}
    } 
} 

class ExtrinsicSyncTest2 {
	//This just contains one test: a 3 thread test of Phase ONE
	//You need to add further tests for Phase ONE and the other phases
	
	@Test
	void testPhaseOne3threads() {
		final Phase phase = Phase.ONE;
		//Kick off 3 threads 
		//thus all 3 should block WAITING
		
		final int nThreads = 3;	
		final Thread t[] = new Thread[nThreads];		
		final ExtrinsicSync s1 = new ExtrinsicSync(phase);
	
		for (int i=0; i<nThreads; i++) {
			(t[i] = new Thread(new TestTask1(0, s1, phase))).start();
		}
		for (Thread ti : t) {
			try {ti.join(100);} catch (Exception e) {System.out.println(e);}
		}	
		
		EnumMap<Thread.State, Integer> threadsInThisState = new EnumMap<>(Thread.State.class);
		for (Thread.State s:Thread.State.values()) {threadsInThisState.put(s, 0);}
		for (Thread ti : t) {
			Thread.State state = ti.getState();
			int n = threadsInThisState.get(state);
			threadsInThisState.put(state, n+1);
		}
		System.out.println("testWaitForGroup0: threadsInThisState: " + threadsInThisState.toString() );
		assertEquals(0, threadsInThisState.get(Thread.State.NEW),"Threads NEW");
		assertEquals(0, threadsInThisState.get(Thread.State.RUNNABLE),"Threads RUNNABLE");
		assertEquals(0, threadsInThisState.get(Thread.State.BLOCKED),"Threads BLOCKED");
		assertEquals(3, threadsInThisState.get(Thread.State.WAITING),"Threads WAITING");
		assertEquals(0, threadsInThisState.get(Thread.State.TIMED_WAITING),"Threads TIMED_WAITING");
		assertEquals(0, threadsInThisState.get(Thread.State.TERMINATED),"Threads TERMINATED");
	}
	
}


