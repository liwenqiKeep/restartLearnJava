* **sql 实现字段增加固定天数：**
  https://cloud.tencent.com/developer/ask/sof/591359

  ~~~sql
  update dgis_datamanager_model_life_time set data_cyle_time = data_create_time +  INTERVAL '7 days' 
  where data_mesuccess_time = '2022-04-06 14:14:57.101'
  ~~~

  

* **查询连接数 & 关闭连接方法**

  ~~~ sql
  -- 查询连接
  select * from pg_stat_activity;
  
  -- 关闭连接
  ~~~

  

