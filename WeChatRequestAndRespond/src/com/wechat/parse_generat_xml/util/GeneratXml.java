
package com.wechat.parse_generat_xml.util;


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

/**
 * 将开发者服务器发送的信息包装成XML格式
 * @author user
 *
 */
public class GeneratXml {


	//扩展xstream实现对xml的转化的支持
 private static XStream xStream = new XStream(new XppDriver()){
	 
	 public HierarchicalStreamWriter createWriter(Writer out) {  
         return new PrettyPrintWriter(out) {  
             // 对那些xml节点的转换增加CDATA标记   true增加  false反之
             boolean cdata = true;  

             @SuppressWarnings("unchecked")  
             public void startNode(String name, Class clazz) {  

                 super.startNode(name, clazz);  
                
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

	 
 };
	
	
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
