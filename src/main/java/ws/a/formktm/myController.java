/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.formktm;


import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    //@ResponseBody
    public String getData
        (@RequestParam("gambar") MultipartFile gambar,
            @RequestParam("nama") String text,
            @RequestParam("nim") String number,
            @RequestParam("prodi") String prodi,
            @RequestParam("email") String email,
            Model paket )
            throws IOException{
            
            String blob = Base64.encodeBase64String(gambar.getBytes());
            
            String isigambar = "data:image/*;base64, "+blob+" ";
            
            paket.addAttribute("gambar", isigambar);
            paket.addAttribute("nama", text);
            paket.addAttribute("nim", number);
            paket.addAttribute("prodi", prodi);
            paket.addAttribute("email", email);
            
            return "view";
            
        }
           
}
