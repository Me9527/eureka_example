Eureka clients tries to talk to Eureka Server in the same zone. 
If there are problems talking with the server or if the server does not exist in the same zone, the clients fail over to the servers in the other zones.


 ApplicationInfoManager.getInstance().setInstanceStatus(InstanceStatus.UP)

















