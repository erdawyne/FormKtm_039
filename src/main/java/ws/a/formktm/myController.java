/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.formktm;


import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ERDA WYNE
 */
@Controller
public class myController {
    
    @RequestMapping ("/identitas")
    @ResponseBody
    public String getData
        (@RequestParam("gambar") MultipartFile gambar,
            @RequestParam("nama+prodi+email") String text,
            @RequestParam("nim") String number)
            throws IOException{
            
            String blob = Base64.encodeBase64String(gambar.getBytes());
    
            text = textProcess(text);
    
            return text+"<br><img src='data:image/jpeg;base64,"+blob+"  '/><br>";
            
        }
           
    
       
    private String textProcess(String nama) {
    String result = "";
    if (nama.equals("Erda")) {result = nama +"Mahasiswa TI";}
        else if(nama.equals("Wyne")) {result = nama + "Mahasiswa";}
        else if(nama.equals("Astuti")) {result = nama + "Mahasiswa";}
        else {result = nama + "cakep amat";
        }
        return result;
    }
}
