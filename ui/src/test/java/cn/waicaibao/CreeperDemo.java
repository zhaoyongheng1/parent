package cn.waicaibao;


import com.gargoylesoftware.htmlunit.ScriptPreProcessor;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Created by liyang-macbook on 2017/4/17.
 */
public class CreeperDemo {

    public static void main(String[] args){
        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setDoNotTrackEnabled(true);
        webClient.getOptions().setTimeout(1000);

        try {

            //table_live
            HtmlPage page = webClient.getPage("http://live.titan007.com/");
            DomElement dom =  page.getElementById("table_live");
            System.out.println("");
//            HtmlPage page = webClient.getPage("http://data.7m.cn/result_data/default_gb.shtml?date=2017-04-16");
//            DomElement dom =  page.getElementById("result_tb");
//
//            DomNodeList<HtmlElement> domnode = dom.getElementsByTagName("tr");
//            for(HtmlElement he:domnode){ webClient.setScriptPreProcessor(new ScriptPreProcessor() {
//
//                @Override
//                public String preProcess(HtmlPage htmlPage, String sourceCode, String sourceName, int lineNumber, HtmlElement htmlElement) {
//                    System.out.println("======"+sourceName+"=="+sourceCode);
//
//                   // htmlPage.executeJavaScript(sourceCode);
//                    return "";
//                }
//            });
//                Iterable<DomElement>  td = he.getChildElements();
//                for(DomElement _td:td){
//                    System.out.println(_td.asText());
//                }
//            }
             // http://www.tuiqiu.net/sc/match


//


//            webClient.setScriptPreProcessor(new ScriptPreProcessor() {
//                @Override
//                public String preProcess(HtmlPage htmlPage, String sourceCode, String sourceName, int lineNumber, HtmlElement htmlElement) {
//                    if (sourceName.contains("tuiqiu.net") || sourceName.contains("tuiqiu2.net")){
//                        System.out.println("========="+sourceName+"111="+sourceCode);
//                        return sourceCode;
//                    }
//
//
//                    return "";
//                }
//            });

//            HtmlPage page = webClient.getPage("http://www.tuiqiu.net/sc/match");
//
//            DomElement dom =  page.getElementById("football_list");
//            DomNodeList<HtmlElement> ul = dom.getElementsByTagName("ul");
//            int i = 0;
//            int k = 0;
//            for(HtmlElement _ul:ul){
//                if(i==0){
//                    continue;
//                }
//                Iterable<DomElement>  li = _ul.getChildElements();
//
//                for(DomElement _li:li){
//                    k++;
//                    switch (k){
//                        case 1 : {
//                            Iterable<DomElement>  span =  _li.getChildElements();
//                            System.out.printf("联赛   时间");
//                            for(DomElement _span:span){
//                                System.out.print(_span.asText());
//                            }
//                            System.out.println();
//                            break;
//                        }
//                        case 2 : {
//                            Iterable<DomElement>  span =  _li.getChildElements();
//                            System.out.printf("主场  VS  客场");
//                            for(DomElement _span:span){
//                                System.out.print(_span.asText());
//                            }
//                            System.out.println();
//                            break;
//                        }
//                        case 3 : {
//                            Iterable<DomElement>  span =  _li.getChildElements();
//                            System.out.printf("让球 大小 让球 大小");
//                            for(DomElement _span:span){
//                                System.out.print(_span.getFirstElementChild().asText());
//                            }
//                            System.out.println();
//                            break;
//                        }
//                    }
//
//
//                }
//                k=0;
//                i++;
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
