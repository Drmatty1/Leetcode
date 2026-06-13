class Foo {
    // volatile int turn = 0;
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        
        printFirst.run();
        // turn = 1;
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.

        // while(turn != 1);
        s2.acquire();
        printSecond.run();
        // turn = 2;
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.

        // while(turn != 2);
        s3.acquire();
        printThird.run();

    }
}