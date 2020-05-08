package tech.limelight.tbre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private Processor processor;

    private StringBuilder builder;
    private String latestLength;

    @Autowired
    public Controller(Processor processor){
        this.processor = processor;
        builder = new StringBuilder();
    }

    @PostMapping("/uploadToTBRE")
    public void uploadData(@RequestBody String data){
        latestLength = processor.processData(data);
        builder.append(data);
    }

    @GetMapping("/downloadProcessedTBREData")
    public String downloadData() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity response = restTemplate.getForEntity("http://localhost:8080/downloadProcessedTBREData",String.class);
//        response.getBody();
//
//        // Server
//        ServerSocket serverSocket = new ServerSocket(123);
//        Socket accept = serverSocket.accept();
//
//        PrintWriter out = new PrintWriter(accept.getOutputStream());
//        out.println("Hello World");
//
//        // Client
//        Socket socket = new Socket();
//        socket.connect("address","portNumber");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        bufferedReader.readLine();



        return latestLength;
    }
}
