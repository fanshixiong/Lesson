
## 实验二
* 显示python中所有的keyword，观察并熟记这些keyword。
* 显示python中的内建函数，了解其功能。
* 编写程序，输入一个自然数，使用内建函数输出它的二进制、八进制、十六进制表示形式，并观察二进制、八进制、十六进制的输出类型。
* 编写程序，输入一个浮点数，使用内建函数输出它的绝对值、四舍五入值、向下取整值和向上取整。
* 导入os库，打印当前运行代码所在的目录，并显示当前目录中的所有文件。
* 重复书中第二章的代码。

------
1. 显示python中所有的keyword，观察并熟记这些keyword。


```python
#导入模块
import  keyword
# 打印关键字列表
print(keyword.kwlist)
```

    ['False', 'None', 'True', 'and', 'as', 'assert', 'async', 'await', 'break', 'class', 'continue', 'def', 'del', 'elif', 'else', 'except', 'finally', 'for', 'from', 'global', 'if', 'import', 'in', 'is', 'lambda', 'nonlocal', 'not', 'or', 'pass', 'raise', 'return', 'try', 'while', 'with', 'yield']
    

---
2. 显示python中的内建函数，了解其功能


```python

```

--- 
3. 编写程序，输入一个自然数，使用内建函数输出它的二进制、八进制、十六进制表示形式，并观察二进制、八进制、十六进制的输出类型。


```python
a = int(input("请输入一个十进制整数："))

print("其对应二进制为：{:b}\n八进制为：{:o}\n十六进制为：{:x}".format(a, a, a))
```

    请输入一个十进制整数：4
    其对应二进制为：100
    八进制为：4
    十六进制为：4
    

---
4. 编写程序，输入一个浮点数，使用内建函数输出它的绝对值、四舍五入值、向下取整值和向上取整。


```python
import math
a = float(input("请输入一个十进制整数："))

print("绝对值为：{}\n四舍五入值为：{}\n向下取整值为：{}\n向上取整值为：{}".format(math.fabs(a), round(a), int(a), math.ceil(a)))
```

    请输入一个十进制整数：10.2
    绝对值为：10.2
    四舍五入值为：10
    向下取整值为：10
    向上取整值为：11
    

--- 
5. 导入os库，打印当前运行代码所在的目录，并显示当前目录中的所有文件。


```python
import os

fileDir = os.curdir
print(fileDir)

entries = os.listdir(fileDir)

for entry in entries:
    print(entry)
```

    .
    .ipynb_checkpoints
    1.png
    python实验.ipynb
    

## 实验三
* 将hello world全部转成大写字母并倒序排练（DLROW OLLEH）打印出来。
* 编写函数输出用户输入的内容中有几个十进制小数？几个字母？
* 查询指定目录下面的所有文件，并对其中的jpg图像改名。（如文件夹中有多个图片，将这些图片按顺序改成1.jpg,2.jpg…，注意需要保留扩展名）。
   `思考`：如果文件夹中还有文件夹你的程序是否能够正确执行？
 ![image.png](1.png)
* 利用python数据结构，设计一组函数帮助小明能记录新学的英文单词和其对应的所有中文翻译，并能很方便地根据英文来查找中文。
`思考`：如果需要在小明下次打开程序的时候，程序依然保存小明上次背过的单词，如何实现？


---
1. 将hello world全部转成大写字母并倒序排练（DLROW OLLEH）打印出来。


```python
str = "hello world"

print(str.upper()[::-1])

```

    DLROW OLLEH
    

---
2. 编写函数输出用户输入的内容中有几个十进制小数？几个字母？


```python
val = input("请输入内容：")

print('包含 %d 个数字' %  len(list(filter(lambda x : x.isdigit(), val))))
print('包含 %d 个字母' %  len(list(filter(lambda x : x.isalpha(), val))))
```

    请输入内容：546464646sadf
    包含 9 个数字
    包含 4 个字母
    

---
3. 查询指定目录下面的所有文件，并对其中的jpg图像改名。（如文件夹中有多个图片，将这些图片按顺序改成1.jpg,2.jpg…，注意需要保留扩展名）。
   `思考`：如果文件夹中还有文件夹你的程序是否能够正确执行？
 ![image.png](1.png)


```python
import os
# 图片输入路径
path = os.curdir
# 图片输出路径,用来存储修改名字后图片的位置，当然你也可以覆盖在path中
outpath = path

if not os.path.exists(outpath):
   os.makedirs(outpath)

def change(path):
    cnt = 1
    for img in os.listdir(path):
        # print(img)
        if os.path.isdir(img):
            change(img)
        name = os.path.splitext(img)
        last_segment = name[1] 
        if name[1] != '.jpg':
            continue
        org_name = os.path.join(path, img)
        changed_name = path + "//" + cnt.__str__() + last_segment
        print(org_name + "  " + changed_name)
        os.rename(org_name, changed_name)

        cnt += 1

change(path)
```

    .ipynb_checkpoints\2.jpg  .ipynb_checkpoints//1.jpg
    .\1.jpg  .//1.jpg
    

---
4. 利用python数据结构，设计一组函数帮助小明能记录新学的英文单词和其对应的所有中文翻译，并能很方便地根据英文来查找中文。
`思考`：如果需要在小明下次打开程序的时候，程序依然保存小明上次背过的单词，如何实现？


```python
f = open("director.txt","r",encoding='utf-8')

lines = f.readlines()

info = dict()
for line in lines:
    if line == "\n":
        continue
    line = line.split()
    eng = line[0]
    ch = line[1]
    info[eng] = ch


new = dict(info)
while 1:
    key = input("请输入英文：（q退出）:")
    if key == 'q':
        break
    value = input("请输入中文: ")
    new[key] = value;

while 1:
    ques = input("请输入要查询的英文：(q退出):")
    if ques == 'q':
        break
    if ques in new:
        print(new[ques])
    else:
        print("还没有学习到这个单词")

with open('director.txt', 'w', encoding='utf-8') as f:
    for key in new:
        f.write("\n" + key + " " + new[key])


```

    请输入英文：（q退出）director
    请输入中文: 方向
    请输入英文：（q退出）q
    请输入要查询的英文：abc
    屁
    
