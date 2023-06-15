package org.ncu.employee_app.entity;

public class groupEmp {
	private int count;
	private String addr;
	
		public groupEmp() {
		super();
	}

		
	public int getCount() {
			return count;
		}


		public void setCount(int count) {
			this.count = count;
		}



		public String getAddr() {
			return addr;
		}




		public void setAddr(String addr) {
			this.addr = addr;
		}






	@Override
	public String toString() {
		return "groupEmp [count=" + count + ", addr=" + addr + "]";
	}
	
	

}
