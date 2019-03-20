
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
public class RecordDB
{
    DocumentBuilderFactory docBuilderFactory;
          DocumentBuilder docBuilder;
          Document doc;
        
      public RecordDB()
      {

          try
          {
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc= docBuilder.parse (new File("record.xml"));
          }
          catch(Exception e)
          {
              System.out.println("error in RecordDB()");
              e.printStackTrace();
          }
      }

      public void editDB(String n,String ag,String g,String ph,String em)
      {
          try
          {
              Node face =doc.getFirstChild();
             Element record =doc.createElement("record");

             Element rid =doc.createElement("id");
             rid.setTextContent(Integer.toString(getLastID()+1));
             record.appendChild(rid);

             Element name =doc.createElement("name");
             name.setTextContent(n);
             record.appendChild(name);

             Element age =doc.createElement("age");
             age.setTextContent(ag);
             record.appendChild(age);

             Element gender =doc.createElement("gender");
             gender.setTextContent(g);
             record.appendChild(gender);

             Element phone =doc.createElement("phone");
             phone.setTextContent(ph);
             record.appendChild(phone);

             Element email =doc.createElement("email");
             email.setTextContent(em);
             record.appendChild(email);

             face.appendChild(record);

             Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");


            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            String xmlString = result.getWriter().toString();
            System.out.println(xmlString);

        FileOutputStream f0;
	byte buf[] = xmlString.getBytes();
	f0 = new FileOutputStream("record.xml");
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
      
      public Vector getAllIDs()
      {
        Vector v= new Vector();
        v.add("SELECT");
        
          try {
           // normalize text representation
           
            NodeList listOfPersons = doc.getElementsByTagName("record");
            

            for(int s=0; s<listOfPersons.getLength() ; s++)
            {
                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                  
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("id");
                    Element firstNameElement = (Element)firstNameList.item(0);

                    NodeList textFNList = firstNameElement.getChildNodes();
                    v.add(((Node)textFNList.item(0)).getNodeValue().trim());
                   
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

      public int getLastID()
      {
        int id=0;

          try {
           // normalize text representation

            NodeList listOfPersons = doc.getElementsByTagName("record");


            for(int s=0; s<listOfPersons.getLength() ; s++)
            {
                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("id");
                    Element firstNameElement = (Element)firstNameList.item(0);

                    NodeList textFNList = firstNameElement.getChildNodes();
                    id=Integer.parseInt(((Node)textFNList.item(0)).getNodeValue().trim());

                }
            }
        }
          catch (Exception e)
          {
              System.out.println("error in dispDB()");
              e.printStackTrace();
          }
          return id;
      }

      public Vector getdata(String id)
      {
          Vector v = null;

           try {

            NodeList listOfPersons = doc.getElementsByTagName("record");

            for(int s=0; s<listOfPersons.getLength() ; s++)
            {

                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("id");
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    String un=((Node)textFNList.item(0)).getNodeValue().trim();
                    System.out.println("uname: " +((Node)textFNList.item(0)).getNodeValue().trim());
                   if(un.equals(id))
                   {
                      v=new Vector();


                      NodeList nam = firstPersonElement.getElementsByTagName("name");
                      Element NameElement = (Element)nam.item(0);
                      NodeList NList = NameElement.getChildNodes();

                      String name=((Node)NList.item(0)).getNodeValue().trim();
                      v.add(name);

                      NodeList ag = firstPersonElement.getElementsByTagName("age");
                      Element lastNameElement = (Element)ag.item(0);
                      NodeList textLNList = lastNameElement.getChildNodes();
                      String age=((Node)textLNList.item(0)).getNodeValue().trim();                     
                      v.add(age);

                      NodeList gen = firstPersonElement.getElementsByTagName("gender");
                      Element g = (Element)gen.item(0);
                      NodeList genlist = g.getChildNodes();
                      String gender=((Node)genlist.item(0)).getNodeValue().trim();
                      v.add(gender);

                      NodeList ph = firstPersonElement.getElementsByTagName("phone");
                      Element p = (Element)ph.item(0);
                      NodeList plist = p.getChildNodes();
                      String phon=((Node)plist.item(0)).getNodeValue().trim();                      
                      v.add(phon);

                       NodeList em = firstPersonElement.getElementsByTagName("email");
                      Element e = (Element)em.item(0);
                      NodeList emlist = e.getChildNodes();
                      String email=((Node)emlist.item(0)).getNodeValue().trim();                     
                      v.add(email);
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



      public void editDATA(String id,String name,String age,String gen,String ph,String em)
      {
        try {

            NodeList listOfPersons = doc.getElementsByTagName("record");

            for(int s=0; s<listOfPersons.getLength() ; s++)
            {

                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("id");
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    String un=((Node)textFNList.item(0)).getNodeValue().trim();
                    System.out.println("id: " +((Node)textFNList.item(0)).getNodeValue().trim());
                   if(un.equals(id))
                   {
                       NodeList ppp = firstPersonElement.getElementsByTagName("name");
                       Element ddd = (Element)ppp.item(0);
                       ddd.setTextContent(name);

                       ppp = firstPersonElement.getElementsByTagName("age");
                       ddd = (Element)ppp.item(0);
                       ddd.setTextContent(age);

                       ppp = firstPersonElement.getElementsByTagName("gender");
                       ddd = (Element)ppp.item(0);
                       ddd.setTextContent(gen);

                       ppp = firstPersonElement.getElementsByTagName("phone");
                       ddd = (Element)ppp.item(0);
                       ddd.setTextContent(ph);

                       ppp = firstPersonElement.getElementsByTagName("email");
                       ddd = (Element)ppp.item(0);
                       ddd.setTextContent(em);
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
	f0 = new FileOutputStream("record.xml");
	for(int i=0;i<buf .length;i++) {
	   f0.write(buf[i]);
	}
	f0.close();

        }
          catch (Exception e)
          {
              System.out.println("error in editDATA()");
              e.printStackTrace();
          }
      }

       public void delete(String id)
      {
          

           try {

            NodeList listOfPersons = doc.getElementsByTagName("record");

            for(int s=0; s<listOfPersons.getLength() ; s++)
            {

                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("id");
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    String un=((Node)textFNList.item(0)).getNodeValue().trim();
                    System.out.println("uname: " +((Node)textFNList.item(0)).getNodeValue().trim());
                   if(un.equals(id))
                   {

                       NodeList recel = doc.getElementsByTagName("record");
                      Element ele = (Element)recel.item(s);
                      ele.getParentNode().removeChild(ele);           
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
	f0 = new FileOutputStream("record.xml");
	for(int i=0;i<buf .length;i++) {
	   f0.write(buf[i]);
	}
	f0.close();
        }
          catch (Exception e)
          {
              System.out.println("error in delete()");
              e.printStackTrace();
          }


      }
      

         public static void main (String argv [])
    {
       RecordDB rdb= new RecordDB();
   
       rdb.delete("4");
    }

}
