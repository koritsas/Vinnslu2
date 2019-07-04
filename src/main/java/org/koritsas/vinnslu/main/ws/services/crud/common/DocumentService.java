package org.koritsas.vinnslu.main.ws.services.crud.common;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.koritsas.vinnslu.main.exceptions.EntityNotFoundException;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.ws.repos.common.DocumentRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentService extends AbstractCRUDService<DocumentRepository,Document,Long> {

    public DocumentService(DocumentRepository repo) {
        super(repo);
    }

    @Transactional(rollbackFor = {EntityNotFoundException.class, ConstraintViolationException.class})
    public Document create(Document document, MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());


            // Check if the file's name contains invalid characters

            Document doc = new Document();
            doc.setDate(document.getDate());
            doc.setId(document.getId());
            doc.setName(document.getName());
            doc.setProtocol(document.getProtocol());
            doc.setSender(document.getSender());
            doc.setReceiver(document.getReceiver());

            doc.setFileName(fileName);
            doc.setFileType(file.getContentType());


            try {

                doc.setData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] dat = doc.getData();

        System.out.println(dat.length);

            return repo.save(doc);

    }


}
