package tech.limelight.tbre;

import org.springframework.stereotype.Service;

@Service
public class Processor {

    public void saveRawData(String data){

    }

    public String processData(String data){
        return Integer.toString(data.length());
    }

    public void saveProcessedData(String data){

    }

}
