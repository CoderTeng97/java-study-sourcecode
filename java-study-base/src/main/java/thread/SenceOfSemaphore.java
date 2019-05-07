package thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 多线程业务场景1
 * 场景：假如现在有n个人去售票厅买票，但是窗口只有2个，那么同时能够买票
 * 的只能有2两个人，当2个人中任意一个买好票离开之后，等待的n-2个
 * 人中又会有一个人可以占用窗口买票。
 * 实际含义：怎么控制同一时间的并发数为2
 * 实现方案：Semaphore信号量（控制并发线程数）
 */
public class SenceOfSemaphore {

    /**
     * 购票
     */
    class BuyTicket implements Runnable{
        //信号量
        private Semaphore semaphore;
        //用户
        private int  user = 0;



        public BuyTicket(Semaphore semaphore, int user) {
            super();
            this.semaphore = semaphore;
            this.user = user;
        }


        public void run() {
            // TODO Auto-generated method stub

            try {
                //获取信号量凭证
                semaphore.acquire();
                System.out.println( "【"+ user+"】用户开始买票");
                Thread.sleep(1000);
                System.out.println( "【"+ user+"】用户购票中");
                Thread.sleep(1000);
                System.out.println( "【"+ user+"】用户离开售票处");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                //释放信号量
                semaphore.release();
            }

        }

    }


    /**
     * 售票大厅
     */
    public void hall(){
        //开辟两个售票窗口
        Semaphore semaphore = new Semaphore(2);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for(int i=1 ;i<=10;i++){
            threadPool.execute(new BuyTicket(semaphore,i));
        }
    }

    public static void main(String[] args) {
        SenceOfSemaphore sc = new SenceOfSemaphore();
        sc.hall();

    }

}