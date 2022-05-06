package personal.ivan.process;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import personal.ivan.domain.Document;

import java.io.FileWriter;
import java.util.function.Function;

public class ProcessDocument implements IProcess{
    @Override
    public void process(Document d, Function<Document,String> method) {
        try (FileWriter fw = new FileWriter("output.txt", true)) {
            String jsonresult = method.apply(d);
            fw.write(jsonresult);
        } catch (Exception e) {

        }
    }
    public static String processToJson(Document d){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonresult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(d);
            return jsonresult;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
