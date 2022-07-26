package personal.ivan.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString(callSuper = true)
@SuperBuilder
public class Document extends Element {

    private List<Element> elements = new ArrayList<>();


    public Document(String text) {
        super(text);
    }

    @Override
    public void printContent() {
        
    }
    
    
    
    
    
    
}
















