1. **table is disable** 

   在使用hbase是需要删除表，在进行删除前，建议先检查状态，判断是否enable、disable、rit状态

2. **table is on rit(Region in transaction)**

   数据表状态不正常，除了查询表状态，无法对表进行访问。

3. **` hbase.ipc.server.max.callqueue.size`**

   ~~~verilog
   com.google.protobuf.ServiceException:org.apache.hadoop.hbase.ipc.RemoteWithExtrasException(org.apache.hadoop.hbase.CallQueueTooBigException): Call queue is full on dgis02,16000,1648644556157, is hbase.ipc.server.max.callqueue.size too small?
   ~~~

   问题原因：大量对hbase表进行的操作阻塞住了（例如对rit状态的数据进行disable、删除等操作）

