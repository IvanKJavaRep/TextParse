package personal.ivan.read;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

interface IReadable {
    public FileInputStream Read(String filename) throws FileNotFoundException;

}

