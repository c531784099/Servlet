package uptoserver;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/***
 * GBK    UTF-8
 * 1\webӦ�õ��������ڣ�����web.xml ����servletcontext����   ��ʼ�����е�filter  ��ʼ��servlet ����
 * ����ʱ�׶Σ����е�servlet ��ʱ����
 * ���ٽ׶Σ�����servlet����   {���ȵ���destory()������������servlet����}������Filter��������servletcontext�ȶ���
 * 
 * servlet;��ʼ��1���ͻ����״η���  2����web.xml��ָ����servlet������˳��
 * servlet��ʼ������servlet��class�ļ����ص��ڴ桢����tomcat�ĵ�servlet���󡢴���servlet����
 * 
 * */
public class UploadServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String filePath;
	private String tempFilePath;
       
  

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//��servletconfig������servlet�������
		super.init(config);		
		//���web.xml�еĳ�ʼ������
		filePath=config.getInitParameter("filepath");
		tempFilePath=config.getInitParameter("tempfilepath");
		//�����ļ�ϵͳ�е���ʵ·��{�����ļ�ϵͳ�ľ���·��}
//		filePath=getServletContext().getRealPath(filePath);
//		tempFilePath=getServletContext().getRealPath(tempFilePath);	
		//�����ϸ��Ϣ
		System.out.println(filePath+"==="+tempFilePath);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����Ϣ����
		response.setContentType("text/plain");
		
		PrintWriter outinfo=response.getWriter();
		
		//��������Ӳ�̵�FielItem����
		
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(4*1024);//���ﻺ�����Ĵ�С���õ���4k
		factory.setRepository(new File(tempFilePath));//������ʱĿ¼		
		//����һ�� �ļ��ϴ�������
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setSizeMax(4*1024*1024);//�����ļ����ϴ���С  Ϊ4M		
		//��ñ�����������ͼ���
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items=upload.parseRequest(request);
			Iterator iter=items.iterator();//ʹ�õ�����
			while(iter.hasNext()){
				FileItem item=(FileItem) iter.next();
				if(item.isFormField()){//判断是否是表单域
				processFormField(item,outinfo);						
				}else{//非表单域   执行
				processUploadField(item,outinfo);
				}				
			}
			//关闭响应流
			outinfo.close();			
		} catch (FileUploadException e) {		
			e.printStackTrace();
		}		
	}

	//文件上传处理函数
	private void processUploadField(FileItem item, PrintWriter outinfo) {
		// TODO Auto-generated method stub
		String filename=item.getName();
		int index=filename.lastIndexOf("\\");//没有就会返回-1
		System.out.println("请求的文件名"+filename+"         index"+index);
		filename=filename.substring(index+1, filename.length());
		System.out.println(filename+"======");
		long filesize=item.getSize();
		
		if(filename.equals("")&&filesize==0) return; 
		
		File uploadFile=new File(filePath+"/"+filename);//数据保存在服务器上的地址和保存的文件名、
		
		try {
			//通过FileItem对象  将数据上传到服务器指定的位置
			item.write(uploadFile);
			//输出信息到  前台
			outinfo.println(filename+" is saved ..");
			outinfo.println("The Size Of "+filename+" is "+filesize+"\r\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

    //����Ĵ�����
	private void processFormField(FileItem item, PrintWriter outinfo) {
		//��ñ�����Ϣ
		String name=item.getFieldName();
		String value=item.getString();
		outinfo.println(name+":"+value+"\r\n");		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
