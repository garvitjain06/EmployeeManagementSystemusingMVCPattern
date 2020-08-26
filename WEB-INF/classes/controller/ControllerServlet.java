/*
	http://localhost:7001/usermgt/controller/ControllerServlet
	Controller Servlet
*/ 

package controller;

import java.io.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;

import common.data.* ;
import common.db.* ;
import common.constants.* ;

public class ControllerServlet extends HttpServlet
{
	public void doGet 
		( HttpServletRequest request, 
			HttpServletResponse response ) 
		throws ServletException, IOException 
	{
		HttpSession session = request.getSession( true ) ;
		try
		{
			int opType = OpTypeConstants.INSERT_PAGE ; 
			String opTypeStr = request.getParameter ("opType") ;  
			if (opTypeStr != null && !opTypeStr.equals ("") )
			{
				opType = Integer.parseInt ( opTypeStr ) ;
			} 

			switch ( opType )
			{ 
				case OpTypeConstants.DISPLAY_PAGE : 
						getServletContext().getRequestDispatcher
							( JSPConstants.DISPLAY_URL ).
							forward (request, response)  ;
						break ;
				case OpTypeConstants.INSERT_PAGE : 
						getServletContext().getRequestDispatcher
							( JSPConstants.INSERT_URL ).
							forward (request, response)  ;
						break ; 
                               case OpTypeConstants.UPDATE_PAGE : 
						getServletContext().getRequestDispatcher
							( JSPConstants.UPDATE_URL ).
							forward (request, response)  ;
						break ; 
                              case OpTypeConstants.DELETE_PAGE : 
						getServletContext().getRequestDispatcher
							( JSPConstants.DELETE_URL ).
							forward (request, response)  ;
						break ; 
                             case OpTypeConstants.HOME_PAGE : 
						getServletContext().getRequestDispatcher
							( JSPConstants.HOME_PAGE_URL ).
							forward (request, response)  ;
						break ;  
			} 
		}
		catch ( Exception e )
		{
			session.setAttribute("exception",e);
			getServletContext().getRequestDispatcher
						( JSPConstants.ERROR_PAGE_URL ).
							forward (request, response)  ;	 
		}
	}
	public void doPost
		( HttpServletRequest request, HttpServletResponse response ) 
		throws ServletException, IOException
	{ 
		HttpSession session = request.getSession( true ) ;
		EmployeeDetails userReg ;
		ResultSet rs = null ;

		try
		{ 	
			if ( session == null ) { 
				getServletContext().getRequestDispatcher
						( JSPConstants.ERROR_PAGE_URL ).
							forward (request, response)  ;
			} 
			int opType = Integer.parseInt ( request.getParameter ("opType") ) ; 
			System.out.println( "opType= " + opType ) ; 	 
			switch ( opType )
			{
				case OpTypeConstants.PROCESS_DISPLAY_PAGE :  
						userReg = getEmployeeDetails( request ) ; 
                                                 
						 session.setAttribute( "userRegData", userReg) ;
					      String displayQuery = QueryFormatter.formSelectWhereQuery ( userReg ,"Eid" ) ;
                                              //  String displayQuery= "select * from EmployeeDetails";
						 rs=SQLExecuter.executeRSQuery ( displayQuery ) ;
                                                
                                                 session.setAttribute( "result", rs) ;
						RequestDispatcher rd=request.getRequestDispatcher(JSPConstants.PROCESS_DISPLAY_URL );  
       						 rd.forward(request, response);
						
							
						
						break ;  
				case OpTypeConstants.PROCESS_INSERT_PAGE : 
						userReg = getEmployeeDetails( request ) ; 
						String insertQuery = 
							QueryFormatter.formCreateQuery ( userReg ) ;
						SQLExecuter.executeUpdateQuery ( insertQuery ) ;
						session.setAttribute( "userRegData", userReg ) ; 
						getServletContext().getRequestDispatcher
						( JSPConstants.PROCESS_INSERT_URL ).
							forward (request, response)  ;
						break ;  
                              case OpTypeConstants.PROCESS_UPDATE_PAGE : 
						userReg = getEmployeeDetails( request ) ; 
						String updateQuery = 
							QueryFormatter.formUpdateWhereQuery ( userReg,"EmployeeName","Eid") ;
						SQLExecuter.executeUpdateQuery ( updateQuery ) ;
						session.setAttribute( "userRegData", userReg ) ; 
						getServletContext().getRequestDispatcher
						( JSPConstants.PROCESS_UPDATE_URL ).
							forward (request, response)  ;
						break ;  
                               case OpTypeConstants.PROCESS_DELETE_PAGE : 
						userReg = getEmployeeDetails( request ) ; 
						String deleteQuery = 
							QueryFormatter.formDeleteWhereQuery ( userReg,"Eid") ;
						SQLExecuter.executeUpdateQuery ( deleteQuery ) ;
						session.setAttribute( "userRegData", userReg ) ; 
						getServletContext().getRequestDispatcher
						( JSPConstants.PROCESS_DELETE_URL ).
							forward (request, response)  ;
						break ;  
                             
			} 
		}
		catch ( Exception e )
		{ 
			session.setAttribute("exception",e);
			getServletContext().getRequestDispatcher
						( JSPConstants.ERROR_PAGE_URL ).
							forward (request, response)  ;				 
		}
		finally
		{
			if( rs != null )
			try
			{
				rs.close() ;
			}
			catch (Exception e) { } 
		} 
	} 
	 
	private EmployeeDetails getEmployeeDetails ( HttpServletRequest request )
				throws ServletException 
	{
		EmployeeDetails userReg = new EmployeeDetails (); 
		userReg.setEid ( request.getParameter ( "Eid" ) ) ; 
		userReg.setEmployeeName ( request.getParameter ( "EmployeeName" ) ) ; 
		userReg.setAddress ( request.getParameter ( "Address" ) ) ; 
		userReg.setDesignation ( request.getParameter ( "Designation" ) ) ; 
		 
		userReg.setPhnno ( request.getParameter ( "Phnno" ) ) ; 
                userReg.setSalary ( request.getParameter ( "Salary" )  ) ;
		return userReg ;
	}
}
