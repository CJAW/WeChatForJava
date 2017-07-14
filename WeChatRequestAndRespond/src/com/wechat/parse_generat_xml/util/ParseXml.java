package com.wechat.parse_generat_xml.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 开发者服务器解析微信服务器发来的XML数据
 * @author user
 *
 */

public class ParseXml {

	public static Map<String, String> parseXml(HttpServletRequest request){

		Map<String, String> map = new HashMap<String,String>();
		// 读取流
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			// 使用流从request中读取XML文件
			Document document = documentBuilder.parse(request.getInputStream());
			// 获得xml的头节点
			Element root = document.getDocumentElement();
			//获取头节点的名字
			//String rootName = root.getNodeName();
			// 获得所有的子节点
			NodeList list = root.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {

				//获取节点
				Node node = list.item(i);
				//获取节点名字
				String name = node.getNodeName();
				//获取节点的value
				String value = node.getNodeValue();
				
				map.put(name, value);
			}
			
					
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
		
	}
	
	
}
