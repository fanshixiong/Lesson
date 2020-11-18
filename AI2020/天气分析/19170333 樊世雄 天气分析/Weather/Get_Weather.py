# 天气查询脚本

import requests
import json
from pyecharts.charts import Bar
from pyecharts.charts import Line
from pyecharts.globals import ThemeType
from pyecharts import options as opts


class Query():
	def __init__(self):
		self.url1 = 'http://api.map.baidu.com/telematics/v1/weather?location={}&output=json&ak=17Lpzker8Bjp6CFXwhkTs6cI7Qg6PYct&callback='
		self.url2 = 'http://www.weather.com.cn/data/sk/{}.html'
		self.headers = {
				'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36'
			}
	def get_data(self, city_name):
		results = {}
		# part1
		res = requests.get(self.url1.format(city_name), headers=self.headers)
		try:
			#data1 = json.loads(res.text)
			data1 = json.load("city_code.json")
		except:
			print('[Error]Cannot find the city weather info...')
			return None
		try:
			pm25 = data1["results"][0]["pm25"]
		except:
			pm25 = None
		try:
			Htemperature, Ltemperature = data1["results"][0]["weather_data"][0]["temperature"].split('~')
			Htemperature, Ltemperature = Htemperature.strip(), Ltemperature.strip().strip('℃')
		except:
			Htemperature, Ltemperature = None, None
		try:
			weather = data1["results"][0]["weather_data"][0]["weather"]
		except:
			weather = None
		# part2
		# param = str(time.time()).split('.')[0]
		try:
			res = requests.get(self.url2.format(self.city2code(city_name)), headers=self.headers)
			res.encoding = 'utf-8'
			data2 = json.loads(res.text)
		except:
			print('[Error]Cannot find the city weather info...')
			return None
		try:
			SD = data2["weatherinfo"]['SD']
		except:
			SD = None
		try:
			QY = data2['weatherinfo']['qy']
		except:
			QY = None
		# part3
		results['pm25'] = pm25
		results['Htemperature'] = Htemperature
		results['Ltemperature'] = Ltemperature
		results['SD'] = SD
		results['QY'] = QY
		results['weather'] = weather
		return results
	def city2code(self, city_name):
		with open('city_code.json', 'r') as f:
			data = json.load(f)
		f.close()
		try:
			return data[city_name]
		except:
			print('[ERROR]:City name error...')
			return None


if __name__ == '__main__':
	# Query().get_data('北京')
	# Query().city2code('上海')

	x_attr = ['cd', 'aba', 'bz', 'dz', 'dy', 'gz', 'gg',
              'gy', 'ls', 'lz', 'ms', 'my', 'nj', 'nc',
              'pzh', 'ss', 'y', 'yb', 'zy', 'zg', 'ls']
	data1 = [35, 28, 38, 41, 36, 28, 39, 36, 37, 39, 37, 36, 38, 39, 42, 39, 35, 38, 38, 38, 36]
	data2 = [-2, -19, -2, -1, -2, -17, -2, -4, 0, 0, -1, -2, -1, -1, -8, -2, -2, -1, -2, 0, -4]
	bar = (
		# init_opts = opts.InitOpts(width="1500px") # 设置可视化图的长度，1500像素
		Bar()
			.add_xaxis(xaxis_data=x_attr)
			.add_yaxis("Maximum Temperature", yaxis_data=data1)
			.add_yaxis("Minimum Temperature", yaxis_data=data2)
			.set_global_opts(tooltip_opts=opts.TooltipOpts(is_show=False),
							 xaxis_opts=opts.AxisOpts(
								 axislabel_opts={"interval": "0"}
							 ),
							 yaxis_opts=opts.AxisOpts(
								 # 分割线配置，显示 y 轴每个刻度的分割线
								 splitline_opts=opts.SplitLineOpts(is_show=True),
							 ))

			.render("weather.html")
	)
	line = (Line()
			.add_xaxis(x_attr)
			.add_yaxis("Maximum Temperature", data1)
			.add_yaxis("Minimum Temperature", data2)
			.render("render.html")
			)
