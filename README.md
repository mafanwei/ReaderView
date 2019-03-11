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
这是我用这个类做出来的demo
[![观看视频](https://raw.github.com/GabLeRoux/WebMole/master/ressources/WebMole_Youtube_Video.png)](https://github.com/mafanwei/ReaderView/blob/master/Demo%E8%A7%86%E9%A2%91.mp4)
