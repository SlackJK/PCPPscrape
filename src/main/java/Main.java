import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static String Url = "https://pcpartpicker.com/products/cpu/#page=1";
    public static String test ="https://www.bazos.sk/";
    public static ArrayList<String> CPUSButtons= new ArrayList<>(Arrays.asList("m_all","R_all","s_all","F_all","f_all","k_all","g_all","h_all","e_all"));
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Scrape.GetData(Url,CPUSButtons,null);
    }
}
