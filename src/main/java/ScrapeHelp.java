import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.text.html.HTML;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ScrapeHelp//Cpus "m_all","R_all","s_all","F_all","f_all","k_all","g_all","h_all","e_all"
{
    public Document doc = null;
    WebClient webClient = new WebClient(BrowserVersion.CHROME);
    public HtmlPage htmlPage = null;
    public ScrapeHelp(String URL,ArrayList<String> Buttons) throws IOException, InterruptedException
    {
        webClient.getOptions().setJavaScriptEnabled(true);
        htmlPage = webClient.getPage(URL);
        htmlPage = InitializePCPartPickerPage(htmlPage,Buttons);
        this.doc= Jsoup.parse(htmlPage.asXml());
    }
    public HtmlPage InitializePCPartPickerPage(HtmlPage Out, ArrayList<String> Buttons) throws InterruptedException
    {
        System.out.println("Initializing Buttons for PCPP page...");
        for (int i = 0; i <Buttons.size(); i++)
        {
            System.out.println(Buttons.get(i));
            HtmlCheckBoxInput InitializeSite = Out.getHtmlElementById(Buttons.get(i));
            Out = (HtmlPage) InitializeSite.setChecked(true);
            System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());
            TimeUnit.MILLISECONDS.sleep(900);
        }
        return Out;
    }
    public static void SetProxy(String IP,String Port)
    {
        System.setProperty("https.proxyHost", IP);//specify the proxy host (ip address)
        System.setProperty("https.proxyPort", Port);//specify the proxy port
    }
    public static ArrayList<String> FindEachClass(Document doc, String ClassName)
    {
        ArrayList<String> Out = new ArrayList<>();
        Elements DataSet = doc.getElementsByClass(ClassName);
        for (int i = 0; i < DataSet.size(); i++)
        {
            Out.add(DataSet.get(i).text());
        }
        //System.out.println(Out);
        return Out;
    }
    public static ArrayList<String> Fill2dArrayListWithRepeating(int size2d1d,String RepeatME)
    {
        ArrayList<String> OutArrayList = new ArrayList<>();
        for (int i = 0; i < size2d1d; i++)
        {
            OutArrayList.add(RepeatME);
        }
        return OutArrayList;
    }
    public static ArrayList<ArrayList<String>> AddEveryRow(ArrayList<ArrayList<String>> Arr2dOne,ArrayList<ArrayList<String>> Arr2dTwo)
    {
        for (int i = 0; i < Arr2dOne.size(); i++)
        {
            try {
                Arr2dOne.get(i).addAll(Arr2dTwo.get(i));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return Arr2dOne;
    }
    public static void WriteCSV(String FileName,String Location, ArrayList<ArrayList<String>> Data) throws IOException
    {
        try {
            String filename = Location+FileName+".csv";
            File path = new File(Location);
            if (path.mkdir())
            {
                FileWriter myWriter = new FileWriter(filename);
                for (int i = 0; i < Data.size(); i++)
                {
                    for (int j = 0; j < Data.get(i).size(); j++)
                    {
                        myWriter.write(Data.get(i).get(j));
                        if(j<Data.get(i).size()-1)
                        {
                            myWriter.write(",");
                        }
                    }
                    myWriter.write("\n");
                }
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static boolean doesExist(String FileName,String Location)
    {
        File f = new File(Location+FileName+".csv");
        return f.isFile();
    }
    /*
    public static void temp()
    {
        ArrayList<Integer> x = new ArrayList<>(Arrays.asList());
        ArrayList<String> y = new ArrayList<>(1,88,894,361,710,236,52,737,77,868,8,149,337,50,413,11,150,436,771,225,78,379,57,114,90,14,106,101,426,722,125,18,895,485,58,21,701,331,62,107,86,824,27,168,99,463,94,440,806,229,709,128,64,439,162,694,680,231,51,79,488,145,63,91,72,119,144,888,113,56,156,116,828,82,886,461,87,93,60,442,89);
        for (int i = 0; i < x.size(); i++)
        {
            y.add("\"#m="+x.get(i)+"\"");
        }
        System.out.println(y);
    }



     */

}
/*Legacy---------------------------------------------------------

        //Manufacturer
        HtmlCheckBoxInput InitializeSite = x.getHtmlElementById("m_all");
        System.out.println(InitializeSite.isChecked());
        HtmlPage Out = (HtmlPage) InitializeSite.setChecked(true);

        TimeUnit.MILLISECONDS.sleep(900);

        //Ratings
        InitializeSite = Out.getHtmlElementById("R_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //Series
        InitializeSite = Out.getHtmlElementById("s_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //MicroArchitecture
        InitializeSite = Out.getHtmlElementById("F_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //Core Family
        InitializeSite = Out.getHtmlElementById("f_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //Socket
        InitializeSite = Out.getHtmlElementById("k_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //Integrated Graphics
        InitializeSite = Out.getHtmlElementById("g_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //SMT
        InitializeSite = Out.getHtmlElementById("h_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());

        TimeUnit.MILLISECONDS.sleep(900);

        //ECC Support
        InitializeSite = Out.getHtmlElementById("e_all");
        Out = (HtmlPage) InitializeSite.setChecked(true);//
        System.out.println(InitializeSite.isDefaultChecked()+","+InitializeSite.isChecked());
 */
