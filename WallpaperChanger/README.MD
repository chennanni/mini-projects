# WallpaperChanger

## 问题引出
个人习惯在白天的时候使用亮色系的风景壁纸，但是在晚上的时候就显得太刺眼了，需要更换为暗色系的壁纸。
每次手动更换不免觉得费心，于是便想写一个脚本自动化这个过程。

## 解决思路
在Windows系统下，写一个python脚本更换壁纸，并设置在开机时，以及每一个小时自动触发该脚本。
该脚本可根据当前系统时间，判断是白天还是夜晚，从而随机选择不同的壁纸。

## 如何运行
- 创建folder，放入图片
- 修改参数pic_count_day, pic_count_ngt, folder_path_day, folder_path_ngt
- python app.py

## 链接
- [【熟能生巧】系列第1期 - 自动更换壁纸](https://www.cnblogs.com/maxstack/p/9323291.html)
