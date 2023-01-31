# MVC 与 MVP 

##  MVP 概述

提到[MVP](https://so.csdn.net/so/search?q=MVP&spm=1001.2101.3001.7020)，就必须要先介绍一下它的前辈MVC，因为MVP正是基于MVC的基础发展而来的。两个之间的关系也是源远流长。

MVC，全称Model-View-Controller，即模型-视图-控制器。

- View：对应于布局文件
- Model：业务逻辑和实体模型
- Controller：对应于Activity

但是View对应于布局文件，其实能做的事情特别少，实际上关于该布局文件中的数据绑定的操作，事件处理的代码都在Activity中，造成了Activity既像View又像Controller，使得Activity变得臃肿。

而当将架构改为MVP以后，Presenter的出现，将Activity视为View层，Presenter负责完成View层与Model层的交互。现在是这样的：

**View 对应于Activity，负责View的绘制以及与用户交互**

Model 依然是业务逻辑和实体模型

Presenter 负责完成View于Model间的交互



下面两幅图通过数据与视图之间的交互清楚地展示了这种变化：

![img](https://img-blog.csdnimg.cn/img_convert/e33035314f3670f1694c3747f9570032.png)



[MVC模式](https://so.csdn.net/so/search?q=MVC模式&spm=1001.2101.3001.7020)下实际上就是Activty与Model之间交互，View完全独立出来了

![img](https://img-blog.csdnimg.cn/img_convert/6cb11d41131991fb2c48fd78004afdaf.png)



MVP模式通过Presenter实现数据和视图之间的交互，简化了Activity的职责。同时即避免了View和Model的直接联系，又通过Presenter实现两者之间的沟通。

总结：MVP模式减少了Activity的职责，简化了Activity中的代码，将复杂的逻辑代码提取到了Presenter中进行处理，模块职责划分明显，层次清晰。与之对应的好处就是，[耦合度](https://so.csdn.net/so/search?q=耦合度&spm=1001.2101.3001.7020)更低，更方便的进行测试



MVC 与 MVP 的区别

![img](https://img-blog.csdnimg.cn/img_convert/03c23b5f7a8d2946da39aca170d2c08b.png)

MVC中是允许Model和View进行交互的，而MVP中很明显，Model与View之间的交互由Presenter完成。还有一点就是Presenter与View之间的交互是通过接口的。

还有一点注意：MVC中V对应的是布局文件，MVP中V对应的是Activity



## 总结

MVP模式的整个核心流程：

View与Model并不直接交互，而是使用Presenter作为View与Model之间的桥梁。其中Presenter中同时持有View层的Interface的引用以及Model层的引用，而View层持有Presenter层引用。当View层某个界面需要展示某些数据的时候，首先会调用Presenter层的引用，然后Presenter层会调用Model层请求数据，当Model层数据加载成功之后会调用Presenter层的回调方法通知Presenter层数据加载情况，最后Presenter层再调用View层的接口将加载后的数据展示给用户。

![img](https://img-blog.csdnimg.cn/img_convert/83c2d9f10c9c5ed184f9f266490ca3d7.png)



## 附录

参考资料

https://blog.csdn.net/hdhhd/article/details/123204173