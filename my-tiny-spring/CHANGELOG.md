## 1. step-1-container-register-and-get
最基本的ioc实现， 使用一个ConcurrentHashMap来存储BeanDefinition。

## 2. step-2-container-register-and-get
 - 将 `BeanFactory` 抽象化， 并且创建它的实例`AutowireCapableBeanFactory`。
 - `BeanDefinition`中增加`beanClass` 和 `beanClassName` 字段，方便通过反射来创造对象。 

## 3. step-3-inject-bean-with-property
 - 通过反射来给Bean注入属性

## 4. step-4-config-beanfactory-with-xml
 - 通过读取xml文件获取 `BeanDefinition` ，并将通过bean的definition获取bean