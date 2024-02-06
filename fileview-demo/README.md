进入openOffice安装路径下的program下面，比如:
D:\Program Files (x86)\OpenOffice 4\program
进入cmd窗口，执行命令
```
soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard
```