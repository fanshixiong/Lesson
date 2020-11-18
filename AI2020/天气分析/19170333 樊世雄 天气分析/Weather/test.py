# https://blog.csdn.net/weixin_43327576/article/details/86514093
import requests
from requests.exceptions import RequestException
from bs4 import BeautifulSoup
import csv
import time


def get_one_page(url):
    '''
    获取网页
    '''
    print('正在加载' + url)
    headers = {'User-Agent': 'User-Agent:Mozilla/5.0'}
    try:
        response = requests.get(url, headers=headers)
        if response.status_code == 200:
            return response.content
        return None
    except RequestException:
        return None


def parse_one_page(html):
    '''
    对网页内容进行解析
    '''
    soup = BeautifulSoup(html, "lxml")
    info = soup.find('div', class_='wdetail')
    rows = []
    tr_list = info.find_all('tr')[1:]  # 使用从第二个tr开始取
    for index, tr in enumerate(tr_list):  # enumerate可以返回元素的位置及内容
        td_list = tr.find_all('td')
        date = td_list[0].text.strip().replace("\n", "")  # 取每个标签的text信息，并使用replace()函数将换行符删除
        #weather = td_list[1].text.strip().replace("\n", "").split("/")[0].strip()
        weather = td_list[1].text.strip().replace("\n", "").split("/")[0].strip() + "/" + td_list[1].text.strip().replace("\n", "").split("/")[1].strip()
        temperature_high = td_list[2].text.strip().replace("\n", "").split("/")[0].strip()
        temperature_low = td_list[2].text.strip().replace("\n", "").split("/")[1].strip()

        # print(td_list[0].text + " " + td_list[1].text + " " + td_list[2].text + "\n")
        # print(td_list[0].text.strip().replace("\n", "") + " " + td_list[1].text.strip().replace("\n", "") + " " + td_list[2].text.strip().replace("\n", "") + "\n")
        # print(date + " " + weather + " " + temperature_high + " " + temperature_low + "\n")

        rows.append((date, weather, temperature_high, temperature_low))
    return rows


# 爬取的城市拼音名称，实验中可只选取一个城市
cities = ['chengdu','aba','bazhong','dazhou','deyang','ganzi','guangan',
          'guangyuan','leshan','luzhou','meishan','mianyang','neijiang','nanchong',
          'panzhihua','scsuining','yaan','yibin','ziyang','zigong','liangshan']

years = ['2018', '2019']
months = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12']

if __name__ == '__main__':
    '''
    with open(cities[2] + '_weather.csv', 'a', newline='') as f:
        writer = csv.writer(f)
        writer.writerow(['date', 'weather', 'temperature_high', 'temperature_low'])
        url = 'http://www.tianqihoubao.com/lishi/' + cities[2] + '/month/' + years[0] + months[0] + '.html'
        html = get_one_page(url)
        content = parse_one_page(html)
        writer.writerows(content)
        print(cities[2] + years[0] + months[0] + ' is OK!')
    '''
    # os.chdir()  # 设置工作路径

    for city in cities:
        with open(city + '_weather.csv', 'a', newline='') as f:
            writer = csv.writer(f)
            writer.writerow(['date', 'weather', 'temperature_high', 'temperature_low'])
            for year in years:
                for month in months:
                    url = 'http://www.tianqihoubao.com/lishi/' + city + '/month/' + year + month + '.html'
                    html = get_one_page(url)
                    content = parse_one_page(html)
                    writer.writerows(content)
                    print(city + year + month + ' is OK!')
                    time.sleep(0.01)

