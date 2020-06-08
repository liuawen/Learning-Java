package cn.itcast.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Java JDK 里 W3C 的document解析方式
 * @author Administrator
 *
 */
public class JavaDocument {

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//先通过documentBuilderFactory创建一个documentBuilder的实例
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// documentBuilder专门用来解析xml文档。获得一个Document对象
		Document document = documentBuilder.parse(JavaDocument.class.getResourceAsStream("books.xml"));
		
		
		// 获取文档的字符编码 和 版本信息
		String xmlVersion = document.getXmlVersion();
		String xmlEncoding = document.getXmlEncoding();
		// 打印查看
		System.out.println("xml 文件的  [version=" + xmlVersion + " , encoding=" + xmlEncoding + "]");
		
		
		// 跟JavaScript获取标签对象一样，返回一个nodeList集合对象
		NodeList nodeList = document.getElementsByTagName("book");
		// 获取
		int bookElementSize = nodeList.getLength();
		// 遍历 所有book结点
		for (int i = 0; i < bookElementSize; i++) {
			//  获取每一个book标签对象
			Node bookNode = nodeList.item(i);
			// 获取标签名
			String bookNodeName = bookNode.getNodeName();
			System.out.println("第" + (i+1) + "标签名: " + bookNodeName);
			
			
			System.out.println(" 属 性 遍 历 ");
			
			// 获取属性结点集合
			NamedNodeMap bookNode_attributes = bookNode.getAttributes();
			// 获取属性长度
			int attribute_len = bookNode_attributes.getLength();
			for (int k = 0; k < attribute_len; k++) {
				Node attNode = bookNode_attributes.item(k);
				System.out.println(attNode.getNodeName() + "=" + attNode.getNodeValue());
			}
			
			////////////////////////////////
			///////// 空两行。方便 查看控制台打印内容 
			System.out.println();
			System.out.println();
			/////////////////////////////////
			
			System.out.println(" 结 点 遍 历 ");
			
			// 获取每一个book标签的子元素对象集合
			NodeList bookNode_childList = bookNode.getChildNodes();
			// 打印孩子结点的长度，发现，多了几个。
			int bookNode_childList_size = bookNode_childList.getLength();
			// 打印book标签孩子结点的长度
			System.out.println( bookNode_childList_size );
			// 遍历book标签对象的孩子结点
			for (int j = 0; j < bookNode_childList_size; j++) {
				//获取book标签对象中的每一个子结点
				Node bookNode_childNode = bookNode_childList.item(j);
				// 判断是否属于标签结点
				if ( bookNode_childNode.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("标签结点");
					// 获取结点的标签名
					String nodeTagName = bookNode_childNode.getNodeName();
					// 获取标签内的文本内容
					String node_innerHTML = bookNode_childNode.getTextContent();
					// 打印 遍历 内容 
					System.out.println(" 标签名: " + nodeTagName + " , innerHTML: " + node_innerHTML);
					
				} else if (bookNode_childNode.getNodeType() == Node.TEXT_NODE) {
					System.out.println("文本结点");
				}
				System.out.println();
			}

			System.out.println("#########################################################");
		}
		
	}

}
