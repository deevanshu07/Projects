package com.schneider.solr.analyticsLog;

import com.activemq.Sender;
import com.queueListenser.QueueListener;
import com.schneider.solr.model.AnswerInfo;
import com.schneider.solr.model.QuestionAnswer;
import com.schneider.solr.model.QuestionInfo;
import com.schneider.solr.resourcesLoader.LoadResource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AnalyticsLog
{
  private static Logger logger = Logger.getLogger(AnalyticsLog.class.getName());
  private Logger reportLog = Logger.getLogger("reportsLogger");
  
  public void createSearchAnatyticsLog(String jsonResponse, String searchId, String sessionId, String SAMAccountName, String wwTechSupportID)
    throws ParseException
  {
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(jsonResponse);
    
    JSONObject jsonObject = (JSONObject)obj;
    
    JSONObject responseHdr = 
      (JSONObject)jsonObject.get("responseHeader");
    JSONObject params = (JSONObject)responseHdr.get("params");
    String searchQry = "";
    if (params.get("q") != null) {
      searchQry = params.get("q").toString();
    } else {
      searchQry = params.get("q.alt").toString();
    }
    if (!searchQry.equals("*"))
    {
      JSONObject response = (JSONObject)jsonObject.get("response");
      int numFound = Integer.parseInt(response.get("numFound")
        .toString());
      JSONArray docArr = (JSONArray)response.get("docs");
      Iterator<JSONObject> docIterator = docArr.iterator();
      while (docIterator.hasNext())
      {
        JSONObject doc = (JSONObject)docIterator.next();
        QuestionAnswer model = new QuestionAnswer();
        model.setSearchId(searchId);
        model.setQuestion(searchQry);
        model.setAnswer(doc.get(LoadResource.title).toString());
        model.setSearchDate(new Timestamp(new Date().getTime()));
        model.setDocumentId(doc.get(LoadResource.url).toString());
        model.setAnswerType(LoadResource.answerType);
        this.reportLog.info(model.toString());
        
        Thread job = new Thread(new Sender(model.toString(), new QueueListener()));
        job.start();
      }
      QuestionInfo quesInfo = new QuestionInfo();
      quesInfo.setSAMAccountName(SAMAccountName);
      quesInfo.setWwTechSupportId(wwTechSupportID);
      quesInfo.setQuestion(searchQry);
      quesInfo.setSearchDate(new Timestamp(new Date().getTime()));
      quesInfo.setSearchId(searchId);
      quesInfo.setLocale(LoadResource.locale);
      quesInfo.setqCTRATE(0);
      if (numFound > 0) {
        quesInfo.setAnswerFlag("Y");
      } else {
        quesInfo.setAnswerFlag("N");
      }
      if (params.get("fq") != null)
      {
        if ((params.get("fq") instanceof String))
        {
          String facetValue = params.get("fq").toString();
          if ((facetValue.trim().contains("entitlements".trim())) || (facetValue.trim().contains("brand".trim()))) {
            quesInfo.setFacetFlag("N");
          } else {
            quesInfo.setFacetFlag("Y");
          }
          quesInfo.setBarndAndEntitlements(facetValue);
        }
        else
        {
          JSONArray object = (JSONArray)params.get("fq");
          String facetValue = params.get("fq").toString();
          if ((object.size() == 2) && (facetValue.trim().contains("entitlements")) && (facetValue.trim().contains("brand")))
          {
            quesInfo.setFacetFlag("N");
            quesInfo.setBarndAndEntitlements(object.toString());
          }
          else if (object.size() >= 2)
          {
            quesInfo.setFacetFlag("Y");
            quesInfo.setBarndAndEntitlements(object.toString());
          }
        }
      }
      else {
        quesInfo.setFacetFlag("N");
      }
      quesInfo.setSessionId(sessionId);
      this.reportLog.info(quesInfo.toString());
      
      Thread job = new Thread(new Sender(quesInfo.toString(), new QueueListener()));
      job.start();
      
      logger.info("Events have pushed to log file");
    }
  }
  
  public void createClickThroghAnalyticsLog(int linkPosition, String title, String docId, String searchId)
    throws Exception
  {
    AnswerInfo ansInfo = new AnswerInfo();
    ansInfo.setAnswerType(LoadResource.answerType);
    ansInfo.setAnswer(title);
    ansInfo.setAnswerCTPosition(linkPosition);
    ansInfo.setAnswerCTRATE(0);
    ansInfo.setSearchDate(new Timestamp(new Date().getTime()));
    ansInfo.setDocumentId(docId);
    ansInfo.setLocale(LoadResource.locale);
    ansInfo.setSearchId(searchId);
    this.reportLog.info(ansInfo.toString());
    Thread job = new Thread(new Sender(ansInfo.toString(), new QueueListener()));
    job.start();
    logger.info("Events have pushed to log file");
  }
}
