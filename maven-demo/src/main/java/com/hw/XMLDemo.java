package com.hw;

import org.dom4j.*;

import java.util.Iterator;
import java.util.List;

public class XMLDemo {
    public static void main(String[] args) {
        String xmlStr =
                "<cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>\n" +
                "\t<cas:authenticationSuccess>\n" +
                "\t\t<cas:user>26092023</cas:user>\n" +
                "\t\t<cas:attributes>\n" +
                "\t\t\t<cas:fid>1234</cas:fid>\n" +
                "\t\t\t<cas:isFromNewLogin>true</cas:isFromNewLogin>\n" +
                "\t\t\t<cas:authenticationDate>2023-09-27T17:38:45.632+08:00[Asia/Shanghai]</cas:authenticationDate>\n" +
                "\t\t\t<cas:successfulAuthenticationHandlers>CustomAuthenticationHandler</cas:successfulAuthenticationHandlers>\n" +
                "\t\t\t<cas:xb></cas:xb>\n" +
                "\t\t\t<cas:bm></cas:bm>\n" +
                "\t\t\t<cas:credentialType>CustomUsernamePasswordCredential</cas:credentialType>\n" +
                "\t\t\t<cas:xm></cas:xm>\n" +
                "\t\t\t<cas:authenticationMethod>CustomAuthenticationHandler</cas:authenticationMethod>\n" +
                "\t\t\t<cas:xgh></cas:xgh>\n" +
                "\t\t\t<cas:longTermAuthenticationRequestTokenUsed>false</cas:longTermAuthenticationRequestTokenUsed>\n" +
                "\t\t\t<cas:sflb>1</cas:sflb>\n" +
                "\t\t</cas:attributes>\n" +
                "\t</cas:authenticationSuccess>\n" +
                "</cas:serviceResponse>";
        try {
            Document document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            //返回包含子元素的迭代器
            Iterator rootIt = root.elementIterator();
            Element authenticationSuccessElement = (Element) rootIt.next();
            List<Element> userElements = authenticationSuccessElement.selectNodes("cas:user");
            String userName = (String)userElements.get(0).getData();
            System.out.println(userName);

//                Element stu = (Element) iterator.next();
//            Iterator student1It = studentElement1.elementIterator();
//            Element element2 = (Element) student1It.next();
//            Object data = element2.getData();
//            System.out.println(data);



        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
