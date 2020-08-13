// 스레드 풀 ExeCutorService
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
 
// http://palpit.tistory.com/732

public class ThreadPoolExeCutorService {
	public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // 여러 스레드를 효과적으로 관리하기 때문에. 
    	// 갑자기 스레드 숫자가 폭발적으로 증가해도 한정적인 자원으로 안정적으로 운영하기 위함. 
        
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
 
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
 
                    int value = Integer.parseInt("숫자");
                }
            };
 
            //executorService.execute(runnable);
            executorService.submit(runnable);
 
            try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        executorService.shutdown();
	}
}

// threadPool 종류 --------------------------
// threadPool = Executors.newFixedThreadPool();
// newCachedThreadPool()의 초기 스레드 수는 0 코어 스레드 수는 0 
// newFixedThreadPool()의 초기 스레드 수는 0 코어 스레드 수는 nThreads - 스레드 다 종료되도 최소한의 스레드 남아있음.
// threadPool은 main이 끝나도 남아있으니 shutdown()으로 종료해야함.
// Runnable -> run() 이나 Callable -> call() 통해서 구현.

// submit와 execute의 차이 ----------------------------------------
// threadPool.submit(thread); // Runnable 또는 Callable을 작업 큐에 저장.
// threadPool.execute(Runnable thread); // 작업처리중 예외 발생시 스레드 종료 후 제거 후 새로 생성
// thread.submit(Runnable thread) // 작업처리중 예외 발생시 스레드 종료안되고 바로 다음작업에 재사용.

