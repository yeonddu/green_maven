package com.myspring.pro28.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*@Controller*/
public class FileDownloadController {
	//������ ���� ��ġ ����
	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	
	@RequestMapping("/download")
	//�ٿ�ε��� �̹��� ���� �̸��� param(����)
	protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		
		OutputStream out = response.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		
		//�ٿ�ε��� ���� ��ü �����ϱ�
		File file = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		//����� �����̸� ����
		response.addHeader("Content-disposition", "attachment: fileName=" + imageFileName);
		
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024*8];
		
		//���۸� �̿��� �ѹ��� 8Kbyte�� �������� ����
		while(true) {
			int count = in.read(buffer);
			System.out.println(count);
			if(count == -1 )
				break;
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}

}
