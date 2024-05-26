package org.br.serratec.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="imagem_produto")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="imagem_id")
    private Integer imagemId;

    @Column(name="alc_tx_media_type")
    private String mimetype;

    @JsonIgnore
    @Lob
    @Column(name="alc_bl_imagem")
    private byte[] data;

    public Imagem() {
    }

    public Imagem(Integer imagemId, String mimetype, byte[] data) {
        this.imagemId = imagemId;
        this.mimetype = mimetype;
        this.data = data;
    }

    public Integer getId() {
        return imagemId;
    }

    public void setId(Integer imagemId) {
        this.imagemId = imagemId;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
