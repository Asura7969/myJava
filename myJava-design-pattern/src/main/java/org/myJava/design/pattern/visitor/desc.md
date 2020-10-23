# 访问者模式

需要对一个对结构中的对象进行很多不同并且不相关的操作，而你想避免让这些操作“污染”这些对象

## 目的
把处理从数据结构分离出来

## 实现方式
* 定义一个需要访问所有元素的抽象类(Visitor.java)
* 定义一个VisitorBase基类继承`Visitor.java`(非必须)
* 写一个继承VisitorBase的类,重写所需要的方法
* 定义一个接受者抽象类(Element.java),并定义一个方法,参数为`Visitor`类型
* 继承Element,实现accept方法,并把自己传进去

