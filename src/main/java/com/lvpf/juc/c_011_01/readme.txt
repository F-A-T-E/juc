synchronized的底层实现

JDK早期   重量级   - OS
后来 的 改进
锁升级的概念：
            我就是厕所所长（一 二）

sync（object）
markword 记录这个线程 ID（偏向锁）
如果有线程争用： 升级为  自旋锁
旋了10次之后：
升级为重量级锁  - OS
