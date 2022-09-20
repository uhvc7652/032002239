package Crawl;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import Tools.MyLabelButton;

public class MyJSONItem {
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private String dates = formatter.format(date);//获取日期
    private String[] area =new String[34];//地区
    private int newAAll = 0;//本土新增确诊
    private int newNSAAll = 0;//本土新增无症状
    private int confirmedAll = 0;//本土累计确诊
    private int[] newA =new int[34];//新增确诊
    private int[] newNSA =new int[34];//新增无症状
    private int[] confirmed = new int[34];//累计确诊
    private JFrame JF;
    private Container container;
    public void ItemParse(String s){

        String str;//字符串解析

        JSONObject _cases = JSON.parseObject(s);

        str = _cases.getString("caseList");

        JSONArray _caseArray0 = JSONArray.parseArray(str);

        if (_caseArray0.size()>0){//数据提取
            for (int i = 0; i < _caseArray0.size(); i++) {
                JSONObject tem = _caseArray0.getJSONObject(i);
                area[i]=tem.getString("area");
                if (area[i].equals("台湾")||area[i].equals("香港")||area[i].equals("澳门")){
                    if (tem.getString("confirmedRelative").equals("")){
                        newA[i]=0;
                    }
                    else {
                        newA[i] = Integer.parseInt(tem.getString("confirmedRelative"));
                    }
                    if (tem.getString("asymptomaticRelative").equals("")){
                        newNSA[i]=0;
                    }
                    else {
                        newNSA[i] = Integer.parseInt(tem.getString("asymptomaticRelative"));
                    }
                    if (tem.getString("confirmed").equals("")){
                        confirmed[i]=0;
                    }
                    else {
                        confirmed[i] = Integer.parseInt(tem.getString("confirmed"));
                    }
                    continue;
                }
                if (tem.getString("nativeRelative").equals("")){
                    newA[i]=0;
                }
                else {
                    newA[i] = Integer.parseInt(tem.getString("nativeRelative"));
                }
                if (tem.getString("asymptomaticLocalRelative").equals("")){
                    newNSA[i]=0;
                }
                else {
                    newNSA[i] = Integer.parseInt(tem.getString("asymptomaticLocalRelative"));
                }
                if (tem.getString("confirmed").equals("")){
                    confirmed[i]=0;
                }
                else {
                    confirmed[i] = Integer.parseInt(tem.getString("confirmed"));
                }
                if(!(area[i].equals("台湾")||area[i].equals("香港")||area[i].equals("澳门"))){
                    newAAll += newA[i];
                    newNSAAll += newNSA[i];
                    confirmedAll += confirmed[i];
                }
            }
        }
    }
    public void BuildFrame() {
    	JF = new JFrame("疫情数据动态显示窗口");
    	JF.setLayout(null);//窗体布局
    	JF.setSize(1500,800);//窗体大小
    	JF.setVisible(true);//窗体可见
    	JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	container = JF.getContentPane();//获取容器
    	container.setBackground(Color.white);//背景黑色
    	refresh();
    }
    public synchronized void refresh() {
    	long a = System.currentTimeMillis();
    	container.removeAll();
    	String[] head = {"省份","新增感染者","新增无症状感染者","累计确诊"}; //将数据整理成行
    	String[][] content = new String[35][4];
    	content[0][0] = "中国本土";
    	content[0][1] = newAAll+"";
    	content[0][2] = newNSAAll+"";
    	content[0][3] = confirmedAll+"";
    
    	for (int i = 0; i < area.length; i++) {
    		content[i+1][0] = area[i];
    		content[i+1][1] = newA[i]+"";
    		content[i+1][2] = newNSA[i]+"";
    		content[i+1][3] = confirmed[i]+"";
    	}
    
    	JLabel jlabel = new JLabel(dates);//显示日期
    	jlabel.setForeground(Color.white);//字体颜色白色
    	container.add(jlabel);
    	jlabel.setBounds(300, 0, 100, 20);

    	JTable jtable = new JTable(content,head);//显示表格
    	JScrollPane jscrollpane = new JScrollPane(jtable);
    	container.add(jscrollpane);    
    	jscrollpane.setBounds(0, 30, 500, 600);

    	DrawlPanel djp = new DrawlPanel();//绘制统计图
    	container.add(djp);    
    	djp.setBounds(500, 0, 800, 800);

    	MyLabelButton mlbFresh = new MyLabelButton("刷新");//刷新键
    	container.add(mlbFresh);
    	mlbFresh.setBounds(100, 690, 100, 50);
    	mlbFresh.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				refresh();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    	
    	MyLabelButton mlbExit = new MyLabelButton("退出");//退出键
    	container.add(mlbExit);
    	mlbExit.setBounds(300, 690, 100, 50);
    	mlbExit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

    	JF.setVisible(false);
    	JF.setVisible(true);

    }
	public class DrawlPanel extends JScrollPane{//绘制统计图类
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private BufferedImage Image = null;
    	public void paint(Graphics g) {//重写paint方法
    		super.paint(g);
    		this.setSize(1600,800);
    		setChartPicture();
    		Graphics2D g2 = (Graphics2D) g;
    		g2.drawImage(Image, null, 0, 0);
    		JLabel jl = new JLabel();
    		jl.setBounds(0, 0, 1600, 800);
    		this.add(jl);
    		jl.setVisible(false);
    		
    	}
    	void setChartPicture(){//生成柱状图
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(newAAll, "新增感染人数", "本土");//柱状图所需数据整理
            dataset.addValue(newNSAAll, "新增无症状感染人数", "本土");
            for (int i = 0; i < area.length; i++) {
                if ((newNSA[i]!=0||newA[i]!=0)&&(!area[i].equals("台湾"))) {
                    dataset.addValue(newA[i], "新增感染人数", area[i]);
                    dataset.addValue(newNSA[i], "新增无症状感染人数", area[i]);
                }
            }
          StandardChartTheme chartTheme = new StandardChartTheme("CN");//柱状图字体设置
          chartTheme.setExtraLargeFont(new Font("宋体",Font.BOLD,20));
          chartTheme.setRegularFont(new Font("宋体",Font.BOLD,8));
          chartTheme.setLargeFont(new Font("宋体",Font.BOLD,20));
          ChartFactory.setChartTheme(chartTheme);
            JFreeChart chart = ChartFactory.createBarChart("新增感染人数统计图(湾湾一骑绝尘不做展示)", "省份", "人数", dataset, PlotOrientation.VERTICAL, true,true, true);
            Image = chart.createBufferedImage(980, 760);
            
        }
    }
	

}


