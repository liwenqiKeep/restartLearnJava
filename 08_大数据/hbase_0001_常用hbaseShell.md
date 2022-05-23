* **复制表到指定空间**
  
  ```she
  # 1. 置为不可用
  disable 'SV:MNR_CHUFA'
  # 2. 创建快照
  snapshot 'SV:MNR_CHUFA', 'MNR_CHUFA_NewSnapshot'
  # 3. 克隆快照
  clone_snapshot 'MNR_CHUFA_NewSnapshot', 'SV:MNR_CHUFA_NEW'
  # 4. 删除克隆快照
  delete_snapshot 'MNR_CHUFA_NewSnapshot'
  ```

* 获取table所有的rowkey
  
  ```
  count 'tablename', INTERVAL=>1
  ```
