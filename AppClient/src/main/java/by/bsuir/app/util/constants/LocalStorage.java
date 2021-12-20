package by.bsuir.app.util.constants;

import by.bsuir.app.entity.Account;
import lombok.Data;

@Data
public class LocalStorage {
    private static Account account;
//    private static List<Product> products;
//    private static List<Feedback> feedbacks;
//    private static List<Mark> marks;
//    private static Long feedback_id;
//    private static String question;
//    private static Feedback feedback;
//    private static Set<Product> productsToCompare;
//    private static Product selectedProduct;
//    private static Long productID;

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account a) {
        account = a;
    }

//    public static Product getFirstProduct() {
//        if (!products.isEmpty()) {
//            Product product = products.get(0);
//            products.remove(0);
//            return product;
//        }
//        return null;
//    }
//
//    public static Product getFirstProductToCompare() {
//        if (!productsToCompare.isEmpty()) {
//            Product product = productsToCompare.iterator().next();
//            productsToCompare.remove(product);
//
//            return product;
//        }
//        return null;
//    }
//    public static List<Product> getProducts() {
//        return products;
//    }
//
//    public static void setProducts(List<Product> products) {
//        LocalStorage.products = products;
//    }
//
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
//
//    public static Set<Product> getProductsToCompare() {
//        if (productsToCompare == null)
//            productsToCompare = new LinkedHashSet<>();
//        return productsToCompare;
//    }
//
//    public static void addProductToCompare(Product product) {
//        if (productsToCompare == null)
//            productsToCompare = new LinkedHashSet<>();
//        productsToCompare.add(product);
//    }
//
//    public static Product getSelectedProduct() {
//        return selectedProduct;
//    }
//
//    public static void setSelectedProduct(Product selectedProduct) {
//        LocalStorage.selectedProduct = selectedProduct;
//    }
//
//    public static List<Mark> getMarks() {
//        return marks;
//    }
//
//    public static void setMarks(List<Mark> marks) {
//        LocalStorage.marks = marks;
//    }
//
//    public static Long getProductID() {
//        return productID;
//    }
//
//    public static void setProductID(Long productID) {
//        LocalStorage.productID = productID;
//    }
}
