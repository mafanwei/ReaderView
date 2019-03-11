# ReaderView
用于txt阅读的自定义View

可用于小说阅读器中

# 思路
这个类要解决几个问题
1.	换行，自定义view不会自动换行
2.  分段，自定义view不会分段
3.	行首不能存在标点（双引号除外），这是汉语的规则，我采用的方式是，如果行首是标点，那么就拖上行的最末尾的字符显示到下行行首，若上行的最末尾的字符也是标点，那么就拖上行的后俩个字下来，以此类推。
4.	如何统计字符
明确了问题，就明白代码怎么写了。

# 效果图
这是我用这个类做出来的demo，这个类只有中间文字部分，上面的章节名和右下角的进度，需要你自己来做
<img src="https://github.com/mafanwei/ReaderView/blob/master/Demo%E6%88%AA%E5%9B%BE.png" width=375 alt="效果图"/>

# 使用说明
## 简易使用
下载ReaderView到你的项目中

1. 在xml声明
```
<com.mafanwei.ReaderView
android:layout_marginLeft="8dp"
android:layout_marginRight="8dp"
android:id="@+id/reader"
android:layout_weight="1"
android:layout_width="match_parent"
android:layout_height="wrap_content" />
```
**注意，在这里需要换成你自己的包名**

2. findviewbyid
3. 设置文本readerView.setTxt();//这里是String类型或者String[] 类型，String[] 类型表示已经分好段。
3. 在代码中注册接口
```
readerView.setShowAtListener(new ReaderView.ShowAtListener() {
@Override
public void showAt(int pos) {
}
});
```
 pos是页面显示到最后显示了文本的第几个字
 
 例如，文本内容是1000个字，可能pos就是217，就是代表了显示到了第217个字。
 ## 其余api
    private Paint paint;//set get
    private int rowHeight;//get
    private int rowSpan;//set get
 
