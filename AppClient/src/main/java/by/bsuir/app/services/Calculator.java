//package by.bsuir.app.services;
//
//import by.bsuir.app.entity.Mark;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Calculator {
//    public static double getAverageMark(List<Mark> marks) {
//        if (marks == null)
//            return 0.0;
//
//        List<BigDecimal> allMarks = new ArrayList<>();
//        int delimiter = 0;
//
//        for (Mark mark : marks) {
//
//            BigDecimal design = mark.getDesign();
//            if (design.compareTo(BigDecimal.valueOf(0.0)) != 0) {
//                allMarks.add(design);
//                delimiter++;
//            }
//
//            BigDecimal packageProduct = mark.getPackageValue();
//            if (packageProduct.compareTo(BigDecimal.valueOf(0.0)) != 0) {
//                allMarks.add(packageProduct);
//                delimiter++;
//            }
//
//            BigDecimal price = mark.getPrice();
//            if (price.compareTo(BigDecimal.valueOf(0.0)) != 0) {
//                allMarks.add(price);
//                delimiter++;
//            }
//
//            BigDecimal service = mark.getService();
//            if (service.compareTo(BigDecimal.valueOf(0.0)) != 0) {
//                allMarks.add(service);
//                delimiter++;
//            }
//
//            BigDecimal repair = mark.getRepair();
//            if (repair.compareTo(BigDecimal.valueOf(0.0)) != 0) {
//                allMarks.add(repair);
//                delimiter++;
//            }
//        }
//
//        return allMarks.stream().mapToDouble(BigDecimal::doubleValue).sum() / delimiter;
//    }
//
//    public static double getAverageMark(List<Mark> marks, int column) {
//        double result = 0;
//        switch (column) {
//            case 0 -> {
//                for (Mark m: marks)
//                    result += Double.parseDouble(String.valueOf(m.getDesign()));
//            }
//            case 1 -> {
//                for (Mark m: marks)
//                    result += Double.parseDouble(String.valueOf(m.getPackageValue()));
//            }
//            case 2 -> {
//                for (Mark m: marks)
//                    result += Double.parseDouble(String.valueOf(m.getPrice()));
//            }
//            case 3 -> {
//                for (Mark m: marks)
//                    result += Double.parseDouble(String.valueOf(m.getService()));
//            }
//            case 4 -> {
//                for (Mark m: marks)
//                    result += Double.parseDouble(String.valueOf(m.getRepair()));
//            }
//            default -> throw new IllegalStateException("Unexpected value: " + column);
//        }
//        return result / marks.size();
//    }
//}
