package kawahedukasi.service;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import net.sf.jasperreports.engine.JRException;
import org.reactivestreams.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

@ApplicationScoped
public class MailService {
    @Inject
    Mailer mailer;

    @Inject
    ExportService exportService;

    public void sendEmail(String email){
        mailer.send(
                Mail.withHtml(email,
                        "CRUD API Quarkus Batch 6",
                        "<h1>Hello,</h1> this is Quarkus Peserta-Service"));
    }
    public void sendExcelToEmail(String email) throws IOException {
        mailer.send(
                Mail.withHtml(email,
                                "Excel Item Batch 6",
                                "<h1>Hello,</h1> this is your excel file")
                        .addAttachment("list-item.xlsx",
                                exportService.excelItem().toByteArray(),
                                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
    }

}