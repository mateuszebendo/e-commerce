package org.br.serratec.ecommerce.controllers;


import java.io.IOException;
import java.util.List;
import org.br.serratec.ecommerce.dtos.ProdutoDTO;
import org.br.serratec.ecommerce.entities.Imagem;
import org.br.serratec.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestParam(value = "file", required = true) MultipartFile file, @RequestPart("produto") ProdutoDTO produtoDto) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(file, produtoDto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO produtoDto) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.update(produtoDto));
    }

    @PutMapping("/update-imagem/{id}")
    public ResponseEntity<ProdutoDTO> updateImagem(@RequestParam("file") MultipartFile file, @PathVariable Integer id) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.updateImagem(file, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.deleteById(id));
    }

    @GetMapping("/{id}/imagem")
    public ResponseEntity<byte[]> findImagemById(@PathVariable Integer id) {
        Imagem imagem = produtoService.getImagem(id);
        if(imagem != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, imagem.getMimetype());
            headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(imagem.getData().length));
            //MimeType mimeType = MimeType.valueOf(imagem.getMimetype());
            //String nomeArquivo = produto.getNome() + "." +mimeType.getSubtype();
            //headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + nomeArquivo);
            return new ResponseEntity<>(imagem.getData(), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}