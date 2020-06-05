### 问：synchronized关键字的作用？

**参考答案：**

synchronized关键字解决的是多个线程之间访问资源的同步性，synchronized关键字可以保证被它修饰的方法或者代码块在任意时刻只能有一个线程执行。

另外，在 Java 早期版本中，synchronized属于重量级锁，效率低下，因为监视器锁（monitor）是依赖于底层的操作系统的 Mutex Lock 来实现的，Java 的线程是映射到操作系统的原生线程之上的。如果要挂起或者唤醒一个线程，都需要操作系统帮忙完成，而操作系统实现线程之间的切换时需要从用户态转换到内核态，这个状态之间的转换需要相对比较长的时间，时间成本相对较高，这也是为什么早期的 synchronized 效率低的原因。庆幸的是在 Java 6 之后 Java 官方对从 JVM 层面对synchronized 较大优化，所以现在的 synchronized 锁效率也优化得很不错了。JDK1.6对锁的实现引入了大量的优化，如自旋锁、适应性自旋锁、锁消除、锁粗化、偏向锁、轻量级锁等技术来减少锁操作的开销。



### 问：synchronized关键字如何使用？

**参考答案：**

**1、修饰实例方法:** 作用于当前对象实例加锁，进入同步代码前要获得当前对象实例的锁

**2、修饰静态方法:** :也就是给当前类加锁，会作用于类的所有对象实例，因为静态成员不属于任何一个实例对象，是类成员（ static 表明这是该类的一个静态资源，不管new了多少个对象，只有一份）。所以如果一个线程A调用一个实例对象的非静态 synchronized 方法，而线程B需要调用这个实例对象所属类的静态 synchronized 方法，是允许的，不会发生互斥现象，**因为访问静态 synchronized 方法占用的锁是当前类的锁，而访问非静态 synchronized 方法占用的锁是当前实例对象锁**。

**3、修饰代码块:** 指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。

synchronized 关键字加到 static 静态方法和 synchronized(class)代码块上都是是给 Class 类上锁。synchronized 关键字加到静态方法上是给对象实例上锁。尽量不要使用 synchronized(String a) 因为JVM中，字符串常量池具有缓存功能！

###  

### 问：synchronized 关键字的底层原理是什么？

**参考答案：**

synchronized 关键字底层原理属于 JVM 层面。

**1、synchronized 同步语句块的情况。** synchronized 同步语句块的实现使用的是 monitorenter 和 monitorexit 指令，其中 monitorenter 指令指向同步代码块的开始位置，monitorexit 指令则指明同步代码块的结束位置。 当执行 monitorenter 指令时，线程试图获取锁也就是获取 monitor(monitor对象存在于每个Java对象的对象头中，synchronized 锁便是通过这种方式获取锁的，也是为什么Java中任意对象可以作为锁的原因) 的持有权。当计数器为0则可以成功获取，获取后将锁计数器设为1也就是加1。相应的在执行 monitorexit 指令后，将锁计数器设为0，表明锁被释放。如果获取对象锁失败，那当前线程就要阻塞等待，直到锁被另外一个线程释放为止。

**2、synchronized 修饰方法的的情况。** synchronized 修饰的方法并没有 monitorenter 指令和 monitorexit 指令，取得代之的确实是 ACC_SYNCHRONIZED 标识，该标识指明了该方法是一个同步方法，JVM 通过该 ACC_SYNCHRONIZED 访问标志来辨别一个方法是否声明为同步方法，从而执行相应的同步调用。



### 问：说说 synchronized 关键字和 volatile 关键字的区别

**参考答案：**

1、volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升，实际开发中使用 synchronized 关键字的场景还是更多一些；

2、多线程访问volatile关键字不会发生阻塞，而synchronized关键字可能会发生阻塞；

3、volatile关键字能保证数据的可见性，但不能保证数据的原子性。synchronized关键字两者都能保证；           4、volatile关键字主要用于解决变量在多个线程之间的可见性，而 synchronized关键字解决的是多个线程之间访问资源的同步性。



### 问：通过N个线程顺序循环打印从0至100，如给定N=3则输出:



```
thread0: 0
thread1: 1
thread2: 2
thread0: 3
thread1: 4
```





**参考答案：**



```
static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        int N = 3;
        Thread[] threads = new Thread[N];
        final Semaphore[] syncObjects = new Semaphore[N];
        for (int i = 0; i < N; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != N-1){
                syncObjects[i].acquire();
            }
        }
        for (int i = 0; i < N; i++) {
            final Semaphore lastSemphore = i == 0 ? syncObjects[N - 1] : syncObjects[i - 1];
            final Semaphore curSemphore = syncObjects[i];
            final int index = i;
            threads[i] = new Thread(new Runnable() {

                public void run() {
                    try {
                        while (true) {
                            lastSemphore.acquire();
                            System.out.println("thread" + index + ": " + result++);
                            if (result > 100){
                                System.exit(0);
                            }
                            curSemphore.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            threads[i].start();
        }
    }
```



### 问：介绍一下AtomicInteger 类的原理

**参考答案：**

AtomicInteger 类的部分源码：



```
// setup to use Unsafe.compareAndSwapInt for updates（更新操作时提供“比较并替换”的作用）
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;
    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    private volatile int value;
```

AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。

CAS的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。UnSafe 类的 objectFieldOffset() 方法是一个本地方法，这个方法是用来拿到“原来的值”的内存地址，返回值是 valueOffset。另外 value 是一个volatile变量，在内存中可见，因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。

 备注：JUC 包中的四种原子类。

**1、基本类型，** 使用原子的方式更新基本类型

​     （1）、AtomicInteger：整形原子类；

​     （2）、AtomicLong：长整型原子类；

​     （3）、AtomicBoolean：布尔型原子类

**2、数组类型，** 使用原子的方式更新数组里的某个元素

（1）、AtomicIntegerArray：整形数组原子类

（2）、AtomicLongArray：长整形数组原子类

（3）、AtomicReferenceArray：引用类型数组原子类

**3、引用类型** 

（1）、AtomicReference：引用类型原子类

（2）、AtomicStampedReference：原子更新引用类型里的字段原子类

（3）、AtomicMarkableReference ：原子更新带有标记位的引用类型

**4、对象的属性修改类型** 

（1）、AtomicIntegerFieldUpdater：原子更新整形字段的更新器

（2）、AtomicLongFieldUpdater：原子更新长整形字段的更新器

（3）、AtomicStampedReference：原子更新带有版本号的引用类型。该类将整数值与引用关联起来，可用于解决原子的更新数据和数据的版本号，可以解决使用 CAS 进行原子更新时可能出现的 ABA 问题。



### 问：什么是线程调度器(Thread Scheduler)和时间分片(Time Slicing)？

**参考答案：**

线程调度器是一个操作系统服务，它负责为Runnable状态的线程分配CPU时间。一旦创建一个线程并启动它，它的执行便依赖于线程调度器的实现。

时间分片是指将可用的CPU时间分配给可用的Runnable线程的过程。分配CPU时间可以基于线程优先级或者线程等待的时间。

线程调度并不受到Java虚拟机控制，所以由应用程序来控制它是更好的选择。



### 问：什么是竞态条件？你怎样发现和解决竞争？

**参考答案：**    

当两个线程竞争同一资源时，如果对资源的访问顺序敏感，就称存在竞态条件。在临界区中使用适当的同步就可以避免竞态条件，实现方法有两种，一种是用synchronized，一种是用Lock显式锁实现。



### 问：你对线程优先级的理解是什么？

**参考答案：**

每一个线程都是有优先级的，一般来说，高优先级的线程在运行时会具有优先权，但这依赖于线程调度的实现，这个实现是和操作系统相关的(OSdependent)。

可以定义线程的优先级，但是这并不能保证高优先级的线程会在低优先级的线程前执行。线程优先级是一个int变量(从1-10)，1代表最低优先级，10代表最高优先级。



### 问：在多线程中，什么是上下文切换(context-switching)？

**参考答案：**

单核CPU也支持多线程执行代码，CPU通过给每个线程分配CPU时间片来实现这个机制。时间片是CPU分配给各个线程的时间，因为时间片非常短，所以CPU通过不停地切换线程执行，让我们感觉多个线程时同时执行的，时间片一般是几十毫秒（ms）。

操作系统中，CPU时间分片切换到另一个就绪的线程，则需要保存当前线程的运行的位置，同时需要加载需要恢复线程的环境信息。



### 问：用户线程和守护线程有什么区别？

**参考答案：**

守护线程都是为JVM中所有非守护线程的运行提供便利服务： 只要当前JVM实例中尚存在任何一个非守护线程没有结束，守护线程就全部工作；只有当最后一个非守护线程结束时，守护线程随着JVM一同结束工作。

两者几乎没有区别，唯一的不同之处就在于虚拟机的离开：如果用户线程已经全部退出运行了，只剩下守护线程存在了，虚拟机也就退出了。

因为没有了被守护者，守护线程也就没有工作可做了，也就没有继续运行程序的必要了。

### 问：如何创建守护线程？以及在什么场合来使用它？

**参考答案：**

任何线程都可以设置为守护线程和用户线程，通过方法Thread.setDaemon(bool on)；true则把该线程设置为守护线程，反之则为用户线程。Thread.setDaemon()必须在Thread.start()之前调用，否则运行时会抛出异常。

守护线程相当于后台管理者 比如 : 进行内存回收,垃圾清理等工作



### 问：线程中断是否能直接调用stop,为什么?

**参考答案：**

Java提供的终止方法只有一个stop,但是不建议使用此方法,因为它有以下三个问题:

1、stop方法是过时的 从Java编码规则来说,已经过时的方式不建议采用；

2、stop方法会导致代码逻辑不完整，stop方法是一种"恶意"的中断，一旦执行stop方法，即终止当前正在运行的线程，不管线程逻辑是否完整，这是非常危险的.

3、stop方法会破坏原子逻辑。多线程为了解决共享资源抢占的问题，使用了锁概念，避免资源不同步，但是正因此原因，stop方法却会带来更大的麻烦：它会丢弃所有的锁，导致原子逻辑受损。
