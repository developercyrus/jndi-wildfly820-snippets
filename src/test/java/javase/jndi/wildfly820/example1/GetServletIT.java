package javase.jndi.wildfly820.example1;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


public class GetServletIT {
	@Test
    public void test() throws Exception {
		Document doc = Jsoup.parse(new URL("http://localhost:8080/jndi-wildfly820-snippets/getServlet"), 60000);
        Elements elements = doc.select("div");
        Element e = elements.get(0);

        String expected = "EN";
        String actual = e.text();
        System.out.println(e.text());
        assertEquals(actual, expected);
	}
	
}