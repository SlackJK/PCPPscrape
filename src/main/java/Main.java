import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static String Url = "https://pcpartpicker.com/products/cpu/#page=1";
    public static String test ="https://www.bazos.sk/";
    public static ArrayList empty = new ArrayList();
    public static ArrayList<String> CPUSButtons= new ArrayList<>(Arrays.asList("m_all","R_all","s_all","F_all","f_all","k_all","g_all","h_all","e_all"));
    public static ArrayList<String> GPUSButtons= new ArrayList<>(Arrays.asList("m_all","R_all","c_all","s_all"));//
    public static ArrayList<String> GPUClassNames= new ArrayList<>(Arrays.asList("td__nameWrapper","td__spec td__spec--1","td__spec td__spec--2","td__spec td__spec--3","td__spec td__spec--4","td__spec td__spec--5","td__spec td__spec--6","td__price"));
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Scrape S = new Scrape(Url,GPUSButtons,GPUClassNames,empty);
        System.out.println(S.GetData());
    }
}
