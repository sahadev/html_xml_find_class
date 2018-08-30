#在html文件中查找对应的class并输出

编译方法：javac -g com/missfresh/sahadev/Main.java
运行方法：java com.missfresh.sahadev.Main html输入路径 html输出路径

> 注意：输入路径与输出路径为必填项，且不可相等。如果输出文件不存在，则会自动创建。

目前能识别的标签类型有：*view*，*input*，*image*。开发者可根据自己的需求添加处理类型。添加处理方法的方式为：
```java
        elementsByTagName = parse.getElementsByTagName("image");
        writeClassByElements(outFile, elementsByTagName);
```
创建时间：2018年08月30日