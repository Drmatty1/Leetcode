class Foo {
    volatile int turn = 0;
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        turn = 0;
        printFirst.run();
        turn = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(turn != 1);
        printSecond.run();
        turn = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(turn != 2);
        printThird.run();

    }
}