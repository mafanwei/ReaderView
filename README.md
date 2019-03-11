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
下载ReaderView到你的项目中
在xml声明
/*** <com.mafanwei.ReaderView
        android:layout_marginLeft="8dp"
        android:layout_marginRight="8dp"
        android:id="@+id/reader"
        android:layout_weight="1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />***/
