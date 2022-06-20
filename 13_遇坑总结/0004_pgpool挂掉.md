note: 记录postgresql pgpool服务异常

[toc]

# could not connect to server: server closed the connection unexpectedly，This probably means the server terminated abnormally，before or while processing the request.

* 背景
    某天，连接测试环境的postgresql失败，排查问题原因。

* 排查步骤

1. 检查pgpool状态

        systemctl status pgpool
        
    输出日志

        Jun 07 14:28:32 hpcc02 pgpool[1111173]: [761483-1] 2022-06-07 14:28:32: pid 1111173: FATAL:  pgpool is not accepting any new connections
        Jun 07 14:28:32 hpcc02 pgpool[1111173]: [761483-2] 2022-06-07 14:28:32: pid 1111173: DETAIL:  all backend nodes are down, pgpool requires at least one valid node
        Jun 07 14:28:32 hpcc02 pgpool[1111173]: [761483-3] 2022-06-07 14:28:32: pid 1111173: HINT:  repair the backend nodes and restart pgpool
        Jun 07 14:28:32 hpcc02 pgpool[3845443]: [772758-1] 2022-06-07 14:28:32: pid 3845443: LOG:  child process with pid: 1111173 exits with status 256
        Jun 07 14:28:32 hpcc02 pgpool[3845443]: [772759-1] 2022-06-07 14:28:32: pid 3845443: LOG:  fork a new child process with pid: 1138139
     
2. 连接数据库时报错信息
 
        psql: error: could not connect to server: server closed the connection unexpectedly
	    This probably means the server terminated abnormally
	    before or while processing the request.
	    
3. 重启所有节点postgresql后服务正常

        /usr/pgsql-12/bin/pg_ctl -l /dev/null -w -D /var/lib/pgsql/12/data/ start