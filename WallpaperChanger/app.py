import win32api, win32con, win32gui
import random
import datetime
import time

pic_count_day = 11
pic_count_ngt = 9
folder_path_day = r'C:\Users\Administrator.WIN-1J9R69V4VDR\Desktop\bg\day\\'
folder_path_ngt = r'C:\Users\Administrator.WIN-1J9R69V4VDR\Desktop\bg\night\\'

# https://blog.csdn.net/felixzh123/article/details/76085132
def set_wallpaper(img_path):
	# 打开指定注册表路径
	reg_key = win32api.RegOpenKeyEx(win32con.HKEY_CURRENT_USER, "Control Panel\\Desktop", 0, win32con.KEY_SET_VALUE)
	# 最后的参数:2拉伸,0居中,6适应,10填充,0平铺
	win32api.RegSetValueEx(reg_key, "WallpaperStyle", 0, win32con.REG_SZ, "6")
	# 最后的参数:1表示平铺,拉伸居中等都是0
	win32api.RegSetValueEx(reg_key, "TileWallpaper", 0, win32con.REG_SZ, "0")
	# 刷新桌面
	win32gui.SystemParametersInfo(win32con.SPI_SETDESKWALLPAPER, img_path, win32con.SPIF_SENDWININICHANGE)

if __name__ == '__main__':
	# get current hour
	current_time = time.localtime(time.time())
	current_hour = current_time[3]
	# get image according to day or night
	if current_hour > 6 and current_hour < 18:
		print ("day")
		folder_path = folder_path_day
		pic_number = random.randint(1,pic_count_day)
	else:
		print("night")
		folder_path = folder_path_ngt
		pic_number = random.randint(1,pic_count_ngt)
	# get image absolute path
	pic_format = '.jpg'
	pic_path = folder_path + str(pic_number) + pic_format
	# change the wallpaper
	set_wallpaper(pic_path)
