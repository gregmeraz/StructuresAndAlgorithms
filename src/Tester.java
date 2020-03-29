import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Tester {

    public static void main(String[] args) {
        System.out.println(topArticles(2));
    }

    public static List<String> topArticles(int limit) {

        List<String> results= new ArrayList<>();
        String jsonLine="";
        try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/articles?page=2");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if(responseCode==200){
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext())
                {
                    jsonLine+=sc.nextLine();
                }
                sc.close();
            }

            List<Articles> articles= new ArrayList<>();

            JSONParser parse = new JSONParser();
            JSONObject parsedResponseArray = (JSONObject)parse.parse(jsonLine);
            JSONArray jsonData =(JSONArray) parsedResponseArray.get("data");

            jsonData.stream().forEach(o -> {
                JSONObject currentArticle= (JSONObject)o;
                String title="";
                long numComments=0;
               if(currentArticle.get("title")==null){
                    if(currentArticle.get("story_title")!=null){
                        title=(String)currentArticle.get("story_title");
                   }
               }
               else{
                   title=(String)currentArticle.get("title");
               }

               if(currentArticle.get("num_comments")!=null){
                   numComments=(Long)currentArticle.get("num_comments");
               }

               if(!title.equalsIgnoreCase("")){
                   articles.add(new Articles(numComments, title));
               }

            });

           results= articles.stream().sorted
                    ((o1, o2) -> (int) (o2.getNumComments()-o1.getNumComments())).limit(limit).map(Articles::getTitle)
                    .collect(Collectors.toList());

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return results;
    }
}

class Articles{

    private long numComments;
    private String title;

    public Articles(long numComments, String title) {
        this.numComments = numComments;
        this.title = title;
    }

    public long getNumComments() {
        return numComments;
    }

    public void setNumComments(long numComments) {
        this.numComments = numComments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "numComments=" + numComments +
                ", title='" + title + '\'' +
                '}';
    }
}
