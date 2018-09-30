# 在html文件中查找对应的class并输出

首先需要进入项目根目录src文件夹下，例如：
```java
/Users/sahadev/openSource/htmlxmlfindclass/src
```

然后进行编译：

编译方法：javac -g com/missfresh/sahadev/Main.java （该命令固定）

运行方法：java com.missfresh.sahadev.Main html输入路径 html输出路径

        例如：java com.missfresh.sahadev.Main /Users/sahadev/openSource/mryx_super_market/pages/mainPages/mine/my_address/my_address.wxml /Users/sahadev/openSource/mryx_super_market/pages/mainPages/mine/my_address/my_address.css

> 注意：输入路径与输出路径为必填项，且不可相等。如果输出文件不存在，则会自动创建。

示例代码：
输入文件：/Users/sahadev/openSource/mryx_super_market/pages/mainPages/mine/my_address/my_address.wxml
```html
<!--pages/mainPages/mine/my_address/my_address.wxml-->
<mf-page mfConfig="{{mfConfig}}">
    <view class="container">

        <view>
            <view class="address-item" wx:if="{{addressList.length > 0}}" wx:for="{{addressList}}" wx:for-item="address">
                <view class="address-full_address">{{address.full_address}}</view>
                <view class="address-address_detail">{{address.address_detail}}</view>
                <view class="address-name">{{address.name}} </view>
                <view class="address-phone_number">{{address.phone_number}}</view>
            </view>
            <view class="address-create">新增收货地址</view>

        </view>

    </view>
</mf-page>
```

输出文件：/Users/sahadev/openSource/mryx_super_market/pages/mainPages/mine/my_address/my_address.css
```css
.container{}
.address-item{}
.address-full_address{}
.address-address_detail{}
.address-name{}
.address-phone_number{}
.address-create{}
```


目前能识别的标签类型有：*view*，*input*，*image*。开发者可根据自己的需求添加处理类型。添加处理方法的方式为：
```java
        elementsByTagName = parse.getElementsByTagName("image");
        writeClassByElements(outFile, elementsByTagName);
```
创建时间：2018年08月30日，修改时间：2018年09月17日
