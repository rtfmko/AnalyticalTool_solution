import java.time.LocalDate;
import java.util.*;

public class AnalyticalTool {
    private static final int max_count = 100000; //edit size of array
    private static List<AnalyticalData> data = new ArrayList<>(); //waiting time line
    private static List<AnalyticDataQuery> query = new ArrayList<>(); //query
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> output = new ArrayList<>(); //result

    public static void main(String[] args) {
        setArray();
        setQuery();
        workWithAnalyticalArray();
        System.out.println(output);
    }

    private static int getArrayLines(){
        do {
            System.out.println("Enter count of lines (Not more than: " + max_count + " )");
            try {
                int in = sc.nextInt();
                if (in<=max_count){
                    return in;
                } else {
                    System.err.println("More than " + max_count + " Try again\n");
                }
            } catch (InputMismatchException e){
                System.err.println("Enter number and try again\n");
                sc.nextLine();
            }
        } while (true);
    }

    private static void setArray(){
        int size = getArrayLines();
        System.out.println("\nArray length: " + size  + "\n");
        sc.nextLine();
        for (int i = 0; i < size;) {
            try {
                data.add(new AnalyticalData(sc.nextLine()));
                if (data.get(i).getSize() <=6  & 5 <= data.get(i).getSize()&& new AnalyticalData(data.get(i)).getValidate()){
                    i++;
                } else {
                    System.err.println("Incorrect input\nCheck input\nTry again");
                    data.remove(i);
                }
                System.out.println("Current line: " + i + "\n");
            } catch (NumberFormatException e){
                System.err.println("Incorrect input\nCheck input\nTry again");
            }
        }
        sc.close();
    }

    private static void setQuery(){
        for (int i = 0; i < data.size();) {
            if (data.get(i).getType().equals("D")) {
                query.add(new AnalyticDataQuery(data.get(i)));
                data.remove(i);
                i--;
            }
            i++;
        }
    }

    private static void workWithAnalyticalArray(){
        for (AnalyticDataQuery analyticDataQuery : query) {
            ArrayList<Integer> result = new ArrayList<>();
            int count = 0;
            for (AnalyticalData datum : data) {
                if (compareDate(analyticDataQuery.getDate(), datum.getDate())) {
                    if (analyticDataQuery.getResponse_type().equals(datum.getResponse_type())) {
                        if (analyticDataQuery.getService_id().equals("*") || (analyticDataQuery.getQuestion_type_id().equals("*"))) {
                            result.add(datum.getTime());
                            count++;
                        } else if (analyticDataQuery.getService_id().equals(datum.getService_id())) {
                            if ((analyticDataQuery.getVariation_id() == 0) || (analyticDataQuery.getVariation_id() == datum.getVariation_id())) {
                                if ((analyticDataQuery.getCategory_id() == 0) || (analyticDataQuery.getCategory_id() == datum.getCategory_id())) {
                                    if ((analyticDataQuery.getSub_category_id() == 0) || (analyticDataQuery.getSub_category_id() == datum.getSub_category_id())) {
                                        if ((analyticDataQuery.getQuestion_type_id().equals(datum.getQuestion_type_id()))) {
                                            result.add(datum.getTime());
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (count > 1) {
                output.add(String.valueOf(result.stream().mapToInt(Integer::valueOf).sum()/count));
            } else if (result.size()==0){
                output.add(" - ");
            } else {
                output.add(String.valueOf(result.get(0)));
            }
        }
    }

    private static boolean compareDate(String query_date, String waiting_date){
        if (!query_date.isEmpty() || !waiting_date.isEmpty()){
            ArrayList<String> query = new ArrayList<>(Arrays.asList(query_date.split("-")));
            ArrayList<String> waiting = new ArrayList<>(Arrays.asList(waiting_date.split("\\.")));
            LocalDate start = LocalDate.of(1970,1,1);
            LocalDate end = LocalDate.now();
            LocalDate check = LocalDate.of(Integer.valueOf(waiting.get(2)),Integer.valueOf(waiting.get(1)),Integer.valueOf(waiting.get(0)));
            if (query.size()==1){
                ArrayList<String> splitter = new ArrayList<>(Arrays.asList(query.get(0).split("\\.")));
                end = LocalDate.of(Integer.valueOf(splitter.get(2)), Integer.valueOf(splitter.get(1)), Integer.valueOf(splitter.get(0)));
            } else {
                for (int i = 0; i < query.size(); i++) {
                    ArrayList<String> splitter = new ArrayList<>(Arrays.asList(query.get(i).split("\\.")));
                    if (i==0){
                        start = LocalDate.of(Integer.valueOf(splitter.get(2)), Integer.valueOf(splitter.get(1)), Integer.valueOf(splitter.get(0)));
                    } else {
                        end = LocalDate.of(Integer.valueOf(splitter.get(2)), Integer.valueOf(splitter.get(1)), Integer.valueOf(splitter.get(0)));
                    }
                }
            }
            if (check.isAfter(start) && check.isEqual(start)){
                return true;
            } else return check.isBefore(end) || check.isEqual(end);
        } return false;
    }
}
