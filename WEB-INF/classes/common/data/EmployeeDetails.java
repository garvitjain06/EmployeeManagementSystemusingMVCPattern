package common.data ;

/*
	Create Table EmployeeDetails
	(
		Eid   varchar(10),
		EmployeeName  varchar(30),
		Address   varchar(70),
		Designation   varchar(70),	
		Phnno	   varchar(10),
		Salary	   varchar(10)	
		
	);	 
*/

public class EmployeeDetails
{
	
	private String  Eid		;
        private String EmployeeName	;
	private String Address		;
        private String Designation	;
	private String Phnno		;	 
	private String Salary		;
	
	

	public String getEid ()		{ return Eid ;	}
	public String getEmployeeName ()	{ return  EmployeeName ; }
	public String getAddress ()	{ return Address ; }
	
	public String getDesignation ()		{ return Designation ;		}
	
	public String getPhnno ()		{ return Phnno ;	} 
	public String getSalary ()	{ return Salary ;	}

	public void setEid  ( String Eid )			{ this.Eid = Eid ;	}  
	public void setEmployeeName ( String EmployeeName )	{ this.EmployeeName = EmployeeName  ; }  
	public void setAddress ( String Address )		{ this.Address = Address ;	}  
	public void setDesignation ( String Designation )		{ this.Designation = Designation ;	}  
	
	public void setPhnno ( String Phnno )			{ this.Phnno = Phnno ;	}  
	 public void setSalary ( String Salary)				{ this.Salary = Salary ;		} 
	

	
	public String toString()
	{
		return        Eid + "," +  EmployeeName + "," + Address + "," +  Designation
				+ "," + Phnno + "," + Salary ;
	}
}
