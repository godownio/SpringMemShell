package cn.org.javaweb.springmemshell;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

@WebServlet("/Vuln")
public class vulnServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] bytes= Base64.getDecoder().decode(req.getParameter("data"));
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