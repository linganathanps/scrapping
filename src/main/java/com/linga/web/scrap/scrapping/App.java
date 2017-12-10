package com.linga.web.scrap.scrapping;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.linga.web.scrap.scrapping.model.PurchaseOder;
import com.linga.web.scrap.scrapping.model.PurchaseOrderDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Connection.Response res = Jsoup.connect("http://openbook.wi.gov/PurchaseOrderDetail.aspx?AgencyCode=395")
//              .userAgent(YourUserAgent)
//              .header("Accept", WhateverTheSiteSends)
//              .timeout(Utilities.timeout)
                .method(Method.GET)
                .execute();   
/*        Document doc1 = Jsoup.connect("http://openbook.wi.gov/PurchaseOrderDetail.aspx?AgencyCode=395").cookies(res.cookies())
        		.data("ctl00_NavigationTab_ClientState", "{\"selectedIndexes\":[\"2\"],\"logEntries\":[],\"scrollState\":{}}")
        		.data("ctl00$Middle$FormView1$cmbxFiscalYear", "2018")
        		.data("ctl00$Middle$ViewPurchaseOrderDetails1$ViewGrid$ctl00$ctl03$ctl01$GoToPageTextBox","1")
        		.data("ctl00_Middle_ViewPurchaseOrderDetails1_ViewGrid_ctl00_ctl03_ctl01_GoToPageTextBox_ClientState","{\"enabled\":true,\"emptyMessage\":\"\",\"validationText\":\"1\",\"valueAsString\":\"1\",\"minValue\":1,\"maxValue\":182,\"lastSetTextBoxValue\",\"1\"}")
        		.data("ctl00$Middle$ViewPurchaseOrderDetails1$ViewGrid$ctl00$ctl03$ctl01$GoToPageTextBox","1")
        		.data("ctl00$Middle$ViewPurchaseOrderDetails1$ViewGrid$ctl00$ctl03$ctl01$ChangePageSizeTextBox","20")
        		.data("ctl00_Middle_ViewPurchaseOrderDetails1_ViewGrid_ctl00_ctl03_ctl01_ChangePageSizeTextBox_ClientState","{\"enabled\":true,\"emptyMessage\":\"\",\"validationText\":\"20\",\"valueAsString\":\"20\",\"minValue\":1,\"maxValue\":3637,\"lastSetTextBoxValue\":\"20\"}")
        		.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
        		.followRedirects(false)
        		.post();*/
/*    	Document doc = Jsoup.connect("http://openbook.wi.gov/PurchaseOrderDetail.aspx?AgencyCode=395").get();
        Element tableId1=doc.getElementById("ctl00_Middle_ViewPurchaseOrderDetails1_ViewGridUpdatePanel");
        Elements em1=doc.select("#ctl00_Middle_ViewPurchaseOrderDetails1_ViewGridUpdatePanel tr");*/
        final WebClient webClient = new WebClient(BrowserVersion.CHROME); 
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.waitForBackgroundJavaScript(15000);
        List<PurchaseOrderDetails> purchaseOrderDetails=new ArrayList<>();
        final HtmlPage page = webClient.getPage("http://openbook.wi.gov/PurchaseOrderDetail.aspx?AgencyCode=395");
        System.out.println(page.asText());
        DomNodeList<DomNode> domlist= ((DomNode) page).querySelectorAll(".rgNumPart a");
        PurchaseOder order=new PurchaseOder();
        order.setYear("2008");
        order.setAgencyCode("395");
        DomNode domnext= ((DomNode) page).querySelector(".rgPageNext");
        for(DomNode dom:domlist) {
        	HtmlPage page1= (HtmlPage)((HtmlAnchor) dom).click();
        	List<DomNode> node=page1.querySelectorAll("#ctl00_Middle_ViewPurchaseOrderDetails1_ViewGrid tbody tr");
        	for(DomNode nodes:node) {
        		PurchaseOrderDetails details =new PurchaseOrderDetails();
        		DomNodeList<DomNode> td=nodes.getChildNodes();
        		if(td.size()>6) {
        			DomNode purchaseOrderraw=td.get(0).querySelector("a");
            		String purchaseOrder=null;
        	    if(purchaseOrderraw!=null)
        	    	purchaseOrder=td.get(5).querySelector("span").asText();
        		String poDate=td.get(2).getFirstChild().asText();
        		String vendor=td.get(3).getFirstChild().asText();
        		DomNode amountraw=td.get(4).querySelector("span");
        		DomNode balanceraw=td.get(4).querySelector("span");
        		String amount=null;
        		String balance=null;
        		if(amountraw!=null)
        			amount=td.get(5).querySelector("span").asText();
        		if(balanceraw!=null)
        		   balance=td.get(5).querySelector("span").asText();
        		details.setOrderNo(purchaseOrder);
        		details.setAmount(amount);
        		details.setBalance(balance);
        		details.setPoDate(poDate);
        		purchaseOrderDetails.add(details);
        		}
  	
        	}
        	//System.out.println(page1.asText());
        }
        HtmlPage page2= (HtmlPage)((HtmlSubmitInput) domnext).click();
        DomNodeList<DomNode> domcont= ((DomNode) page2).querySelectorAll(".rgNumPart a");
        for(DomNode dom:domcont) {
        	HtmlPage page1= (HtmlPage)((HtmlAnchor) dom).click();
        	System.out.println(page1.asText());
        }
        //List<HtmlAnchor> anchor = ((HtmlPage) domlist).getAnchors();
        //HtmlAnchor an=(HtmlAnchor) domlist.get(0);
       // HtmlPage page1= (HtmlPage)((HtmlAnchor) domlist.get(2)).click();
        /*synchronized(page1){
        	page1.wait(10000);
        }*/
        //Page page2= (Page)((HtmlAnchor) domlist.get(3)).click();
       /* System.out.println(page1.asText());
        DomNodeList<DomNode> domlist1= ((DomNode) page1).querySelectorAll("#ctl00_Middle_ViewPurchaseOrderDetails1_ViewGridUpdatePanel tr");
        Document doc2=Jsoup.parse(page1.toString());
        Document doc3=Jsoup.parse(page2.toString());
        Elements em1=doc2.select("#ctl00_Middle_ViewPurchaseOrderDetails1_ViewGridUpdatePanel tr");
        Elements em3=doc3.select("#ctl00_Middle_ViewPurchaseOrderDetails1_ViewGridUpdatePanel tr");*/
    }
}
