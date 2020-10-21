package com.jiseung.s3.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiseung.s3.MyTestCase;
import com.jiseung.s3.notice.NoticeDTO;

public class QnADAOTest extends MyTestCase{

	@Autowired
	private QnADAO qnADAO;

	
	
	//@Test
	public void qnaWriteTest()throws Exception{
		QnADTO qnaDTO = new QnADTO();
		qnaDTO.setTitle("test title2");
		qnaDTO.setWriter("test Writer2");
		qnaDTO.setContents("test Contents2");
		int result = qnADAO.qnaWrite(qnaDTO);
		
	assertNotEquals(0, result);
	}
	
	//@Test
	public void qnaReplyTest() throws Exception{
			//답글
				QnADTO child = new QnADTO();
				child.setTitle("Test Reply Title 5");
				child.setWriter("Test Reply Writer 5");
				child.setContents("Test Reply Contents 5");
				
				
				//부모글 정보
				QnADTO parent = qnADAO.qnaSelect(15);
				
				//update
				
				qnADAO.qnaReplyUpdate(parent);

				//부모글의 정보로 답글에 정보를 입력
				
				//ref는 부모의 ref
				child.setRef(parent.getRef());
				child.setStep(parent.getStep()+1);
				child.setDepth(parent.getDepth()+1);
				
				
				int result = qnADAO.qnaReply(child);
				assertNotEquals(0, result);
				//assertNotNull(parent);
	}
	
	
	
		@Test
		public void QnAWriteTest() throws Exception{
			
			for(int i=0;i<100;i++) {
				QnADTO qnaDTO = new QnADTO();
				qnaDTO.setTitle("Title"+i);
				qnaDTO.setContents("Contentsv-_-v "+i);
				qnaDTO.setWriter("jung"+i);
				int result = qnADAO.qnaWrite(qnaDTO);
				
				if(i%10==0) {
					Thread.sleep(1000);
				}
			}
			
		}
	

}
