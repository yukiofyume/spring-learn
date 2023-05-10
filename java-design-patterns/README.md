# 0.参考
[Java Design Patterns (中文)](https://java-design-patterns.com/zh/patterns/)

# 1.创建型

## 1.1.工厂类型

### 1.1.1.简单工厂模式

[代码参考](https://java-design-patterns.com/zh/patterns/factory/#%E8%A7%A3%E9%87%8A)

同属来说是使用一个类工厂，来创建所需要的接口的具体实现类，就像一个层级为 2 的树一样，父节点来被工厂类创建，子节点就是具体的实现类。

缺点很明显了，就是这个树只能有 2 层，然后如果后续添加子节点后，需要去修改获取具体类的枚举（相当于if-else，这种枚举的写法还是挺好的，看的很清晰）。违反了设计模式的开闭原则（OCP），即对扩展开放，对修改关闭。

### 1.1.2.工厂方法

[代码工厂](https://java-design-patterns.com/zh/patterns/factory-method/#also-known-as)

和简单工厂模式的区别是，简单工厂模式添加新的节点之后，需要去修改工厂类的枚举；工厂方法需要添加新的节点的时候，不需要去修改工厂类，这里的工厂类指的是，最初的接口的无数个实现类。比如需要去添加某个东西的时候，只需要定义一个类去实现接口，然后就可以去做相应的动作的。这里是没用一个统一的出口的。

### 1.1.3.抽象工厂

[代码参考](https://java-design-patterns.com/zh/patterns/abstract-factory/)