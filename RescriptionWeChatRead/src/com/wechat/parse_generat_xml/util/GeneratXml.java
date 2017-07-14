package com.wechat.parse_generat_xml.util;

/**
 * 将开发者服务器发送的信息包装成XML格式
 * @author user
 *
 */
import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wechat.respond.util.ImageMessage;
import com.wechat.respond.util.MusicMessage;
import com.wechat.respond.util.NewsMessage;
import com.wechat.respond.util.TextMessage;
import com.wechat.respond.util.VideoMessage;
import com.wechat.respond.util.VoiceMessage;


public class GeneratXml {

	/*
	 * 对发送到微信服务器的数据进行包装成XML数据，对数据进行扩展
	 */
	private static XStream xStream = new XStream(new XppDriver() {

		public HierarchicalStreamWriter createWriter(Writer out) {

			return new PrettyPrintWriter(out) {

				// 对全部xml节点的转换都添加CDATA标记

				boolean cdata = true;

				public void startNode(String name, Class clazz) {

					super.startNode(name, clazz);

					if (name.equals("CreateTime")) {

						cdata = false;

					}

				}

				protected void writeText(QuickWriter writer, String text) {

					if (cdata) {

						writer.write("<![CDATA[");

						writer.write(text);

						writer.write("]]>");

					} else {

						writer.write(text);

					}

				}

			};

		}

	});
	
	
//	
//	private static String gereratXml(Class clazz, String econding) {
//		
//				String result = null;
//		
//				try {
//					JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
//					Marshaller marshaller = jaxbContext.createMarshaller();
//					marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//					marshaller.setProperty(Marshaller.JAXB_ENCODING, econding);
//					StringWriter writer = new StringWriter();
//					marshaller.marshal(clazz, writer);
//					result = writer.toString();
//				} catch (JAXBException e) {
//		
//					e.printStackTrace();
//				}
//		
//				return result;
//			}

	
	
	
	/**
	 * 使用xtream将javabean文件转化位xml格式的文件
	 * @param textMessage
	 * @return
	 */
	public static String messageToXML(TextMessage textMessage){
		
		xStream.alias("xml", textMessage.getClass());
		
		
	return xStream.toXML(textMessage);
	}
	
	
	
	/**
	 * 使用xtream将javabean文件转化位xml格式的文件
	 * 将文本文件转化位xml
	 * @param textMessage
	 * @return
	 */
	public static String messageToXML(MusicMessage musicMessage){
		
		xStream.alias("xml", musicMessage.getClass());
		
	return xStream.toXML(musicMessage);
	}
	
	
	
	/**
	 * 使用xtream将javabean文件转化位xml格式的文件
	 * 将图片信息转化为xml
	 * @param imageMessage
	 * @return
	 */
	public static String messageToXML(ImageMessage imageMessage){
		
		xStream.alias("xml", imageMessage.getClass());
		
	return xStream.toXML(imageMessage);
	}
	
	
	/**
	 * 使用xtream将javabean文件转化位xml格式的文件
	 * 将图文信息转化为xml
	 * 
	 * @param newsMessage
	 * @return
	 */
	public static String messageToXML(NewsMessage newsMessage){
		
		xStream.alias("xml", newsMessage.getClass());
		
	return xStream.toXML(newsMessage);
	}
	
	
	/**
	 * 使用xtream将javabean文件转化位xml格式的文件
	 * 将视频转化为xml
	 * @param videoMessage
	 * @return
	 */
	public static String messageToXML(VideoMessage videoMessage){
		
		xStream.alias("xml", videoMessage.getClass());
		
	return xStream.toXML(videoMessage);
	}
	
	
	/**
	 * 使用xtream将javabean文件转化位xml格式的文件
	 * 将语音转化为xml
	 * @param voiceMessage
	 * @return
	 */
	public static String messageToXML(VoiceMessage voiceMessage){
		
		xStream.alias("xml", voiceMessage.getClass());
		
	return xStream.toXML(voiceMessage);
	}
	
}
