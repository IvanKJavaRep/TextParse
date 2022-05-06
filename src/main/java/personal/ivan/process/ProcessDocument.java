package personal.ivan.process;

import personal.ivan.domain.Document;

import java.util.function.Consumer;

public class ProcessDocument implements IProcess{
    @Override
    public void process(Document d, Consumer<Document> method) {

    }
    public static void processToJson(Document d)
    {
        /*try (FileWriter fw = new FileWriter("output.txt", true)) {
            fw.write(json);
            fw.write("\n");
            if (txtL.lst.size() > 0) {
                //jsonList = g.toJson(p.searchForList());
                fw.write(jsonList);
                fw.write("\n");
            }
            fw.write("\n");
        } catch (Exception e) {

        }*/
    }
}
