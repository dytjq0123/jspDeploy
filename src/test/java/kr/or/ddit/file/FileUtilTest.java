package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileUtilTest {
	
	private String fileName;
	

	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"uploadFile\"; filename=\"brown.png\"";

		/***When***/
		String fileName = FileUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", fileName);

	}

}
