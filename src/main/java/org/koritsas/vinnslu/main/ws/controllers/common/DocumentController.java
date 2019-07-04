package org.koritsas.vinnslu.main.ws.controllers.common;

import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.common.DocumentDto;
import org.koritsas.vinnslu.main.ws.services.crud.common.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/documents")
public class DocumentController extends AbstractCRUDController<DocumentService,Document,Long,DocumentDto>{

    public DocumentController(DocumentService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }


    @PostMapping()
    public ResponseEntity<Document> createDocument(DocumentDto dto, MultipartFile file){

        Document document = mapper.map(dto,Document.class);

        return ResponseEntity.ok(service.create(document,file));
    }
/*
    @GetMapping()
    public ResponseEntity<List<Document>> getAllDocuments(){

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public Document getDocument(@PathVariable Long id){
        return service.find(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok("Deleted: " + service.delete(id));
    }

    @PutMapping()
    public ResponseEntity<Document> update(@RequestBody Document dto) {
        return ResponseEntity.status(200)
                .body( service.update(dto.getId(), mapper.map(dto, Document.class)));
    }
*/



}
