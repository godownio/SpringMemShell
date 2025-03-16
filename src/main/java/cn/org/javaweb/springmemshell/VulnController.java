package cn.org.javaweb.springmemshell;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

@Controller
public class VulnController {
    @RequestMapping("/Vulnindex")
    public void Vulnindex(@RequestParam String data) throws IOException {
        byte[] bytes= Base64.getDecoder().decode(data);
        ByteArrayInputStream BAIS=new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream=new ObjectInputStream(BAIS);
        try
        {
            System.out.println(objectInputStream.readObject());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
