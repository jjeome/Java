package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//DB에 접근하는 JDBC클래스
public class EmpDAO {
	//싱글톤 : db와의 연결을 이 instance만을 통해서 관리하도록.
	private static EmpDAO empDAO = null;
	private EmpDAO() {}
	//static이 붙으면 클래스에서 사용을 하든 안하든 인스턴스 하나랑 무조건 연결이 되어야함
	//불필요한 인스턴스가 생길 수 있기 때문에 아래처럼 만들어줌?
	//get메소드를 명확하게 호출하지 않는이상 EmpDAO인스턴스가 만들어지지 않음(정확히 사용할때만 쓰려고)
	public static EmpDAO getInstance() {
		if(empDAO == null) {
			//new연산자 하는 거에 제한두려고
			//필요할때만 실행하려고
			empDAO = new EmpDAO();
		}
		return empDAO;
	}
	
	//DAO-Oracle 연결 정보
	String jdbcDriver;
	String oracleUrl;
	String connectedId;
	String connectedPwd;
	
	//각 메소드에서 공통적으로 사용하는 필드(재사용하기 때문에)
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//-메소드1-
	public void connect() {
		dbConfig();
		//필드에 정보를 넣어 그걸 넘겨주는 방식
		try {
		//1.JDBC Driver 로딩
		Class.forName(jdbcDriver);
		//2.DB 서버 접속
		conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch(SQLException e) {
			System.out.println("DB 접속 실패");
		} 
	}
	//dao oracle 연결 정보를 properites에 저장해둔 것 불러오기
	private void dbConfig() {
		String resource = "config/db.properties"; //실제 물리적인 위치가 아님
		Properties properties = new Properties();
		
		try {
			//properties의 파일위ㅣ를 정확히 알거나 결과가 변동이 생길 때 사용해야함(classloader로 경로 찾아야함)
			//현재 실행되는 클래스 정보를 끌어올리는 것
			//물리적인 파일 위치 가지고 옴
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			//key와 value만 가지고 있으면 알아서 
			properties.load(new FileInputStream(filePath));//key와 value를 구성한 인스턴스 만드는것
		} catch(IOException e) {
			e.printStackTrace();
		}
		//properties에 있는 key값들 넘겨받기
		jdbcDriver = properties.getProperty("driver");
		oracleUrl  = properties.getProperty("url");
		connectedId  = properties.getProperty("id");
		connectedPwd  = properties.getProperty("password");
	}
	
	//-메소드2-
	//3.CRUD 실행 - 보통 5개의 메소드 -> 직접적인 연산과 출력 X -> 프로그램 안에서 별도로 연산일어남 따라서 리턴타입 잘 적어줘야함
	//전체조회 : list로 받아서 조회해주면 됨
	public List<Employee> selectAll(){
		List<Employee> list = new ArrayList<>();//리턴되는 타입있으면 타입에 맞는 변수를 만들어주기
		try {
			connect(); //DB와 연결
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees ORDER BY employee_id");
			while(rs.next()) {
				Employee emp = new Employee(); //employee클래스 만들기
				emp.setEmployeeId(rs.getInt("employee_id")); //한 컬럼의 값을 한 필드에 집어넣을때
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommission(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				
				list.add(emp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();//연결 된 후에는 끊어줘야 함(DB) - 동시접속 대기가 있으면 안되니까
		}
		return list; //그리고 리턴해주기
	}
	
	
	//단건조회 - 한개만 꺼내는 조건 : primary key
		public Employee selectOne(int employeeId) {
			Employee emp = null;
			try { 
				connect();
				String sql = "SELECT * FROM employees WHERE employee_id="+employeeId;//sql문에 조건 + 해줌
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				//반환값 하나 나오게 할 때 if문 쓰는것이 좋음
				if(rs.next()) {
					emp = new Employee();//emp값이 있을때만 인스턴스 만들기
					emp.setEmployeeId(rs.getInt("employee_id")); //한 컬럼의 값을 한 필드에 집어넣을때
					emp.setFirstName(rs.getString("first_name"));
					emp.setLastName(rs.getString("last_name"));
					emp.setEmail(rs.getString("email"));
					emp.setPhoneNumber(rs.getString("phone_number"));
					emp.setHireDate(rs.getDate("hire_date"));
					emp.setJobId(rs.getString("job_id"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setCommission(rs.getDouble("commission_pct"));
					emp.setManagerId(rs.getInt("manager_id"));
					emp.setDepartmentId(rs.getInt("department_id"));
				}
			} catch(SQLException e) {
				e.printStackTrace();//여기 비워두면 에러나면 그냥 종료됨 무조건 뭐라도 넣기
			} finally {
				disconnect();
			}
			return emp;
	}
	//등록 - 프로그램이 다 정보를 입력 받고 dao는 쿼리문으로 넣어주는것 -> VO객체를 매개변수로 받기
	public void insert(Employee emp) {
		try {
			connect();
			String sql = "INSERT INTO employees VALUE(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId()); //insert sql문안에 int타입인 1000으로 첫번재 물음표를 대체한다는 뜻(타입(몇번째,값))
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHireDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setDouble(8, emp.getSalary());
			pstmt.setDouble(9, emp.getCommission());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());
			
			int result = pstmt.executeUpdate();//db로 쿼리 넘어가기위해서 꼭 해주기!
			
			if(result>0) {
				System.out.println("등록이 완료되었습니다.");
			} else {
				System.out.println("등록되지 않았습니다.");
			}
			System.out.println(result+"건이 완료되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//수정
	public void update(Employee emp) {
		try {
			connect();
			String sql = "UPDATE employees SET salary = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, emp.getEmployeeId()); 
			pstmt.setDouble(1, emp.getSalary());
			
			int result = pstmt.executeUpdate();//db로 쿼리 넘어가기위해서 꼭 해주기!
			
			if(result>0) {
				System.out.println("수정이 완료되었습니다.");
			} else {
				System.out.println("수정되지 않았습니다.");
			}
			System.out.println(result+"건이 완료되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
		
	//삭제 - 기본키가 되는 애를 매개변수에 
	public void delete(int employeeId) {
		try {
			connect();
			String sql = "DELETE FROM employees WHERE employee_id"+employeeId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
	}
		
	//-메소드3-
	//4.자원해제
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
