package kr.or.ddit.student.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	
	private StudentServiceInf stdService;
	
	// @Before --> @Test --> @After
	
	// 테스트 메서드안에 중복되는 내용 : StudentService 구현체에 대한 생성 로직
	//	--> @Before 어노테이션이 붙은 setup 메서드에 위임
	// 모든 테스트 메서드에서 StudentService 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
	// 클래스 변수를 setup메서드에서 초기화하는 로직이 필요
	// 테스트 메서드에서 StudnetService를 생성하는 로직은 삭제
	
	@Before
	public void setup(){
		stdService = new StudentService();
	}

	/**
	* Method : selectAllStudentsTest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 전체 학생 정보 조회 테스트
	*/
	@Test
	public void selectAllStudentsTest() {
		/***Given***/

		/***When***/
		List<StudentVo> stdList = stdService.selectAllStudents();
		
		for(StudentVo vo : stdList){
			System.out.println(vo);
		}

		/***Then***/
		assertEquals(25, stdList.size()); 

	}
	
	@Test
	public void selectStudentTest1() {
		/***Given***/
		int id = 1;
		
		/***When***/
		StudentVo studentVo = stdService.getStudent(id);
		
		System.out.println(studentVo.getId());
		System.out.println(studentVo.getName());
		System.out.println(studentVo.getCall_cnt());
		/***Then***/
		assertEquals(1, studentVo.getId());
		assertEquals("김마음", studentVo.getName());
		assertEquals(0, studentVo.getCall_cnt());

	}
	
	@Test
	public void selectStudentTest2() {
		/***Given***/
		StudentVo studentVo = new StudentVo();
		int id = 1;
		studentVo.setId(id);

		/***When***/
		StudentVo studentVo2 = stdService.getStudent(studentVo);
		
		System.out.println(studentVo2.getId());
		System.out.println(studentVo2.getName());
		System.out.println(studentVo2.getCall_cnt());

		/***Then***/
		assertEquals(1, studentVo2.getId());
		assertEquals("김마음", studentVo2.getName());
		assertEquals(0, studentVo2.getCall_cnt());

	}
	
	@Test
	public void getStudentPageListTest(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		int page = 2;
		int pageSize = 10;
		map.put("page", page);
		map.put("pageSize", pageSize);

		/***When***/
		Map<String, Object> resultMap = stdService.getStudentPageList(map);
		
		// 학생 페이지 리스트
		List<StudentVo> studentList = (List<StudentVo>)resultMap.get("pageList");
		
		// 학생 전체 건수
		int totCnt = (int) resultMap.get("totCnt");
		/***Then***/
		assertEquals(10, studentList.size());	// 학생 페이지 리스트 건수에 대한 검증
		assertEquals(25, totCnt);				// 학생 전체 건수에 대한 검증

	}
	
	@Test
	public void getStudentPageListTest2(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		int page = 3;
		int pageSize = 10;
		map.put("page", page);
		map.put("pageSize", pageSize);

		/***When***/
		Map<String, Object> resultMap = stdService.getStudentPageList(map);
		
		// 학생 페이지 리스트
		List<StudentVo> studentList = (List<StudentVo>)resultMap.get("pageList");
		
		// 학생 전체 건수
		int totCnt = (int) resultMap.get("totCnt");
		
		for(int i = 0; i < studentList.size(); i++){
			System.out.print("ID : " + studentList.get(i).getId() + "\t");
			System.out.println("NAME : " + studentList.get(i).getName() + " rownum : " +  (int)(i+1));
		}
		/***Then***/
		assertEquals(5, studentList.size());	// 학생 페이지 리스트 건수에 대한 검증
		assertEquals(25, totCnt);				// 학생 전체 건수에 대한 검증

	}
	
	
	/**
	* Method : calculatePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 전체 건수를 인자로 페이지 네비게이션 사이즈를 구하는 테스트
	*/
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;
		
		int cnt = totCnt / pageSize;		// 몫
		int mod = totCnt % pageSize;		// 나머지
		
		if(mod > 0){
			cnt++;
		}

		/***When***/
		double naviSize = (totCnt / pageSize);
		System.out.println(Math.ceil(naviSize));
		System.out.println(Math.floor(totCnt / pageSize));
		
		/***Then***/
	}
	
	@Test
	public void studentUpdateTest(){
		/***Given***/
		StudentVo studentVo = new StudentVo();
		studentVo.setId(23);
		studentVo.setName("김요섭");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
		studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		studentVo.setZipcd("34940");
		studentVo.setPic("brown.png");
		studentVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");
		studentVo.setPicname("385a2c82-9fe8-44b8-a987-96fa8cdde652");

		/***When***/
		int cnt = stdService.studentUpdate(studentVo);
		

		/***Then***/
		assertEquals(1, cnt);

	}

}
