package com.myspring.pro28.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	
	//uploadForm.jsp �� �̵�
	@RequestMapping(value="/form")
		public String form() {
			return "uploadForm";
		}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		
		//�Ű����� ������ ���� ������ ������ Map ����
		Map map = new HashMap();
		
		Enumeration enu = multipartRequest.getParameterNames(); //id, name, file1, 2, 3 ...
		
		//���۵� �Ű����� ���� key/value�� map�� ���� 
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();  //id, name, file1, 2, 3 ...
			String value = multipartRequest.getParameter(name);  //id, name, file1, 2, 3 ...�� �ش��ϴ� value��
			System.out.println(name +"," + value);
			map.put(name, value);
		}
		
		//������ ���ε��� �� ��ȯ�� ���� �̸��� ����Ǵ� fileList�� �ٽ� map�� ����
		List fileList = fileProcess(multipartRequest);
		map.put("fileList", fileList);
		
		ModelAndView mav = new ModelAndView();
		
		//map�� ���â���� ������
		mav.addObject("map", map);
		
		mav.setViewName("result");
		
		return mav;
	}
	
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception {
		List<String> fileList = new ArrayList<String>();
		
		//÷�ε� ���� �̸� ��������
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();			
			System.out.println("fileName: " + fileName);
			
			//���� �̸��� ���� MultipartFile ��ü ��������
			MultipartFile mFile = multipartRequest.getFile(fileName);
			System.out.println("mFile: "+ mFile);
			
			//���� ���� �̸� ��������
			String originalFileName = mFile.getOriginalFilename();
			System.out.println("originalFileName: " + originalFileName);
			
			//���� �̸��� �ϳ��� fileList�� �����ϱ�
			fileList.add(originalFileName);
			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
			
			//÷�ε� ������ �����ϴ��� üũ
			if(mFile.getSize() != 0) {
				//��λ� ������ �������� ���� ���
				if(! file.exists()) {
					//��ο� �ش��ϴ� ���丮 �����
					if(file.getParentFile().mkdirs()) {
						//���� ����
						file.createNewFile();
					}
				}
				//�ӽ÷� ����� multipartFile�� ���� ���Ϸ� ����
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + originalFileName));
			}
		}
		//÷���� ���� �̸��� ����� fileList ��ȯ
		return fileList;
		
	}
	
}
