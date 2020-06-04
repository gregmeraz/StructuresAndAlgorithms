import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

public class HtmlFixer {

    static String testString = "<p>Littler Mendelson is the largest U.S.-based law firm" +
            " exclusively devoted to representing management in every aspect of " +
            "labor and employment law.  Since the firm was started in 1942 by Robert Littler," +
            " who chose to represent management clients in what were mostly disputes involving unions," +
            " Littler has adhered to and expanded its continuous representation of corporate America, and " +
            "the global reach those companies have realized, in all areas of employment and labor law.</p>" +
            "<strong>Focus</strong> <p>Littler's single focus on employment and  labor law has created a cartel of " +
            "attorneys whose knowledge of and experience in these areas of law is unsurpassed. With lawyers who practice " +
            "in more than 36 areas of law, there is no employment issue a company has faced that hasn't been addressed by " +
            "one of Littler's attorneys. When a company faces a workplace issue, Littler Mendelson is in a position to " +
            "respond.</p><strong>Client Service</strong> <p>Littler attorneys are dedicated to incomparable client service.  " +
            "Littler has a Knowledge Management group whose attorneys harness the collective knowledge of the firm and provide " +
            "that knowledge to clients through tools, products and services that are available 24 hours per day, seven days a week. " +
            " This allows Littler to provide up-to-the-minute information on changes in the employment law arena and give clients " +
            "the information and tools they need to respond to those changes.  Littler clients can subscribe to services like Littler" +
            " GPS, the Guide for Policies by State, the Littler Monitor that tracks state and federal employment-related legislation " +
            "and other significant regulatory developments, or utilize the Audit Quarterback, Audit QB, which allows attorneys and " +
            "clients to conduct large scale employment audits in areas such as wage and hour issues, human resources assessments, " +
            "fair employment practices, affirmative action and diversity issues, and I-9 compliance, among many other challenges that impact the workplace.</p><p>Littler attorneys have deep subject matter expertise in employment law matters that companies have faced for decades, as well as emerging issues that are only now beginning to surface.  The rules of discovery in litigation have expanded to include electronic means of communication, including email, voice mail, text messages and instant messaging.  Littler is one of few firms which has an eDiscovery practice to help clients navigate the rules which govern the preservation and admission of this evidence at trial.  Employment and labor law is dynamic. Littler is constantly evolving and growing to meet and respond to the changes that impact the workplace.</p>";

    public static void main(String[] args) {
        String remainder=testString.substring(0,500);
        for(int i=0; i<=testString.length()-1; i++){
            System.out.println(testString.charAt(i));
        }
      //  System.out.println(remainder);
    }

}
