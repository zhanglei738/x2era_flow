设计思路

web接口调用Azkaban的API


1.模拟登陆获取session-id
  请求:POST
  请求参数:
  action=login	
  username	
  password	
  响应参数:
  error	        Return an error message if the login attempt fails.
  session.id	Return a session id if the login attempt succeeds.


2.流程执行
  请求:GET
  请求参数:
  session.id
  ajax=executeFlow
  project  : run-all-jobs
  flow	
  响应参数:
  error	
  flow	
  execid

3.任务监控设计
  a.自定义监控粒度
    条数监控 select count(1) from xxx 
    数据返回 如果条数 >=1 {"status":"normal","count":"1"}
            如果条数  =0 {"status":"fail","count":"0"}
  b.自定义schedule,配置报表任务的监控粒度
  c.告警数据返回,短信  or 电话告警
  
  
  monitor bean 设计
  字段	                      释义	                        备注
  status 	         monitor监控结果/status /fail	
  
  table_name              监控具体的表名	
  
  count_num	                校验结果	
  
  monitor_time	              日期	

  
  
  
  
            