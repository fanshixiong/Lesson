# -*- codeing = utf-8 -*-

import pandas
from matplotlib import pyplot as plt
from pyecharts.charts import Bar
from pyecharts.charts import Line
from pyecharts.globals import ThemeType
from pyecharts import options as opts

# 处理中文
from pylab import *

mpl.rcParams['font.sans-serif'] = ['SimHei']

cities = ['chengdu', 'aba', 'bazhong', 'dazhou', 'deyang', 'ganzi', 'guangan',
          'guangyuan', 'leshan', 'luzhou', 'meishan', 'mianyang', 'neijiang', 'nanchong',
          'panzhihua', 'scsuining', 'yaan', 'yibin', 'ziyang', 'zigong', 'liangshan']

all_min_weather = [35, 28, 38, 41, 36, 28, 39, 36, 37, 39, 37, 36, 38, 39, 42, 39, 35, 38, 38, 38, 36]
all_max_weather = [-2, -19, -2, -1, -2, -17, -2, -4, 0, 0, -1, -2, -1, -1, -8, -2, -2, -1, -2, 0, -4]


def draw_img_plt(city, dates, highs, lows):

    # 分析数据
    min_weather = lows.idxmin()
    max_weather = highs.idxmax()
    # all_min_weather.append(lows[min_weather])
    # all_max_weather.append(highs[max_weather])
    text_max = "最高温度：" + str(highs[max_weather]) + "℃ -- " + str(dates[max_weather])
    text_min = "最低温度：" + str(lows[min_weather]) + "℃ -- " + str(dates[min_weather])
    # print(lows[min_weather])
    # print(highs[max_weather])

    # 画图

    fig = plt.figure(dpi=128, figsize=(10, 6))

    plt.plot(dates, highs, c='red', alpha=0.5)
    plt.plot(dates, lows, c='blue', alpha=0.5)

    plt.fill_between(dates, highs, lows, facecolor='blue', alpha=0.2)
    # 图表格式
    # 设置图标的图形格式
    plt.title('2 years weather', fontsize=24)
    plt.xlabel('', fontsize=6)
    fig.autofmt_xdate()
    plt.ylabel('Temperature(℃)', fontsize=12)
    plt.tick_params(axis='both', which='major', labelsize=10)
    # 修改刻度
    plt.xticks(dates[::60])
    # 显示最高和最低温度
    plt.text(570, 0, text_max, size=8, color="r", alpha=0.8)
    plt.text(570, -2, text_min, size=8, color="b", alpha=0.8)
    # 保存

    img = city + '.png'
    plt.savefig(img, dpi=100)
    # 显示
    # plt.show()


def draw_img_bar():
    # print(cities)
    print(all_max_weather)
    print(all_min_weather)
    cities = ['cd', 'aba', 'bz', 'dz', 'dy', 'gz', 'gg',
              'gy', 'ls', 'lz', 'ms', 'my', 'nj', 'nc',
              'pzh', 'ss', 'y', 'yb', 'zy', 'zg', 'ls']
    bar = (
        # init_opts = opts.InitOpts(width="1500px") # 设置可视化图的长度，1500像素
        Bar()
            .add_xaxis(xaxis_data=cities)
            .add_yaxis("Maximum Temperature", yaxis_data=all_max_weather)
            .add_yaxis("Minimum Temperature", yaxis_data=all_min_weather)
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


def draw_img_line():
    cities = ['cd', 'aba', 'bz', 'dz', 'dy', 'gz', 'gg',
              'gy', 'ls', 'lz', 'ms', 'my', 'nj', 'nc',
              'pzh', 'ss', 'y', 'yb', 'zy', 'zg', 'ls']
    line = (Line()
            .add_xaxis(cities)
            .add_yaxis("Maximum Temperature", all_max_weather)
            .add_yaxis("Minimum Temperature", all_min_weather)
            )
    line.render("render.html")

#计算历史上某一天里的晴雨的概率
def calc_weather(month, day, dates, weather, is_sun):
    # print("2020年5月2日".find(month + "月" + day + "日") != -1)
    dates_idx = list(filter(lambda x : x.find(month + "月" + day + "日") != -1, dates))

    # print(dates_idx)

    count1 = 0
    # 下雨
    if is_sun == 0:
        for i in dates_idx:
            if weather[list(dates).index(i)].find("雨") != -1 :
                count1 += 1
        print(count1 / np.size(dates_idx))
        #return np.size(list(filter(lambda x: ((dates[list(weather).index(x)] in dates_idx) and weather[list(dates).index(x)].find("雨") != -1), weather))) / np.size(dates_idx)
        return count1 / np.size(dates_idx)
    # 晴
    else:
        for i in dates_idx:
            if weather[list(dates).index(i)].find("晴") != -1 :
                count1 += 1
        print(count1 / np.size(dates_idx))
        #return np.size(list(filter(lambda x: ((dates[list(weather).index(x)] in dates_idx) and weather[list(dates).index(x)].find("雨") != -1), weather))) / np.size(dates_idx)
        return count1 / np.size(dates_idx)

if __name__ == '__main__':

    for city in cities:
        file = 'datas/' + city + '_weather.csv'
        datalsit = pandas.read_csv(file, encoding='gbk')

        # 数据处理
        # datalsit['temperature_high'] = datalsit['气温'].str.split('/', expand=True)[0]
        # datalsit['temperature_low'] = datalsit['气温'].str.split('/', expand=True)[1]

        # print(datalsit['temperature_high'])
        datalsit['temperature_high'] = datalsit['temperature_high'].map(lambda x: int(x.replace('℃', '')))
        datalsit['temperature_low'] = datalsit['temperature_low'].map(lambda x: int(x.replace('℃', '')))

        dates = datalsit['date']
        highs = datalsit['temperature_high']
        lows = datalsit['temperature_low']
        weather = datalsit['weather']

        day1 = "2019年05月04日"
        # 拿到月份和日期
        month = day1.strip().split("月")[0].split("年")[1]
        day = day1.strip().split("月")[1].split("日")[0]
        # print(month + " " + day)
        prob = calc_weather(month, day, dates, weather, 0)
        print(str(prob) + "\n")
        draw_img_plt(city, dates, highs, lows)

    draw_img_bar()
    draw_img_line()
