
class AnalyticDataQuery {

    private String type;
    private String service_id;
    private int variation_id;
    private String question_type_id;
    private int category_id;
    private int sub_category_id;
    private String response_type;
    private String date;

    AnalyticDataQuery(AnalyticalData listData) {
        setQueryData(listData);
    }

    private void setQueryData(AnalyticalData listData){
        setType(listData.getType());
        setService_id(listData.getService_id());
        setVariation_id(listData.getVariation_id());
        setQuestion_type_id(listData.getQuestion_type_id());
        setCategory_id(listData.getCategory_id());
        setSub_category_id(listData.getSub_category_id());
        setResponse_type(listData.getResponse_type());
        setDate(listData.getDate());
    }

    private void setType(String type) {
        this.type = type;
    }

    String getService_id() {
        return service_id;
    }

    private void setService_id(String service_id) {
        this.service_id = service_id;
    }

    int getVariation_id() {
        return variation_id;
    }

    private void setVariation_id(int variation_id) {
        this.variation_id = variation_id;
    }

    String getQuestion_type_id() {
        return question_type_id;
    }

    private void setQuestion_type_id(String question_type_id) {
        this.question_type_id = question_type_id;
    }

    int getCategory_id() {
        return category_id;
    }

    private void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    int getSub_category_id() {
        return sub_category_id;
    }

    private void setSub_category_id(int sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    String getResponse_type() {
        return response_type;
    }

    private void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    private void setDate(String date) {
        this.date = date;
    }

    String getDate() {
        return date;
    }
}
