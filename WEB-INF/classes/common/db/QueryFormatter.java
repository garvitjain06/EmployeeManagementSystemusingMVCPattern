package common.db	;

import java.lang.reflect.*; 

import common.data.* ;
import common.util.ClassUtil ;

public class QueryFormatter
{
	public static String formCreateQuery 
		( Object inObject )
	{ 
		StringBuffer sb = null ; 
		Class c = inObject.getClass () ; 
		Field [] fields = c.getDeclaredFields () ;  
		
		if (fields.length == 0 )
		{
			return null ;
		}
		sb = new StringBuffer () ;	
		sb.append ( "insert into " ) ;
		sb.append ( ClassUtil.getClassName (c.getName()) ) ; 
		sb.append ( " values (" ) ; 

		Method m = null ;
		try
		{
			// n-1 fields
			for ( int i = 0 ; i < fields.length - 1 ; i++ )
			{ 
 				m = c.getMethod ("get"+ ClassUtil.getMethodName ( 
					fields[i].getName() ), null ); 
				if (fields[i].getType().getName().equals("java.lang.String"))
				{
					sb.append ("'");
					sb.append (m.invoke(inObject,null)) ;
					sb.append ("'"); 
				}  
				sb.append(",");
			} 
			// last field 
			m = c.getMethod ( "get"+ ClassUtil.getMethodName ( 
				fields[fields.length-1].getName() ), null ) ; 
			if (fields[fields.length-1].getType().getName().equals("java.lang.String"))
			{
				sb.append ("'");
				sb.append (m.invoke(inObject,null)) ;
				sb.append ("'"); 
			} 
			sb.append(")");
		}
		catch( NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch( IllegalAccessException e)
		{
			e.printStackTrace();
		} 
		catch (InvocationTargetException ite) {
			ite.printStackTrace();
		}  
		return sb.toString() ;
	}

	public static String formSelectWhereQuery 
		( Object inObject,String columnName)
	{ 
		StringBuffer sb = null ; 
		Class c = inObject.getClass () ; 
		Field [] fields = c.getDeclaredFields () ;  
		
		if (fields.length == 0 )
		{
			return null ;
		}
		sb = new StringBuffer () ;	
		sb.append ( "Select * from " ) ;
		sb.append ( ClassUtil.getClassName (c.getName()) ) ; 
		sb.append ( " where " ) ; 
		sb.append ( columnName ) ; 
		sb.append (" =  ") ;
                Method m = null ;
		try
		{
			// n-1 fields
			
 				m = c.getMethod ("get"+ ClassUtil.getMethodName ( 
					fields[0].getName() ), null ); 
				if (ClassUtil.getMethodName ( 
					fields[0].getName()).equals(columnName))
				{
					sb.append ("'");
					sb.append (m.invoke(inObject,null)) ;
					sb.append ("'"); 
				}  
                               
				
			
		}
		catch( NoSuchMethodException e)
		{
			e.printStackTrace();
		}
                catch( IllegalAccessException e)
		{
			e.printStackTrace();
		} 
		catch (InvocationTargetException ite) {
			ite.printStackTrace();
		}  
                     
		System.out.println(sb.toString());
		return sb.toString() ;
	}
public static String formUpdateWhereQuery 
		( Object inObject, String columnName,String columnName1)
	     { 
		StringBuffer sb1 = null ; 
		Class d = inObject.getClass () ; 
		Field [] fields = d.getDeclaredFields () ;  
		if (fields.length == 0 )
		{
			return null ;
		}
		sb1 = new StringBuffer () ;	
		sb1.append ( "update  " ) ;
		sb1.append ( ClassUtil.getClassName (d.getName()) ) ; 
                sb1.append ( " set  " ) ; 
                  sb1.append(columnName);
                  sb1.append("=  ");       
		Method m = null ;
		try
		{
			// n-1 fields
			
 				m = d.getMethod ("get"+ ClassUtil.getMethodName ( 
					fields[1].getName() ), null ); 
				if (ClassUtil.getMethodName ( 
					fields[1].getName()).equals(columnName))
				{
					sb1.append ("'");
					sb1.append (m.invoke(inObject,null)) ;
					sb1.append ("'"); 
				}  
                               
				
			
		}
		catch( NoSuchMethodException e)
		{
			e.printStackTrace();
		}
                catch( IllegalAccessException e)
		{
			e.printStackTrace();
		} 
		catch (InvocationTargetException ite) {
			ite.printStackTrace();
		}  
                         
                sb1.append ( " where " ) ; 
		sb1.append ( columnName1 ) ; 
		sb1.append (" =  ") ;
                try
		{
			// n-1 fields
			
 				m = d.getMethod ("get"+ ClassUtil.getMethodName ( 
					fields[0].getName() ), null ); 
				
                                if (ClassUtil.getMethodName ( 
					fields[0].getName()).equals(columnName1))
				{
					sb1.append ("'");
					sb1.append (m.invoke(inObject,null)) ;
					sb1.append ("'"); 
				}  
				
			
		}
		catch( NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch( IllegalAccessException e)
		{
			e.printStackTrace();
		} 
		catch (InvocationTargetException ite) {
			ite.printStackTrace();
		}  
                
		System.out.println(sb1.toString());
		return sb1.toString() ;
	}

public static String formDeleteWhereQuery 
		( Object inObject,String columnName)
	{ 
		StringBuffer sb1 = null ; 
		Class d = inObject.getClass () ; 
		Field [] fields = d.getDeclaredFields () ;  
		
		if (fields.length == 0 )
		{
			return null ;
		}
		sb1 = new StringBuffer () ;	
		sb1.append ( "delete " ) ;		 
                sb1.append ( " from  " ) ; 
                sb1.append ( ClassUtil.getClassName (d.getName()) ) ;
                sb1.append ( " where " ) ;
                 sb1.append ( columnName ) ; 
                  sb1.append ( "= " ) ;
		Method m = null ;
		try
		{
			// n-1 fields
			
 				m = d.getMethod ("get"+ ClassUtil.getMethodName ( 
					fields[0].getName() ), null ); 
				if (ClassUtil.getMethodName ( 
					fields[0].getName()).equals(columnName))
				{
					sb1.append ("'");
					sb1.append (m.invoke(inObject,null)) ;
					sb1.append ("'"); 
				}  
				
			
		}
		catch( NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch( IllegalAccessException e)
		{
			e.printStackTrace();
		} 
		catch (InvocationTargetException ite) {
			ite.printStackTrace();
		}  
		
		System.out.println(sb1.toString());
		return sb1.toString() ;
	}
	public static void main ( String[] args )
	{
		EmployeeDetails user = 
			new EmployeeDetails (); 
		user.setEid ("1") ; 
		user.setEmployeeName ( "2" ) ; 
		user.setAddress ( "3" ) ; 
		user.setDesignation ( "4" ) ; 
		user.setPhnno ( "5" ) ; 
		user.setSalary ( "6" ) ; 
		
		QueryFormatter qf = new QueryFormatter () ;
		qf.formCreateQuery ( user ) ;
	}
}
