git pull
git status
git add .
git status
::获取当前系统时间并指定格式（提取信息）
set name=%date:~0,4%.%date:~5,2%.%date:~8,2%/%time:~0,2%.%time:~3,2%shao
::去掉空格
set "name=%name: =%"
git commit -m '%name%'
git status
git push
git status
pause