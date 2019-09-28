class Validate {

    private final String possible_types = "DC";
    private final int max_services = 10;
    private final int max_service_variation = 3;
    private final int max_questions_type = 10;
    private final int max_question_categories = 20;
    private final int max_questions_sub_categories = 5;
    private final String possible_response_type = "PN";

    boolean check(String type, String services, int service_variation, String questions_type, int question_categories, int questions_sub_categories, String response_type){
        return  (possible_types.contains(type) &&
                possible_response_type.contains(response_type) &&
                service_variation <= max_service_variation &&
                question_categories <= max_question_categories &&
                questions_sub_categories <= max_questions_sub_categories &&
                (services.equals("*") || Integer.valueOf(services) <= max_services) &&
                (questions_type.equals("*") || Integer.valueOf(questions_type) <= max_questions_type));
    }
}
