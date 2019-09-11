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
