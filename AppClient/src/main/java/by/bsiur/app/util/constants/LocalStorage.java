package by.bsiur.app.util.constants;

import by.bsiur.app.entity.Account;
import by.bsiur.app.entity.Contract;
import lombok.Data;

import java.util.List;

@Data
public class LocalStorage {
    private static Account account;
    private static List<Contract> contracts;
   // private static List<Feedback> feedbacks;
    private static Long feedback_id;
    private static String question;
   // private static Feedback feedback;

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account a) {
        account = a;
    }

    public static Contract getFirstCar() {
        if (!contracts.isEmpty()) {
            Contract contract = contracts.get(0);
            contracts.remove(0);
            return contract;
        }
        return null;
    }
    public static List<Contract> getContracts() {
        return contracts;
    }

    public static void setContracts(List<Contract> contracts) {
        LocalStorage.contracts = contracts;
    }

//    public static Feedback getFirstFeedback() {
//        if (!feedbacks.isEmpty()) {
//            Feedback feedback = feedbacks.get(0);
//            feedbacks.remove(0);
//            return feedback;
//        }
//        return null;
//    }
//
//    public static String getQuestion() {
//        return question;
//    }
//
//    public static List<Feedback> getFeedbacks() {
//        return feedbacks;
//    }
//
//    public static void setFeedbacks(List<Feedback> feedbacks) {
//        LocalStorage.feedbacks = feedbacks;
//    }
//
//    public static Long getFeedback_id() {
//        return feedback_id;
//    }
//
//    public static void setFeedback_id(Long feedback_id) {
//        LocalStorage.feedback_id = feedback_id;
//    }
//
//    public static Feedback getFeedback() {
//        return feedback;
//    }
//
//    public static void setFeedback(Feedback feedback) {
//        LocalStorage.feedback = feedback;
//    }
}
