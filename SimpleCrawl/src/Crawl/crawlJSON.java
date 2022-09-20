package Crawl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;



public class crawlJSON {
    private String myUA = UserAgentUtil.randomUserAgent();//随机用户头
    
	private String strDoc = null;
	public crawlJSON() {
		// TODO Auto-generated constructor stub
		getDocstr();
        MyJSONItem mJI = new MyJSONItem();//建立数据解析类
        mJI.ItemParse(strDoc);
        mJI.BuildFrame();
	}
    public static void main(String[] args){
    	new crawlJSON();
    	
        
    }
    void getDocstr() {
        Document document;
        while(true) {
            try {
            	document = Jsoup.connect("https://voice.baidu.com/act/newpneumonia/newpneumonia/?from=osari_aladin_banner")
                        .userAgent(myUA)
                        .post();
            } catch (Exception e) {
            	JOptionPane.showConfirmDialog(null, "请确保连接上网络!!!");
                return ;
            }
            break;
        }//获取网页的document
        
        strDoc = document.toString();
        
        Matcher matcher = Pattern.compile("\"component\":\\[(.*)\\]").matcher(strDoc);//正则匹配出需要的部分
        if (matcher.find()) {
            strDoc = matcher.group();
        }
        strDoc = strDoc.substring(13);
        strDoc = strDoc.substring(0,strDoc.length()-1);//截取JSONString
    }
}