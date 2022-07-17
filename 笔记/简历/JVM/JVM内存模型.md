目录

- 什么是跨平台？

- - 跨平台定义
  - C语言代码能不能跨平台运行呢？
  - Java跨平台的原因

- JVM内存模型

- - 运行时数据区总览
  - 程序计数器
  - java堆（Heap）
  - 栈区
  - 方法区
  - JVM堆，栈，方法区对应模型



> ❝
>
> Java与C++之间有一堵由内存动态分配和垃圾收集技术所围成的“高墙”，墙外面的人想进去，墙里面的人想出来。
>
> ❞

## 什么是跨平台？

我之前一直在想一个问题，一直在说Java可以跨平台，但是C代码可以放到 windows 平台执行也可以放到 linux 平台里面执行，为什么不说C语言跨平台呢？

### 跨平台定义

`跨平台定义：`首先这是基于源码的跨平台。也就是说，只写一套代码，但是在各个平台如 Windows，Linux，unix 都能顺利运行，这就是跨平台。

我们知道 Java 是运行在虚拟机里面的，不管你的服务器是windows系统还是linux系统，只要在各个平台上面安装 java虚拟机，那么就可以愉快的运行Java代码，所以说Java是平台无关的语言即可跨平台。

然而 C&C++ 语言，他们是平台有关的语言，我们在 Windows 系统下面编写好了代码，运行的很快乐，但是拿到 Linux 系统运行却不一定能成功可能报错。例如一段打开文件的代码实现，我随便百度一下两个平台的代码实现如下图，分为 windows 实现和 linux 实现，也就是说C语言平台有关，不能跨平台运行。

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGn0tniccOpmvPlSz0iayM0DCO6Fuick8L5S0yeU2tq0wcJswCoMia6GRbksQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />C++代码打开文件系统

### C语言代码能不能跨平台运行呢？

当然可以了，有两种方法可以让C程序代码实现跨平台运行，

1. 写好兼容代码。

只要你在代码里面写好兼容代码，同时写一套 windows 的实现，再写一套 linux 的实现，那么这套代码就可以同时在 windows 和 linux 系统下执行。假如一个打开文件的操作在windows和linux里面的实现不一样，伪代码如下：

```
if (当前系统 == windows){
  open1 file ;
} else if (当前系统 == linux) {
  open2 file ;
} else {
  open3 file ;
}
```

可以想象，如果你是要实现一个大的工程有很多代码，你得写多少兼容代码，而且测试的时候还需要同时放到两个平台去测试，这是多么的夸张，使得程序员原本就不茂密的头发更加雪上添霜。

1. 移植编译器

因为支持C++语言的各个平台的架构不同（比如CPU能够处理的指令集不一样），所以一份C++源代码要想在另一个操作系统平台上执行，就必须用该平台相对应的C++代码编译器对C++源代码重新进行编译，生成该平台可以直接执行的机器代码。

它的执行过程是：预处理->编译->汇编->链接->机器码

可以看到编译器是关键，再拿C语言为例，Linux下直接使用 gcc编译器 编译C程序，在Windows下使用对应的 mingw 编译C程序，这样用两套不同的编译器来在不同的平台进行编译，不同的编译器都是封装了各自平台对C语言的处理，但是这样也很麻烦啊，所以Java虚拟机的价值就更加突显了。

### Java跨平台的原因

Java虚拟机定义了一种Java内存模型（Java memory model, JMM）来屏蔽掉各种硬件和操作系统的内存访问差异，简单理解也就是说Java虚拟机相当于是在源码和平台之间抽象了一层出来，专门处理一些平台之间访问的兼容问题，使得源码可以`一次编译到处运行`。

然而C/C++是直接使用物理硬件和操作系统的内存模型，因此会由于不同平台的内存模型不同而产生差异。

这样看来JVM内存结构是马达啊！

## JVM内存结构

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGnLHFvZfLrqGDgE6MbJdkpV7xPMhdCiay5RkG4b4UnZK3FF6ag5pW1nYg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />

可以看到Java源代码先是经过编译器进行编译，变成.class文件，由类加载器加载进内存运行。

java 编译的字节码解析路径直达[从JVM设计者的角度来看.class文件结构，一文弄懂.class文件的身份地位](https://mp.weixin.qq.com/s?__biz=MzU0ODYzMzc0MA==&mid=2247483814&idx=1&sn=b9b3ed03f9ac5ef35589760f9ddd890e&chksm=fbbd6c45cccae553b5250cbf61b2ab9b4bd07ac7d830dc32cb9c1185c3a9308ce48bd3761597&mpshare=1&scene=21&srcid=0711UshaVNXz5Homz3E1tGpd&sharer_sharetime=1594477165754&sharer_shareid=ba5c86fc507767c388656b07aa6c3a67&version=3.0.24.6143&platform=mac&rd2werd=1#wechat_redirect)

Java在 JVM 中的运行生命周期和类加载详细过程路径直达[java类在JVM中的生命周期](https://mp.weixin.qq.com/s?__biz=MzU0ODYzMzc0MA==&mid=2247483798&idx=1&sn=94ac776c44c5d20a5e1d067e70a16de7&chksm=fbbd6c75cccae563b84d5435e15222d16de2158eb68e2ec0179c22969a3933627d456107985d&mpshare=1&scene=21&srcid=0711riTLjkIgcXBNZQ6Vedy8&sharer_sharetime=1594476787902&sharer_shareid=ba5c86fc507767c388656b07aa6c3a67&version=3.0.24.6143&platform=mac&rd2werd=1#wechat_redirect)

运行之前的解析读者可以直接看我前面写的几篇，本文主要想说的是运行时数据区。

### 运行时数据区总览

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGn8Il2v4Y3EWGk1vessZkibVIuWIYrSK7ib79tb2d6t5licgahsRENNicibWg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />JVM运行时数据区

方法区和堆区是所有线程共享的，栈和程序计数器都是线程私有各自管各自的。

`线程私有:`Java虚拟机的多线程实现，是通过线程轮流切换并分配处理器执行时间的方式来实现的，再任何一个确定的时刻，一个处理器都只会执行一条线程中的指令。因此为了线程切换之后能恢复到正确的的执行位置，每条线程都需要一个独立的程序计数器，各个线程之间计数器不影响独立存储，我们称这类内存区域为“线程私有”内存。

### 程序计数器

```
程序计数器存放的是下一条字节码指令执行的地址，存放地址的地方，因此只需要一块较小的内存空间，它的作用是当前线程所执行的字节码行号指示器。
```

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGnWzyF5mXeiad802RtDrPIdBzPqf9X5vwnJMbGXAzmr5csXEaW01hCPsg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />JVM指令

放上一篇文章的图，这是 jvm 的一些指令，最终会和计算机的相关指令相对应。

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGnlHs7Bw3Zbw2iaUGPpbxZQPOn2A8L2Yj2YEn2VCqlW8jxAYUzpnevBOg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />字节码指令有序进行

我们都知道在计算机里面CPU是从指令寄存器拿到执行指令进行工作，当指令寄存器里面一条指令被CPU拿走执行，那么寄存器就会把程序计数器里面指定的下一个需要执行的字节码指令对应的CPU指令拿进来，让CPU进行执行，所以实现字节码指令都可以做到有序执行，`需要注意的是程序计数器存放的都是下一个字节码指令的地址`，这样才可以一直往下执行嘛。

ps：这个地方我解释这么清楚是因为其他的大家耳闻较多，很容易理解，但是这个区域至少我大学的时候这个地方就不是很理解。

注：程序计数器是唯一一个在JVM规范中没有规定任何 OutOfMemoryError 的区域。

### java堆（Heap）

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGnYMyCnRWRRhzNa0jNXK82Igk6zYKYCfeibs8rJuZ8r8AUXiaaEfoDGpDA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />new的世界

Java堆是垃圾收集器管理的主要区域，因此很多时候也被称作“GC堆”，幸好国内没翻译成“垃圾堆”。

对于大多数应用来说，Java堆(Heap)是Java虚拟机所管理的内存中最大的一块，主要记住三点：

1. Java堆是被所有`线程共享`的一块内存区域，在虚拟机启动时创建；
2. 此内存区域的`唯一目的就是存放对象实例`，几乎所有的对象实例都在这里分配内存；
3. OutOfMemoryError异常。如果在堆中没有内存完成实例分配，并且堆也无法再扩展时会抛出此异常。

### 栈区

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGnqj02tjFzDwCmZ1Aia53icA0NJQIAFEzTmbLQUoOhsrkFDWaubbrWJlpQ/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />入栈出栈

```
每一个方法从调用开始到完成的过程，就是一个栈帧在在虚拟机中入栈到出栈的过程
```

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGn9V5ErYtJOZlZMfbJQXd16aic4qD2kGG0oZWHgQHkdyc8iabekcxO7QhA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />栈帧

```
栈帧包括的内容：
```

1. 局部变量表
2. 操作数栈
3. 动态链接

说白了就是:

- 存放了编译期可知的各种基本数据类型（boolean，byte，char，short，int...）
- 存放对象引用（注意不是对象本身，是引用，即指针）
- 存放字节码指令地址 returnAddress 类型（即方法返回地址，方法出口）

局部变量表的内存空间在编译期间就完成了分配，进入一个方法的时候，这个方法需要在帧里面分配多少局部变量空间是确定的，不会改变。

#### 本地方法栈

这里简单提一下，他与Java虚拟机栈所发挥的作用是非常相似的，其区别不过是虚拟机栈为虚拟机执行 Java 方法（也就是字节码）服务，而本地方法栈则是为虚拟机使用到的 Native 方法服务。

Navtive 方法是 Java 通过 JNI 直接调用本地 C/C++ 库，可以认为是 Native 方法相当于 C/C++ 暴露给 Java 的一个接口，Java 通过调用这个接口从而调用到 C/C++ 方法。当线程调用 Java 方法时，虚拟机会创建一个栈帧并压入 Java 虚拟机栈。然而当它调用的是 native 方法时，虚拟机会保持 Java 虚拟机栈不变，也不会向 Java 虚拟机栈中压入新的栈帧，虚拟机只是简单地动态连接并直接调用指定的 native 方法。

```
异常：
```

1. StackOverFlowError：栈溢出，线程请求的栈深度大于虚拟机所允许的深度（代码实现可以写一个递归方法，然后不给递归出口，调用递归方法每次递归都会产生新的栈帧直到把栈区打满溢出）
2. OutOfMemoryError：虚拟机栈扩展时无法申请到足够内存（代码实现可以一直循环new对象，直到把堆区打满内存溢出）

### 方法区

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGnQU8y4UjiaM8Ah4VlKcerdwd82rMWVJxoNtvOE5zrwiacQudRUiapxTZzA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />方法区

由图看出此部分主要有静态的常量（类信息不会变），和运行时常量池。

用于存储:

1. 已被虚拟机加载的类信息
2. 常量
3. 静态变量
4. 即时编译器（JIT）编译后的代码

#### 传说中的永久代

很多人都把方法区称为永久代，本质上两者不等价。

这个说法是建立在HotPot虚拟机的，其设计团队把GC分代收集扩展到了方法区，也即是用永久代来实现方法区以至于垃圾收集器可以像管理堆一样管理方法区内存，对其他的虚拟机来说是不存在永久代的概念的。

#### 运行时常量池

运行时常量池是方法区的一部分，class文件除了类的版本，字段，方法，接口等描述信息之外，还有一项信息是常量池，用于存放编译期生成的各种字面量和符号引用，这些内容将在类加载后进入方法区的运行时常量池中存放。

这部分内容是具备动态性的，运行期间可以放入新的常量，例如String类的intern（）方法，以及new String（“123”）的时候，String类型先会先去常量池看123存在不，存在的话直接在堆区生成对象并且引用他，如果不存在会先去常量池创建一个“123”再去堆引用指向他。

### JVM堆，栈，方法区对应结构

<img src="https://mmbiz.qpic.cn/mmbiz_png/5ic2qggSMqHnVxj0JCTcicsMeSnQGdcEGnJG9QHYrcpIgfa6V7ibSEtiaPlm8ib6VvzjzZp7jWQ5TsoNw5el389IagA/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />JVM堆，栈，方法区结构图

```
从设计者角度根据类的内容来划分JVM内存：
```

方法区其实就是存放一些“死的东西”，不会动的东西，例如类的一些死的信息（类名，常量等）；

栈是存放活的动起来的东西，专门对类函数方法来设置的，入栈出栈也不用垃圾回收内存什么的（试想一下，类里面的方法很多，而且是方法进入方法返回，都有进有出，在数据结构里面只有栈这种结构能满足设计，栈帧当然就是根据方法里面的局部变量什么的来设计的）；

堆区存放对象，对象变化比较大，涉及到垃圾回收因此也单独划分区域来存储，便于管理和回收；

程序计数器方便调度字节码指令，让程序动起来，即代码按照代码顺序执行；

本地方法栈由于是调用的c代码，是通过动态链接的方式而不是传统数据结构中的栈结构，所以也抽出来进行特殊处理，划分一个本地方法栈。

这样看，整个类信息主要是拆开来，为了方便管理，存储和调度从而划分成了这几个区域。

`公众号下篇内容预告：```对象的创建，内存布局以及访问定位

用了洪荒之力写完这篇，有收获的朋友点个在看或者分享鼓励一下吧，十分感谢~