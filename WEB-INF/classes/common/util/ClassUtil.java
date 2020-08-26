package common.util ;

import java.util.StringTokenizer ;

public class ClassUtil
{
	public static String getClassName ( String fqClassName )
	{
		StringTokenizer st = 
			new StringTokenizer ( fqClassName, "." ) ;
		String token = null ;
		while(st.hasMoreTokens())
			token = st.nextToken();
		return token ;
	}
	public static void main ( String [] args )
	{
		System.out.println(getClassName("common.data.EmployeeDetails"));
	}
	public static String getMethodName ( String mName )
	{  
		return	Character.toUpperCase( mName.charAt(0) ) + 
				mName.substring (1) ;
	}
}
