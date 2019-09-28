import java.util.ArrayList;
import java.util.Arrays;

class AnalyticalData {

    private String type;
    private String service_id;
    private int variation_id;
    private String question_type_id;
    private int category_id;
    private int sub_category_id;
    private String response_type;
    private String date;
    private int time;
    private int size;

    AnalyticalData(String listData){
        parsing(listData);
    }

    AnalyticalData(AnalyticalData analyticalData) {
        setType(analyticalData.getType());
        setService_id(analyticalData.getService_id());
        setVariation_id(analyticalData.getVariation_id());
        setQuestion_type_id(analyticalData.getQuestion_type_id());
        setCategory_id(analyticalData.getCategory_id());
        setSub_category_id(analyticalData.getSub_category_id());
        setResponse_type(analyticalData.getResponse_type());
    }

    private void parsing(String listData){
        ArrayList<String> list = new ArrayList<>(Arrays.asList(listData.split(" ")));
        setSize(list.size());
        if (list.size() <= 6 & 5 <= list.size()){
            setType(list.get(0));
            if (list.get(1).length()!=list.get(1).replace(".","").length()){
                ArrayList temp = new ArrayList<>(Arrays.asList(list.get(1).split("\\.")));
                setService_id(String.valueOf(temp.get(0)));
                setVariation_id(Integer.parseInt(String.valueOf(temp.get(1))));
            } else {
                setService_id(list.get(1));
            }
            if (list.get(2).length()>1){
                ArrayList temp = new ArrayList<>(Arrays.asList(list.get(2).split("\\.")));
                if (temp.size()>2){
                    setQuestion_type_id(String.valueOf(temp.get(0)));
                    setCategory_id(Integer.parseInt(String.valueOf(temp.get(1))));
                    setSub_category_id(Integer.parseInt(String.valueOf(temp.get(2))));
                } else if (temp.size()==1){
                    setQuestion_type_id(String.valueOf(temp.get(0)));
                } else {
                    setQuestion_type_id(String.valueOf(temp.get(0)));
                    setCategory_id(Integer.parseInt(String.valueOf(temp.get(1))));
                }
            } else {
                setQuestion_type_id(list.get(2));
            }
            setResponse_type(list.get(3));
            setDate(list.get(4));
            if (list.size()>5){
                setTime(Integer.parseInt(list.get(5)));
            }

        }

    }

    boolean getValidate(){
        return new Validate().check(getType(),getService_id(),
                getVariation_id(),getQuestion_type_id(),
                getCategory_id(),getSub_category_id(),
                getResponse_type());
    }

    String getType() {
        return type;
    }

    String getService_id() {
        return service_id;
    }

    int getVariation_id() {
        return variation_id;
    }

    String getQuestion_type_id() {
        return question_type_id;
    }

    int getCategory_id() {
        return category_id;
    }

    int getSub_category_id() {
        return sub_category_id;
    }

    String getResponse_type() {
        return response_type;
    }

    int getTime() {
        return time;
    }

    int getSize() {
        return size;
    }

    String getDate() {
        return date;
    }

    private void setTime(int time) {
        this.time = time;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private void setDate(String data) {
        this.date = data;
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setService_id(String service_id) {
        this.service_id = service_id;
    }

    private void setVariation_id(int variation_id) {
        this.variation_id = variation_id;
    }

    private void setQuestion_type_id(String question_type_id) {
        this.question_type_id = question_type_id;
    }

    private void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    private void setSub_category_id(int sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    private void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

}
