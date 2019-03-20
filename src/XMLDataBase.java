import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Vector;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLDataBase

{
    DocumentBuilderFactory docBuilderFactory;
    DocumentBuilder docBuilder;
    Document doc;

      public XMLDataBase()
      {
          try
          {
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc= docBuilder.parse (new File("login.xml"));
          }
          catch(Exception e)
          {
              System.out.println("error in XMLDataBase()");
              e.printStackTrace();
          }
      }

      public void editDB(String password,String priv,String name)
      {
          try
          {
              Node face =doc.getFirstChild();
             Element login =doc.createElement("login");

             Element pass =doc.createElement("pass");           
             pass.setTextContent(password);           
             login.appendChild(pass);

             Element privillage =doc.createElement("privillage");
             privillage.setTextContent(priv);
             login.appendChild(privillage);

             Element uname =doc.createElement("uname");
             uname.setTextContent(name);
             login.appendChild(uname);
             face.appendChild(login);

             Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");


            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            String xmlString = result.getWriter().toString();
            System.out.println(xmlString);

        FileOutputStream f0;
	byte buf[] = xmlString.getBytes();
	f0 = new FileOutputStream("login.xml");
	for(int i=0;i<buf .length;i++) {
	   f0.write(buf[i]);
	}
	f0.close();



          }
          catch(Exception e)
          {
              System.out.println("error in editDB()");
              e.printStackTrace();
          }
      }

      public Vector dispDB()
      {
          Vector v= new Vector();

          try {
           // normalize text representation
            doc.getDocumentElement ().normalize ();
            System.out.println ("Root element of the doc is " +
                 doc.getDocumentElement().getNodeName());


            NodeList listOfPersons = doc.getElementsByTagName("login");
            int totalPersons = listOfPersons.getLength();
            System.out.println("Total no of people : " + totalPersons);

            for(int s=0; s<listOfPersons.getLength() ; s++)
            {
                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {


                    Element firstPersonElement = (Element)firstPersonNode;

                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("pass");
                    Element firstNameElement = (Element)firstNameList.item(0);

                    NodeList textFNList = firstNameElement.getChildNodes();
                    System.out.println("pass: " +
                           ((Node)textFNList.item(0)).getNodeValue().trim());

                    //-------
                    NodeList lastNameList = firstPersonElement.getElementsByTagName("privillage");
                    Element lastNameElement = (Element)lastNameList.item(0);

                    NodeList textLNList = lastNameElement.getChildNodes();
                    System.out.println("privillage: " +
                           ((Node)textLNList.item(0)).getNodeValue().trim());


                    NodeList ageList = firstPersonElement.getElementsByTagName("uname");
                    Element ageElement = (Element)ageList.item(0);

                    NodeList textAgeList = ageElement.getChildNodes();
                    System.out.println("uname : " +
                           ((Node)textAgeList.item(0)).getNodeValue().trim());
                    v.add(((Node)textAgeList.item(0)).getNodeValue().trim());
                }
            }
        }
          catch (Exception e)
          {
              System.out.println("error in dispDB()");
              e.printStackTrace();
          }
          return v;
    }

      public boolean logincheck(String name,String pword)
      {
          boolean flag=false;

           NodeList listOfPersons = doc.getElementsByTagName("login");


            for(int i=0;i<listOfPersons.getLength();i++)
            {
                 Node firstPersonNode = listOfPersons.item(i);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;

                    //-------
                    NodeList pass = firstPersonElement.getElementsByTagName("pass");
                    Element password = (Element)pass.item(0);
                    NodeList textFNList = password.getChildNodes();
                    String p=((Node)textFNList.item(0)).getNodeValue().trim();

                    NodeList uname = firstPersonElement.getElementsByTagName("uname");
                    Element username = (Element)uname.item(0);                   
                    textFNList = username.getChildNodes();
                    String u=((Node)textFNList.item(0)).getNodeValue().trim();

                     System.out.println("username==>"+u);
                     System.out.println("password==>"+p);
                    if(u.equals(name.trim()) && p.equals(pword.trim()))
                    {
                        flag=true;
                        break;
                    }
                }
            }

          return flag;
      }

      public Vector getdata(String name)
      {
          Vector v = null;

           try {

            NodeList listOfPersons = doc.getElementsByTagName("login");

            for(int s=0; s<listOfPersons.getLength() ; s++)
            {
               
                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("uname");
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    String un=((Node)textFNList.item(0)).getNodeValue().trim();
                    System.out.println("uname: " +((Node)textFNList.item(0)).getNodeValue().trim());
                   if(un.equals(name))
                   {
                      v=new Vector();
                      v.add(un);

                      NodeList priv = firstPersonElement.getElementsByTagName("privillage");
                      Element lastNameElement = (Element)priv.item(0);
                      NodeList textLNList = lastNameElement.getChildNodes();
                      String pr=((Node)textLNList.item(0)).getNodeValue().trim();
                      System.out.println("privillage: " +((Node)textLNList.item(0)).getNodeValue().trim());
                      v.add(pr);

                      NodeList pword = firstPersonElement.getElementsByTagName("pass");
                      Element ageElement = (Element)pword.item(0);
                      NodeList textAgeList = ageElement.getChildNodes();
                      String pw=((Node)textAgeList.item(0)).getNodeValue().trim();
                      System.out.println("pass : " +((Node)textAgeList.item(0)).getNodeValue().trim());
                      v.add(pw);
                   }
                }
            }
        }
          catch (Exception e)
          {
              System.out.println("error in getdata()");
              e.printStackTrace();
          }

          return v;
      }

    public boolean passChange(String uname,String pass)
    {
        boolean flag =false;

        try {

            NodeList listOfPersons = doc.getElementsByTagName("login");
            for(int s=0; s<listOfPersons.getLength() ; s++)
            {

                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("uname");
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    String un=((Node)textFNList.item(0)).getNodeValue().trim();
                    System.out.println("uname: " +((Node)textFNList.item(0)).getNodeValue().trim());
                   if(un.equals(uname))
                   {
                      NodeList pword = firstPersonElement.getElementsByTagName("pass");
                      Element password = (Element)pword.item(0);
                      password.setTextContent(pass);
                      flag=true;
                   }
                }
            }

              Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");


            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            String xmlString = result.getWriter().toString();
            System.out.println(xmlString);

        FileOutputStream f0;
	byte buf[] = xmlString.getBytes();
	f0 = new FileOutputStream("login.xml");
	for(int i=0;i<buf .length;i++) {
	   f0.write(buf[i]);
	}
	f0.close();


        }
          catch (Exception e)
          {
              System.out.println("error in getdata()");
              e.printStackTrace();
          }
        return flag;
    }

    public boolean privChange(String uname,String priv)
    {
        boolean flag =false;

        try {

            NodeList listOfPersons = doc.getElementsByTagName("login");
            for(int s=0; s<listOfPersons.getLength() ; s++)
            {

                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("uname");
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    String un=((Node)textFNList.item(0)).getNodeValue().trim();
                    System.out.println("uname: " +((Node)textFNList.item(0)).getNodeValue().trim());
                   if(un.equals(uname))
                   {
                      NodeList pword = firstPersonElement.getElementsByTagName("privillage");
                      Element password = (Element)pword.item(0);
                      password.setTextContent(priv);
                      flag=true;
                   }
                }
            }

              Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");


            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            String xmlString = result.getWriter().toString();
            System.out.println(xmlString);

        FileOutputStream f0;
	byte buf[] = xmlString.getBytes();
	f0 = new FileOutputStream("login.xml");
	for(int i=0;i<buf .length;i++) {
	   f0.write(buf[i]);
	}
	f0.close();


        }
          catch (Exception e)
          {
              System.out.println("error in getdata()");
              e.printStackTrace();
          }
        return flag;
    }



      public static void main (String argv [])
    {
       
      
    }


}