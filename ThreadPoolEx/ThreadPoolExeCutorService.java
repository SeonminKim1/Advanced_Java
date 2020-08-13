// ������ Ǯ ExeCutorService
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
 
// http://palpit.tistory.com/732

public class ThreadPoolExeCutorService {
	public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // ���� �����带 ȿ�������� �����ϱ� ������. 
    	// ���ڱ� ������ ���ڰ� ���������� �����ص� �������� �ڿ����� ���������� ��ϱ� ����. 
        
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
 
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[�� ������ ����: " + poolSize + "] �۾� ������ �̸�: " + threadName);
 
                    int value = Integer.parseInt("����");
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

// threadPool ���� --------------------------
// threadPool = Executors.newFixedThreadPool();
// newCachedThreadPool()�� �ʱ� ������ ���� 0 �ھ� ������ ���� 0 
// newFixedThreadPool()�� �ʱ� ������ ���� 0 �ھ� ������ ���� nThreads - ������ �� ����ǵ� �ּ����� ������ ��������.
// threadPool�� main�� ������ ���������� shutdown()���� �����ؾ���.
// Runnable -> run() �̳� Callable -> call() ���ؼ� ����.

// submit�� execute�� ���� ----------------------------------------
// threadPool.submit(thread); // Runnable �Ǵ� Callable�� �۾� ť�� ����.
// threadPool.execute(Runnable thread); // �۾�ó���� ���� �߻��� ������ ���� �� ���� �� ���� ����
// thread.submit(Runnable thread) // �۾�ó���� ���� �߻��� ������ ����ȵǰ� �ٷ� �����۾��� ����.

