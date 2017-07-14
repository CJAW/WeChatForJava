package com.wechat.parse_generat_xml.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * 开发者服务器解析微信服务器发来的XML数据
 * @author user
 *
 */

public class ParseXml {

	public static Map<String, String> parseXml(HttpServletRequest request){

		
		Map<String, String> map = null;
//		// 读取流
//		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//		try {
//			request.setCharacterEncoding("UTF-8");
//			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//			// 使用流从request中读取XML文件
//			Document document = documentBuilder.parse(request.getInputStream());
//			// 获得xml的头节点
//			Element root = document.getDocumentElement();
//			//获取头节点的名字
//			//String rootName = root.getNodeName();
//			// 获得所有的子节点
//			NodeList list = root.getChildNodes();
//
//			for (int i = 0; i < list.getLength(); i++) {
//
//				//获取节点
//				Node node = list.item(i);
//				//获取节点名字
//				String name = node.getNodeName();
//				//获取节点的value
//				String value = node.getNodeValue();
//				
//				map.put(name, value);
//			}
//			
//					
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try {
			
		    map = new HashMap<String,String>();
			SAXReader reader = new SAXReader();
			org.dom4j.Document document = reader.read(request.getInputStream());
			//获取跟节点
			org.dom4j.Element root =document.getRootElement();
			//获取所有的子节点
			java.util.List<org.dom4j.Element> list = root.elements();
			//遍历所有的子节点
			for(org.dom4j.Element e : list){
				map.put(e.getName(), e.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return map;
		
	}
	
	
}
