package com.missfresh.sahadev;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	private static DocumentBuilder db = null;

	public static void main(String[] args) throws Exception {

		initCheck(args);
	}

	private static void initCheck(String[] args) throws Exception {
		if (args.length < 2) {
			throw new Exception("请输入正确的读取文件路径与输出文件路径！");
		}
		runAnyWay(args);
	}

	private static void runAnyWay(String[] args) {
		final String inputFilePath = args[0];
		final String onputFilePath = args[1];
		try {
			exec(inputFilePath, onputFilePath);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exec(String inputPath, String outPath) throws Exception {

		if (outPath.equals(inputPath)) {
			throw new Exception("输入路径与输出路径不可相等，请检查确认！");
		}

		File outFile = new File(outPath);
		File inFile = new File(inputPath);

		if (!outFile.exists()) {

			File newOutFile = new File(outFile.getParentFile(), outFile.getName() + ".temp_css");
			if (outFile.renameTo(newOutFile)) {
				outFile = newOutFile;
			}
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		db = factory.newDocumentBuilder();

		Document parse = db.parse(inFile);

		NodeList elementsByTagName = parse.getElementsByTagName("view");
		writeClassByElements(outFile, elementsByTagName);

		elementsByTagName = parse.getElementsByTagName("input");
		writeClassByElements(outFile, elementsByTagName);

		elementsByTagName = parse.getElementsByTagName("image");
		writeClassByElements(outFile, elementsByTagName);
	}

	private static void writeClassByElements(File outFile, NodeList elementsByTagName) throws IOException {
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile, true)));

		for (int i = 0; i < elementsByTagName.getLength(); i++) {
			Node item = elementsByTagName.item(i);

			Node namedItem2 = item.getAttributes().getNamedItem("class");
			if (namedItem2 != null) {
				String namedItem = namedItem2.getTextContent();
				System.out.println("class => " + namedItem);
				bWriter.append("." + namedItem + "{}\n");
			}
		}

		bWriter.flush();
		bWriter.close();
	}

}
