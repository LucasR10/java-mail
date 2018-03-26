
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


public class MandarRelatorio {

    private final String EMAIL_REMETENTE = "cfacilplus@gmail.com";
    private final String SENHA_REMETENTE = "Cfacilplus1595";

    private String nome;
    private String email;

    public void setNome(String text) {
        this.nome = text;
    }

    public void setEmail(String text) {
        this.email = text;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    boolean  send()  {
        try{
              MultiPartEmail email = new MultiPartEmail();        
              email.setHostName("smtp.googlemail.com");
              email.setSmtpPort(465);
              email.setAuthenticator(new DefaultAuthenticator(EMAIL_REMETENTE, SENHA_REMETENTE));
              email.setSSLOnConnect(true);
              email.setFrom(this.EMAIL_REMETENTE);
              email.setSubject(" não responda !");
              email.setMsg("Olá " + this.nome);
              //trocar pelo caminho real do arquivo.
              email.attach(  arquivoTXT() );
              email.addTo(this.email);
              email.send();
              return  true;
        }catch(EmailException ex){
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }  
    }

    public EmailAttachment arquivoTXT() {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:\\lerr_txt\\maquina1.txt" );
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("txt do relatório ");
        attachment.setName("TXT rel");
        return attachment;
    }

}
