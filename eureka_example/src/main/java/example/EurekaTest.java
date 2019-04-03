package example;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;

/**
 * Servlet implementation class EurekaTest
 * http://localhost:9080/eureka_example/test/name/sfasf
 * http://localhost:9080/eureka_example/test/testEureka/service-provide-01
 */
@Path("test")
public class EurekaTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Context
	private ServletContext servletContext;

//	@GET
//	@Path("/testEureka/{appId}")
//	@Produces(MediaType.TEXT_XML)
//	public String testEureka(@PathParam("appId") String appId) {
////		  EurekaServerContextHolder tmp = EurekaServerContextHolder.getInstance();
////		  EurekaServerContext context = tmp.getServerContext();
////		  EurekaClient eurekaClient = new DiscoveryClient(applicationInfoManager, eurekaClientConfig);
////		EurekaClient eurekaClient = (EurekaClient) servletContext.getAttribute(EurekaClient.class.getName());
////		List<InstanceInfo> ins01 = eurekaClient.getInstancesById(appId);
////		List<InstanceInfo> ins02 = eurekaClient.getInstancesByVipAddress(appId, false);
////		Applications applications = eurekaClient.getApplicationsForARegion(appId);
//
//		return "<User>" + "<Name>" + appId + "</Name>" + "</User>";
//	}

	@GET
	@Path("/testEureka/{appId}")
	@Produces(MediaType.TEXT_XML)
	public String testEureka(@PathParam("appId") String appId) {
	EurekaClient eurekaClient = (EurekaClient) servletContext.getAttribute(EurekaClient.class.getName());
	List<InstanceInfo> ins01 = eurekaClient.getInstancesById(appId);
	List<InstanceInfo> ins02 = eurekaClient.getInstancesByVipAddress(appId, false);
	Applications applications = eurekaClient.getApplicationsForARegion(appId);
	
		return "<User>" + "<Name>" + appId + "</Name>" + "</User>";
	}
	
	@GET
	@Path("/name/{i}")
	@Produces(MediaType.TEXT_XML)
	public String userName(@PathParam("i") String i) {

		String name = i;
		return "<User>" + "<Name>" + name + "</Name>" + "</User>";
	}

	@GET
	@Path("/age/{j}")
	@Produces(MediaType.TEXT_XML)
	public String userAge(@PathParam("j") int j) {

		int age = j;
		return "<User>" + "<Age>" + age + "</Age>" + "</User>";
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EurekaTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("test 01");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
