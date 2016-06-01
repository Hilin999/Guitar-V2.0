package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Guitar;
import model.GuitarSpec;
import model.Inventory;

/**
 * Servlet implementation class searchGuitar
 */
@WebServlet("/searchGuitar")
public class searchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static void initializeInventory(){
    		Inventory initialize = new Inventory();		
    	try {
    		initialize.loadData(); 		
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
     }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type=request.getParameter("type");
		String builder=request.getParameter("builder");
		String numStrings=request.getParameter("numStrings");
		String backWood=request.getParameter("backWood");
		String topWood=request.getParameter("topWood");
		PrintWriter out=response.getWriter();

		//调取数据库中的数据到内存
		initializeInventory();
	   
		Inventory inventory = new Inventory();
	    GuitarSpec required = new GuitarSpec(builder, type,numStrings,topWood,backWood);
	    List matchingGuitars = inventory.search(required);    
	    if (!matchingGuitars.isEmpty()) {
		      System.out.println("以下是符合您搜索条件的吉他：");
	        for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
	          Guitar guitar = (Guitar)i.next();
	          GuitarSpec spec = guitar.getSpec();
	          out.println("以下是符合您搜索条件的吉他："+"<br>"
	        		     +"编号是"+guitar.getSerialNumber()+"<br>"
	                     +"价格是"+guitar.getPrice()+"<br>"
	                     +"制造商"+spec.getBuilder()+"<br>"
	                     +"种类"+spec.getType()+"<br>"
	                     +"弦数"+spec.getNumStrings()+"<br>"
	                     +"前壳"+spec.getTopWood()+"<br>"
	                     +"后壳"+spec.getBackWood()+"<br>"
	        		  );
			      }
			    } else {
			     out.println("抱歉，我们没有符合您条件的吉他 ");
			    }
			  }    
	    
 }
   

